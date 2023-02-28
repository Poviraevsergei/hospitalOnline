package com.tms.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "user_example")
public class UserExample {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "u_seq")
    @SequenceGenerator(name = "u_seq", sequenceName = "user_example_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "username")
    private String username;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerExample customer;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usersExamples")
    Collection<TelephoneExample> telephones;
}
