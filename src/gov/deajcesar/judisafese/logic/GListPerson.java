/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.logic;

import gov.deajcesar.judisafese.dao.IDaoPerson;
import gov.deajcesar.judisafese.dao.PersonDAO;
import gov.deajcesar.judisafese.entity.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jairo
 */
public class GListPerson {
    private IDaoPerson dp;

    public GListPerson() {
        this.dp = new PersonDAO();
    }
    
    public void addPerson(GPerson gp) throws SQLException{
        this.dp.insert(gp.getPerson());
    }
    
    public List<GPerson> getResultQueryPersons(String q) throws SQLException{
        List<Person> list = this.dp.query(q);
        List<GPerson> GList = new ArrayList();
        for(Person p: list){
           GList.add(new GPerson(p));
        }
        return GList;
    }
    
    public GPerson getFindPerson(String cc) throws SQLException{
        Person p = this.dp.findByCC(cc);
        GPerson gp;
        if(p!=null)
           gp=new GPerson(p);
        else
           gp=null;
        return gp;
    }
    public GPerson getFindPerson(int id) throws SQLException{
        Person p = this.dp.findById(id);
        GPerson gp;
        if(p!=null)
           gp=new GPerson(p);
        else
           gp=null;
        return gp;
    }
    
    public void updateGPerson(GPerson gp) throws SQLException {
        this.dp.update(gp.getPerson());
    }
    
}
