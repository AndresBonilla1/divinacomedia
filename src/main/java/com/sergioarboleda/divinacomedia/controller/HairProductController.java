package com.sergioarboleda.divinacomedia.controller;

import com.sergioarboleda.divinacomedia.model.HairProduct;
import com.sergioarboleda.divinacomedia.service.HairProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
 * servicios relacionados con la colección hairproducts, utilizando los métodos
 * de la clase HairProductService.
 * 
 * @since 06-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@RequestMapping("hairproducts")
@RestController
@CrossOrigin(origins = "*")
public class HairProductController {
    
    /**
     * Este atributo es la instancia de la interface HairProductService.
     */
    @Autowired
    private HairProductService service;
    
    /**
     * Obtiene todos los usuarios.
     * 
     * @return Lista de todos usuarios registrados
     */
    @GetMapping("/all")
    public List<HairProduct> getAll() {
        return service.getAll();
    }
    
    /**
     * Obtiene un producto por su referencia.
     * 
     * @param reference Referencia
     * @return Producto
     */
    @GetMapping("/{id}")
    public HairProduct getByReference(@PathVariable("id") String reference) {
        return service.getProductByReference(reference);
    }

    /**
     * Guarda un product en la base de datos.
     * 
     * @param product product a guardar
     * @return product enviado
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct product) {
        return service.save(product);
    }

    /**
     * Actualiza un product de la base de datos.
     * 
     * @param product Usuario
     * @return product enviado
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct product) {
        return service.update(product);
    }
    
    /**
     * Borra a un product por la referencia de la base de datos.
     * 
     * @param id Referencia del product
     * @return product enviado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
    
    /**
     * Valida si la referencia de un producto existe o no.
     * @param reference Referencia del producto
     * @return True si la referencia existe, sino devuelve false
     */
    @GetMapping("/existproduct/{id}")
    public boolean existProduct(@PathVariable("id") String reference) {
        return service.existProduct(reference);
    }
    
    /**
     * Obtiene una lista de productos con el precio menor o igual al buscado.
     * 
     * @param precio Precio
     * @return Lista de productos
     */
    @GetMapping("/price/{price}")
    public List<HairProduct> getByPriceLessThanEqual(@PathVariable("price") Double precio) {
        return service.getByPriceLessThanEqual(precio);
    }
    
    /**
     * Obtiene uuna lista de productos cuya descripción este contenida en la
     * descripción en la de algún producto.
     * 
     * @param descripcion Descripción
     * @return Lista de productos
     */
    @GetMapping("/description/{description}")
    public List<HairProduct> getByDescriptionLike(@PathVariable("description") String descripcion) {
        return service.getByDescriptionLike(descripcion);
    }
}
