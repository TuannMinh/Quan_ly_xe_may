/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory.Little;

import DomainModel.D_Mau;
import Utilities.JDBCHeper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import Utilities.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class R_Mau {
private DBconnection context;
    public List<D_Mau> getAllMau() {
        ArrayList<D_Mau> dsp = new ArrayList<>();
        String sql = "select * from Mau";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_Mau d = new D_Mau(
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

//    public Integer add(D_Mau ds) {
//        Integer row = 0;
//        String sql = "insert into Mau(MauSac) values(?)";
//        try {
//            row = JDBCHeper.excuteUpdate(sql,
//                    ds.getMau()
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return row;
//    }
    
         public boolean add(D_Mau ds) {

        String query = "insert into Mau(MauSac) values(?)";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ds.getMau());
           
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer update(D_Mau ds) {
        Integer row = 0;
        String sql = "Update Mau set MauSac =?\n"
                + "               Where Id = ?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    
                    ds.getMau(),
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public Integer delete(D_Mau ds) {
        Integer row = 0;
        String sql = "Delete from Mau\n"
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
    
     public D_Mau getOne(String ma) {

        String sql = "select id, MauSac from Mau where mauSac = ?";
        try ( Connection cn = context.getConnection();  PreparedStatement pr = cn.prepareStatement(sql)) {
            pr.setObject(1, ma);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                D_Mau sp = new D_Mau();
                sp.setId(rs.getString(1));
                sp.setMau(rs.getString(2));
               
                return sp;
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
}
