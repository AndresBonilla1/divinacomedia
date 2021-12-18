package com.sergioarboleda.divinacomedia.repository.crud;

import com.sergioarboleda.divinacomedia.model.Order;
import java.util.Date;
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
    
    /**
     * Método que usa un query para consultar ordenes por rangos de fecha de
     * registro y id del salesMan.
     * 
     * @param registerDate Fecha inicial
     * @param registerDate2 Fecha final
     * @param id Id del salesMan
     * @return Lista de ordenes
     */
    public List<Order> findByRegisterDayBetweenAndSalesMan_id(Date registerDate, Date registerDate2, Integer id);
    
    /**
     * Método que obtiene una lista de ordenes por el status y el id del
     * salesMan.
     * 
     * @param status Status de las ordenes
     * @param id Id del salesMan
     * @return Lsita de ordenes
     */
    public List<Order> findByStatusAndSalesMan_id(String status, Integer id);
    
    /**
     * Método que obtiene lista de ordenes por el id del salesMan.
     * 
     * @param id Id del salesMan
     * @return Lista de ordenes
     */
    public List<Order> findBySalesMan_id(Integer id);
}
