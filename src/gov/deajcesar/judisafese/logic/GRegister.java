/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.logic;

import gov.deajcesar.judisafese.entity.Person;
import gov.deajcesar.judisafese.entity.Register;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jairo
 */
public class GRegister {
    private Register register;

    public GRegister(GPerson p,Date date, Date time, double temperature, String symptoms, String origin, String destination, String obrsevation) {
        this.register = new Register(p.getPerson(),date,time, temperature, symptoms, origin, destination, obrsevation);
    }

    public GRegister(Register register) {
        this.register = register;
    }

    public GRegister() {
        this.register=null;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
    
    public Person getPerson() {
        if(this.register!=null)
            return this.register.getPerson();
        else 
            return null;
    }

    public void setPerson(Person person) {
        if(this.register!=null)
            this.register.setPerson(person);
    }

    public Date getDate() {
        if(this.register!=null)
            return this.register.getDate();
        else
            return null;
    }

    public void setDate(Date date) {
        if(this.register!=null)
            this.register.setDate(date);
    }

    public Date getTime() {
        if(this.register!=null)
            return this.register.getTime();
        else
            return null;
    }

    public void setTime(Date time) {
        if(this.register!=null)
            this.register.setTime(time);
    }

    public double getTemperature() {
        if(this.register!=null)
            return this.register.getTemperature();
        else 
            return 0;
    }

    public void setTemperature(double temperature) {
        if(this.register!=null)
            this.register.setTemperature(temperature);
    }

    public String getSymptoms() {
        if(this.register!=null)
            return this.register.getSymptoms();
        else 
            return null;
    }

    public void setSymptoms(String symptoms) {
        if(this.register!=null)
            this.register.setSymptoms(symptoms);
    }

    public String getOrigin() {
        if(this.register!=null)
            return this.register.getOrigin();
        else
            return null;
    }

    public void setOrigin(String origin) {
        if(this.register!=null)
            this.register.setOrigin(origin);
    }

    public String getDestination() {
        if(this.register!=null)
            return this.register.getDestination();
        else
            return null;
    }

    public void setDestination(String destination) {
        if(this.register!=null)
            this.register.setDestination(destination);
    }

    public String getObrsevation() {
        if(this.register!=null)
            return this.register.getObrsevation();
        else 
            return null;
    }

    public void setObrsevation(String obrsevation) {
        if(this.register!=null)
          this.register.setObrsevation(obrsevation);
    }
    
    public GPerson getGPerson(){
        GPerson gp = new GPerson(this.register.getPerson());
        return gp;
    }
    
    public boolean validate(){
        this.getGPerson().validate();
        
        if(this.register.getTemperature()<=30){
            throw new NullPointerException("Se debe registrar un valor valido para la temperatura(Sup. a 30°C)");
        }
        else if(this.register.getSymptoms().trim().isEmpty()){
            throw new NullPointerException("Se debe registrar sintomas del visitante");
        }
        else if(this.register.getOrigin().isEmpty()){
            throw new NullPointerException("Se debe registrar el Origen del visitante");
        }
        else if(this.register.getDestination().isEmpty()){
            throw new NullPointerException("Se debe registrar el destino del visitante");
        }
        else
         return true;
    }
}
