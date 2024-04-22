package Service.Little;

import DomainModel.D_SoKhung;
import ViewModel.VM_SoKhung;
import java.util.ArrayList;
import java.util.List;

public interface SoKhungService {

    public List<D_SoKhung> getAll();

    public List<D_SoKhung> getAllSoKhung();

    public Integer add(D_SoKhung vds);

    public Integer update(D_SoKhung vds);

    public Integer delete(D_SoKhung vds);

    public ArrayList<String> getMSP();

    public D_SoKhung getOne(String ma);

    public List<D_SoKhung> getAllByNameMaSP(String masp);

    public Integer updateTrangThaiSoKhung(D_SoKhung ds);

    public Integer updateTraLaiTrangThaiSK(D_SoKhung ds);

    void suask(String d);

    void suask1(String d);

    public List<D_SoKhung> getAllByNameMaSP2(String masp);
}
