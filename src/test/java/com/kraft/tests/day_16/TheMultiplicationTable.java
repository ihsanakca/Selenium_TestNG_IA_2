package com.kraft.tests.day_16;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class TheMultiplicationTable {
    public SXSSFWorkbook workbook;
    public SXSSFSheet sheet;
    public SXSSFRow row;
    public SXSSFCell cell;

    public void writeToExcel(String path,String sheetName) throws IOException {

        FileOutputStream outputExcelFile = new FileOutputStream(path);

        workbook = new SXSSFWorkbook();
        sheet = workbook.createSheet(sheetName);

        for (int i = 0; i <10; i++) {
            row = sheet.createRow(i);
            for (int j = 0; j <10 ; j++) {
                cell = row.createCell(j);
                String result=Integer.toString((i+1)*(j+1));
                cell.setCellValue((i+1)+"*"+(j+1)+"="+result);
            }
        }
        workbook.write(outputExcelFile);
        outputExcelFile.close();
    }

    @Test
    public void testWriteToExcel() throws IOException {
        writeToExcel("src/test/resources/deneme.xlsx","Sheet1");
    }
}
