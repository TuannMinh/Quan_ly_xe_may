/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.D_SanPhamBig;
import DomainModel.D_DTBinhXang;
import DomainModel.D_DTXiLanh;
import DomainModel.D_LoaiXe;
import DomainModel.D_Mau;
import DomainModel.D_XuatXu;
import ServiceImpl.CTSanPhamImpl;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import ServiceImpl.little.DTBinhXangImpl;
import ServiceImpl.little.DTXiLanhImpl;
import ServiceImpl.little.LoaiXeImpl;
import ServiceImpl.little.MauImpl;
import ServiceImpl.little.XuatXuImpl;
import ServiceImpl.little.SoKhungImpl;
import View.Little.View_DTBinhXang;
import View.Little.View_DTXiLanh;
import View.Little.View_LoaiXe;
import View.Little.View_Mau;
import View.Little.View_SoKhung;
import View.Little.View_XuatXu;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author VietTien
 */
public class View_SanPhamBig extends javax.swing.JFrame {

    private DefaultTableModel defaultTbalemode1;
    private DefaultTableModel defaultTbalemode2;
    private DefaultComboBoxModel defaultComBoboxModel;

    private final CTSanPhamImpl cTSanPhamImpl;
    private final DTBinhXangImpl dTbinhXangImpl;
    private final DTXiLanhImpl dTXiLanhImpl;
    private final MauImpl mauImpl;
    private final XuatXuImpl xuatXuImpl;
    private final LoaiXeImpl loaiXeImpl;
    private final SoKhungImpl soKhungImpl;
    private final D_SanPhamBig d_SanPhamBig;
    private final List<D_SanPhamBig> list;
    int sl = 0;

    public View_SanPhamBig() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
           
        this.cTSanPhamImpl = new CTSanPhamImpl();

