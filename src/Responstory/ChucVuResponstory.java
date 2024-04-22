/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;

import DomainModel.D_ChucVu;
import Utilities.DBconnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Admin
 */
public class ChucVuResponstory {
     public List<D_ChucVu> getAll(){
        String querry = """
                       SELECT [idcv]
                              ,[tenChucVu]
                          FROM [dbo].[ChucVu]
                        """;
        try { Connection con = DBconnection.getConnection();
        PreparedStatement ps = con.prepareStatement(querry);
         ResultSet rs = ps.executeQuery();
         List<D_ChucVu> list = new ArrayList<>();
            while (rs.next()) {                
                D_ChucVu dv = new D_ChucVu(rs.getString(1),rs.getString(2));
                list.add(dv);
            }
            return list;           
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     public void them(D_ChucVu nv ) {
        String querry = """
                        INSERT INTO [dbo].[ChucVu]
                                   (
                                   [tenChucVu])
                             VALUES
                                   (?)
                        """;
        try {
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setObject(1, nv.getTen());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
 
    public void sua(D_ChucVu cv ,String Id){
        String querry = """
                       UPDATE [dbo].[ChucVu]
                           SET 
                             [tenChucVu] =?
                         WHERE idcv = ?
                        """;
        try { Connection con = DBconnection.getConnection();
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setObject(1,cv.getTen());
        ps.setObject(2, Id);
        ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    
  }
}
