package com.ironyard.data;

import javax.persistence.*;
import java.util.List;


/**
 * Created by Raul on 10/24/16.
 */
@Entity
public class company {
    private String name;
    private String address;
    private String foundeddate;
    private int worth;

    @OneToMany(cascade = CascadeType.ALL)
    private List<employees> employees;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFoundeddate() {
        return foundeddate;
    }

    public void setFoundeddate(String foundeddate) {
        this.foundeddate = foundeddate;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public List<com.ironyard.data.employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<com.ironyard.data.employees> employees) {
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
