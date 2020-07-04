/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.logic;

import gov.deajcesar.judisafese.entity.Person;
import gov.deajcesar.judisafese.entity.Register;

/**
 *
 * @author jairo
 */
public class GPerson {
    private Person person;

    public GPerson(String cc, String name, String lastName, String phone, String email, String addres) {
        this.person = new Person(cc, name, lastName, phone, email, addres);
    }

    public GPerson(Person person) {
        this.person = person;
    }
    
    public GPerson() {
        this.person = new Person();
    }
     public int getId() {
        return this.person.getId();
    }
    public Person getPerson() {
        return person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public String getCc() {
        return this.person.getCc();
    }

    public void setCc(String cc) {
        this.person.setCc(cc);
    }

    public String getName() {
        return this.person.getName();
    }

    public void setName(String name) {
        this.person.setName(name);
    }

    public String getLastName() {
        return this.person.getLastName();
    }

    public void setLastName(String lastName) {
        this.person.setLastName(lastName);
    }

    public String getPhone() {
        return this.person.getPhone();
    }

    public void setPhone(String phone) {
        this.person.setPhone(phone);
    }

    public String getEmail() {
        return this.person.getEmail();
    }

    public void setEmail(String email) {
        this.person.setEmail(email);
    }

    public String getAdress() {
        return this.person.getAdress();
    }

    public void setAdress(String adress) {
        this.person.setAdress(adress);
    }
    
    public void addRegister(GRegister gr){
        if(this.person!=null)
           this.person.addRegister(gr.getRegister());
    }
    public boolean validate(){
        if(this.person.getCc().isEmpty()){
            throw new NullPointerException("Se debe registrar la cedula del visitante");
        }
        else if(this.person.getName().isEmpty()){
            throw new NullPointerException("Se debe registrar el (los) Nombre(s) del visitante");
        }
        else if(this.person.getLastName().isEmpty()){
            throw new NullPointerException("Se debe registrar el (los) Apellido(s) del visitante");
        }
        return true;
    }
    
    
    
    
    
    
}
