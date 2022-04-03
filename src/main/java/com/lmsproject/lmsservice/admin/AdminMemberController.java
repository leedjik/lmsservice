package com.lmsproject.lmsservice.admin;

import com.lmsproject.lmsservice.admin.dto.MemberDto;
import com.lmsproject.lmsservice.admin.model.MemberParam;
import com.lmsproject.lmsservice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminMemberController {

    private final MemberService memberService;

    @GetMapping("/admin/member/list.do")
    public String list(Model model, MemberParam memberParam){

        List<MemberDto> members = memberService.list(memberParam);

        model.addAttribute("list", members);

        return "admin/member/list";
    }

}
