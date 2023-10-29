package com.example.demo1029.Entity;

public class User {
    private Long id;
    private String username;

    // 构造函数
    public User() {
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // 可选的其他方法，例如 toString 方法等
}

