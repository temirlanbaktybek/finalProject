package com.example.project666.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Component
@Table(name = "JobSeeker")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker implements Serializable {

    @Id
    @Column( name = "jobseeker_login")
    private String JobSeekerLogin;

    @Column( name = "jobseeker_password")
    private String JobSeekerPassword;

    @OneToOne(cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn( name = "jobseeker_cv")
    private CV cv;

    @Column( name = "roles")
    private String roles;

}
