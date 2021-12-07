package com.sergioarboleda.divinacomedia.repository.crud;

import com.sergioarboleda.divinacomedia.model.HairProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Esta interface extiende de CrudRepository, contiene el CRUD para la colección 
 * hairproducts con llave primaria String.
 * 
 * @since 06-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct, String> {
    
}
