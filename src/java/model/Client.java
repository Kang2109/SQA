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
public class Client {
    protected int id;

    public Client(int id) {
        this.id = id;
    }
   protected String name;
      protected String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client() {
    }

    public Client(String name, String address, String email, String phonenumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Client(int id, String name, String address, String email, String phonenumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
    }
      
       protected String email;
       protected String phonenumber;
}
