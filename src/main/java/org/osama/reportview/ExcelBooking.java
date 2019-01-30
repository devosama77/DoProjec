package org.osama.reportview;

import org.apache.poi.ss.usermodel.*;
import org.osama.model.Book;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelBooking extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        @SuppressWarnings("unchecked")
        List<Book> bookList= (List<Book>) model.get("books");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"booking.xlsx\"");


          Sheet sheet = workbook.createSheet("sheet1");
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy"));


          Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Date");
        header.createCell(1).setCellValue("Customer Name");
        header.createCell(2).setCellValue("Driver Name");
        header.createCell(3).setCellValue("Address");
        header.createCell(4).setCellValue("Booking");
        header.createCell(5).setCellValue("Trip Done");
        header.createCell(6).setCellValue("Trip Missing");
        header.createCell(7).setCellValue("Trip Cancel");
        header.createCell(8).setCellValue("Type of Liquid");
        header.createCell(9).setCellValue("Tanker Size");
        header.createCell(10).setCellValue("Tanker Number");
        header.createCell(11).setCellValue("Remark");
          int i=1;
          for (Book b:bookList){
              Row row=sheet.createRow(i++);

              Cell cell= row.createCell(0);
              cell.setCellValue(b.getDate());
              cell.setCellStyle(cellStyle);
//              System.out.println("Date is : "+b.getDate());
//              row.createCell(0).setCellValue(b.getDate());
              row.createCell(1).setCellValue(b.getCustomerName());
              row.createCell(2).setCellValue(b.getDriverName());
              row.createCell(3).setCellValue(b.getCustomerAddress());
              row.createCell(4).setCellValue(b.getBooking());
              row.createCell(5).setCellValue(b.getTripDone());
              row.createCell(6).setCellValue(b.getTripMissing());
              row.createCell(7).setCellValue(b.getTripCancel());
              row.createCell(8).setCellValue(b.getTypeWater());
              row.createCell(9).setCellValue(b.getSizeTanker());
              row.createCell(10).setCellValue(b.getNumberTanker());
              row.createCell(11).setCellValue(b.getRemark());
          }


    }
}
