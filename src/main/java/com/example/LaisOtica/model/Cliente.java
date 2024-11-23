package com.example.LaisOtica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@ToString
public class Cliente {

    @Id
    @Autowired
    private Long id;
    private String name;
    private String email;
    private int cpf;
    private Date data;
    private Lente lente;

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }

}
