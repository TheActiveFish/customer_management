package com.dao;

import java.util.List;
import com.domain.CbankForm;
import com.tool.JDBConnection;
import com.tool.SQLCode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//对客户银行表的操作（tb_Client_bank）
public class CbankDaoImpl
    implements CbankDao {
  private JDBConnection connection = new JDBConnection();

  //查询的操作
  public List bankSelect() {
    List list = new ArrayList();
    String sql = SQLCode.getSQLCode("sql.bank.select");
    CbankForm form = null;
    try {
      ResultSet rs = connection.executeQuery(sql);
      while (rs.next()) {
        form = new CbankForm();
        form.setBank_id(rs.getString(1));
        form.setBank_name(rs.getString(2));
        form.setBank_bz(rs.getString(3));
        list.add(form);
      }
    }
    catch (SQLException ex) {
    }
    connection.close();
    return list;
  }

//删除的操作
  public void bankDelete(CbankForm bank) {
    String sql = SQLCode.getSQLCode("sql.bank.delete");
    sql = connection.editSqlCode(sql, bank.getBank_id());
    connection.executeUpdate(sql);
    connection.close();
  }

//修改操作
  public void bankUpdate(CbankForm bank) {
    String sql = SQLCode.getSQLCode("sql.bank.update");
    sql = connection.editSqlCode(sql, bank.getBank_name());
    sql = connection.editSqlCode(sql, bank.getBank_bz());
    sql = connection.editSqlCode(sql, bank.getBank_id());
    connection.executeUpdate(sql);
    connection.close();
  }

//插入的操作
  public void bankInsert(CbankForm bank) {
    String sql = SQLCode.getSQLCode("sql.bank.insert");
    sql = connection.editSqlCode(sql, bank.getBank_id());
    sql = connection.editSqlCode(sql, bank.getBank_name());
    sql = connection.editSqlCode(sql, bank.getBank_bz());
    connection.executeUpdate(sql);
    connection.close();

  }

//以数据库中的记录数，查找出多少记录计算,以便做帐号存贮
  public int bankCountId() {
    int iCount = 0;
    String sql = SQLCode.getSQLCode("sql.bank.count");
    ResultSet rs = null;
    try {
      rs = connection.executeQuery(sql);
      while (rs.next()) {
        CbankForm form = new CbankForm();
        iCount = rs.getInt("t");
      }
    }
    catch (SQLException ex) {
    }
    connection.close();
    return iCount + 1;
  }

//单独查询的操作
  public CbankForm bankSelectOne(CbankForm bank) {
     String sql = SQLCode.getSQLCode("sql.bank.selectOne");
     sql=connection.editSqlCode(sql,bank.getBank_id());
     CbankForm form = null;
     try {
       ResultSet rs = connection.executeQuery(sql);
       while (rs.next()) {
         form = new CbankForm();
         form.setBank_id(rs.getString(1));
         form.setBank_name(rs.getString(2));
         form.setBank_bz(rs.getString(3));
       }
     }
     catch (SQLException ex) {
     }
     connection.close();
     return form;
  }
}
