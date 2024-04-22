/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responstory;
import Utilities.DBconnection;
import ViewModel.NhanVienTTCT;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class NhanVienTTCTRepositories {
     public NhanVienTTCT getone(String ma) {
        String query = """
SELECT        dbo.NhanVien.maNV, dbo.NhanVien.tenNV, dbo.NhanVien.diaChi, dbo.NhanVien.gioiTinh, dbo.NhanVien.ngaySinh, dbo.NhanVien.sdt, dbo.NhanVien.email, dbo.NhanVien.trangThai, dbo.TaiKhoan.userName, 
                         dbo.TaiKhoan.passWordd, dbo.ChucVu.tenChucVu
FROM            dbo.NhanVien INNER JOIN
                         dbo.TaiKhoan ON dbo.NhanVien.idTaiKhoan = dbo.TaiKhoan.idtk INNER JOIN
                         dbo.ChucVu ON dbo.TaiKhoan.idChucVu = dbo.ChucVu.idcv
						 Where  DBO.NhanVien.maNV = ?
                       """;
        try ( Connection con = DBconnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienTTCT nv= new NhanVienTTCT(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11));
             return nv;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
}
