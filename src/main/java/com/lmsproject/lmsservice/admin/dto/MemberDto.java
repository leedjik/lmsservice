package com.lmsproject.lmsservice.admin.dto;

import com.lmsproject.lmsservice.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberDto {

    String userId;
    String userName;
    String password;
    String phone;
    LocalDateTime regDt;

    boolean emailAuthYn;
    LocalDateTime emailAuthDt;
    String emailAuthKey;

    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;

    boolean adminYn;
    String userStatus;

    // 추가 컬럼
    long totalCount;
    long seq;

    public static MemberDto of(Member member){

        return MemberDto.builder()
                .userId(member.getUserId())
                .userName(member.getUserName())
                .phone(member.getPhone())
                //.password(member.getPassword())
                .regDt(member.getRegDt())
                .emailAuthYn(member.isEmailAuthYn())
                .emailAuthDt(member.getEmailAuthDt())
                .emailAuthKey(member.getEmailAuthKey())
                .resetPasswordKey(member.getResetPasswordKey())
                .resetPasswordKey(member.getResetPasswordKey())
                .adminYn(member.isAdminYn())
                .userStatus(member.getUserStatus())
                .build();
    }
}
