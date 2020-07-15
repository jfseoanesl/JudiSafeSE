/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.dao;

import gov.deajcesar.judisafese.entity.Register;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jairo
 */
public interface IDaoRegister {
    public void insert(Register r) throws SQLException;
    public List<Register> query(String q) throws SQLException;
    public void deleteAll();
    public List<Register> queryReportDayTmp(Date i, Date f, double tm) throws SQLException;
}
