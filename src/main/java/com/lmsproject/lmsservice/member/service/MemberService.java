package com.lmsproject.lmsservice.member.service;

import com.lmsproject.lmsservice.admin.dto.MemberDto;
import com.lmsproject.lmsservice.admin.model.MemberParam;
import com.lmsproject.lmsservice.member.entity.Member;
import com.lmsproject.lmsservice.member.model.MemberInput;
import com.lmsproject.lmsservice.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService extends UserDetailsService {
    
    boolean register(MemberInput parameter);

    /**
     * uuid에 해당하는 계정을 활성화 함
     */

    boolean emailAuth(String uuid);
    
    /**
     * 입력한 이메일로 비밀번호 초기화 정보를 전송
     */
    boolean sendResetPassword(ResetPasswordInput parameter);

    /**
     * 회원 목록 리턴(관리자에서만 사용 가능)
     */
    List<MemberDto> list(MemberParam memberParam);

    /**
     * 회원 상세 정보
     */
    MemberDto detail(String userId);
}


