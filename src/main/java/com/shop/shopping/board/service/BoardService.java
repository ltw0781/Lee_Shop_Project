package com.shop.shopping.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.shopping.board.domain.Board;
import com.shop.shopping.common.domain.Page;

public interface BoardService {
    
    // 게시글 목록
    public List<Board> list(@Param("page") Page page) throws Exception;

    // 게시글 상세
    public Board read(int no) throws Exception;

    // 게시글 등록
    public int insert(Board board) throws Exception;

    // 게시글 수정
    public int update(Board board) throws Exception;

    // 게시글 삭제
    public int delete(int no) throws Exception;

}
