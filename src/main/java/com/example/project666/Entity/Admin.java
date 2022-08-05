package com.example.project666.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adminn")
public class Admin implements Serializable {

    @Id
    @Column(name = "admin_login")
    private String adminLogin;

    @Column( name = "admin_password")
    private String adminPassword;


    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Column( name = "roles")
    private String roles;

}
