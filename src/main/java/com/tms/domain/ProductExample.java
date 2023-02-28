package com.tms.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "product_example")
public class ProductExample {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "p_seq")
    @SequenceGenerator(name = "p_seq", sequenceName = "product_example_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "product_info")
    private String productInfo;

    @ManyToMany(mappedBy = "productsExample")
    List<CustomerExample> customers;
}
