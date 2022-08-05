package com.example.project666.Entity;


import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.*;

@Data
@Entity
@Table(name = "test_result")
public class TestResult implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "test_result_id")
    private long id;

    @OneToOne(cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private Tests tests;

    @Column(name = "a1")
    private String a1;

    @Column(name = "a2")
    private String a2;

    @Column(name = "a3")
    private String a3;

    @OneToOne(cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "jobseeker_login")
    private JobSeeker jobSeeker;

}
