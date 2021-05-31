/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author duyqu
 */
public class Water implements Serializable{
     protected int id;
   protected String thang;
      protected int chiso;
      
       protected String trangthai;
  protected Client client;

    public Water(String thang, int chiso, String trangthai, Client client) {
        this.thang = thang;
        this.chiso = chiso;
        this.trangthai = trangthai;
        this.client = client;
    }

    public Water(String thang, int chiso) {
        this.thang = thang;
        this.chiso = chiso;
    }

    public Water(int chiso) {
        this.chiso = chiso;
    }

    public Water() {
    }

    public Water(int id, String thang, int chiso) {
        this.id = id;
        this.thang = thang;
        this.chiso = chiso;
    }

    public Water(int id, String thang, int chiso, String trangthai) {
        this.id = id;
        this.thang = thang;
        this.chiso = chiso;
        this.trangthai = trangthai;
    }

    public Water(int id, String trangthai) {
        this.id = id;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public int getChiso() {
        return chiso;
    }

    public void setChiso(int chiso) {
        this.chiso = chiso;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

   
}
