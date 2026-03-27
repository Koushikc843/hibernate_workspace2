package com.mphasis.firsthibernateapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("ELECTRONICS")
public class Electronics extends Product {

    private String brand;
    private Integer warrantyPeriod;     
    private Integer powerConsumption;   

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Integer getWarrantyPeriod() { return warrantyPeriod; }
    public void setWarrantyPeriod(Integer warrantyPeriod) { this.warrantyPeriod = warrantyPeriod; }

    public Integer getPowerConsumption() { return powerConsumption; }
    public void setPowerConsumption(Integer powerConsumption) { this.powerConsumption = powerConsumption; }
}
