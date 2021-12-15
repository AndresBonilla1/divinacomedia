package com.sergioarboleda.divinacomedia.model;

import java.util.Date;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta clase es un document y corresponde a la colección de usuarios. Utiliza 
 * lombok para simplificar la codificación. Esta clase posee todos sus atributos
 * encapsulados y dos constructores: uno vacio y el otro con todos sus 
 * atributos.
 *
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class User {

    /**
     * Este atributo corresponde a la llave primaria del documento y es de tipo
     * Integer.
     */
    @Id
    private Integer id;

    /**
     * Este atributo corresponde a la identificación del usuario.
     */
    private String identification;
    
    /**
     * Este atributo corresponde al nombre del usuario, varchar(80) y not null.
     */
    private String name;
    
    /**
     * Este atributo corresponde a la fecha de nacimiento.
     */
    private Date birthtDay;
    
    /**
     * Este atributo corresponde al mes de nacimiento.
     */
    private String monthBirthtDay;
    
    /**
     * Este atributo corresponde a la direccion del usuario.
     */
    private String address;
    
    /**
     * Este atributo corresponde al celular del usuario.
     */
    private String cellPhone;
    
    /**
     * Este atributo corresponde al email del usuario.
     */
    private String email;

    /**
     * Este atributo corresponde a la contraseña del usuario.
     */
    private String password;
    
    /**
     * Este atributo corresponde a la zona del usuario.
     */
    private String zone;
    
    /**
     * Este atributo corresponde al tipo o cargo del usuario.
     */
    private String type;
}
