package com.sergioarboleda.divinacomedia.repository;

import com.sergioarboleda.divinacomedia.model.Order;
import com.sergioarboleda.divinacomedia.repository.crud.OrderCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Esta clase es el repositorio de la colección orders e implememta todos los
 * métodos necesarios para el manejo de datos, a traves de la injección de
 * dependencias de la interface OrderCrudRepository.
 *
 * @since 12-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Repository
public class OrderRepository {

    /**
     * Este atributo es la instancia de la interface OrderCrudRepository.
     */
    @Autowired
    private OrderCrudRepository repository;

    /**
     * Obtiene un optional tipo order por el id.
     *
     * @param id Id de la orden
     * @return Order si lo encuentra, de lo contrario null
     */
    public Optional<Order> getOrderById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Obtiene una lista de ordenes buscados por la zona del asesor comercial.
     *
     * @param zone Zona del asesor comercial
     * @return Listado con las ordenes de la zona
     */
    public List<Order> getBySalesManZone(String zone) {
        return repository.findBySalesManZone(zone);
    }
    
    /**
     * Obtiene todas las ordenes en la base de datos.
     * 
     * @return Lista con todas las ordenes
     */
    public List<Order> getAll() {
        return repository.findAll();
    }

    /**
     * Guarda una orden en la base de datos, si existe lo actualiza.
     *
     * @param order Orden
     * @return Orden guardada
     */
    public Order save(Order order) {
        return repository.save(order);
    }
}
