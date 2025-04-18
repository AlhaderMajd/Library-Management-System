package com.example.Library_Management_System.dao;

import com.example.Library_Management_System.entity.Role;
import com.example.Library_Management_System.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}