/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Responstory.KhuyenMaiResponstortImpl;
import Service.IKhuyenMaiService;
import ViewModel.KhuyenMai_View;
import java.util.ArrayList;
import java.util.List;
import DomainModel.D_KhuyenMai;
import Responstory.KhuyenMaiRepositories;

/**
 *
 * @author Admin
 */
public class KhuyenMaiServiceImpl implements IKhuyenMaiService {

    private KhuyenMaiResponstortImpl km = new KhuyenMaiResponstortImpl();
    private KhuyenMaiRepositories rs = new KhuyenMaiRepositories();

    @Override
    public List<KhuyenMai_View> getall() {
        List<KhuyenMai_View> ds = new ArrayList<>();
        List<D_KhuyenMai> list = this.km.getAll();
        for (D_KhuyenMai km : list) {
            KhuyenMai_View view = new KhuyenMai_View("", km.getMaKH(), km.getTenKH(), km.getThoiGianKM(), km.getThoiGianKT(), km.getGiaTri());
            ds.add(view);
        }
        return ds;
    }

    @Override
    public boolean insert(KhuyenMai_View km
    ) {
        D_KhuyenMai kmDM = new D_KhuyenMai("", km.getMaKH(), km.getTenKH(), km.getThoiGianKM(), km.getThoiGianKT(), km.getGiaTri());
        this.km.add(kmDM);
        return true;

    }

    @Override
    public boolean update(KhuyenMai_View km
    ) {
        D_KhuyenMai kmDM = new D_KhuyenMai("", km.getMaKH(), km.getTenKH(), km.getThoiGianKM(), km.getThoiGianKT(), km.getGiaTri());
        this.km.update(kmDM);
        return true;
    }

    @Override
    public boolean delete(KhuyenMai_View km
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhuyenMai_View getGt(String ma) {
        return rs.one(ma);
    }

}
