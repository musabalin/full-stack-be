package com.etiya.fullstack.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author musa.balin
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "unitPrice")
    private float unitPrice;
    @Column(name = "stock")
    private String stock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
