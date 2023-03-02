package com.tms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@ToString(exclude = {"customers"})
@EqualsAndHashCode(exclude = {"customers"})
@Entity
@Table(name = "product_example")
public class ProductExample {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "p_seq")
    @SequenceGenerator(name = "p_seq", sequenceName = "product_example_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "product_info")
    private String productInfo;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    Set<CustomerExample> customers;
}