package com.sergioarboleda.divinacomedia;

import com.sergioarboleda.divinacomedia.repository.crud.HairProductCrudRepository;
import com.sergioarboleda.divinacomedia.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase main del proyecto divinacomedia, implementa la interface
 * CommandLineRunner, corra el programa AQUI.
 *
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@SpringBootApplication
public class DivinacomediaApplication implements CommandLineRunner {

    /**
     * Instancia del CrudRepository del HairProduct.
     */
    @Autowired
    private HairProductCrudRepository productRepository;

    /**
     * Instancia del CrudRepository de User.
     */
    @Autowired
    private UserCrudRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DivinacomediaApplication.class, args);
    }

    /**
     * Método para limpiar la base de datos cada vez que se ejecute el
     * programa.
     * 
     * @param args Argumentos
     * @throws Exception Excepción si la hay
     */
    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        userRepository.deleteAll();
    }

}
