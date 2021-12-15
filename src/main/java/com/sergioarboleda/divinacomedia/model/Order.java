package com.sergioarboleda.divinacomedia.model;

import java.util.Date;
import java.util.Map;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta clase es un document y corresponde a la colección de ordenes. Utiliza 
 * lombok para simplificar la codificación. Esta clase posee todos sus atributos
 * encapsulados y dos constructores: uno vacio y el otro con todos sus 
 * atributos.
 *
 * @since 12-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * Atributo static que corresponde al estado de la orden Pendiente.
     */
    public static String PENDING = "Pendiente";

    /**
     * Atributo static que corresponde al estado de la orden Aprobada.
     */
    public static String APROVED = "Aprobada";

    /**
     * Atributo static que corresponde al estado de la orden Rechazada.
     */
    public static String REJECTED = "Rechazada";

    /**
     * Este atributo corresponde al id de la orden.
     */
    @Id
    private Integer id;

    /**
     * Este atributo corresponde a la fecha de registro de la orden.
     */
    private Date registerDay;

    /**
     * Este atributo corresponde al estado de la orden.
     */
    private String status;

    /**
     * Este atributo corresponde al asesor comercial que creo la orden.
     */
    private User salesMan;

    /**
     * Este atributo corresponde a los productos de la orden.
     */
    private Map<String, HairProduct> products;

    /**
     * Este atributo corresponde las cantidades de los productos en la orden.
     */
    private Map<String, Integer> quantities;

}
