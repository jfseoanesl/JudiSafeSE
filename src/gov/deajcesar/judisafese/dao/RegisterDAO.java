/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.dao;

import gov.deajcesar.judisafese.entity.Register;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author jairo
 */
public class RegisterDAO implements IDaoRegister {

    @Override
    public void insert(Register r) throws SQLException {
       EntityManager em = ConectionDB.cnx();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close(); 
    }

    @Override
    public List<Register> query(String q) throws SQLException {
        EntityManager em = ConectionDB.cnx();
        em.getTransaction().begin();
      
        TypedQuery<Register> query = em.createQuery(q, Register.class);
        List<Register> results = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return results;
    }
    
}
