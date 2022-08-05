package com.example.project666.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Component
@Entity
@Table(name = "Headhunter")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value= {"tests"})
public class HeadHunter implements Serializable {

    @Id
    @Column (name = "headhunter_login")
    private String headhunter_login;

    @Column (name = "headhunter_password")
    private String headhunter_password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "headhunter_test")
    private List<Tests> tests;

    @Column( name = "roles")
    private String roles;


    public void updateTest(Tests test){
        tests.add(test);
    }
}
