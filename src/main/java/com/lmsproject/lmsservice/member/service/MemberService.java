package com.lmsproject.lmsservice.member.service;

import com.lmsproject.lmsservice.member.model.MemberInput;
import com.lmsproject.lmsservice.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService {

    boolean register(MemberInput parameter);

    /**
     * uuid에 해당하는 계정을 활성화 함
     */

    boolean emailAuth(String uuid);
    
    /**
     * 입력한 이메일로 비밀번호 초기화 정보를 전송
     */
    boolean sendResetPassword(ResetPasswordInput parameter);
}
