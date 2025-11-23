package com.shop.shopping.common.domain;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Files {
 
    private int no; // 파일 번호
    private String id; // 파일 고유 아이디
    private String fileName; // 파일 이름
    private String filePath; // 파일 경로
    private long fileSize; // 파일 사이즈
    private String type; // 타입 ('main', 'sub')
    private String originName; // 원파일 이름
    private String parentTable; // 부모 테이블 정보
    private int parentNo; // 부모 엔티티 번호
    private Date createdAt; // 등록일자
    private Date updatedAt; // 수정일자

    private MultipartFile file; // MultipartFile 객체

    public Files() {
        this.id = UUID.randomUUID().toString();
    }

}
