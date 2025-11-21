package com.shop.shopping.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.shopping.board.domain.Board;
import com.shop.shopping.board.mapper.BoardMapper;
import com.shop.shopping.common.domain.Files;
import com.shop.shopping.common.domain.Page;
import com.shop.shopping.common.service.FileService;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    private FileService fileService;

    /**
     * 게시판 리스트(목록)
     */
    @Override
    public List<Board> list(Page page) throws Exception {

        int total = boardMapper.count();
        page.setTotal(total);

        List<Board> boardList = boardMapper.list(page);

        return boardList;

    }

    @Override
    public Board read(int no) throws Exception {
        Board board = boardMapper.read(no);
        return board;
    }

    @Override
    public int insert(Board board) throws Exception {

        int result = boardMapper.insert(board);

        String parentTable = "board";
        int parentNo = boardMapper.maxPk();

        List<MultipartFile> fileList = board.getFile();

        if (!fileList.isEmpty()) {
            for (MultipartFile file : fileList) {
                if (file.isEmpty())
                    continue;

                // 파일 정보 등록
                Files uploadFile = new Files();

                uploadFile.setParentTable(parentTable);
                uploadFile.setParentNo(parentNo);
                uploadFile.setFile(file);

                fileService.upload(uploadFile);
            }
        }
        if (result > 0) {
            return result;
        }
        return 0;

    }

    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);
        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        int result = boardMapper.delete(no);
        return result;
    }

}
