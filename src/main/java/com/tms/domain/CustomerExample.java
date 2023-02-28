package com.tms.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "customer_example")
public class CustomerExample {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_seq")
    @SequenceGenerator(name = "c_seq", sequenceName = "customer_example_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @JsonBackReference
    @OneToOne(mappedBy = "customer")
    private UserExample userExample;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "l_product_customer",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    List<ProductExample> productsExample;
}
