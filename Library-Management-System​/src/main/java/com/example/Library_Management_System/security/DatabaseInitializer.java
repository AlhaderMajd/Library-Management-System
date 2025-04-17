package com.example.Library_Management_System.security;

import com.example.Library_Management_System.dao.RoleRepository;
import com.example.Library_Management_System.dao.UserRepository;
import com.example.Library_Management_System.entity.Role;
import com.example.Library_Management_System.entity.RoleType;
import com.example.Library_Management_System.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Check if roles exist, if not create them
        if (roleRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setName(RoleType.ADMIN);
            roleRepository.save(adminRole);

            Role authorRole = new Role();
            authorRole.setName(RoleType.AUTHOR);
            roleRepository.save(authorRole);

            Role memberRole = new Role();
            memberRole.setName(RoleType.MEMBER);
            roleRepository.save(memberRole);
        }

        // Check if admin user exists, if not create it
        if (userRepository.findByName("admin") == null) {
            User admin = new User();
            admin.setName("admin");
            admin.setPassword("admin123");

            // Get the ADMIN role from repository
            Role adminRole = roleRepository.findByName(RoleType.ADMIN)
                    .orElseThrow(() -> new RuntimeException("ADMIN role not found"));

            admin.setRole(adminRole);
            userRepository.save(admin);
        }
        if (userRepository.findByName("author") == null) {
            User author = new User();
            author.setName("author");
            author.setPassword("author123");

            // Get the ADMIN role from repository
            Role adminRole = roleRepository.findByName(RoleType.AUTHOR)
                    .orElseThrow(() -> new RuntimeException("AUTHOR role not found"));

            author.setRole(adminRole);
            userRepository.save(author);
        }
        if (userRepository.findByName("member") == null) {
            User author = new User();
            author.setName("member");
            author.setPassword("author123");

            // Get the ADMIN role from repository
            Role adminRole = roleRepository.findByName(RoleType.MEMBER)
                    .orElseThrow(() -> new RuntimeException("AUTHOR role not found"));

            author.setRole(adminRole);
            userRepository.save(author);
        }
    }
}