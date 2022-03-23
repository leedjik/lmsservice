package com.lmsproject.lmsservice.member.repository;

import com.lmsproject.lmsservice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
