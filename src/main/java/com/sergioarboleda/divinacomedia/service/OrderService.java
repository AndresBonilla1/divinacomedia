package com.sergioarboleda.divinacomedia.service;

import com.sergioarboleda.divinacomedia.model.Order;
import com.sergioarboleda.divinacomedia.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Esta clase es de tipo service, contiene los servicios de la colección orders
 * y utiliza los métodos de OrderRepository a traves de inyeccion de
 * dependencias.
 *
 * @since 12-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Service
public class OrderService {

    /**
     * Este atributo es la instancia del repositorio OrderRepository.
     */
    private OrderRepository repository;

    /**
     * Obtiene una orden por su id, si no lo encuentra devuelve una orden vacia.
     *
     * @param id Id de la orden
     * @return Orden
     */
    public Order getOrderById(Integer id) {
        return repository.getOrderById(id).orElse(new Order());
    }
    
    /**
     * Obtiene una lista con todas las ordenes en la base de datos.
     * 
     * @return Lista de ordenes
     */
    public List<Order> getAll() {
        return repository.getAll();
    }

    /**
     * Obtiene una lista con las ordenes de una zona.
     *
     * @param zone Zona
     * @return Lista de ordenes por zona
     */
    public List<Order> getBySalesManZone(String zone) {
        return repository.getBySalesManZone(zone);
    }

    /**
     * Guarda una orden validando que todos sus campos esten completos, y
     * validando que el id no este repetido y si esta vacio se lo genera.
     *
     * @param order Orden
     * @return Orden
     */
    public Order save(Order order) {
        if (order.getId() == null) {
            // Colocandole un id cuando no lo trae
            List<Order> allOrders = repository.getAll();
            if (!allOrders.isEmpty()) {
                int mayor = 0;
                for (Order o : allOrders) {
                    if (o.getId() > mayor) {
                        mayor = o.getId();
                    }
                }
                order.setId(mayor + 1);
            } else {
                order.setId(1);
            }

            // Validando campos
            if (order.getProducts() == null || order.getQuantities() == null
                    || order.getRegisterDay() == null || order.getSalesMan() == null) {
                return order;
            } else {
                order.setStatus(Order.PENDING);
                return repository.save(order);
            }
        } else {
            // Si viene con el id
            if (order.getProducts() == null || order.getQuantities() == null
                    || order.getRegisterDay() == null || order.getSalesMan() == null) {
                return order;
            } else {
                Optional<Order> existOrder = repository.getOrderById(order.getId());
                if (existOrder.isPresent()) {
                    return order;
                } else {
                    order.setStatus(Order.PENDING);
                    return repository.save(order);
                }
            }
        }
    }

    /**
     * Función que actualiza el estado de una orden, usando el id de la orden
     * y el estado especificado.
     *
     * @param state Estado
     * @param id Id de la orden
     * @return Orden
     */
    public Order actualizarEstado(String state, Integer id) {
        Order order = getOrderById(id);
        if (order.getId() == null) {
            return order;
        } else {
            if (state.equalsIgnoreCase("Aprobada")) {
                order.setStatus(Order.APROVED);
                return order;
            } else if (state.equalsIgnoreCase("Rechazada")) {
                order.setStatus(Order.REJECTED);
                return order;
            }
            return order;
        }
    }
}
