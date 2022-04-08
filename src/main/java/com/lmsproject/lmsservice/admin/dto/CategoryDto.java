package com.lmsproject.lmsservice.admin.dto;


import com.lmsproject.lmsservice.admin.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDto {

    Long id;

    String categoryName;
    int sortValue;
    boolean usingYn;    // 현재 사용 여부

    public static List<CategoryDto> of (List<Category> categories){
        if(categories != null) {
            List<CategoryDto> categoryDtoList = new ArrayList<>();

            for (Category x : categories) {
                categoryDtoList.add(of(x));
            }
            return categoryDtoList;
        }
        return null;
    }

    public static CategoryDto of (Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .sortValue(category.getSortValue())
                .usingYn(category.isUsingYn())
                .build();
    }
}
