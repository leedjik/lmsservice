package com.lmsproject.lmsservice.admin.service;

import com.lmsproject.lmsservice.admin.dto.CategoryDto;
import com.lmsproject.lmsservice.admin.entity.Category;
import com.lmsproject.lmsservice.admin.model.CategoryInput;
import com.lmsproject.lmsservice.admin.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    //CRUD 구현 class

    private final CategoryRepository categoryRepository;
    private Sort getSortBySortValueDesc(){
        return Sort.by(Sort.Direction.DESC, "sortValue");
    }

    @Override
    public List<CategoryDto> list() {
       // List<CategoryDto> categoryDtoList = new ArrayList<>();


        List<Category> categories = categoryRepository.findAll(getSortBySortValueDesc());

        return CategoryDto.of(categories);

        /*
        CategoryDto.java에서 List<Category>를 만들어주는 of함수를 만들었으므로
        아래 내용은 굳이 해줄 필요가 없다.
        if(CollectionUtils.isEmpty(categories)){

            categories.forEach(e ->{
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(e.getId());
                categoryDto.setCategoryName(e.getCategoryName());

                categoryDtoList.add(categoryDto);
            });
        }

        return categoryDtoList;
        */
    }

    @Override
    public boolean add(String categoryName) {
        // 그냥 추가만 하면 되는데, 동일한 카테고리에 대해서 체크해야하는 이슈가 있다.
        Category category = Category.builder()
                .categoryName(categoryName)
                .usingYn(true)
                .sortValue(0)   //가장 많은 애가 앞에 오도록
                .build();

        categoryRepository.save(category);

        return true;
    }

    @Override
    public boolean update(CategoryInput categoryInput) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryInput.getId());

        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setCategoryName(categoryInput.getCategoryName());
            category.setSortValue(categoryInput.getSortValue());
            category.setUsingYn(categoryInput.isUsingYn());
            categoryRepository.save(category);
        }

        return true;
    }

    @Override
    public boolean del(long id) {

        categoryRepository.deleteById(id);

        return true;
    }





}