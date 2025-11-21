package com.shop.shopping.common.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Files {

    private int no; // 파일 번호
    private String parentTable; // 부모 테이블 정보
    private int parentNo; // 부모 엔티티 번호
    private String fileName; // 파일 이름
    private String originName; // 원파일 이름
    private String filePath; // 파일 경로
    private long fileSize; // 파일 사이즈
    private Date createdAt; // 등록일자
    private Date updatedAt; // 수정일자
    private int fileCode; // 파일 코드

    private MultipartFile file; // MultipartFile 객체

}
