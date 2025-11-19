package com.shop.shopping.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.shopping.board.domain.Board;
import com.shop.shopping.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> list() throws Exception {
        List<Board> boardList = boardMapper.list();
        return boardList;
    }

    @Override
    public Board read(int no) throws Exception {
        return boardMapper.read(no);
    }

    @Override
    public int insert(Board board) throws Exception {
        return boardMapper.insert(board);
    }

    @Override
    public int update(Board board) throws Exception {
        return boardMapper.update(board);
    }

    @Override
    public int delete(int no) throws Exception {
        return boardMapper.delete(no);
    }
    
}
