package ru.specialist.dao;

import jakarta.persistence.*;

@Table(name = "teachers")
@Entity
public class Teacher {
    @Id
    private int id;
    private String name;
    private String addr;
    private String phone;

    public Teacher() {
    }

    public Teacher(int id, String name, String addr, String phone) {
        super();
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
    }


    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString() {
        return String.format("%-3d %-50s %60s %70s", getId(), getAddr(), getName(), getPhone());
    }
}
