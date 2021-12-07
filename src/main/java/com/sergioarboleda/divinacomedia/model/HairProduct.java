package com.sergioarboleda.divinacomedia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta clase es un document y corresponde a la colección de hairproducts.
 * Utiliza lombok para simplificar la codificación. Esta clase posee todos sus
 * atributos encapsulados y dos constructores: uno vacio y el otro con todos sus 
 * atributos.
 * 
 * @since 06-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hairproducts")
public class HairProduct {

    /**
     * Este atributo corresponde a la llave primaria del documento y es de tipo
     * String.
     */
    @Id
    @JsonProperty("reference")
    private String id;

    /**
     * Este atributo corresponde a la marca del producto.
     */
    @JsonProperty("brand")
    private String brand;

    /**
     * Este atributo corresponde a la categoria del producto.
     */
    @JsonProperty("category")
    private String category;

    /**
     * Este atributo corresponde al nombre del producto.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Este atributo corresponde a la descripción del producto.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Este atributo corresponde a la disponibilidad del producto.
     */
    @JsonProperty("availability")
    private Boolean availability = true;

    /**
     * Este atributo corresponde al precio del producto.
     */
    @JsonProperty("price")
    private Double price;

    /**
     * Este atributo corresponde al stock del producto.
     */
    @JsonProperty("quantity")
    private Integer quantity;

    /**
     * Este atributo corresponde a la url de la foto del producto.
     */
    @JsonProperty("photography")
    private String photography;
}
