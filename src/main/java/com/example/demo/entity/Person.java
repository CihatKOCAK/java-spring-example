package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class Person {
    @Id
    @SequenceGenerator(name = "persons_id_seq", sequenceName = "persons_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "persons_id_seq", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "first_name")
    private String firstName;

    @Column(length = 100, name = "last_name")
    private String lastName;

    @Column(length = 11, name = "phone")
    private String phone;

    @Column(length = 50, name = "email")
    private String email;

    @Column(name = "status")
    private Boolean status;

    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Address> addressList; // OneToMany -> join

}
