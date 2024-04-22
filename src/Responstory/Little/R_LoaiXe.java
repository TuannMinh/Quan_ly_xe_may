/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory.Little;

import DomainModel.D_LoaiXe;
import Utilities.JDBCHeper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import Utilities.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class R_LoaiXe {
private DBconnection context;
    public List<D_LoaiXe> getAllLX() {
        ArrayList<D_LoaiXe> dsp = new ArrayList<>();
        String sql = "select * from LoaiXe";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_LoaiXe d = new D_LoaiXe(
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

//    public Integer add(D_LoaiXe ds) {
//        Integer row = 0;
//        String sql = "insert into LoaiXe(LoaiXe) values(?)";
//        try {
//            row = JDBCHeper.excuteUpdate(sql,
//                    ds.getLaoiXe()
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return row;
//    }
    
       public boolean add(D_LoaiXe ds) {

        String query = "insert into LoaiXe(LoaiXe) values(?)";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ds.getLaoiXe());
           
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer update(D_LoaiXe ds) {
        Integer row = 0;
        String sql = "Update LoaiXe set LoaiXe =?\n"
                + "               Where Id = ?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    
                    ds.getLaoiXe(),
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public Integer delete(D_LoaiXe ds) {
        Integer row = 0;
        String sql = "Delete from LoaiXe\n"
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
    
    
     public D_LoaiXe getOne(String ma) {

        String sql = "select id, LoaiXe from LoaiXe where loaiXe = ? ";
        try ( Connection cn = context.getConnection();  PreparedStatement pr = cn.prepareStatement(sql)) {
            pr.setObject(1, ma);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                D_LoaiXe sp = new D_LoaiXe();
                sp.setId(rs.getString(1));
                sp.setLaoiXe(rs.getString(2));
               
                return sp;
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
}
