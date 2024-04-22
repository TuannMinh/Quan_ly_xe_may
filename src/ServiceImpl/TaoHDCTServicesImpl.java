/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Responstory.TaoHDCTRepository;
import Service.HoaDonServies;
import Service.TaoHDCTServices;
import ViewModel.TaoHDCTMODEL;

/**
 *
 * @author ADMIN
 */
public class TaoHDCTServicesImpl implements TaoHDCTServices{
    TaoHDCTRepository rs =new TaoHDCTRepository();

    @Override
    public void themdhct(TaoHDCTMODEL nv, String idsp, String idhd, String idsk, String idkm) {
        rs.them(nv, idsp, idhd, idsk, idkm);
       }
    
}
