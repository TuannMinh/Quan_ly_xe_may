
package Service.Little;

import DomainModel.D_Mau;
import ViewModel.VM_Mau;
import java.util.List;


public interface MauService {
    public List<D_Mau> getAll();

    public List<VM_Mau> getAllMau();

    public boolean add(VM_Mau vds) ;

    public Integer update(VM_Mau vds) ;

    public Integer delete(VM_Mau vds);
    
    public D_Mau getOne(String ma);
}
