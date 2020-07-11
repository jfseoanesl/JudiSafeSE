/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jairo
 */
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private int id;
    private String cc;
    private String name; 
    private String lastName;
    private String phone;
    private String email; 
    private String adress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="person", fetch = FetchType.EAGER)//
    private List<Register> registers=new ArrayList<>();

   
    public Person() {
        //this.registers = new ArrayList();
    }

    public Person(String cc, String name, String lastName, String phone, String email, String adress) {
        this.cc = cc;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        //this.registers = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", cc=" + cc + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", adress=" + adress + ", registers=" + registers + '}';
    }
    
    public void addRegister(Register r){
        this.registers.add(r);
    }

    public List<Register> getRegisters() {
        return registers;
    }
    
    
}
