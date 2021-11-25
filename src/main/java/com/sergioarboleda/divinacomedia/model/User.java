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
 * Esta clase es un entity, implementa la interface Serializable y corresponde
 * a la tabla user en la base de datos. Utiliza lombok para simplificar la
 * codificación. Esta clase posee todos sus atributos encapsulados y dos
 * constructores: uno vacio y el otro con todos sus atributos.
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

    /**
     * Este atributo corresponde a la llave primaria de la tabla, es de tipo
     * Integer y autoincremental.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Este atributo corresponde al email del usuario, es unico, varchar(50) y
     * not null.
     */
    @Column(name = "user_mail", unique = true, length = 50, nullable = false)
    private String email;

    /**
     * Este atributo corresponde a la contraseña del usuario, varchar(50) y not
     * null.
     */
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;

    /**
     * Este atributo corresponde al nombre del usuario, varchar(80) y not null.
     */
    @Column(name = "user_name", length = 80, nullable = false)
    private String name;
}
