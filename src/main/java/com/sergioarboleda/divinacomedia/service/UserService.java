/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.service;

import com.sergioarboleda.divinacomedia.model.User;
import com.sergioarboleda.divinacomedia.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @since 24-Nov-2021
 * @version 1.0
 * @author Andres Bonilla
 */
@Service
public class UserService {

    /**
     *
     */
    @Autowired
    private UserRepository repository;

    /**
     *
     * @return
     */
    public List<User> getAll() {
        return repository.getAll();
    }

    /**
     *
     * @param user
     * @return
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
     *
     * @param user
     * @return
     */
    public boolean notExistNameOrEmail(User user) {
        List<User> listUser = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
        return listUser.isEmpty();
    }

    /**
     *
     * @param user
     * @return
     */
    public boolean nullFields(User user) {
        if (user.getEmail() == null || user.getName() == null || user.getPassword() == null) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }

    /**
     *
     * @param email
     * @param password
     * @return
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
