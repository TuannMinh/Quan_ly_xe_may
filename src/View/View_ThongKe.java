/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Service.CTHoaDonService;
import Service.CTSanPhamService;
import Service.HoaDonServies;
import ServiceImpl.CTHoaDonImpl;
import ServiceImpl.CTSanPhamImpl;
import ServiceImpl.HoadonServicesImpl;
import Utilities.ExportExcel;
import ViewModel.CTHoaDonNT;
import ViewModel.CTSanPhamHD;
import ViewModel.HoaDon;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Dell
 */
public class View_ThongKe extends javax.swing.JFrame {

    private HoaDonServies hoaDonServies = new HoadonServicesImpl();
    private CTHoaDonService ctHoaDonServies = new CTHoaDonImpl();
    private CTSanPhamService ctSanPhamService = new CTSanPhamImpl();
    private ExportExcel exportExcel = new ExportExcel();
    private DefaultComboBoxModel defaultComboBoxModel;
    private DefaultTableModel defaultTableModel;
    private JPanel jpnItem;

    /**
     * Creates new form NewJFrame1
     */
    public View_ThongKe() {
        initComponents();
        this.setLocationRelativeTo(null);
        cbbNamDoanhThu.removeAllItems();
        addNamDoanhThu(hoaDonServies.getYear());
        setBieuDoDoanhThu(jpnThongKe);
        lblSumDonHang.setText(String.valueOf(sumHoaDon(hoaDonServies.getList(0))) + " Đơn Hàng");
        lblSumDate.setText(sum(ctHoaDonServies.sumDate(getNgayHienTai(), 0)));
        lblSumMonth.setText(sum(ctHoaDonServies.sumMonth(getMonth(), 0)));
        lblSumYear.setText(sum(ctHoaDonServies.sumYear(getYear(), 0)));
    }

    private void loadDataThongKe(List<CTSanPhamHD> list) {
        defaultTableModel = (DefaultTableModel) tblSanPham.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        for (CTSanPhamHD sanPham : list) {
            defaultTableModel.addRow(new Object[]{
                count++,
                sanPham.getMaSP(),
                ctSanPhamService.getByNameSanPham(sanPham.getMaSP()),
                ctSanPhamService.getByNameDTBinhXang(sanPham.getMaSP()),
                ctSanPhamService.getByNameDTXiLanh(sanPham.getMaSP()),
                ctSanPhamService.getByNameSoKhung(sanPham.getMaSP()),
                ctSanPhamService.getByNameMau(sanPham.getMaSP()),
                ctSanPhamService.getByNameXuatXu(sanPham.getMaSP()),
                ctSanPhamService.getByNameLoaiXe(sanPham.getMaSP()),
                sanPham.getSoLuong()
            });
        }
    }

    private void loadDataDoanhThu(List<Integer> list) {
        defaultTableModel = (DefaultTableModel) tblDoanhThu.getModel();
        defaultTableModel.setRowCount(0);
        for (Integer integer : list) {
            defaultTableModel.addRow(new Object[]{
                integer,
                ctHoaDonServies.getSoLuongDoanhThu(integer, 0),
                ctHoaDonServies.getTongTienHang(integer, 0),
                ctHoaDonServies.getTongTienHang(integer, 0) - ctHoaDonServies.getSoTienPhaiTra(integer, 0),
                ctHoaDonServies.getSoTienPhaiTra(integer, 0)
            });
        }
    }

    private void addNamDoanhThu(List<Integer> list) {
        defaultComboBoxModel = (DefaultComboBoxModel) cbbNamDoanhThu.getModel();
        for (Integer integer : list) {
            defaultComboBoxModel.addElement(integer);
        }
    }

