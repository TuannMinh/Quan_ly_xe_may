/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.ChucVuModels;
import java.util.List;


/**
 *
 * @author Admin
 */
public interface ChucVuService {
    List<ChucVuModels> getAll();

    void them(ChucVuModels cv);

    void sua(ChucVuModels cv, String id);
}
