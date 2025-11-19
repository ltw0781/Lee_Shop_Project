package com.shop.shopping.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.shopping.user.domain.CustomUser;
import com.shop.shopping.user.domain.Users;
import com.shop.shopping.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    // public String main(Principal principal, Model model) throws Exception {
    // public String main(Authentication authentication, Model model) throws Exception {
    public String main(@AuthenticationPrincipal CustomUser authUser, Model model) throws Exception {

        log.info(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;메인화면;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");

        // if (principal != null) {
        //     String username = principal.getName(); // 인증된 사용자 아이디
        //     log.info("username : {}", username);
        //     Users user = userService.select(username); // 사용자 정보 조회
        //     log.info("user : {}", user);
        //     model.addAttribute("user", user); // 사용자 정보 모델에 등록
        // }

        // if (authentication != null) {
        //     User user = (User) authentication.getPrincipal();
        //     String username = user.getUsername();                               // 인증된 사용자 아이디
        //     String password = user.getPassword();                               // 인증된 사용자 비밀번호
        //     Collection<GrantedAuthority> authList = user.getAuthorities();      // 사용자 권한
        //     log.info("username : {}", username);
        //     log.info("password : {}", password);
        //     log.info("authList : {}", authList);

        //     Users joinedUser = userService.select(username);                    // 사용자 정보 조회
        //     log.info("joinedUser : {}", joinedUser);

        //     model.addAttribute("user", user);                     // 사용자 정보 모델에 등록

        // }

        if (authUser != null) {
            
            log.info("authUser : {}", authUser);
            Users user = authUser.getUser();
            model.addAttribute("user", user);

        }

        return "index";
    }

    /**
     * 회원가입 화면
     * 
     * @return
     */
    @GetMapping("/join")
    public String join() {
        return "/join";
    }

    /**
     * 회원 가입 처리
     * 
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/join")
    public String joinPost(Users user, HttpServletRequest request) throws Exception {

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

    /**
     * 로그인 화면
     * @return
     */
    @GetMapping("/login")
    public String login() {
        log.info(";;;;;;;;;;;;;;;;;;로그인 페이지;;;;;;;;;;;;;;;;;;");
        return "login";
    }
    

}
