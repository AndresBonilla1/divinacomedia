/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.divinacomedia.repository.crud;

import com.sergioarboleda.divinacomedia.model.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Esta interface extiende de CrudRepository, contiene el CRUD para la colección
 * usuarios con llave primaria Integer y las consultas especificas para validar
 * datos del usuario.
 * 
 * @since 12-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone':?0}")
    List<Order> findBySalesManZone(String zone);
}
