package com.sergioarboleda.divinacomedia.service;

import com.sergioarboleda.divinacomedia.model.User;
import com.sergioarboleda.divinacomedia.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es de tipo service, contiene los servicios de la tabla user y
 * utiliza los métodos de UserRepository a traves de inyeccion de dependencias.
 * 
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Service
public class UserService {

    /**
     * Este atributo es la instancia del repositorio UserRepository.
     */
    @Autowired
    private UserRepository repository;

    /**
     * Obtiene todos los usuarios.
     * 
     * @return Lista con todos los usuarios registrados
     */
    public List<User> getAll() {
        return repository.getAll();
    }

    /**
     * Guarda un usuario, siempre y cuando su id no lo tenga otro usuario,
     * no haya otro usuario con su nombre y correo y no contrnga campos nulos,
     * de lo contrario lo devuelve.
     * 
     * @param user Usuario
     * @return Usuario guardado o sin guardar si no cumple con las validaciones
     */
    public User save(User user) {
        if (user.getId() == null) {
            if (notExistNameOrEmail(user) && !nullFields(user)) {
                return repository.save(user);
            } else {
                return user;
            }
        } else {
            Optional<User> existUser = repository.getUserById(user.getId());
            if (existUser.isEmpty() && notExistNameOrEmail(user) && !nullFields(user)) {
                return repository.save(user);
            } else {
                return user;
            }
        }
    }

    /**
     * Valida que no haya un usuario con el nombre y correo que se estan
     * ingresando, si no hay ninguno devuelve true, sino devuelve false.
     * 
     * @param user Usuario a validar
     * @return True si los datos no existen, sino devuelve false
     */
    public boolean notExistNameOrEmail(User user) {
        List<User> listUser = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
        return listUser.isEmpty();
    }

    /**
     * Valida que los campos del usuario no vengan nulos, excepto el id.
     * 
     * @param user Usuario a validar
     * @return True si tiene campos nulos, sino devuelve false
     */
    public boolean nullFields(User user) {
        if (user.getEmail() == null || user.getName() == null || user.getPassword() == null) {
            return true;
        }
        return false;
    }

    /**
     * Valida que un usuario tenga el email, si encuentra un usuario devuelve
     * true, de lo contrario devuelve false.
     * 
     * @param email Correo del usuario
     * @return True si encontro un usuario con el correo, sino devuelve false
     */
    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }

    /**
     * Obtiene un usuario que contenga el email y el password, si no hay ninguno
     * devuelve un user con nombre de "NO DEFINIDO".
     * 
     * @param email Correo del usuario
     * @param password Contraseña del usuario
     * @return Usuario
     */
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            return new User(null, email, password, "NO DEFINIDO");
        }
    }

}
