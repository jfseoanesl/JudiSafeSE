/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.logic;

import gov.deajcesar.judisafese.dao.IDaoRegister;
import gov.deajcesar.judisafese.dao.RegisterDAO;
import gov.deajcesar.judisafese.entity.Register;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jairo
 */
public class GListRegister {
    private IDaoRegister dr;

    public GListRegister() {
        this.dr= new RegisterDAO();
    }
    
    public void addRegister(GRegister gr) throws SQLException{
        this.dr.insert(gr.getRegister());
    }
    public List<GRegister> getResultQueryRegisters(String q) throws SQLException{
        List<Register> list = this.dr.query(q);
        List<GRegister> GList = new ArrayList();
        for(Register r : list){
            GList.add(new GRegister(r));
        }
        return GList;
    }
    
}
