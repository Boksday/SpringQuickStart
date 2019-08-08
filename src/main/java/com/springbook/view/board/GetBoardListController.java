package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
    BoardVO vo = new BoardVO();
    BoardDAO boardDAO = new BoardDAO();
    
    List<BoardVO> boardList = boardDAO.getBoardList(vo);
    
    ModelAndView mav = new ModelAndView();
    mav.setViewName("getBoardList");
    mav.addObject("boardList", boardList);
    return mav;
  }
}
