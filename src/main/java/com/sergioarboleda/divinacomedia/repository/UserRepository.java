/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.repository;

import com.sergioarboleda.divinacomedia.model.User;
import com.sergioarboleda.divinacomedia.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Esta clase es el repositorio de la tabla user e implememta todos los
 * métodos necesarios para el manejo de datos, a traves de la injección de
 * dependencias de la clase UserCrudRepository.
 * 
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Repository
public class UserRepository {

    /**
     * Este atributo es la instancia de la interface UserCrudRepository.
     */
    @Autowired
    private UserCrudRepository repository;

    /**
     * Obtiene todos loa usuarios.
     * 
     * @return Lista con todos los usuarios
     */
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    /**
     * Obtiene un optional tipo usuario con el id.
     * 
     * @param id Id del usuario
     * @return Usuario o null si no lo encuentra
     */
    public Optional<User> getUserById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Obtiene un optional tipo usuario con el nombre.
     * 
     * @param name Nombre del usuario
     * @return Usuario o null si no lo encuentra
     */
    public Optional<User> getUserByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Obtiene un optional tipo usuario con el correo.
     * 
     * @param email Correo del usuario
     * @return Usuario o null si no lo encuentra
     */
    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * Obtiene una lista de usuarios que coincidan con el nombre o el email
     * ingresados.
     * 
     * @param name Nombre de usuario
     * @param email Correo de usuario
     * @return Lista con usuarios
     */
    public List<User> getUserByNameOrEmail(String name, String email) {
        return repository.findByNameOrEmail(name, email);
    }

    /**
     * Obtiene un optional tipo usuario que coincida con el correo y contraseña
     * ingresados.
     * 
     * @param email Correo del usuario
     * @param password Contraseña del usuario
     * @return Usuario o null si no lo encuentra
     */
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    /**
     * Guarda un usuario.
     * 
     * @param user Usuario
     * @return Usuario guardado
     */
    public User save(User user) {
        return repository.save(user);
    }

}
