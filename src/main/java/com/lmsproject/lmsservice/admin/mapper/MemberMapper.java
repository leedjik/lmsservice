package com.lmsproject.lmsservice.admin.mapper;

import com.lmsproject.lmsservice.admin.dto.MemberDto;
import com.lmsproject.lmsservice.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 멤버라는 DB에 대해 쿼리를 수행할 수 있는 인터페이스
@Mapper
public interface MemberMapper {

    List<MemberDto> selectList(MemberParam memberDto);
}

