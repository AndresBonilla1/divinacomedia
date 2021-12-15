package com.sergioarboleda.divinacomedia.repository;

import com.sergioarboleda.divinacomedia.model.User;
import com.sergioarboleda.divinacomedia.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Esta clase es el repositorio de la colección user e implememta todos los
 * métodos necesarios para el manejo de datos, a traves de la injección de
 * dependencias de la interface UserCrudRepository.
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
     * @return User o null si no lo encuentra
     */
    public Optional<User> getUserById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Obtiene un optional tipo usuario con el nombre.
     * 
     * @param name Nombre del usuario
     * @return User o null si no lo encuentra
     */
    public Optional<User> getUserByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Obtiene un optional tipo usuario con el correo.
     * 
     * @param email Correo del usuario
     * @return User o null si no lo encuentra
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
     * @return User o null si no lo encuentra
     */
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    /**
     * Guarda un usuario, si ya existe lo actualiza.
     * 
     * @param user User
     * @return User guardado
     */
    public User save(User user) {
        return repository.save(user);
    }

    /**
     * Elimina un usuario por el id.
     * 
     * @param id Id del usuaruo a borrar
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
    /**
     * Método que obtiene una lista de usuarios con el id, email y nombre
     * ingresados.
     * 
     * @param id Id del usuario
     * @param email Email del usuario
     * @param name Nombre del usuario
     * @return Lista de usuarios
     */
    public List<User> getUserByIdOrEmailOrName(Integer id, String email, String name) {
        return repository.findByIdOrEmailOrName(id, email, name);
    }
}
