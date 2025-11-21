package com.shop.shopping.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.shopping.board.domain.Board;
import com.shop.shopping.board.service.BoardService;
import com.shop.shopping.common.domain.Files;
import com.shop.shopping.common.domain.Page;
import com.shop.shopping.common.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private FileService fileService;

    @GetMapping("/list")
    public void list(Model model, Page page) throws Exception {

        List<Board> boardList = boardService.list(page);

        model.addAttribute("boardList", boardList);
        model.addAttribute("page", page);

    }

    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model, Files file) throws Exception {

        // 게시글 조회
        Board board = boardService.read(no);
        model.addAttribute("board", board);

        // 파일 목록 요청
        file.setParentNo(board.getNo());
        file.setParentTable("board");

        log.info("file : " + file);
        List<Files> fileList = fileService.listByParent(file);
        // 모델 등록
        model.addAttribute("fileList", fileList);

        // 뷰 페이지 지정
        return "/board/read";

    }

    @GetMapping("/insert")
    public String insert() throws Exception {

        return "/board/insert";

    }

    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {

        log.info("board : " + board);
        int result = boardService.insert(board);

        if (result > 0) {
            return "redirect:/board/list";
        }
        return "/board/insert";

    }

    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception {

        Board board = boardService.read(no);
        
        model.addAttribute("board", board);

        return "/board/update";

    }

    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {

        int result = boardService.update(board);

        if (result > 0) {
            return "redirect:/board/list";
        }
        int no = board.getNo();
        return "redirect:/board/update?no=" + no + "&error";

    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {

        int result = boardService.delete(no);

        if (result > 0) {
            return "redirect:/board/list";
        }

        return "redirect:/board/update?no=" + no + "&error";

    }

}
