package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demotable", schema = "public")
public class DemoTableEntity implements Serializable{

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private Integer id;    
    @Column(name = "demoTxt")
    private String demoTxt;
    @Column(name = "demoNumber")
    private Double demoNumber;

    public DemoTableEntity(){
        super();
    }

    public DemoTableEntity(String demoTxt, Double demoNumber){
        super();
        this.demoTxt = demoTxt;
        this.demoNumber = demoNumber;
    }


    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getDemoTxt(){
        return this.demoTxt;
    }

    public void setDemoTxt(String demoTxt){
        this.demoTxt = demoTxt;
    }
    
    public Double getDemoNumber(){
        return this.demoNumber;
    }

    public void setDemoNumber(Double demoNumber){
        this.demoNumber = demoNumber;
    }
}
