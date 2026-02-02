package com.thephoenixcollective.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hr_contacts", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
public class HRContactsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hr_name", nullable = false)
    private String name;

    private String title;

    @Column(name = "company_name", nullable = false)
    private String company;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String status;

}