        this.dTbinhXangImpl = new DTBinhXangImpl();
        this.dTXiLanhImpl = new DTXiLanhImpl();
        this.mauImpl = new MauImpl();
        this.xuatXuImpl = new XuatXuImpl();
        this.loaiXeImpl = new LoaiXeImpl();
        this.soKhungImpl = new SoKhungImpl();
        list = cTSanPhamImpl.getAllSanPham();
        this.d_SanPhamBig = new D_SanPhamBig();
        loadData(cTSanPhamImpl.getAllSanPham2());
        loadBX(cTSanPhamImpl.getDTBX());
        loadXL(cTSanPhamImpl.getDTXL());
        loadMau(cTSanPhamImpl.getMau());
        loadXuatXu(cTSanPhamImpl.getXuatXu());
        loadLoaiXe(cTSanPhamImpl.getLoaiXe());
//        loadSoKhung(ServiceSP.getSoKhung());

    }
   public View_SanPhamBig(View_QLBanHang view_QLBanHang) {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        this.cTSanPhamImpl = new CTSanPhamImpl();

        this.dTbinhXangImpl = new DTBinhXangImpl();
        this.dTXiLanhImpl = new DTXiLanhImpl();
        this.mauImpl = new MauImpl();
        this.xuatXuImpl = new XuatXuImpl();
        this.loaiXeImpl = new LoaiXeImpl();
        this.soKhungImpl = new SoKhungImpl();
        list = cTSanPhamImpl.getAllSanPham();
        this.d_SanPhamBig = new D_SanPhamBig();
        loadData(cTSanPhamImpl.getAllSanPham2());
        loadBX(cTSanPhamImpl.getDTBX());
        loadXL(cTSanPhamImpl.getDTXL());
        loadMau(cTSanPhamImpl.getMau());
        loadXuatXu(cTSanPhamImpl.getXuatXu());
        loadLoaiXe(cTSanPhamImpl.getLoaiXe());
//        loadSoKhung(ServiceSP.getSoKhung());

    }
    public void loadData(ArrayList<D_SanPhamBig> ctsp) {

        defaultTbalemode1 = (DefaultTableModel) tlbBang1.getModel();
        defaultTbalemode1.setRowCount(0);

        defaultTbalemode2 = (DefaultTableModel) bang2.getModel();
        defaultTbalemode2.setRowCount(0);
        TableColumnModel columnModel = tlbBang1.getColumnModel();
        for (int col = 9; col <= 9; col++) {
            columnModel.getColumn(col).setCellRenderer(new CurrencyRenderer());
        }

        for (D_SanPhamBig x : ctsp) {
            if (x.getTrangThai() == 1) {
                defaultTbalemode1.addRow(new Object[]{
                    x.getIdSP(),
                    x.getMaSP(),
                    x.getTenSP(),
                    x.getDtBinhXang().getDTBinhXang(),
                    x.getdTXiLanh().getDTXiLanh(),
                    x.getMau().getMau(),
                    x.getXuatXu().getXuatXu(),
                    x.getLoaiXe().getLaoiXe(),
                    x.getNamSX(),
                    x.getGiaBan(),
                    x.getTrangThai() == 1 ? "Yes" : "No",});
            } else {
                defaultTbalemode2.addRow(new Object[]{
                    x.getIdSP(),
                    x.getMaSP(),
                    x.getTenSP(),
                    x.getDtBinhXang().getDTBinhXang(),
                    x.getdTXiLanh().getDTXiLanh(),
                    x.getMau().getMau(),
                    x.getXuatXu().getXuatXu(),
                    x.getLoaiXe().getLaoiXe(),
                    x.getNamSX(),
                    x.getGiaBan(),
                    x.getTrangThai() == 1 ? "Yes" : "No",});
            }
        }
    }

    public void loadBX(ArrayList<String> list) {
        cbbBinhXang.removeAllItems();
        defaultComBoboxModel = (DefaultComboBoxModel) cbbBinhXang.getModel();

        for (String string : list) {
            defaultComBoboxModel.addElement(string);
        }

    }

    public void loadXL(ArrayList<String> list) {
        cbbXiLanh.removeAllItems();
        defaultComBoboxModel = (DefaultComboBoxModel) cbbXiLanh.getModel();

        for (String string : list) {
            defaultComBoboxModel.addElement(string);
        }

    }

    public void loadMau(ArrayList<String> list) {
        cbbMau.removeAllItems();
        defaultComBoboxModel = (DefaultComboBoxModel) cbbMau.getModel();

        for (String string : list) {
            defaultComBoboxModel.addElement(string);
        }

    }

    public void loadXuatXu(ArrayList<String> list) {
        cbbXuatXu.removeAllItems();
        defaultComBoboxModel = (DefaultComboBoxModel) cbbXuatXu.getModel();

        for (String string : list) {
            defaultComBoboxModel.addElement(string);
        }

    }

    public void loadLoaiXe(ArrayList<String> list) {
        cbbLoaiXe.removeAllItems();
        defaultComBoboxModel = (DefaultComboBoxModel) cbbLoaiXe.getModel();

        for (String string : list) {
            defaultComBoboxModel.addElement(string);
        }

    }

    public D_SanPhamBig getForm() {
        D_SanPhamBig kh = new D_SanPhamBig();

        kh.setIdSP(txtidctsp.getText());
        kh.setMaSP(txtMaSP.getText());
        kh.setTenSP(txtTenSP.getText());

        String index1 = cbbBinhXang.getSelectedItem().toString();
        D_DTBinhXang dtbx1 = dTbinhXangImpl.getOne(index1);
        kh.setDtBinhXang(dtbx1);

        String index2 = cbbXiLanh.getSelectedItem().toString();
        D_DTXiLanh dtbx2 = dTXiLanhImpl.getOne(index2);
        kh.setdTXiLanh(dtbx2);

        String index3 = cbbMau.getSelectedItem().toString();
        D_Mau dtbx3 = mauImpl.getOne(index3);
        kh.setMau(dtbx3);

        String index4 = cbbXuatXu.getSelectedItem().toString();
        D_XuatXu dtbx4 = xuatXuImpl.getOne(index4);
        kh.setXuatXu(dtbx4);

        String index5 = cbbLoaiXe.getSelectedItem().toString();
        D_LoaiXe dtbx5 = loaiXeImpl.getOne(index5);
        kh.setLoaiXe(dtbx5);

        kh.setNamSX(Integer.parseInt(txtNamSX.getText()));
        kh.setGiaBan(Double.parseDouble(txtGiaBan.getText()));

        int t = 0;
        if (rdoYes.isSelected()) {
            t = 1;
        }
        kh.setTrangThai(t);

        return kh;

    }

    public boolean checkForm() {

        if (txtMaSP.getText().trim().isEmpty()) {
          
             JOptionPane.showMessageDialog(this,
                    "Không được bỏ trống Mã",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtTenSP.getText().trim().isEmpty()) {
   
             JOptionPane.showMessageDialog(this,
                    "Không được bỏ trống Tên",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtNamSX.getText().trim().isEmpty()) {
     
             JOptionPane.showMessageDialog(this,
                    "Không được bỏ trống Năm Sản Xuất",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtGiaBan.getText().trim().isEmpty()) {
           
             JOptionPane.showMessageDialog(this,
                    "Không được bỏ trống Giá Bán",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;

        }
        try {
            int nsx = Integer.parseInt(txtNamSX.getText());
            if (nsx < 1800 || nsx > 2023) {
                
                JOptionPane.showMessageDialog(this,
                    "Năm Sản Xuất Không hợp lệ",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Năm Sản Xuất không hợp lệ, vui lòng thử lại với năm sản xuất là số",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra Dung Tích Xi Lanh có phải số hợp lệ hay không
        try {
            double giaBan = Double.parseDouble(txtGiaBan.getText());
            if (giaBan< 15000000 || giaBan > 1000000000) {
                JOptionPane.showMessageDialog(this,
                    "Giá bán không hợp lệ",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
                
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Giá bán không hợp lệ, vui lòng thử lại với giá trị số",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Tiếp tục kiểm tra các trường khác nếu cần thiết
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jpSanPham = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButton62 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbBang1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        rdoYes = new javax.swing.JRadioButton();
        rdoNo = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        aa = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbbBinhXang = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbbXiLanh = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbbMau = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbbXuatXu = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbbLoaiXe = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNamSX = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtidctsp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bang2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        txtTimKiem2 = new javax.swing.JTextField();
        cbbTimKiem2 = new javax.swing.JButton();
        cbbKhoiPhuc = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tlbBang2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));

        jButton62.setBackground(new java.awt.Color(0, 153, 153));
        jButton62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton62.setForeground(new java.awt.Color(255, 255, 255));
        jButton62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imegas/Home.png"))); // NOI18N
        jButton62.setText("QL Bán Hàng");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jButton64.setBackground(new java.awt.Color(0, 153, 153));
        jButton64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton64.setForeground(new java.awt.Color(255, 255, 255));
        jButton64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/khachhang.png"))); // NOI18N
        jButton64.setText("   QL Nhân Viên");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        jButton65.setBackground(new java.awt.Color(0, 153, 153));
        jButton65.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton65.setForeground(new java.awt.Color(255, 255, 255));
        jButton65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sanpham.png"))); // NOI18N
        jButton65.setText("  QL Sản Phẩm");
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jButton66.setBackground(new java.awt.Color(0, 153, 153));
        jButton66.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton66.setForeground(new java.awt.Color(255, 255, 255));
        jButton66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nhanvien.png"))); // NOI18N
        jButton66.setText("QL Khách Hàng");
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });

        jButton67.setBackground(new java.awt.Color(0, 153, 153));
        jButton67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton67.setForeground(new java.awt.Color(255, 255, 255));
        jButton67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lichsu.png"))); // NOI18N
        jButton67.setText("   Khuyến Mãi");
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        jButton68.setBackground(new java.awt.Color(0, 153, 153));
        jButton68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton68.setForeground(new java.awt.Color(255, 255, 255));
        jButton68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dangnhap.png"))); // NOI18N
        jButton68.setText("      Đăng Xuất");
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(0, 204, 204));
        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("QUẢN LÝ BÁN XE MÁY");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel16)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        jButton11.setBackground(new java.awt.Color(51, 51, 51));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/channels4_profile.jpg"))); // NOI18N

        jButton69.setBackground(new java.awt.Color(0, 153, 153));
        jButton69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton69.setForeground(new java.awt.Color(255, 255, 255));
        jButton69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/file-invoice-dollar (1).png"))); // NOI18N
        jButton69.setText("Lịch Sử Hóa Đơn");
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton62, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));
        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tlbBang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tlbBang1.setForeground(new java.awt.Color(0, 51, 153));
        tlbBang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "masp", "ten", "dtbx", "dtxilanh", "mau", "xuatxu", "loaixe", "NSX", "Giá Bán", "Trạng Thái", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tlbBang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlbBang1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tlbBang1);
        if (tlbBang1.getColumnModel().getColumnCount() > 0) {
            tlbBang1.getColumnModel().getColumn(0).setMinWidth(0);
            tlbBang1.getColumnModel().getColumn(0).setPreferredWidth(0);
            tlbBang1.getColumnModel().getColumn(0).setMaxWidth(0);
            tlbBang1.getColumnModel().getColumn(10).setMinWidth(0);
            tlbBang1.getColumnModel().getColumn(10).setPreferredWidth(0);
            tlbBang1.getColumnModel().getColumn(10).setMaxWidth(0);
            tlbBang1.getColumnModel().getColumn(11).setMinWidth(0);
            tlbBang1.getColumnModel().getColumn(11).setPreferredWidth(0);
            tlbBang1.getColumnModel().getColumn(11).setMaxWidth(0);
        }

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Trạng Thái :");

        buttonGroup1.add(rdoYes);
        rdoYes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoYes.setForeground(new java.awt.Color(0, 51, 51));
        rdoYes.setText("Còn Bán");
        rdoYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoYesActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNo);
        rdoNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNo.setForeground(new java.awt.Color(0, 51, 51));
        rdoNo.setText("Không còn bán");

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        btnUpdate.setBackground(new java.awt.Color(0, 204, 204));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/refresh (6).png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 204, 204));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/broom (1).png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 204, 204));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/plus (1).png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoYes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoNo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(rdoYes)
                    .addComponent(rdoNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        aa.setBackground(new java.awt.Color(0, 204, 204));
        aa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout aaLayout = new javax.swing.GroupLayout(aa);
        aa.setLayout(aaLayout);
        aaLayout.setHorizontalGroup(
            aaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        aaLayout.setVerticalGroup(
            aaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );

        jButton6.setBackground(new java.awt.Color(0, 204, 204));
        jButton6.setText("Chọn Ảnh");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Dung Tích Bình Xăng :");

        cbbBinhXang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbBinhXang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbBinhXangActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Dung Tích Xi Lanh :");

        cbbXiLanh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Màu Sắc :");

        cbbMau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Loại Xe :");

        cbbXuatXu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton2.setText("Chi tiết");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton3.setText("Chi tiết");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton4.setText("Chi tiết");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton5.setText("Chi tiết");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jButton7.setText("Tìm Kiếm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton7)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã Sản Phẩm :");

        txtMaSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tên Sản Phẩm :");

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Xuất Xứ :");

        cbbLoaiXe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton8.setText("Chi tiết");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 102, 102));
        jButton12.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton12.setText("Chi tiết");
        jButton12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Update Số Khung :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Năm Sản Xuất :");

        txtNamSX.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Giá Bán :");

        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("VND");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(cbbBinhXang, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2))
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtMaSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                                .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(cbbXiLanh, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3)))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton12))
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton4))
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(cbbXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton5))
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(cbbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton8)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jButton6))))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(txtidctsp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtidctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                                .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addGap(12, 12, 12)))
                        .addGap(39, 39, 39)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel18)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(txtNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbBinhXang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(cbbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbXiLanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jLabel9)
                            .addComponent(jButton12))
                        .addContainerGap(177, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpSanPham.addTab("Sản Phẩm", jPanel3);

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        bang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Mã Sản Phẩm", "Tên Sản Phẩm", "Dung Tích Binh Xăng", "Dung Tích Xi Lanh", "Màu", "Xuất Xứ", "Loại Xe", "Năm Sản Xuất", "Giá Bán", "Trạng Thái", "Số Lượng"
            }
        ));
        bang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bang2);
        if (bang2.getColumnModel().getColumnCount() > 0) {
            bang2.getColumnModel().getColumn(0).setMinWidth(0);
            bang2.getColumnModel().getColumn(0).setPreferredWidth(0);
            bang2.getColumnModel().getColumn(0).setMaxWidth(0);
            bang2.getColumnModel().getColumn(10).setMinWidth(0);
            bang2.getColumnModel().getColumn(10).setPreferredWidth(0);
            bang2.getColumnModel().getColumn(10).setMaxWidth(0);
            bang2.getColumnModel().getColumn(11).setMinWidth(0);
            bang2.getColumnModel().getColumn(11).setPreferredWidth(0);
            bang2.getColumnModel().getColumn(11).setMaxWidth(0);
        }

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbbTimKiem2.setText("Tìm Kiếm");
        cbbTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiem2ActionPerformed(evt);
            }
        });

        cbbKhoiPhuc.setText("Khôi Phục");
        cbbKhoiPhuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhoiPhucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cbbTimKiem2)
                .addGap(28, 28, 28)
                .addComponent(cbbKhoiPhuc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbKhoiPhuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 273, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 180, Short.MAX_VALUE))
        );

        jpSanPham.addTab("Sản Phẩm Đã Bán", jPanel8);

        tlbBang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Dung Tích Bình Xăng", "Dung Tích Xi Lanh", "Màu", "Xuất Xứ", "Số Khung", "Giá", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tlbBang2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 200, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );

        jpSanPham.addTab("", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSanPham)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpSanPham)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  String duongdanang = "C:\\anh\\anh1.jpg";

    public ImageIcon RessiezImage(String a) {
        ImageIcon MyImage = new ImageIcon(a);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(aa.getWidth(), aa.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    private void cbbBinhXangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbBinhXangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbBinhXangActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton62ActionPerformed

    private void rdoYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoYesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        View_DTBinhXang bx = new View_DTBinhXang();
        bx.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        View_DTXiLanh bx = new View_DTXiLanh();
        bx.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        View_Mau bx = new View_Mau();
        bx.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        View_XuatXu bx = new View_XuatXu();
        bx.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
         View_SoKhung view = new View_SoKhung(this);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
                view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser f = new JFileChooser("D:\\Anh");
            f.setDialogTitle("Mở file");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            duongdanang = ftenanh.getAbsolutePath();
            if (duongdanang != null) {
                label.setIcon(RessiezImage(String.valueOf(duongdanang)));
                System.out.println(duongdanang);
            }

        } catch (Exception e) {
            System.out.println("Chưa Chọn ảnh");;
            System.out.println(duongdanang);;

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkForm()) {
            D_SanPhamBig ds = this.getForm();

            if (this.cTSanPhamImpl.add(ds)) {

                loadData(cTSanPhamImpl.getAllSanPham2());
                JOptionPane.showMessageDialog(this, "Thêm thành công,mời bạn thêm số khung cho sản phẩm mới");
                clearForm();
                View_SoKhung view = new View_SoKhung(this);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
                view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              
            } else {
                JOptionPane.showMessageDialog(this,
                    "Mã sản phẩm này đã tồn tại ! Bạn có thể tìm ở mục tìm kiếm",
                    "Lỗi",
                    JOptionPane.ALLBITS);
                clearForm();

            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       this.clearForm();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (checkForm()) {
            D_SanPhamBig ds = this.getForm();

            if (this.cTSanPhamImpl.update(ds)) {
                JOptionPane.showMessageDialog(this, "Bạn đã update thành công");
                clearForm();
                loadData(cTSanPhamImpl.getAllSanPham2());

            } else {

                JOptionPane.showMessageDialog(this,
                    "Mã sản phẩm này đã tồn tại ! Bạn có thể tìm ở mục tìm kiếm",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String ma = txtTimKiem.getText().trim();
        if (ma.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm hoặc tên sản phẩm cần tìm");
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) tlbBang1.getModel();
        dtm.setRowCount(0);
        int count = 0;
        for (D_SanPhamBig x : cTSanPhamImpl.getAllSanPham2()) {
            if (x.getMaSP().contains(ma) || x.getTenSP().contains(ma)) {
                Object[] obj = {
                    x.getIdSP(),
                    x.getMaSP(),
                    x.getTenSP(),
                    x.getDtBinhXang().getDTBinhXang(),
                    x.getdTXiLanh().getDTXiLanh(),
                    x.getMau().getMau(),
                    x.getXuatXu().getXuatXu(),
                    x.getLoaiXe().getLaoiXe(),
                    x.getNamSX(),
                    x.getGiaBan(),
                    x.getTrangThai() == 1 ? "Yes" : "No",
                    x.getSoLuong()
                };
                dtm.addRow(obj);
                count = 1;
            }
        }
        if (count
                == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã sản phẩm hoặc tên sản phẩm nào như vậy");
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbbTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiem2ActionPerformed
        String ma = txtTimKiem2.getText().trim();
        if (ma.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm hoặc tên sản phẩm cần tìm");
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) bang2.getModel();
        dtm.setRowCount(0);
        int count = 0;
        for (D_SanPhamBig x : cTSanPhamImpl.getAllSanPham2()) {
            if (x.getMaSP().contains(ma) || x.getTenSP().contains(ma)) {
                Object[] obj = {
                    x.getIdSP(),
                    x.getMaSP(),
                    x.getTenSP(),
                    x.getDtBinhXang().getDTBinhXang(),
                    x.getdTXiLanh().getDTXiLanh(),
                    x.getMau().getMau(),
                    x.getXuatXu().getXuatXu(),
                    x.getLoaiXe().getLaoiXe(),
                    x.getNamSX(),
                    x.getGiaBan(),
                    x.getTrangThai() == 1 ? "Yes" : "No",
                    x.getSoLuong()
                };
                dtm.addRow(obj);
                count = 1;
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã sản phẩm hoặc tên sản phẩm nào như vậy");
        }
    }//GEN-LAST:event_cbbTimKiem2ActionPerformed

    private void cbbKhoiPhucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhoiPhucActionPerformed
        D_SanPhamBig ds = this.getForm();

        int row = this.bang2.getSelectedRow();
        if (row == -1) {
            return;
        }

        if (this.cTSanPhamImpl.updateTrangthai(ds) != null) {
            JOptionPane.showMessageDialog(this, "Bạn đã update thành công");
            clearForm();
            loadData(cTSanPhamImpl.getAllSanPham2());

        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi đang xẩy ra");
            
        }

    }//GEN-LAST:event_cbbKhoiPhucActionPerformed

    private void cbbMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauActionPerformed
//        String x = cbbMau.getSelectedItem().toString();
//        D_Mau mau = mS.getOne(x);
//        System.out.println(mau.getId());
    }//GEN-LAST:event_cbbMauActionPerformed

    private void bang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bang2MouseClicked
        int row = bang2.getSelectedRow();
        if (row == -1) {
            return;
        }

        txtidctsp.setText(bang2.getValueAt(row, 0).toString());
        txtMaSP.setText(bang2.getValueAt(row, 1).toString());
        txtTenSP.setText(bang2.getValueAt(row, 2).toString());
        cbbBinhXang.setSelectedItem(bang2.getValueAt(row, 3).toString());
        cbbXiLanh.setSelectedItem(bang2.getValueAt(row, 4).toString());
        cbbMau.setSelectedItem(bang2.getValueAt(row, 5).toString());
        cbbXuatXu.setSelectedItem(bang2.getValueAt(row, 6).toString());
        cbbLoaiXe.setSelectedItem(bang2.getValueAt(row, 7).toString());
        txtNamSX.setText(bang2.getValueAt(row, 8).toString());

        txtGiaBan.setText(bang2.getValueAt(row, 9).toString());

        String trangthai = bang2.getValueAt(row, 10).toString();
        if (trangthai.equalsIgnoreCase("Yes")) {
            rdoYes.setSelected(true);
        } else {
            rdoNo.setSelected(true);

        }


    }//GEN-LAST:event_bang2MouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void tlbBang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbBang1MouseClicked
        int row = tlbBang1.getSelectedRow();
        if (row == -1) {
            return;
        }

        txtidctsp.setText(tlbBang1.getValueAt(row, 0).toString());
        txtMaSP.setText(tlbBang1.getValueAt(row, 1).toString());
        txtTenSP.setText(tlbBang1.getValueAt(row, 2).toString());
        cbbBinhXang.setSelectedItem(tlbBang1.getValueAt(row, 3).toString());
        cbbXiLanh.setSelectedItem(tlbBang1.getValueAt(row, 4).toString());
        cbbMau.setSelectedItem(tlbBang1.getValueAt(row, 5).toString());
        cbbXuatXu.setSelectedItem(tlbBang1.getValueAt(row, 6).toString());
        cbbLoaiXe.setSelectedItem(tlbBang1.getValueAt(row, 7).toString());
        txtNamSX.setText(tlbBang1.getValueAt(row, 8).toString());

        txtGiaBan.setText(tlbBang1.getValueAt(row, 9).toString());

        String trangthai = tlbBang1.getValueAt(row, 10).toString();
        if (trangthai.equalsIgnoreCase("Yes")) {
            rdoYes.setSelected(true);
        } else {
            rdoNo.setSelected(true);

        }
//        txtidctsp.setText(tlbBang1.getValueAt(row, 9).toString());
        //        label.setIcon(RessiezImage(String.valueOf(list.get(row).getHinhAnh())));
    }//GEN-LAST:event_tlbBang1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        View_LoaiXe bx = new View_LoaiXe();
        bx.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton69ActionPerformed

    public void clearForm() {
        cbbBinhXang.setSelectedIndex(0);
        cbbXiLanh.setSelectedIndex(0);
        cbbMau.setSelectedIndex(0);
        cbbXuatXu.setSelectedIndex(0);
        cbbLoaiXe.setSelectedIndex(0);
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtNamSX.setText("");
        txtGiaBan.setText("");
        rdoYes.setSelected(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_SanPhamBig.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_SanPhamBig.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_SanPhamBig.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_SanPhamBig.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_SanPhamBig().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aa;
    private javax.swing.JTable bang2;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbBinhXang;
    private javax.swing.JButton cbbKhoiPhuc;
    private javax.swing.JComboBox<String> cbbLoaiXe;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JButton cbbTimKiem2;
    private javax.swing.JComboBox<String> cbbXiLanh;
    private javax.swing.JComboBox<String> cbbXuatXu;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jpSanPham;
    private javax.swing.JLabel label;
    private javax.swing.JRadioButton rdoNo;
    private javax.swing.JRadioButton rdoYes;
    private javax.swing.JTable tlbBang1;
    private javax.swing.JTable tlbBang2;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNamSX;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtidctsp;
    // End of variables declaration//GEN-END:variables
}
