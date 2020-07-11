/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.dao;

import gov.deajcesar.judisafese.entity.Person;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author jairo
 */
public class PersonDAO implements IDaoPerson {

    @Override
    public void insert(Person p) throws SQLException {
        EntityManager em = ConectionDB.cnx();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteAll() {
        
    }

    @Override
    public void update(Person p) throws SQLException {
        EntityManager em = ConectionDB.cnx();
        em.getTransaction().begin();
        Person up = em.find(Person.class, p.getId());
        up.setName(p.getName());
        up.setLastName(p.getLastName());
        up.setPhone(p.getPhone());
        up.setEmail(p.getEmail());
        up.setAdress(p.getAdress());
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public List<Person> query(String q) throws SQLException {
        EntityManager em = ConectionDB.cnx();
        em.getTransaction().begin();
      
        TypedQuery<Person> query = em.createQuery(q, Person.class);
        List<Person> results = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return results;
    }

    @Override
    public Set<Person> selectAll() {
        return null;
    }

    @Override
    public Person findByCC(String cc) throws SQLException, NoResultException{
        EntityManager em = ConectionDB.cnx();
        
        String q = "Select P from Person as P where P.cc=:cc";
        TypedQuery<Person> query = em.createQuery(q, Person.class);
        Person result = query.setParameter("cc", cc).getSingleResult();
        em.close(); 
        return result;
    }

    @Override
    public Person findById(int id) throws SQLException {
        EntityManager em = ConectionDB.cnx();
        Person p=em.find(Person.class, id);
        em.close();
        return p;
    }
    
    public void migrarEntity(){
        File file= new File("Datos xls/poo.txt");
        try{
        Scanner Lect = new Scanner(file);
        PersonDAO dp = new PersonDAO();
        EntityManager em=ConectionDB.cnx();
        em.getTransaction().begin();
        while(Lect.hasNext()){
            //System.out.println(Lect.nextLine());
            String l[] = Lect.nextLine().split(";");
            Person p = new Person();
            p.setCc(l[0]);
            p.setName(l[1]);
            if(l.length>2)
             p.setLastName(l[2]);
            //System.out.println(p);
           em.persist(p);
        }
        em.getTransaction().commit();
        em.close();
        }catch(Exception e){
            e.printStackTrace();
        };
    }
    

}
