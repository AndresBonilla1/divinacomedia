package com.sergioarboleda.divinacomedia.service;

import com.sergioarboleda.divinacomedia.model.HairProduct;
import com.sergioarboleda.divinacomedia.repository.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es de tipo service, contiene los servicios de la colección 
 * hairproduct y utiliza los métodos de HairProductRepository a traves de 
 * inyeccion de dependencias.
 * 
 * @since 06-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Service
public class HairProductService {

    /**
     * Instancia del repositorio HairProductRepository. 
     */
    @Autowired
    private HairProductRepository repository;

    /**
     * Obtiene todos los productos.
     * 
     * @return Lista con los productos
     */
    public List<HairProduct> getAll() {
        return repository.getAll();
    }
    
    /**
     * Obtiene un optional tipo HairProduct por el id.
     * 
     * @param reference Referencia del producto
     * @return Producto o null si no lo encuentra
     */
    public Optional<HairProduct> getProductoByReference(String reference) {
        return repository.getByReference(reference);
    }

    /**
     * Guarda un producto validando que la referencia del usuario no exista y
     * que no hayan campos nulos.
     * 
     * @param product Producto a guardar
     * @return Producto
     */
    public HairProduct save(HairProduct product) {
        if (product.getId()== null) {
            return product;
        } else {
            if (camposVacios(product)) {
                return product;
            } else {
                Optional<HairProduct> existProduct = repository.getByReference(product.getId());
                if (existProduct.isEmpty()) {
                    return repository.save(product);
                } else {
                    return product;
                }
            }
        }
    }

    /**
     * Actualiza un producto existente, modificando los campos que no se reciban
     * nulos, de lo contrario devuelve el producto.
     * 
     * @param product Producto
     * @return Producto actualizado o devuelto
     */
    public HairProduct update(HairProduct product) {
        Optional<HairProduct> existProduct = repository.getByReference(product.getId());
        if (existProduct.isPresent()) {
            if (product.getAvailability()!= null) {
                existProduct.get().setAvailability(product.getAvailability());
            }
            if (product.getName() != null) {
                existProduct.get().setName(product.getName());
            }
            if (product.getBrand()!= null) {
                existProduct.get().setBrand(product.getBrand());
            }
            if (product.getCategory()!= null) {
                existProduct.get().setCategory(product.getCategory());
            }
            if (product.getDescription()!= null) {
                existProduct.get().setDescription(product.getDescription());
            }
            if (product.getPhotography()!= null) {
                existProduct.get().setPhotography(product.getPhotography());
            }
            if (product.getPrice()!= null) {
                existProduct.get().setPrice(product.getPrice());
            }
            if (product.getQuantity()!= null) {
                existProduct.get().setQuantity(product.getQuantity());
            }
            return repository.save(existProduct.get());
        } else {
            return product;
        }
    }

    /**
     * Método que elimina un producto por la referencia, siempre que exista.
     * 
     * @param reference Referenca del producto
     * @return True si lo borro, de lo contrario false
     */
    public boolean delete(String reference) {
        Boolean aBoolean = getProductoByReference(reference).map(product -> {
            repository.delete(product.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    /**
     * Método que valida que si los campos de un producto estan vacios.
     * 
     * @param product Productos
     * @return True si hay campos vacios, de lo contrario false
     */
    public boolean camposVacios(HairProduct product) {
        return product.getAvailability() == null || product.getBrand() == null || product.getCategory() == null || product.getDescription() == null
                || product.getName() == null || product.getPhotography() == null || product.getPrice() == null || product.getQuantity() == null;
    }
}
