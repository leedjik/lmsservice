package com.lmsproject.lmsservice;

// MainPage를 만드는 목적은 매핑하기 위함
// 논리적인 인터넷 주소 <-> 물리적인 파일
// 매핑 가능한 주체: 클래스, 속성, 메소드

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 한글 사용하기 위해 사전 설정
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        String msg = "<p>hello</p>" + "<p>안녕하세요!!</p>";

        printWriter.write(msg);
        printWriter.close();
    }
}
