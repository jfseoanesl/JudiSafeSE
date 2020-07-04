/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jairo
 */
public class ConectionDB {
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory(
          "objectdb:$objectdb/db/Judis.odb");;
    
    public static EntityManager cnx(){
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public static void close(){
        emf.close();
    }
}
