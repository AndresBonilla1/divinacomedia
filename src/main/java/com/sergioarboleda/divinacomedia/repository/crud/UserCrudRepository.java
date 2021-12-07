package com.sergioarboleda.divinacomedia.repository.crud;

import com.sergioarboleda.divinacomedia.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Esta interface extiende de CrudRepository, contiene el CRUD para la colección
 * usuarios con llave primaria Integer y las consultas especificas para validar
 * datos del usuario.
 * 
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    /**
     * Método que busca un usuario con el nombre ingresado y retorna un 
     * optional con el usuario, si no encuentra ningun usuario con ese nombre
     * devuelve null.
     * 
     * @param name Nombre del usuario
     * @return User o null en caso de no encontrarlo
     */
    public Optional<User> findByName(String name);

    /**
     * Método que busca a todos los usuarios con ese nombre y correo, retorna 
     * una lista con los usuarios que coinciden con la busqueda.
     * 
     * @param name Nombre del usuario
     * @param email Correo del usuario
     * @return Lista con los usuarios que coinciden con el nombre y correo
     */
    public List<User> findByNameOrEmail(String name, String email);

    /**
     * Método que busca un usuario con el email ingresado y retorna un
     * optional con el usuario, si no encuentra ningun usuario con ese email
     * devuelve null.
     * 
     * @param email Correo del usuario
     * @return User o null en caso de no encontrarlo
     */
    public Optional<User> findByEmail(String email);

    /**
     * Método que busca un usuario con el email y password ingresados y retorna
     * un optional con el usuario, si no encuentra a ningun usuario devuelve
     * null.
     * 
     * @param email Correo del usuario
     * @param password Contrasela del usuario
     * @return User o null en caso de no encontrarlo
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    /**
     * Método que busca a los usuarios con el id, email y nombre ingresados.
     * 
     * @param id Id del usuario
     * @param email Email del usuario
     * @param name Nombre del usuario
     * @return Una lista de usuarios coincidentes con la busqueda
     */
    public List<User> findByIdOrEmailOrName(Integer id, String email, String name);
}
