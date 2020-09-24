package com.example.iasf.Entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Không để trống")
    @Size(min = 8, message = "Từ 8 ký tự trở lên")
    private String name;
    @NotBlank(message = "Không để trống")
    private int age;
    @NotBlank(message = "Không để trống")
    private double salary;

    public User() {
    }

    public User(@NotNull @Size(min = 8) String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
