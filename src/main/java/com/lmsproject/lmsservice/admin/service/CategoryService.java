package com.lmsproject.lmsservice.admin.service;

import com.lmsproject.lmsservice.admin.dto.CategoryDto;
import com.lmsproject.lmsservice.admin.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryService {
    //CRUD interface 담당

    List<CategoryDto> list();
    /**
     * 카테고리 신규 추가
     */

    boolean add(String categoryName);

    /**
     * 카테고리 수정
     */
    boolean update(CategoryDto categoryDto);

    /**
     * 카테고리 삭제
     */
    boolean del(long id);


}