package com.shop.shopping.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shop.shopping.user.domain.UserAuth;
import com.shop.shopping.user.domain.Users;

@Mapper
public interface UserMapper {

    // 회원 가입
    public int join(Users user) throws Exception;

    // 회원 권한 등록
    public int insertAuth(UserAuth userAuth) throws Exception;

    // 회원 조회
    public Users select(@Param("username") String username) throws Exception;
    
}
