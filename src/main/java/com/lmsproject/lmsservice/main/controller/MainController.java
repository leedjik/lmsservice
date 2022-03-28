package com.lmsproject.lmsservice.main.controller;

// MainPage를 만드는 목적은 매핑하기 위함
// 논리적인 인터넷 주소 <-> 물리적인 파일
// 매핑 가능한 주체: 클래스, 속성, 메소드

import com.lmsproject.lmsservice.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/error/denied")
    public String errorDenied(){

        return "error/denied";
    }
}
