package com.sergioarboleda.divinacomedia.controller;

import com.sergioarboleda.divinacomedia.model.Actualizar;
import com.sergioarboleda.divinacomedia.model.Order;
import com.sergioarboleda.divinacomedia.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase tipo controller que maneja el contexto de las peticiones a los
 * servicios relacionados con la colección orders, utilizando los métodos de la
 * clase UserService.
 * 
 * @since 15-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@RequestMapping("order")
@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    
    /**
     * Este atributo es la instancia de la interface OrderService.
     */
    @Autowired
    private OrderService service;
    
    /**
     * Obtiene una orden por el id.
     * 
     * @param id Id de la orden
     * @return Orden
     */
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Integer id) {
        return service.getOrderById(id);
    }
    
    /**
     * Obtiene una lista con todas las ordenes registradas.
     * 
     * @return Lista de ordenes
     */
    @GetMapping("/all")
    public List<Order> getAll() {
        return service.getAll();
    }
    
    /**
     * Obtiene una lista con las ordenes por zona.
     * 
     * @param zone Zona
     * @return Lista de ordenes
     */
    @GetMapping("/zona/{ZONA}")
    public List<Order> getBySalesManZone(@PathVariable("ZONA") String zone) {
        return service.getBySalesManZone(zone);
    }
    
    /**
     * Guarda una orden en la base de datos.
     * 
     * @param order Orden
     * @return Orden
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }
    
    /**
     * Actualiza el estado de una orden.
     * 
     * @param info Objeto de la clase Actualizar 
     * @return Orden actualizada
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order actualizarEstado(@RequestBody Actualizar info) {
        return service.actualizarEstado(info.getStatus(), info.getId());
    }
    
    /**
     * Obtiene una lista de ordenes buscando por la fecha de registro y el id
     * del salesMan.
     * 
     * @param date Fecha de registro
     * @param id Id del salesMAn
     * @return Lista de ordenes
     */
    @GetMapping("/date/{date}/{id}")
    public List<Order> getByRegisterDayBetweenAndSalesMan_id(@PathVariable("date") String date, @PathVariable("id") Integer id) {
        return service.getOrdersByRegisterDaySalesManId(date, id);
    }
    
    /**
     * Obtiene una lista de ordenes por el status y el id del salesMan.
     * 
     * @param status Status de la orden
     * @param id Id del salesMan
     * @return Lista de ordenes
     */
    @GetMapping("/state/{status}/{id}")
    public List<Order> getByStatusAndSalesMan_id(@PathVariable("status") String status, @PathVariable("id") Integer id) {
        return service.getByStatusAndSalesMan_id(status, id);
    }
    
    /**
     * Obtiene una lista de ordenes por el id del salesMan.
     * 
     * @param id Id del salesMan
     * @return Lista de ordenes
     */
    @GetMapping("/salesman/{id}")
    public List<Order> getBySalesMan_id(@PathVariable("id") Integer id) {
        return service.getBySalesMan_id(id);
    }
}
