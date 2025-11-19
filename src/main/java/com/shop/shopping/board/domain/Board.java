package com.shop.shopping.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
    
    private Long no;            // 게시글 번호
    private int boardType;      // 게시글 유형
    private String category;    // 카테고리
    private String title;       // 제목
    private String writer;      // 작성자
    private String content;     // 내용
    private Date createdAt;     // 작성일
    private Date updatedAt;     // 수정일
    private int viewCount;      // 조회수


}
