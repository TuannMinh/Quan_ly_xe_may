/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory.Little;

import DomainModel.D_DTBinhXang;

import Utilities.JDBCHeper;
import java.util.ArrayList;
import java.util.List;
import Utilities.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class R_DTBinhXang {

    private DBconnection context;

    public List<D_DTBinhXang> getAllDTBX() {
        ArrayList<D_DTBinhXang> dsp = new ArrayList<>();
        String sql = "select * from DTBinhXang";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_DTBinhXang d = new D_DTBinhXang(
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

    public boolean add(D_DTBinhXang ds) {

        String query = "insert into DTBinhXang(dTBinhXang) values(?)";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ds.getDTBinhXang());
           
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer update(D_DTBinhXang ds) {
        Integer row = 0;
        String sql = "Update DTBinhXang set dtBinhXang =?\n"
                + "               Where Id = ?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    ds.getDTBinhXang(),
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public Integer delete(D_DTBinhXang ds) {
        Integer row = 0;
        String sql = "Delete from DTBinhXang\n"
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

    public D_DTBinhXang getOne(String ma) {

        String sql = "select id, dTBinhXang from DTBinhXang where dTBinhXang = '" + ma + "' ";
        try ( Connection cn = context.getConnection();  PreparedStatement pr = cn.prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                D_DTBinhXang sp = new D_DTBinhXang();
                sp.setId(rs.getString(1));
                sp.setDTBinhXang(rs.getString(2));

                return sp;
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }
//
//    public static void main(String[] args) {
//        R_DTBinhXang r = new R_DTBinhXang();
//        D_DTBinhXang d = r.getOne("5");
//        System.out.println(d.getId());
//    }
}
