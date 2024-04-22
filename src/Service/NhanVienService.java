/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.NhanVienModels;
import ViewModel.NhanVienTTCT;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface NhanVienService {

    public List<NhanVienModels> getList();

    List<NhanVienModels> getListloc(int id);

    void them(NhanVienModels nv, String user);

    List<String> getListusename();

    NhanVienModels getLisstma(String id);

    void sua(NhanVienModels nv, String d);

    List<NhanVienModels> gettk(String ma);

    public NhanVienTTCT getCt(String ma);

}
