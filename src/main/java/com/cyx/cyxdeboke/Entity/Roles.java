package com.cyx.cyxdeboke.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {
    private Long id;
    private String name;
    private int power;
    private String remarks;

    public Roles() {
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Roles(Long id, String name, int power, String remarks) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.remarks = remarks;
    }
}
