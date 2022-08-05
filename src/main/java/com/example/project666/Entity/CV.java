package com.example.project666.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "cv")
public class CV implements Serializable {

    @Id
    @Column(name = "cv_title")
    private String cv_title;

    @Column(name = "cv_name_of_joobseeker")
    private String name;

    @Column(name = "cv_address")
    @NotNull
    private String address;

    @Column(name = "cv_phone")
    private int cv_phone;

    @Column(name = "cv_skills")
    private String cv_skills;

    @Column(name = "cv_work_exp")
    private String cv_work_exp;

}
