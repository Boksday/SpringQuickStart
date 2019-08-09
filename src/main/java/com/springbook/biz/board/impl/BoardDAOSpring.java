package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select IFNULL(max(seq),0)+1 from board a),?,?,?)";
  private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
  private final String BOARD_DELETE = "delete board where seq=?";
  private final String BOARD_GET = "select * from board where seq=?";
  private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
  private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";

  // CRUD 기능

  // 글 등록
  public void insertBoard(BoardVO vo) {
    System.out.println("JDBC TEMPLATE");
    jdbcTemplate.update(BOARD_INSERT,vo.getTitle(), vo.getWriter(), vo.getContent());
  }

  // 글 수정
  public void updateBoard(BoardVO vo) {
    System.out.println("JDBC TEMPLATE");
    jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
  }

  // 글 삭제
  public void deleteBoard(BoardVO vo) {
    System.out.println("JDBC TEMPLATE");
    jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
  }

  // 글 상세조회
  public BoardVO getBoard(BoardVO vo) {
    System.out.println("JDBC TEMPLATE");
    Object[] args = { vo.getSeq() };
    return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
  }

  public List<BoardVO> getBoardList(BoardVO vo) {
    System.out.println("JDBC TEMPLATE");
    Object[] args = {vo.getSearchKeyword()};
    if(vo.getSearchCondition().equals("TITLE")) {
      return jdbcTemplate.query(BOARD_LIST_T,args, new BoardRowMapper());
    }else if(vo.getSearchCondition().equals("CONTENT")) {
      return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
    }
    return null;
  }
}
