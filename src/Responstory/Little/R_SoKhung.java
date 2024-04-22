/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory.Little;

import DomainModel.D_SanPhamBig;

import DomainModel.D_SoKhung;

import Utilities.JDBCHeper;
import java.util.ArrayList;
import java.util.List;

import Utilities.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class R_SoKhung {

    private DBconnection context;

    public List<D_SoKhung> getAllSK() {
        ArrayList<D_SoKhung> dsp = new ArrayList<>();
        String sql = "select sk.id,sp.maSP,sk.sokhung,sk.trangthai from SoKhung sk inner join SanPham sp on sk.idsp=sp.id\n";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                D_SoKhung d = new D_SoKhung();
                d.setId(rs.getString(1));

                D_SanPhamBig ds = new D_SanPhamBig();
                ds.setMaSP(rs.getString(2));
                d.setCtsp(ds);

                d.setSoKhung(rs.getString(3));
                d.setTrangThai(rs.getInt(4));

                dsp.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsp;
    }

    public List<D_SoKhung> getAllByNameMaSP(String masp) {
        ArrayList<D_SoKhung> dsp = new ArrayList<>();
        String sql = "select sk.id,sp.maSP,sk.sokhung,sk.trangthai from SoKhung sk\n"
                + "                inner join SanPham sp on sk.idsp=sp.id where maSP= '" + masp + "'";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                
                D_SoKhung d = new D_SoKhung();
                d.setId(rs.getString(1));

                D_SanPhamBig ds = new D_SanPhamBig();
                ds.setMaSP(rs.getString(2));
                d.setCtsp(ds);

                d.setSoKhung(rs.getString(3));
                d.setTrangThai(rs.getInt(4));

                dsp.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsp;
    }
    
        public List<D_SoKhung> getAllByNameMaSP2(String masp) {
        ArrayList<D_SoKhung> dsp = new ArrayList<>();
        String sql = "	select sk.id,sp.maSP,sk.sokhung,sk.trangthai from SoKhung sk\n" +
"                          inner join SanPham sp on sk.idsp=sp.id where sk.trangThai=1 and maSP= '" + masp + "'";

        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                
                D_SoKhung d = new D_SoKhung();
                d.setId(rs.getString(1));

                D_SanPhamBig ds = new D_SanPhamBig();
                ds.setMaSP(rs.getString(2));
                d.setCtsp(ds);

                d.setSoKhung(rs.getString(3));
                d.setTrangThai(rs.getInt(4));

                dsp.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsp;
    }

    public ArrayList<String> getMSP() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select Masp from SanPham";
        ResultSet rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String st = rs.getString(1);
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Integer add(D_SoKhung ds) {
        Integer row = 0;
        String sql = "insert into SoKhung(idsp,SoKhung,trangThai) values(?,?,?)";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    ds.getCtsp().getIdSP(),
                    ds.getSoKhung(),
                    ds.getTrangThai()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public Integer update(D_SoKhung ds) {
        Integer row = 0;
        String sql = "Update SoKhung set SoKhung =?\n"
                + "               Where Id = ?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    ds.getSoKhung(),
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public Integer delete(D_SoKhung ds) {
        Integer row = 0;
        String sql = "Delete from SoKhung\n"
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

    public Integer updateTrangThaiSoKhung(D_SoKhung ds) {
        Integer row = 0;
        String sql = "update SoKhung set trangThai=0 \n"
                + "where id=?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }
    public void Suask(String tt ) {
        String querry = """
                       UPDATE [dbo].[SoKhung]
                           SET 
                              [trangThai] = 0
                         WHERE SoKhung = ?
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1,tt );
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public void Suask1(String tt ) {
        String querry = """
                       UPDATE [dbo].[SoKhung]
                           SET 
                              [trangThai] = 1
                         WHERE SoKhung = ?
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1,tt );
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public Integer updateTraLaiTrangThaiSK(D_SoKhung ds) {
        Integer row = 0;
        String sql = "update SoKhung set trangThai=1 \n"
                + "where id=?";
        try {
            row = JDBCHeper.excuteUpdate(sql,
                    ds.getId()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public D_SoKhung getOne(String ma) {

        String sql = "select id, SoKhung from SoKhung where SoKhung = ? ";
        try ( Connection cn = context.getConnection();  PreparedStatement pr = cn.prepareStatement(sql)) {
            pr.setObject(1, ma);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                D_SoKhung sp = new D_SoKhung();
                sp.setId(rs.getString(1));
                sp.setSoKhung(rs.getString(2));

                return sp;
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

}
