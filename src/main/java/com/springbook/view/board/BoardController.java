package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
  @Autowired
  BoardService boardService;
  //글 등록
  @RequestMapping(value="/insertBoard.do")
  public String insertBoard(BoardVO vo) {
    boardService.insertBoard(vo);
    return "redirect:getBoardList.do";
  }
  
  //글 수정
  @RequestMapping("/updateBoard.do")
  public String updateBoard(@ModelAttribute("board") BoardVO vo) {
    boardService.updateBoard(vo);
    return "getBoardList.do";
  }
  
  //글 삭제
  @RequestMapping("/deleteBoard.do")
  public String deleteBoard(BoardVO vo) {
    boardService.deleteBoard(vo);
    return "getBoardList.do";
  }
  
  //글 상세조회
  @RequestMapping("/getBoard.do")
  public String getBoard(BoardVO vo, Model model) {
    model.addAttribute("board", boardService.getBoard(vo));
    return "getBoard.jsp";
  }
  
  //글 목록 검색
  @RequestMapping("/getBoardList.do")
  public String getBoardList(BoardVO vo, Model model) {
    if(vo.getSearchCondition() == null) {
      vo.setSearchCondition("TITLE");
    }
    if(vo.getSearchKeyword() == null) {
      vo.setSearchKeyword("");
    }
    model.addAttribute("boardList", boardService.getBoardList(vo));
    return "getBoardList.jsp";
  }
  
  //검색 조건 목록 설정
  @ModelAttribute("conditionMap")
  public Map<String, String> searchConditionMap(){
    Map<String, String> conditionMap = new HashMap<String, String>();
    conditionMap.put("제목", "TITLE");
    conditionMap.put("내용", "CONTENT");
    return conditionMap;
  }
}
