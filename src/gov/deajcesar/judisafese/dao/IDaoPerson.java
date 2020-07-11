/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.dao;

import gov.deajcesar.judisafese.entity.Person;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jairo
 */
public interface IDaoPerson {
   
    public void insert(Person p) throws SQLException;
    public Person findByCC(String cc) throws SQLException;
    public Person findById(int id)throws SQLException;
    public void deleteAll();
    public void update(Person p) throws SQLException;
    public List<Person> query(String q) throws SQLException;
    public Set<Person> selectAll();

}
