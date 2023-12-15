package com.crud.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@RequestMapping(value="/", method = RequestMethod.GET)

@Controller
public class HomeController {


    @Autowired
    BoardServiceImpl boardService; // BoardServiceImpl 주입

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String boardlist(Model model){
        model.addAttribute("list", boardService.getBoardList());
        return "list";
    }
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String addPost(){
        return "addpostform";
    }

    @RequestMapping(value="/addok", method=RequestMethod.POST)
    public String addPostOK(BoardVO vo){

        int i = boardService.insertBoard(vo);
        if(i == 0){
            System.out.println("데이터 추가 실패");
        }
        else
            System.out.println("데이터 추가 성공!!!");
        return "redirect:list";
    }

    /*public String addPostOK(BoardVO vo){
        int i = boardService.insertBoard(vo); // BoardServiceImpl의 insertBoard 메서드 호출
        if(i == 0) {
            System.out.println("데이터 추가 실패!");
        } else {
            System.out.println("데이터 추가 성공!");
        }
        return "redirect:list";
    }*/
    @RequestMapping(value="/viewform/{id}", method=RequestMethod.GET)
    public String viewPost(@PathVariable("id") int id, Model model){

        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO);
        return "view";
    }

    @RequestMapping(value="/editform/{id}", method=RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){

        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO);
        return "editform";
    }
    @ModelAttribute("u")
    public BoardVO getBoardVO() {
        return new BoardVO(); // 적절한 객체 반환 or 초기화
    }

    @RequestMapping(value="/editok", method=RequestMethod.POST)
    public String editPostOk(@ModelAttribute("u") BoardVO vo){

        if(boardService.updateBoard(vo) == 0){
            System.out.println("데이터 수정 실패");
        }
        else
            System.out.println("데이터 수정 성공!!!");
        return "redirect:list";
    }

    @RequestMapping(value="/deleteok/{id}", method=RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id){

        if(boardService.deleteBoard(id) == 0){
            System.out.println("데이터 삭제 실패");
        }
        else
            System.out.println("데이터 삭제 성공!!!");
        return "redirect:../list";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
