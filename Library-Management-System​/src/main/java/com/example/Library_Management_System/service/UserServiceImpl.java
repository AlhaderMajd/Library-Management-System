package com.example.Library_Management_System.service;

import com.example.Library_Management_System.dao.UserRepository;
import com.example.Library_Management_System.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        if (user.getPassword() != null) {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setPassword(user.getPassword());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}