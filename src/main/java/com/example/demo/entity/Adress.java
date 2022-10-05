package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person_adress")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class Adress implements java.io.Serializable {

    @Id
    @SequenceGenerator(name = "adress_id_seq", sequenceName = "adress_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "adress_id_seq", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500, name = "street")
    private String street;
    @Column(length = 500, name = "city")
    private String city;
    @Column(length = 500, name = "country")
    private String country;
    @Column(length = 6, name = "zip")
    private String zipCode;

    @Column(length = 50, name = "status")
    private Boolean status;

    @Enumerated
    private AdressType adressType;

    @ManyToOne
    @JoinColumn(name = "adress_id")
    private Person person;

    enum AdressType {
        HOME,
        WORK,
        OTHER
    }
}