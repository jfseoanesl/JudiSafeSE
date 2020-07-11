/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.logic;

import gov.deajcesar.judisafese.dao.IDaoPerson;
import gov.deajcesar.judisafese.dao.PersonDAO;
import gov.deajcesar.judisafese.entity.Person;
import gov.deajcesar.judisafese.entity.Register;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.NoResultException;

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
    
    public GPerson getReportPersonRegister(Date i, Date f, String cc) throws SQLException, NoResultException{
        if(i==null){
            throw new NullPointerException("Se requiere la fecha inicial");
        }
        else if(f==null){
            throw new NullPointerException("Se requiere la fecha final");
        }
        else if(cc.trim().isEmpty()){
            throw new NullPointerException("Se requiere el No de CC");
        }
        else{
            Person person = this.dp.findByCC(cc);
            List<Register> ingresos = person.getRegisters();
            Iterator<Register> it = person.getRegisters().iterator();
            while(it.hasNext()){
                Register r = it.next();
                if((r.getDate().compareTo(i)<0) || r.getDate().compareTo(f)>0 ){
                    it.remove();
                }
            }
            GPerson p = new GPerson(person);
            return p;
        }    
    }
}
