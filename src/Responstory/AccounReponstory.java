/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;

import DomainModel.D_Accoun;
import java.sql.ResultSet;
import java.sql.Connection;
import Utilities.DBconnection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class AccounReponstory {

    public void them(D_Accoun ac, String user) {
        String querry = """
                      INSERT INTO [dbo].[TaiKhoan]
                                  ([userName]
                                  ,[passWordd]
                                  ,[idChucVu])
                            VALUES
                                  (?,?,(SELECT [idcv]
                                    FROM [dbo].[ChucVu]
                                    where tenChucVu =?))
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, ac.getUsername());
            ps.setObject(2, ac.getPasswword());
            ps.setObject(3, user);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List<String> layIdcv() {
        String query = """
                      SELECT 
                            [tenChucVu]
                              FROM [dbo].[ChucVu]
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public int showAccount(String name, String passWord) {
        String sql = """
                     SELECT 
                           [userName]
                           ,[passWordd]
                           ,[idChucVu]
                       FROM [dbo].[TaiKhoan]
                     """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if (name.equals(rs.getString("userName")) && passWord.equals(rs.getString("passWordd"))) {
                    if (rs.getString("idChucVu").equals(layidcv())) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String layidcv() {
        String sql = """
                     SELECT [idcv]
                           ,[tenChucVu]
                       FROM [dbo].[ChucVu]
                       where tenChucVu = 'Nhân Viên'
                     """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if ((rs.getString("tenChucVu")).equalsIgnoreCase("Nhân viên")) {
                    return rs.getString("idcv");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public D_Accoun layIdcvUser(String user) {
        String query = """
                      SELECT [idtk]
                        FROM [dbo].[TaiKhoan]
                        where userName = ?
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, user);
            ResultSet rs = ps.executeQuery();
            D_Accoun acc = new D_Accoun();
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                acc.setIdtk(rs.getString(1));
            }
            return acc;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public boolean checkEmail(String email) {
        String query = "select * from TaiKhoan where userName = ?";
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            if (list.isEmpty()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return true;
    }

    public boolean updateMatKhau(String username, String password) {
        try {
            String query = "update TaiKhoan set passWordd = ? where userName  = ?";
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
}
