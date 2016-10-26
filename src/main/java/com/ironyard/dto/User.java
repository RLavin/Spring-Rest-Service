package com.ironyard.dto;

/**"id": 1,
 "name": "Leanne Graham",
 "username": "Bret",
 "email": "Sincere@april.biz",
 "Address": {
 "street": "Kulas Light",
 "suite": "Apt. 556",
 "city": "Gwenborough",
 "zipcode": "92998-3874",
 "Geo": {
 "lat": "-37.3159",
 "lng": "81.1496"
 }
 * Created by Raul on 10/26/16.
 */
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
