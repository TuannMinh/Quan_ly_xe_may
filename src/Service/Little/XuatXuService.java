
package Service.Little;

import DomainModel.D_XuatXu;
import ViewModel.VM_XuatXu;
import java.util.List;


public interface XuatXuService {
    public List<D_XuatXu> getAll();

    public List<VM_XuatXu> getAllXuatXu();

    public boolean add(VM_XuatXu vds) ;

    public Integer update(VM_XuatXu vds) ;

    public Integer delete(VM_XuatXu vds);
    
    public D_XuatXu getOne(String ma);
}
