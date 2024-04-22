
package Service.Little;

import DomainModel.D_DTXiLanh;
import ViewModel.VM_DTXiLanh;
import java.util.List;


public interface DTXiLanhService {
    public List<D_DTXiLanh> getAll();

    public List<VM_DTXiLanh> getAllDongSP();

    public boolean add(VM_DTXiLanh vds) ;

    public Integer update(VM_DTXiLanh vds) ;

    public Integer delete(VM_DTXiLanh vds);
    
    public D_DTXiLanh getOne(String ma);
}
