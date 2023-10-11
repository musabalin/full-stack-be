package com.etiya.fullstack.entities.resposes.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author musa.balin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryResponse {
    private int id;
    private String name;
}
