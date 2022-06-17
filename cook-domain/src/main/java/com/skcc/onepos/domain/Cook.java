package com.skcc.onepos.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Cook{

    @Id @GeneratedValue
    Long id;

    int orderId;
    int storeId;
    int prodId;
    int qty;
    int holeflag;
    int tableNo;

    @OneToMany
    List<Menu> menus;

    CookStatus cookStatus;
    
    @PostPersist
    public void onPostPersist(){
        PetReserved petReserved = new PetReserved();
        petReserved.setAppearance(this.getAppearance());
        petReserved.setEnergy(this.getEnergy());
        petReserved.setId(this.getId());
        petReserved.setName(this.getName());
        petReserved.setType(this.getType());
        petReserved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){

        PetUpdated petUpdated = new PetUpdated();
        petUpdated.setAppearance(this.getAppearance());
        petUpdated.setEnergy(this.getEnergy());
        petUpdated.setId(this.getId());
        petUpdated.setName(this.getName());
        petUpdated.setType(this.getType());

        petUpdated.publishAfterCommit();

    }

    public void sendConfirm(){

    }
    public void getStock(){

    }
    public void cookStart(){

    }
    public void cookEnd(){

    }
    public void stockSend(){

    }
    public void servingRequest(){

    }
    public void sendToKakao(){
        
    }

    public CookStatus getCookStatus() {
        return cookStatus;
    }
    public void setCookStatus(CookStatus cookStatus) {
        this.cookStatus = cookStatus;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getTableNo() {
        return tableNo;
    }
    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public int getProdId() {
        return prodId;
    }
    public void setProdId(int prodId) {
        this.prodId = prodId;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getHoleflag() {
        return holeflag;
    }
    public void setHoleflag(int holeflag) {
        this.holeflag = holeflag;
    }

}