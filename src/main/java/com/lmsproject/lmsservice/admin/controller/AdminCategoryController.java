package com.lmsproject.lmsservice.admin.controller;

import com.lmsproject.lmsservice.admin.dto.CategoryDto;
import com.lmsproject.lmsservice.admin.model.CategoryInput;
import com.lmsproject.lmsservice.admin.model.MemberParam;
import com.lmsproject.lmsservice.admin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminCategoryController {

    private final CategoryService categoryService;

    @GetMapping("/admin/category/list.do")
    public String list(Model model, MemberParam memberParam){

        List<CategoryDto> list = categoryService.list();
        model.addAttribute("list", list);

        return "admin/category/list";
    }

    @PostMapping("/admin/category/add.do")
    public String add(Model model, CategoryInput categoryInput){

        boolean result = categoryService.add(categoryInput.getCategoryName());

        return "redirect:/admin/category/list.do";
    }

    @PostMapping("/admin/category/delete.do")
    public String del(Model model, CategoryInput categoryInput){
        categoryService.del(categoryInput.getId());

        return "redirect:/admin/category/list.do";
    }

    @PostMapping("/admin/category/update.do")
    public String update(Model model, CategoryInput categoryInput){
        boolean result = categoryService.update(categoryInput);

        return "redirect:/admin/category/list.do";
    }
}
