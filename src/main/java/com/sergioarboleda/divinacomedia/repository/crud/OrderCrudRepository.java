package com.sergioarboleda.divinacomedia.repository.crud;

import com.sergioarboleda.divinacomedia.model.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Esta interface extiende de CrudRepository, contiene el CRUD para la colección
 * orders con llave primaria Integer y las consultas especificas para validar
 * datos de las ordenes.
 * 
 * @since 12-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    /**
     * Método que usa un query para consultar las ordenes de una zona.
     * 
     * @param zone Zona
     * @return Lista de Ordenes
     */
    @Query("{'salesMan.zone':?0}")
    public List<Order> findBySalesManZone(String zone);
}
