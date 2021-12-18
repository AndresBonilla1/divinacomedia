package com.sergioarboleda.divinacomedia.repository.crud;

import com.sergioarboleda.divinacomedia.model.HairProduct;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Esta interface extiende de MongoRepository, contiene el CRUD para la
 * colección hairproducts con llave primaria String.
 * 
 * @since 06-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct, String> {
    
    /**
     * Obtiene una lista de productos con el precio menor o igual al ingresado.
     * 
     * @param precio Precio
     * @return Lista de productos
     */
    public List<HairProduct> findByPriceLessThanEqual(Double precio);
    
    /**
     * Obtiene una lista de productos buscando las que la cadena ingresada este
     * contenida en la descripción del producto, ignorando mayusculas y
     * minusculas. El like y el regex en el query ambas sirven para buscar la
     * cadena en la descripción.
     * 
     * @param description Cadena de caracteres buscada
     * @return Lista de productos
     */
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<HairProduct> findByDescriptionLike(String description);
}
