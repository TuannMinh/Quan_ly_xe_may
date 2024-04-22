package Utilities;

import Service.CTSanPhamService;
import ServiceImpl.CTSanPhamImpl;
import ViewModel.CTSanPhamHD;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExportExcel {

    private static CTSanPhamService ctSanPhamSevices = new CTSanPhamImpl();

    public void excel(List<CTSanPhamHD> list, String nameSheet) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet(nameSheet);// creating a blank sheet
            XSSFRow crow = null;
            Cell cell = null;
            int rownum = 1;
            int count = 0;
            crow = sheet.createRow(0);
            cell = crow.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = crow.createCell(1, CellType.STRING);
            cell.setCellValue("Mã Sản Phẩm");
            cell = crow.createCell(2, CellType.STRING);
            cell.setCellValue("Tên Sản Phẩm");
            cell = crow.createCell(3, CellType.STRING);
            cell.setCellValue("Dung Tích Bình Xăng");
            cell = crow.createCell(4, CellType.STRING);
            cell.setCellValue("Dung Tích Xi Lanh");
            cell = crow.createCell(5, CellType.STRING);
            cell.setCellValue("Số Khung");
            cell = crow.createCell(6, CellType.STRING);
            cell.setCellValue("Màu sắc");
            cell = crow.createCell(7, CellType.STRING);
            cell.setCellValue("Xuất Xứ");
            cell = crow.createCell(8, CellType.STRING);
            cell.setCellValue("Loại Xe");
            cell = crow.createCell(9, CellType.STRING);
            cell.setCellValue("Số Lượng");
            for (CTSanPhamHD ctSanPhamHD : list) {
                count++;
                Row row = sheet.createRow(rownum++);
                createList(ctSanPhamHD, row, count);
            }

            FileOutputStream out = new FileOutputStream(new File("ThongKeSanPham.xlsx")); // file name with path
            workbook.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createList(CTSanPhamHD ctSanPhamHD, Row row, int count) // creating cells for each row
    {

        Cell cell = row.createCell(0);
        cell.setCellValue(count);

        cell = row.createCell(1);
        cell.setCellValue(ctSanPhamHD.getMaSP());

        cell = row.createCell(2);
        cell.setCellValue(ctSanPhamSevices.getByNameSanPham(ctSanPhamHD.getMaSP()));

        cell = row.createCell(3);
        cell.setCellValue(ctSanPhamSevices.getByNameDTBinhXang(ctSanPhamHD.getMaSP()));

        cell = row.createCell(4);
        cell.setCellValue(ctSanPhamSevices.getByNameDTXiLanh(ctSanPhamHD.getMaSP()));

        cell = row.createCell(5);
        cell.setCellValue(ctSanPhamSevices.getByNameSoKhung(ctSanPhamHD.getMaSP()));

        cell = row.createCell(6);
        cell.setCellValue(ctSanPhamSevices.getByNameMau(ctSanPhamHD.getMaSP()));

        cell = row.createCell(7);
        cell.setCellValue(ctSanPhamSevices.getByNameXuatXu(ctSanPhamHD.getMaSP()));

        cell = row.createCell(8);
        cell.setCellValue(ctSanPhamSevices.getByNameLoaiXe(ctSanPhamHD.getMaSP()));

        cell = row.createCell(9);
        cell.setCellValue(ctSanPhamHD.getSoLuong());
    }
}
