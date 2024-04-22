/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responstory.inf;

import DomainModel.D_KhuyenMai;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IKhuyenMaiResponstory {

    List<D_KhuyenMai> getAll();

    boolean add(D_KhuyenMai km);

    boolean update(D_KhuyenMai km);

    boolean delete(D_KhuyenMai km);

}
