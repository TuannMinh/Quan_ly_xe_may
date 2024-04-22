/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory.Little;

import DomainModel.D_XuatXu;
import Utilities.JDBCHeper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import Utilities.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class R_XuatXu {

    private DBconnection context;

    public List<D_XuatXu> getAllXX() {
        ArrayList<D_XuatXu> dsp = new ArrayList<>();
        String sql = "select * from XuatXu";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_XuatXu d = new D_XuatXu(
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

//    public Integer add(D_XuatXu ds) {
//        Integer row = 0;
//        String sql = "insert into XuatXu(xuatXu) values(?)";
//        try {
//            row = JDBCHeper.excuteUpdate(sql,
//                    ds.getXuatXu()
//            );
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return row;
//    }
          public boolean add(D_XuatXu ds) {

        String query = "insert into XuatXu(xuatXu) values(?)";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ds.getXuatXu());
           
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer update(D_XuatXu ds) {
        Integer row = 0;
        String sql = "Update XuatXu set xuatXu =?\n"
                + "               Where Id = ?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    ds.getXuatXu(),
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public Integer delete(D_XuatXu ds) {
        Integer row = 0;
        String sql = "Delete from XuatXu\n"
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
    public D_XuatXu getOne(String ma) {
        System.out.println("xx"+ma);

        String sql = "select id, xuatXu from XuatXu where xuatXu = ? ";
        try ( Connection cn = context.getConnection();  PreparedStatement pr = cn.prepareStatement(sql)) {
            pr.setObject(1, ma);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                D_XuatXu sp = new D_XuatXu();
                sp.setId(rs.getString(1));
                sp.setXuatXu(rs.getString(2));
               
                return sp;
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    } 
   
}
