package com.kraft.tests.day_16;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToExcel_2 {
    public SXSSFWorkbook workbook;
    public SXSSFSheet sheet;

    public SXSSFRow row;

    public SXSSFCell cell;

    @Test
    public void addValuesToExcel() throws IOException {

        String filePath = "src/test/resources/deneme.xlsx";
        String sheetName = "sheet_1";
        FileOutputStream outputExcelFile = new FileOutputStream(filePath);

        workbook = new SXSSFWorkbook();
        sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < 10; i++) {
            row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                cell = row.createCell(j);
                cell.setCellValue((i+1) * j);
            }
        }
        workbook.write(outputExcelFile);
        outputExcelFile.close();

    }
}
