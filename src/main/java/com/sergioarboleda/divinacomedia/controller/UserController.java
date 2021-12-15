package com.sergioarboleda.divinacomedia.controller;

import com.sergioarboleda.divinacomedia.model.User;
import com.sergioarboleda.divinacomedia.service.UserService;
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
 * servicios relacionados con la colección user, utilizando los métodos de la
 * clase UserService.
 * 
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@RequestMapping("user")
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    /**
     * Este atributo es la instancia de la clase UserService.
     */
    @Autowired
    private UserService service;

    /**
     * Obtiene todos los usuarios.
     * 
     * @return Lista de todos usuarios registrados
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }

    /**
     * Guarda un usuario en la base de datos.
     * 
     * @param user User a guardar
     * @return User enviado
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    /**
     * Actualiza un usuario de la base de datos.
     * 
     * @param user Usuario
     * @return Usuario enviado
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.update(user);
    }
    
    /**
     * Borra a un usuario por el id de la base de datos.
     * 
     * @param id Id del usuario
     * @return Usuario enviado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }
    
    /**
     * Valida que exista un usuario con el email ingresado, si lo encuentra
     * devuelve true, de lo contrario devuelve false.
     * 
     * @param email Correo a buscar
     * @return True si se encotro el correo, sino devuelve false
     */
    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return service.getUserByEmail(email);
    }
    
    /**
     * Valida que exista un usuario con el nombre ingresado, si lo encuentra
     * devuelve true, de lo contrario devuelve false.
     * 
     * @param name Nombre a buscar
     * @return True si se encotro el correo, sino devuelve false
     */
    @GetMapping("/nameexist/{name}")
    public boolean existName(@PathVariable("name") String name) {
        return service.getUserByName(name);
    }

    /**
     * Busca un usuario con el email y password ingresados, si lo encuentra
     * devuelve el usuario, sino devuelve un usuario con nombre "NO DEFINIDO".
     * 
     * @param email Correo del usuario
     * @param password Contraseña del usuario
     * @return User
     */
    @GetMapping("/{email}/{password}")
    public User validarUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getUserByEmailAndPassword(email, password);
    }
    
    /**
     * Obtiene un usuario por el id, si no existe devuelve un usuario vacio.
     * 
     * @param id Id del usuario
     * @return Usuario
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return service.getUserById(id);
    }
}
