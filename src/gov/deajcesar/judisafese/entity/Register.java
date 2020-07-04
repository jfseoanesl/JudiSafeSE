/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jairo
 */
@Entity
public class Register implements Serializable {
   private static final long serialVersionUID = 1L;
   
   @Id @GeneratedValue
   private int id;
   
   @ManyToOne(cascade = CascadeType.REFRESH)
   @JoinColumn(name = "id_person", nullable = false, updatable = true)//
   private Person person;
   
   @Temporal(TemporalType.DATE)
   private Date date;
   @Temporal(TemporalType.TIME)
   private Date time;
   private double temperature;
   private String symptoms;
   private String origin;
   private String destination;
   private String obrsevation;

    public Register() {
    }

    public Register(Person person,Date date, Date time, double temperature, String symptoms, String origin, String destination, String obrsevation) {
        
        this.person = person;
        this.date=date;
        this.time = time;
        this.temperature = temperature;
        this.symptoms = symptoms;
        this.origin = origin;
        this.destination = destination;
        this.obrsevation = obrsevation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getObrsevation() {
        return obrsevation;
    }

    public void setObrsevation(String obrsevation) {
        this.obrsevation = obrsevation;
    }

    @Override
    public String toString() {
        return "Register{" + "id=" + id + ", person=" + person + ", date=" + date + ", time=" + time + ", temperature=" + temperature + ", symptoms=" + symptoms + ", origin=" + origin + ", destination=" + destination + ", obrsevation=" + obrsevation + '}';
    }
}
