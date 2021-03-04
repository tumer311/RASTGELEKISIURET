/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
public class RastgeleKisi {

    private final Kisi kisi; //kisi nesnesi
    private final File file;
    int[] b;

    public RastgeleKisi() throws IOException {
        kisi = new Kisi();
        file = new File("Kisiler.txt");
        if (!file.exists()) {
            file.createNewFile();           
        }

    }

    public void RastgeleKisiUret(int Kisisayisi) throws IOException {
          FileWriter fileWriter = new FileWriter(file, true);

        try (BufferedWriter bWriter = new BufferedWriter(fileWriter)) {
            for (int i = 0; i <Kisisayisi; i++) {
                bWriter.write(kisi.KisiDondur()); //dosyaya yazdiriyoruz.
                bWriter.newLine();
            }
            
            bWriter.close();
        }

    }

    public void KontrolEt() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader("Kisiler.txt");
        String line;

        try (BufferedReader br = new BufferedReader(fileReader)) {
            while ((line = br.readLine()) != null) {
                String[] b = line.split(" ");  //alinan line string dizisine ayri ayri bolunuyor.
                BytedizisineCevir(b[0]); //ilk indis bize tc yi veriyor
                kisi.gec_tc(this.b);     //son indis ime yi
                BytedizisineCevir(b[b.length - 1]);    //dosyayı okuyup tc ve imei numarasini alıyoruz
                kisi.gec_ime(this.b);                  //kontrol ettirmek icin gerekli fonksiyonlara yolluyoruz

            }
			br.close();
        }
        System.out.println("Gecerli Tc Sayisi " + kisi.Gecerli_tc());
        System.out.println("Gecersiz Tc Sayisi " + kisi.Gecersiz_tc());
        System.out.println("Gecerli Imei Sayisi " + kisi.Gecerli_im());
        System.out.println("Gecersiz Imei Sayisi " + kisi.Gecersiz_im());

        kisi.SetDeger(0, 0);

    }

    private void BytedizisineCevir(String z) {

        z = z.replace("(", "");
        z = z.replace(")", "");
        z = z.replace(" ", "");   //gelen string ifadesini bosluklardan ve parantezlerden arindiriyoruz.

        b = new int[z.length()];

        for (int i = 0; i < z.length(); i++) {

            b[i] = (byte) Character.getNumericValue(z.charAt(i));

        }

    }

}
