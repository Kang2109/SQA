/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author duyqu
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class User implements Serializable{
    private int id;
    private String name;
    private String email;
    private String address;
  
    private String phonenumber;
    private String username;
    private String password;
private String position;

    public User(int id, String name, String email, String address, String phonenumber, String username, String password, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public User(String name, String email, String address, String phonenumber, String username, String password, String position) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
        this.position = position;
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

    public String getEmail() {
        return email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, String email, String address, String phonenumber, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
    }

    public User(String name, String email, String address, String phonenumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }



    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phonenumber=" + phonenumber + ", username=" + username + ", password=" + password + '}';
    }

   
    
    
}
