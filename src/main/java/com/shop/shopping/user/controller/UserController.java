package com.shop.shopping.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.shopping.user.domain.Users;
import com.shop.shopping.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * 회원가입 화면
     * @return
     */
    @GetMapping("/join")
    public String join() {
        return "/join";
    }


    /**
     * 회원 가입 처리
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/join")
    public String joinPost(Users user, HttpServletRequest request) throws Exception{

        // 암호화전 비밀번호 호출
        String plainPassword = user.getPassword();
        // 회원가입 요청
        int result = userService.join(user);
        // 회원가입시 바로 로그인
        boolean loginResult = false;
        if (result > 0) {
            // 암호화 전 비밀번호로 다시 세팅
            user.setPassword(plainPassword);
            loginResult = userService.login(user, request); // 바로 로그인
        }
        if (loginResult) {
            // 메인 화면으로 이동
            return "redirect:/";
        }
        if (result > 0) {
            // 로그인 화면으로 이동
            return "redirect:/login";
        }
        return "redirect:/join?error=true";
    }
    
    

}
