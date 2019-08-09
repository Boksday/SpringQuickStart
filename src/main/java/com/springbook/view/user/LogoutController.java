package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

public class LogoutController {

  @RequestMapping("/logout.do")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:login.jsp";
  }
}
