/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

/**  
Güray Meriç
B151210120
guray.meric@ogr.sakarya.edu.tr


Ebubekir Tümer
B161210117
ebubekir.tumer@ogr.sakarya.edu.tr

Yazildigi Tarih:1.04.2018
 

Programlama Dillerinin Prensibleri 2.Odev

Kütüphane Oluşturma

*/ 
public class Telefon {

    private String tel_no;
    private ImeNo Im;
    private byte[] numara;

    Telefon() {

        Im = new ImeNo();
        numara = new byte[4];
        numara[0] = 0;
        numara[1] = 3;
        numara[2] = 4;   //turkiyeye uygun telefon numarasi uretilbilmek icin
        numara[3] = 5;
    }

    private void TelnoUret() {
        tel_no = "05";
        tel_no += numara[Rand.RastgeleSayi(4)];  

        for (int i = 0; i < 8; i++) {
            tel_no += Rand.RastgeleSayi(9);
        }

    }
    
    
    public void SetDeger(int x,int y)
    {
        Im.SetDeger(x, y);
    }

    public int Gecerli() {
        return Im.GetGecerli();
    }

    public int Gecersiz() {
        return Im.GetGecesiz();
    }

    public void dizigonder(int[] x) {

        Im.Gecerli_gecersiz(x);
    }

    public String TelveImeDondur() {
        TelnoUret();

        return tel_no + " (" + Im.ImeDondur() + ")";

    }

}
