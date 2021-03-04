/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Güray Meriç B151210120 guray.meric@ogr.sakarya.edu.tr
 *
 *
 * Ebubekir Tümer B161210117 ebubekir.tumer@ogr.sakarya.edu.tr
 *
 * Yazildigi Tarih:1.04.2018
 *
 *
 * Programlama Dillerinin Prensibleri 2.Odev
 *
 * Kütüphane Oluşturma
 *
 */
public class Kisi {

    private final KimlikNo tc;
    private final Telefon tel;
    private int yas;
    private final String[] isim;
    private int sayac;

    Kisi() throws IOException {
        tel = new Telefon();
        tc = new KimlikNo();
        yas = 0;
        sayac = 0;
        isim = new String[3000];
        İsimAta();
    }

    private void İsimAta() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader("random_isimler.txt");
        String line;

        try (BufferedReader br = new BufferedReader(fileReader)) {
            while ((line = br.readLine()) != null) {
                isim[sayac] = line;
                sayac++;
            }
        }
    }

    public void SetDeger(int x, int y) {
        tel.SetDeger(x, y);
        tc.SetDeger(x, y);    //gecerli ve gecersiz alt alanlarına sıfır degeri atıyoruz.
    }

    private String Rastgeleİsim() {

        return isim[Rand.RastgeleSayi(3000)];  //rastgele bir isim donduruyor.

    }

    private int YasDondur() {

        yas = Rand.RastgeleSayi(99) + 1;

        return yas;
    }

    public void gec_tc(int[] x) {
        tc.Gecerli_gecersiz(x);      //gelen byte dizisini kontrol ettirmek 
        //icin fonksiyona yolluyoruz.
    }

    public void gec_ime(int[] x) {
        tel.dizigonder(x);

    }

    public int Gecerli_im() {
        return tel.Gecerli();
    }

    public int Gecersiz_im() {
        return tel.Gecersiz();
    }

    public int Gecerli_tc() {
        return tc.GetGecerli();
    }

    public int Gecersiz_tc() {
        return tc.GetGecesiz();
    }

    public String KisiDondur() {

        return tc.TcDondur() + " " + Rastgeleİsim() + " " + YasDondur() + " " + tel.TelveImeDondur();

    }

}
