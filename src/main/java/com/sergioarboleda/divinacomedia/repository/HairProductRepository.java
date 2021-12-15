package com.sergioarboleda.divinacomedia.repository;

import com.sergioarboleda.divinacomedia.model.HairProduct;
import com.sergioarboleda.divinacomedia.repository.crud.HairProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Esta clase es el repositorio de la colección hairproducts e implememta todos
 * los métodos necesarios para el manejo de datos, a traves de la injección de
 * dependencias de la interface HairProductCrudRepository.
 * 
 * @since 06-Dic-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Repository
public class HairProductRepository {
    
    /**
     * Este atributo es la instancia de la interface HairProductCrudRepository.
     */
    @Autowired
    private HairProductCrudRepository repository;

    /**
     * Obtiene todos los hair products.
     * 
     * @return Lista con todos los hair products
     */
    public List<HairProduct> getAll() {
        return (List<HairProduct>) repository.findAll();
    }
    
    /**
     * Obtiene un producto por su referencia.
     * 
     * @param reference Referencia
     * @return Producto
     */
    public Optional<HairProduct> getByReference(String reference) {
        return repository.findById(reference);
    }

    /**
     * Guarda un hair product.
     * 
     * @param hairProduct hair product
     * @return HairProduct guardado
     */
    public HairProduct save(HairProduct hairProduct) {
        return repository.save(hairProduct);
    }

    /**
     * Borra un producto por la referencia.
     * 
     * @param id Referencia del producto
     */
    public void delete(String id) {
        repository.deleteById(id);
    }
}