    private void setBieuDoDoanhThu(JPanel jpnItem) {
        List<CTHoaDonNT> list = ctHoaDonServies.getListByHoaDon(getYear(), 0);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (CTHoaDonNT item : list) {
                dataset.addValue(item.getDoanhThu(), "Sản phẩm", item.getNgayTao());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê doanh thu ".toUpperCase(), "Thời gian(tháng)", "Doanh thu (VND)", dataset, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

    private int sumHoaDon(List<HoaDon> list) {
        int count = 0;
        for (HoaDon bill : list) {
            count++;
        }
        return count;
    }

    private Date getNgayHienTai() {
        LocalDate localDate = LocalDate.now();
        return Date.valueOf(localDate);
    }

    private String getMonth() {
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        String monthString = String.format("%02d", month);
        return monthString;
    }

    private String getYear() {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        String yearString = String.valueOf(year);
        return yearString;
    }

    private String sum(List<Double> list) {
        for (Double sum : list) {
            if (sum == null) {
                return 0 + ".VND";
            } else {
                int intValue = (int) Math.round(sum);
                return intValue + ".VND";
            }
        }
        return 0 + ".VND";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButton62 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton70 = new javax.swing.JButton();
        panelThongKe = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSumDate = new javax.swing.JLabel();
        lblgetDate = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSumDonHang = new javax.swing.JLabel();
        lblSumHangPanelThongKe = new javax.swing.JLabel();
        lblSumHuyPanelThongKe = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblSumMonth = new javax.swing.JLabel();
        lblgetMonth = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblSumYear = new javax.swing.JLabel();
        lblGetYear = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jLabel89 = new javax.swing.JLabel();
        cbbNamDoanhThu = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnXuatFileExcelPanelThongKe = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel88 = new javax.swing.JLabel();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        btnTimKiemPanelThongKe = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jpnThongKe = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jPanel14.setBackground(new java.awt.Color(0, 102, 102));

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

        jButton11.setBackground(new java.awt.Color(51, 51, 51));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/channels4_profile.jpg"))); // NOI18N

        jButton69.setBackground(new java.awt.Color(0, 153, 153));
        jButton69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton69.setForeground(new java.awt.Color(255, 255, 255));
        jButton69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/file-invoice-dollar (1).png"))); // NOI18N
        jButton69.setText("Lịnh Sử Hóa Đơn");
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 255, 255));
        jLabel16.setText("QUẢN LÝ BÁN XE MÁY");

        jButton70.setBackground(new java.awt.Color(0, 153, 153));
        jButton70.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton70.setForeground(new java.awt.Color(255, 255, 255));
        jButton70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/file-invoice-dollar (1).png"))); // NOI18N
        jButton70.setText("Thống kê");
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });

        panelThongKe.setBackground(new java.awt.Color(0, 102, 102));

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tổng Doanh Thu Ngày");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ngay.png"))); // NOI18N

        lblSumDate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSumDate.setForeground(new java.awt.Color(255, 0, 0));
        lblSumDate.setText(" ");

        lblgetDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblgetDate.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblSumDate, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblgetDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblgetDate)))
                .addGap(18, 18, 18)
                .addComponent(lblSumDate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Tổng Đơn Hàng");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/giohang.png"))); // NOI18N

        lblSumDonHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSumDonHang.setForeground(new java.awt.Color(255, 0, 0));
        lblSumDonHang.setText(" ");

        lblSumHangPanelThongKe.setText(" ");

        lblSumHuyPanelThongKe.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSumHuyPanelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblSumDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(lblSumHangPanelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSumHangPanelThongKe))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSumDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSumHuyPanelThongKe)
                .addGap(15, 15, 15))
        );

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Tổng Doanh Thu Tháng");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thang.png"))); // NOI18N

        lblSumMonth.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSumMonth.setForeground(new java.awt.Color(255, 0, 0));
        lblSumMonth.setText(" ");

        lblgetMonth.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblgetMonth.setText(" ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblSumMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(lblgetMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel13))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblgetMonth))
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(lblSumMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(102, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Tổng Doanh Thu Năm");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nam.png"))); // NOI18N

        lblSumYear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSumYear.setForeground(new java.awt.Color(255, 0, 0));
        lblSumYear.setText(" ");

        lblGetYear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGetYear.setText(" ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 34, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblGetYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblSumYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGetYear))
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addComponent(lblSumYear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(246, 248, 250));

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tháng", "Tổng Số Sản Phẩm", "Tổng Giá Bán", "Tổng Giá Giảm", "Doanh Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoanhThuMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblDoanhThu);

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel89.setText("Năm");

        cbbNamDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbNamDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNamDoanhThuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbNamDoanhThuMouseEntered(evt);
            }
        });
        cbbNamDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNamDoanhThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel89)
                .addGap(18, 18, 18)
                .addComponent(cbbNamDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(cbbNamDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(394, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18))
        );

        jTabbedPane1.addTab("Doanh Thu", jPanel7);

        jPanel8.setBackground(new java.awt.Color(246, 248, 250));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "DT Bình Xăng", "DT Xi Lanh", "Số Khung", "Màu Sắc", "Xuất Xứ", "Loại Xe", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tblSanPham);

        btnXuatFileExcelPanelThongKe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatFileExcelPanelThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/excel.png"))); // NOI18N
        btnXuatFileExcelPanelThongKe.setText("Xuất File Excel");
        btnXuatFileExcelPanelThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileExcelPanelThongKeActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel87.setText("Ngày Bắt Đầu");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel88.setText("Ngày Kết Thúc");

        btnTimKiemPanelThongKe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiemPanelThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTimKiemPanelThongKe.setText("Tìm Kiếm");
        btnTimKiemPanelThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemPanelThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXuatFileExcelPanelThongKe)
                .addGap(60, 60, 60))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel87)
                .addGap(18, 18, 18)
                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel88)
                .addGap(18, 18, 18)
                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnTimKiemPanelThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel87)
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel88)
                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiemPanelThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuatFileExcelPanelThongKe)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel8);

        jPanel9.setBackground(new java.awt.Color(246, 248, 250));

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1258, Short.MAX_VALUE)
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Biểu đồ", jPanel9);

        javax.swing.GroupLayout panelThongKeLayout = new javax.swing.GroupLayout(panelThongKe);
        panelThongKe.setLayout(panelThongKeLayout);
        panelThongKeLayout.setHorizontalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelThongKeLayout.createSequentialGroup()
                        .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelThongKeLayout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelThongKeLayout.setVerticalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1699, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 672, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        // TODO add your handling code here:
        View_KhachHang kh = new View_KhachHang();
        kh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        View_HoaDon_Paid p = new View_HoaDon_Paid();
        p.setVisible(true);
    }//GEN-LAST:event_jButton69ActionPerformed

    private void cbbNamDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNamDoanhThuActionPerformed
        int year = (int) cbbNamDoanhThu.getSelectedItem();
        loadDataDoanhThu(ctHoaDonServies.getListDoanhThu(String.valueOf(year), 0));
        
        int selectedIndex = cbbNamDoanhThu.getSelectedIndex();
        Object selectedItem = cbbNamDoanhThu.getItemAt(selectedIndex);
        String selectedYear = selectedItem.toString();
        lblGetYear.setText(selectedYear);
        lblSumYear.setText(sum(ctHoaDonServies.sumYear(selectedYear, 0)));
    }//GEN-LAST:event_cbbNamDoanhThuActionPerformed

    private void btnXuatFileExcelPanelThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileExcelPanelThongKeActionPerformed
        try {
            String ngayBatDau = ((JTextField) txtNgayBatDau.getDateEditor().getUiComponent()).getText();
            String ngayKetThuc = ((JTextField) txtNgayKetThuc.getDateEditor().getUiComponent()).getText();
            exportExcel.excel(ctHoaDonServies.getListThongKe(ngayBatDau, ngayKetThuc, 0), "Thống kê ngày " + ngayBatDau + " " + ngayKetThuc);
            JOptionPane.showMessageDialog(this, "Xuất thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuatFileExcelPanelThongKeActionPerformed

    private void btnTimKiemPanelThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemPanelThongKeActionPerformed
        String ngayBatDau = ((JTextField) txtNgayBatDau.getDateEditor().getUiComponent()).getText();
        String ngayKetThuc = ((JTextField) txtNgayKetThuc.getDateEditor().getUiComponent()).getText();
        loadDataThongKe(ctHoaDonServies.getListThongKe(ngayBatDau, ngayKetThuc, 0));
    }//GEN-LAST:event_btnTimKiemPanelThongKeActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        View_ThongKe tk = new View_ThongKe();
        tk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton70ActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoanhThuMouseClicked
        int row = tblDoanhThu.getSelectedRow();
        lblgetMonth.setText(tblDoanhThu.getValueAt(row, 0).toString());
        lblSumMonth.setText(tblDoanhThu.getValueAt(row, 4).toString() + ".VND");
    }//GEN-LAST:event_tblDoanhThuMouseClicked

    private void cbbNamDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNamDoanhThuMouseClicked

    }//GEN-LAST:event_cbbNamDoanhThuMouseClicked

    private void cbbNamDoanhThuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNamDoanhThuMouseEntered

    }//GEN-LAST:event_cbbNamDoanhThuMouseEntered

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
            java.util.logging.Logger.getLogger(View_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiemPanelThongKe;
    private javax.swing.JButton btnXuatFileExcelPanelThongKe;
    private javax.swing.JComboBox<String> cbbNamDoanhThu;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton70;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JLabel lblGetYear;
    private javax.swing.JLabel lblSumDate;
    private javax.swing.JLabel lblSumDonHang;
    private javax.swing.JLabel lblSumHangPanelThongKe;
    private javax.swing.JLabel lblSumHuyPanelThongKe;
    private javax.swing.JLabel lblSumMonth;
    private javax.swing.JLabel lblSumYear;
    private javax.swing.JLabel lblgetDate;
    private javax.swing.JLabel lblgetMonth;
    private javax.swing.JPanel panelThongKe;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblSanPham;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    // End of variables declaration//GEN-END:variables
}
