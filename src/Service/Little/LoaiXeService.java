
package Service.Little;

import DomainModel.D_LoaiXe;
import ViewModel.VM_LoaiXe;
import java.util.List;


public interface LoaiXeService {
    public List<D_LoaiXe> getAll();

    public List<VM_LoaiXe> getAllLX();

    public boolean add(VM_LoaiXe vds) ;

    public Integer update(VM_LoaiXe vds) ;

    public Integer delete(VM_LoaiXe vds);
    
    public D_LoaiXe getOne(String ma);
}
