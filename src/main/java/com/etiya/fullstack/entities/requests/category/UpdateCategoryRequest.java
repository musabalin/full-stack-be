package com.etiya.fullstack.entities.requests.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author musa.balin
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
    @Min(1)
    private int id;

    @NotBlank()
    @Size(min = 3, message = "Name should be longer than 3 characters.")
    private String name;
}