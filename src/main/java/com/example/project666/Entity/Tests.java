package com.example.project666.Entity;

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
@Table(name = "tests")
public class Tests implements Serializable {

    @Id
    @Column(name = "test_id")
    private long test_id;

    @Column(name = "q1")
    private String question1;

    @Column(name = "q2")
    private String question2;

    @Column(name = "q3")
    private String question3;

}
