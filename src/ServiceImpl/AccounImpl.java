/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import DomainModel.D_Accoun;
import Responstory.AccounReponstory;
import Service.AccounService;
import ViewModel.AccounModels;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class AccounImpl implements AccounService{
    AccounReponstory rs = new AccounReponstory();

    @Override
    public void them(AccounModels nv, String user) {
         D_Accoun nvv = new D_Accoun();
       nvv.setUsername(nv.getUsername());
        nvv.setPasswword(nv.getPasswword());
        rs.them(nvv,user);
      }

    @Override
    public List<String> getListCV() {
          return rs.layIdcv();
             
     }

    @Override
    public int showAccount(String name, String passWord) {
        return rs.showAccount(name, passWord);
     }

    @Override
    public D_Accoun getListUser(String uer) {
        return rs.layIdcvUser(uer);
 }

    @Override
    public boolean checkEmail(String email) {
        return rs.checkEmail(email);
    }

    @Override
    public boolean updateMatKhau(String username, String password) {
        return rs.updateMatKhau(username,password);
    }
}
