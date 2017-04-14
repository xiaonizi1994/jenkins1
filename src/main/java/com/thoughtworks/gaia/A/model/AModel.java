package com.thoughtworks.gaia.A.model;

import com.thoughtworks.gaia.common.jpa.IdBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "A")
public class AModel extends IdBaseModel {
    @Column(name = "name", nullable = false, length = 64)
    private String name;
    public void setName(String name){this.name=name;}
    public String getName() {
        return name;
    }
}


