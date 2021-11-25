/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.divinacomedia.repository.crud;

import com.sergioarboleda.divinacomedia.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {

    /**
     *
     * @param name
     * @return
     */
    public Optional<User> findByName(String name);

    /**
     *
     * @param name
     * @param email
     * @return
     */
    public List<User> findByNameOrEmail(String name, String email);

    /**
     *
     * @param email
     * @return
     */
    public Optional<User> findByEmail(String email);

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
}
