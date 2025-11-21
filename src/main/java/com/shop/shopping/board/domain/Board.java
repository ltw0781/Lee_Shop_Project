package com.shop.shopping.board.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shop.shopping.common.domain.Files;

import lombok.Data;

@Data
public class Board {
    
    private int no;            // 게시글 ID
    private int boardType;      // 카테고리
    private String category;    // 카테고리
    private String title;       // 게시글 제목
    private String writer;      // 작성자
    private String content;     // 게시글 내용
    private Date createdAt;     // 게시글 등록일자
    private Date updatedAt;     // 게식글 수정일자
    private int viewCount;      // 게시글 조회수

    private Files files;

    private List<MultipartFile> file;

}
