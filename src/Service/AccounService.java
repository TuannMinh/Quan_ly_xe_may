/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.D_Accoun;
import ViewModel.AccounModels;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public interface AccounService {

    void them(AccounModels nv, String user);

    List<String> getListCV();

    D_Accoun getListUser(String uer);

    int showAccount(String name, String passWord);

    public boolean checkEmail(String email);

    public boolean updateMatKhau(String username, String password);


}
