package com.kraft.tests.day_15;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF_DataProviderDemo {
    /**
     * Önce @DataProvider metodunu oluşturacağız...
     * Daha sonra bu metod ile @Test metodumuzu birbirine bağlayacağız. Böylece
     * datayı @DataProvider'dan alacağız..
     * Data transferini iki boyutlu array kullanarak yapacağız..
     */

    @DataProvider(name = "OgrenciSinavNotlari")
    public Object[][] testData(){
        String [][]data={
                {"Hasan","80","50"},
                {"Ahmet","90","80"},
                {"Sezai","55","60"},
                {"Ali","100","100"}
        };
        return data;
    }

    @Test(dataProvider = "OgrenciSinavNotlari")
    public void testDataProvider(String ad, String vizeNotu, String finalNotu){

        System.out.println("Ad: "+ad+" vize: "+vizeNotu+" final: "+finalNotu);

    }
}
