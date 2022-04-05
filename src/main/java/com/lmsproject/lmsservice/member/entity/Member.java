package com.lmsproject.lmsservice.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member implements MemberCode{

    @Id
    private String userId;
    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;
    
    private boolean emailAuthYn;
    private LocalDateTime emailAuthDt;
    private String emailAuthKey;
    
    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;
    
    private boolean adminYn;    //관리자 여부
    
    private String userStatus;//이용가능한상태, 정지상태
    
}
