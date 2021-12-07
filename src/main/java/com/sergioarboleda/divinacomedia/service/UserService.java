package com.sergioarboleda.divinacomedia.service;

import com.sergioarboleda.divinacomedia.model.User;
import com.sergioarboleda.divinacomedia.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es de tipo service, contiene los servicios de la colección user y
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
     * Obtiene un optional tipo User por el id.
     * 
     * @param id Id del usuario
     * @return Usuario o null si no lo encuentra
     */
    public Optional<User> getUserById(Integer id) {
        return repository.getUserById(id);
    }

    /**
     * Guarda un usuario, siempre y cuando su id no lo tenga otro usuario, no
     * haya otro usuario con su nombre y correo y no contrnga campos nulos, de
     * lo contrario lo devuelve.
     *
     * @param user User
     * @return User guardado o sin guardar si no cumple con las validaciones
     */
    public User save(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            if (user.getIdentification() == null || user.getEmail() == null || user.getName() == null || user.getPassword() == null
                    || user.getType() == null || user.getZone() == null) {
                return user;
            } else {
                List<User> existUser = repository.getUserByIdOrEmailOrName(user.getId(), user.getEmail(), user.getName());
                if (existUser.isEmpty()) {
                    return repository.save(user);
                } else {
                    return user;
                }
            }
        }
    }

    /**
     * Actualiza un usuario existente, modificando los campos que no se reciban
     * nulos, de lo contrario devuelve el usuario.
     * 
     * @param user Usuario
     * @return Usuario actualizado o devuelto
     */
    public User update(User user) {
        Optional<User> existUser = repository.getUserById(user.getId());
        if (existUser.isEmpty()) {
            if (user.getIdentification() != null) {
                existUser.get().setIdentification(user.getIdentification());
            }
            if (user.getName() != null) {
                existUser.get().setName(user.getName());
            }
            if (user.getAddress() != null) {
                existUser.get().setAddress(user.getAddress());
            }
            if (user.getCellPhone() != null) {
                existUser.get().setCellPhone(user.getCellPhone());
            }
            if (user.getEmail() != null) {
                existUser.get().setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                existUser.get().setPassword(user.getPassword());
            }
            if (user.getType() != null) {
                existUser.get().setType(user.getType());
            }
            if (user.getZone() != null) {
                existUser.get().setZone(user.getZone());
            }
            return repository.save(existUser.get());
        } else {
            return user;
        }
    }

    /**
     * Método que elimina un usuario por el id, siempre que exista.
     * 
     * @param id Id del usaurio
     * @return True si lo borro, de lo contrario false
     */
    public boolean delete(Integer id) {
        Boolean aBoolean = getUserById(id).map(user -> {
            repository.delete(user.getId());
            return true;
        }).orElse(false);
        return aBoolean;
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
     * @return User
     */
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            return new User();
        }
    }

}
