package com.lmsproject.lmsservice.member.controller;

import com.lmsproject.lmsservice.member.model.MemberInput;
import com.lmsproject.lmsservice.member.model.ResetPasswordInput;
import com.lmsproject.lmsservice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/member/login")
    public String login() {

        return "member/login";
    }
    
    @GetMapping("/member/find-password")
    public String findPassword() {
        
        return "member/find_password";
    }
    
    @PostMapping("/member/find-password")
    public String findPasswordSubmit(Model model, ResetPasswordInput parameter) {
    
        boolean result = memberService.sendResetPassword(parameter);
        model.addAttribute("result", result);
        
        return "member/find_password_result";
    }

    @GetMapping("/member/register")
    public String register(){
        return "member/register";
    }

    @PostMapping("/member/register")
    public String registerSubmit(
                                Model model,    // 클라이언트에 data내리기위한 인터페이스
                                HttpServletRequest request,
                                MemberInput memberInput){

        boolean result = memberService.register(memberInput);

        model.addAttribute("result", result);

        return "member/register_complete";
    }

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, HttpServletRequest httpServletRequest){

        String uuid = httpServletRequest.getParameter("id");

        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);

        return "member/email_auth";
    }

    @GetMapping("/member/info")
    public String memberInfo(){

        return "member/info";
    }
}
