package com.example.Library_Management_System.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private Long id;  // Same as user ID

    @Enumerated(EnumType.STRING)
    private RoleType name;

    @OneToOne
    @MapsId  // Indicates the ID is shared with the user association
    @JoinColumn(name = "user_id")  // Column name matches primary key
    private User user;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ...

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                ", user=" + user +
                '}';
    }
}