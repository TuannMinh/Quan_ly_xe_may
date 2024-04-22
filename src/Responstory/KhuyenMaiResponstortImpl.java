/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;

import DomainModel.D_KhuyenMai;
import Responstory.inf.IKhuyenMaiResponstory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utilities.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KhuyenMaiResponstortImpl implements Responstory.inf.IKhuyenMaiResponstory {

    @Override
    public List<D_KhuyenMai> getAll() {
        ArrayList<D_KhuyenMai> list = new ArrayList<>();
        try {
            Connection conn = DBconnection.getConnection();
            String sql = "select idkm,maKhuyenMai,tenKhuyenmai,thoiGianBd,thoiGianKT,GiaTri  from KhuyenMai";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("idkm");
                String ma = rs.getString("maKhuyenMai");
                String ten = rs.getString("tenKhuyenMai");              
                Date thoiGianKM = rs.getDate("thoiGianBd");
                Date thoiGianKT = rs.getDate("thoiGianKT");
                int giaTri = rs.getInt("GiaTri");

                D_KhuyenMai km = new D_KhuyenMai(id, ma, ten,thoiGianKM, thoiGianKT, giaTri);
                list.add(km);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean add(D_KhuyenMai km) {
        try {
            Connection cnn = DBconnection.getConnection();
            String sql = "insert into KhuyenMai(maKhuyenMai,tenKhuyenMai,thoiGianBd,thoiGianKT,GiaTri) values(?,?,?,?,?)";
            PreparedStatement ps = cnn.prepareCall(sql);
            ps.setString(1, km.getMaKH());
            ps.setString(2, km.getTenKH());
            ps.setObject(3, km.getThoiGianKM());
            ps.setObject(4, km.getThoiGianKT());
            ps.setInt(5, km.getGiaTri());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(D_KhuyenMai km) {
           try {
            Connection cnn = DBconnection.getConnection();
            String sql = "update KhuyenMai set maKhuyenMai =?,tenKhuyenmai=?, thoiGianBd =?, thoiGianKT=?, GiaTri =? where maKhuyenMai=?";
            PreparedStatement ps = cnn.prepareCall(sql);
            ps.setString(1, km.getMaKH());
            ps.setString(2, km.getTenKH());          
            ps.setObject(3, km.getThoiGianKM());
            ps.setObject(4, km.getThoiGianKT());
            ps.setInt(5, km.getGiaTri());
            ps.setString(6, km.getMaKH());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(D_KhuyenMai km) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
