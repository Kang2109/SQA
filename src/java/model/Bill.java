/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Timestamp;

/**
 *
 * @author duyqu
 */
public class Bill {
        protected int id;
    protected User user;
    protected Client client;
   protected Water water;
  protected Timestamp ngaytt;
  protected int cscu;
     protected int tieuthu;
      protected double tiennuoc;
      protected double tienthue;
      protected double phibvmt;
      protected double tongtien;
    public Bill(int id, User user, Client client, Water water, Timestamp ngaytt, int cscu, int tieuthu, double tiennuoc, double tienthue, double phibvmt, double tongtien) {
        this.id = id;
        this.user = user;
        this.client = client;
        this.water = water;
        this.ngaytt = ngaytt;
        this.cscu = cscu;
        this.tieuthu = tieuthu;
        this.tiennuoc = tiennuoc;
        this.tienthue = tienthue;
        this.phibvmt = phibvmt;
        this.tongtien = tongtien;
    }

    public Bill(User user, Client client, Water water, Timestamp ngaytt, int cscu, int tieuthu, double tiennuoc, double tienthue, double phibvmt, double tongtien) {
        this.user = user;
        this.client = client;
        this.water = water;
        this.ngaytt = ngaytt;
        this.cscu = cscu;
        this.tieuthu = tieuthu;
        this.tiennuoc = tiennuoc;
        this.tienthue = tienthue;
        this.phibvmt = phibvmt;
        this.tongtien = tongtien;
    }

    public Bill(Client client, Water water, Timestamp ngaytt, int cscu, int tieuthu, double tiennuoc, double tienthue, double phibvmt, double tongtien) {
        this.client = client;
        this.water = water;
        this.ngaytt = ngaytt;
        this.cscu = cscu;
        this.tieuthu = tieuthu;
        this.tiennuoc = tiennuoc;
        this.tienthue = tienthue;
        this.phibvmt = phibvmt;
        this.tongtien = tongtien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public Timestamp getNgaytt() {
        return ngaytt;
    }

    public void setNgaytt(Timestamp ngaytt) {
        this.ngaytt = ngaytt;
    }

    public int getCscu() {
        return cscu;
    }

    public void setCscu(int cscu) {
        this.cscu = cscu;
    }

    public int getTieuthu() {
        return tieuthu;
    }

    public void setTieuthu(int tieuthu) {
        this.tieuthu = tieuthu;
    }

    public double getTiennuoc() {
        return tiennuoc;
    }

    public void setTiennuoc(double tiennuoc) {
        this.tiennuoc = tiennuoc;
    }

    public double getTienthue() {
        return tienthue;
    }

    public void setTienthue(double tienthue) {
        this.tienthue = tienthue;
    }

    public double getPhibvmt() {
        return phibvmt;
    }

    public void setPhibvmt(double phibvmt) {
        this.phibvmt = phibvmt;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
   

 
}
