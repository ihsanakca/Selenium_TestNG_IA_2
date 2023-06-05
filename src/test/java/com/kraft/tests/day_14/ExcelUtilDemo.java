package com.kraft.tests.day_14;

import com.kraft.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void excelUtilPractice(){

        ExcelUtil qaTeam1 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam1");

        //satır sayısının alınması (row)
        System.out.println("qaTeam1.rowCount() = " + qaTeam1.rowCount());

        //sütun sayısının alınması
        System.out.println("qaTeam1.columnCount() = " + qaTeam1.columnCount());

        //sütun adlarının alınması
        System.out.println("qaTeam1.getColumnsNames() = " + qaTeam1.getColumnsNames());

        //bütün datanın alınması
        List<Map<String, String>> dataList = qaTeam1.getDataList();
        System.out.println("dataList = " + dataList);

        //satır satur yazdıralım...
        for (Map<String, String> row : dataList) {
            System.out.println("row = " + row);
        }

        //5.inci satırı getirelim...
        System.out.println("dataList.get(5) = " + dataList.get(5));

        //11.inci satırın bir hücresindeki veriyi key ile alma
        System.out.println("dataList.get(11).get(\"Your Name\") = " + dataList.get(11).get("Your Name"));

        //dataları iki boyutlu array içine alalım..

        String[][] dataArray = qaTeam1.getDataArray();

        for (String[] rows : dataArray) {
            for (String cells : rows) {
                System.out.print(cells+" ");
            }
            System.out.println();
        }

        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));


    }
}
