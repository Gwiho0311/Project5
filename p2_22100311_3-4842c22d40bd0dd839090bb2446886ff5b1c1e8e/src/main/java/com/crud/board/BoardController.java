package com.crud.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    BoardServiceImpl boardService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(Model model){
        model.addAttribute("list",boardService.getBoardList());
        return "board/list";
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addPost(){
        return "board/addpostform";
    }
    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOK(BoardVO vo){
        int i = boardService.insertBoard(vo);
        if(i==0)
            System.out.println("실패");
        else
            System.out.println("성공");
        return "redirect:list";
    }
    @RequestMapping(value = "/editform/{id}",method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u",boardVO);
        return "board/editform";
    }
    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo){
        if(boardService.updateBoard(vo)==0)
            System.out.println("실패");
        else
            System.out.println("성공");
        return "redirect:list";
    }
    @RequestMapping(value = "/deleteok/{id}",method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id){
        if(boardService.deleteBoard(id)==0)
            System.out.println("데이터 삭제 실패");
        else
            System.out.println("데이터 삭제 성공");
        return "redirect:../list";
    }
}