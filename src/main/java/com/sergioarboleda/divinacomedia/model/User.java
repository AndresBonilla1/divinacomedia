/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase User, esta clase permite crear objetos tipo user para . Utiliza lombok
 * para simplificar la codificación. Esta clase posee todos sus atributos
 * encapsulados y posee dos constructores: uno vacio y el otro incluyendo todos
 * sus argumentos.
 * 
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "user_mail", unique = true, length = 50, nullable = false)
    private String email;
    
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;
    
    @Column(name = "user_name", length = 80, nullable = false)
    private String name;
}
