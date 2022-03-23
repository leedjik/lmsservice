package com.lmsproject.lmsservice.member.controller;

import com.lmsproject.lmsservice.member.entity.Member;
import com.lmsproject.lmsservice.member.model.MemberInput;
import com.lmsproject.lmsservice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

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
}
