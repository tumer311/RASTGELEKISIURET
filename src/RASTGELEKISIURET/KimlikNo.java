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
public class KimlikNo {

    private int[] k_no; //tc ile islem yapmak icin
    private String Tc_no; //tc no degerini kolaylik acisindan dondurebilmek icin
    private int gecerli;
    private int gecersiz;  

    KimlikNo() {
        gecerli = 0;
        gecersiz = 0;
    }

    private void RastgeleTcUret() {

       int i;
        int toplam = 0;
        int basamak_10 = 0;
        k_no[0] =  (1 + Rand.RastgeleSayi(9));
        toplam+=k_no[0];
        basamak_10+=k_no[0]*7;
        for ( i = 1; i < k_no.length-2; i++) {
            k_no[i] =  Rand.RastgeleSayi(10);
               toplam += k_no[i];

            if (i % 2 == 1) {
                basamak_10 -= k_no[i];
            } else {
                basamak_10 += k_no[i] * 7;
            }

        }
        
          k_no[i]=(basamak_10 % 10); 
          k_no[i + 1]=((toplam + k_no[i]) % 10);  

    }
    public void SetDeger(int x,int y)
    {
        gecerli=x;
        gecersiz=y;    
    }

  

    public String TcDondur() {

        k_no = new int[11];

        
        RastgeleTcUret();
        

        Ata();
        return Tc_no;//string olarak donduruyoruz.

    }

    private void Ata() {
        Tc_no = "";
        if (Tc_gecerlimi()) {
            for (int i = 0; i < k_no.length; i++) {
                Tc_no += k_no[i];
            }
        }

    }

    public void Gecerli_gecersiz(int[] x) {
        k_no = x;
        if (Tc_gecerlimi()) {
            gecerli++;
        } else {
            gecersiz++;
        }

    }

    public int GetGecerli() {
        return gecerli;
    }

    public int GetGecesiz() {
        return gecersiz;
    }

    private boolean Tc_gecerlimi() {

        int i;
        int toplam = 0;
        int basamak_10 = 0;
        for (i = 0; i < k_no.length - 2; i++) {
            toplam += k_no[i];

            if (i % 2 == 1) {
                basamak_10 -= k_no[i];
            } else {
                basamak_10 += k_no[i] * 7;
            }
        }

        if (basamak_10 % 10 == k_no[i]) {
            return ((toplam + k_no[i]) % 10) == k_no[i + 1];
        }

        return false;
    }

}
