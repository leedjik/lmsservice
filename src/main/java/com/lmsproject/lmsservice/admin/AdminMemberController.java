package com.lmsproject.lmsservice.admin;

import com.lmsproject.lmsservice.admin.dto.MemberDto;
import com.lmsproject.lmsservice.admin.model.MemberParam;
import com.lmsproject.lmsservice.member.service.MemberService;
import com.lmsproject.lmsservice.util.PageUtil;
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

        memberParam.init();

        List<MemberDto> members = memberService.list(memberParam);


        long totalCount = 0;
        if(members != null && members.size() > 0){
            totalCount = members.get(0).getTotalCount();
        }
        String queryString = memberParam.getQueryString();

        PageUtil pageUtil = new PageUtil(totalCount, memberParam.getPageIndex(), memberParam.getPageIndex(), queryString);
        model.addAttribute("pager", pageUtil.pager());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", members);

        return "admin/member/list";
    }
    @GetMapping("/admin/member/detail.do")
    public String detail(Model model, MemberParam memberParam){

        memberParam.init();

        MemberDto member = memberService.detail(memberParam.getUserId());
        model.addAttribute("member", member);

        return "admin/member/detail";
    }

}
