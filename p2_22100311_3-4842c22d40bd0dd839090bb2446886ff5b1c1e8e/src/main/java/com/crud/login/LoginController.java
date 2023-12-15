package com.crud.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/login")
public class LoginController {
    @Autowired
    UserServiceImpl service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }



    @RequestMapping(value = "/loginOk", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, UserVO vo){
        String returnURL = "";
        if(session.getAttribute("login")!=null){
            session.removeAttribute("login");
        }
        // 입력받은 아이디와 비밀번호를 이용하여 데이터베이스에서 사용자 정보를 조회합니다.
        UserVO loginvo = service.getUser(vo);
        if(loginvo!=null){
            // 조회된 사용자 정보가 있다면 로그인 성공
            System.out.println("로그인 성공!");
            session.setAttribute("login",loginvo);
            returnURL = "redirect:/board/list";
        } else{
            // 조회된 사용자 정보가 없다면 로그인 실패
            System.out.println("로그인 실패!");
            session.setAttribute("login_f",0);
            returnURL = "redirect:/login/login";
        }
        return returnURL;
    }


    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login/login";
    }
}
