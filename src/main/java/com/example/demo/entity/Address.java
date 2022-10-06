package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "person_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class Address implements java.io.Serializable {

    @Id
    @SequenceGenerator(name = "seq_address_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_address_id", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500, name = "address")
    private String address;
    

    @Column(name = "status")
    private Boolean status;

    @Enumerated
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Person person;

    public enum AddressType {
        HOME,
        WORK,
        OTHER
    }
}