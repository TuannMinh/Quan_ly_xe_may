
package Service.Little;

import DomainModel.D_DTBinhXang;
import ViewModel.VM_DTBinhXang;
import java.util.List;


public interface DTBinhXangService {
    public List<D_DTBinhXang> getAll();

    public List<D_DTBinhXang> getAllBX();

    public boolean add(D_DTBinhXang vds) ;

    public Integer update(D_DTBinhXang vds) ;

    public Integer delete(D_DTBinhXang vds);
    
    public D_DTBinhXang getOne(String ma);
}
