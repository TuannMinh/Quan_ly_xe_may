/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory.Little;

import DomainModel.D_DTXiLanh;
import Utilities.DBconnection;
import Utilities.JDBCHeper;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class R_DTXiLanh {
private DBconnection context;
    public List<D_DTXiLanh> getAllDTXL() {
        ArrayList<D_DTXiLanh> dsp = new ArrayList<>();
        String sql = "select * from DTXiLanh";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_DTXiLanh d = new D_DTXiLanh(
                        rs.getString(1),
                        rs.getString(2)
                );
                dsp.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsp;
    }

//    public Integer add(D_DTXiLanh ds) {
//        Integer row = 0;
//        String sql = "insert into DTXiLanh(dTXiLanh) values(?)";
//        try {
//            row = JDBCHeper.excuteUpdate(sql,
//                    ds.getDTXiLanh()
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return row;
//    }
//    
       public boolean add(D_DTXiLanh ds) {

        String query = "insert into DTXiLanh(dTXiLanh) values(?)";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ds.getDTXiLanh());
           
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer update(D_DTXiLanh ds) {
        Integer row = 0;
        String sql = "Update DTXiLanh set dtXiLanh =?\n"
                + "               Where Id = ?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    
                    ds.getDTXiLanh(),
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public Integer delete(D_DTXiLanh ds) {
        Integer row = 0;
        String sql = "Delete from DTXiLanh\n"
                + "where id =?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }
    
      public D_DTXiLanh getOne(String ma) {

        String sql = "select id, dTXiLanh from DTXiLanh where dTXiLanh = '" + ma + "' ";
        try ( Connection cn = context.getConnection();  PreparedStatement pr = cn.prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                D_DTXiLanh sp = new D_DTXiLanh();
                sp.setId(rs.getString(1));
                sp.setDTXiLanh(rs.getString(2));
               
                return sp;
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
}
