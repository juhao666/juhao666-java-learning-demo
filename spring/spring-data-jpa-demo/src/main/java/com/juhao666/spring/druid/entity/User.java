package com.juhao666.spring.druid.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "public", indexes = {@Index(name = "uk_email", columnList = "email", unique = true)})
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "integer")
    Integer id;
    @Column(nullable = false, length = 20, columnDefinition = "character varying(20)")
    String name;
    @Transient
    int age;
    @Column(nullable = false, length = 60, columnDefinition = "character varying(60)")
    String email;
    LocalDate birthDay;
}
