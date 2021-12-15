package com.sergioarboleda.divinacomedia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase es auxiliar, para recibir la información que viene de la
 * petición PUT para actualizar el status de las ordenes. Utiliza lombok para
 * simplificar la codificación. Esta clase posee todos sus atributos
 * encapsulados y dos constructores: uno vacio y el otro con todos sus 
 * atributos.
 *
 * @since 15-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actualizar {
    
    /**
     * El id de la orden.
     */
    private Integer id;
    
    /**
     * El status de la orden a actualizar.
     */
    private String status;
}
