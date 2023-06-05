package com.kraft.tests.day_14;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDemo {

    public String readFromExcel(String sheetName,int row, int column) throws IOException {
        String path="src/test/resources/LoginList.xlsx";

        File file=new File(path);
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet= wb.getSheet(sheetName);

        String s = sheet.getRow(row).getCell(column).toString();
        return s;
    }

    @Test
    public void test1() throws IOException {
        System.out.println(readFromExcel("QaTeam1", 2, 1));
    }
}
