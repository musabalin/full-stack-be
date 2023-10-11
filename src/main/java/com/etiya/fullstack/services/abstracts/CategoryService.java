package com.etiya.fullstack.services.abstracts;

import com.etiya.fullstack.entities.requests.category.AddCategoryRequest;
import com.etiya.fullstack.entities.requests.category.UpdateCategoryRequest;
import com.etiya.fullstack.entities.resposes.category.GetAllCategoryResponse;
import com.etiya.fullstack.entities.resposes.category.GetCategoryResponse;

import java.util.List;

/**
 * @author musa.balin
 */
public interface CategoryService {
    List<GetAllCategoryResponse> getAll();
    GetCategoryResponse getById(int id);
    void add(AddCategoryRequest request);
    void update(UpdateCategoryRequest request);
    void delete(int id);
}
