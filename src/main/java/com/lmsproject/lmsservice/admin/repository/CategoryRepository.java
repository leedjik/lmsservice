package com.lmsproject.lmsservice.admin.repository;

import com.lmsproject.lmsservice.admin.entity.Category;
import com.lmsproject.lmsservice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}