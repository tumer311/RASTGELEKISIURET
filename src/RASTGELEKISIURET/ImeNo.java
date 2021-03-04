package RASTGELEKISIURET;

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
public class ImeNo {

    private int[] numaralar;
    private int gecerli;
    private int gecersiz;

    ImeNo() {
        numaralar = new int[15];
        gecerli = 0;
        gecersiz = 0;

    }

    private void RastgeleIme() {
      int toplam = 0;
        int i;
        for (i = 0; i < numaralar.length-1; i++) {
            numaralar[i] = Rand.RastgeleSayi(10);
             if (i % 2 == 1) {
                toplam += ((numaralar[i] * 2) % 10) + (numaralar[i] / 10);
            } else {
                toplam += numaralar[i];
            }
        }
        
        toplam%=10;
        numaralar[i]=((10-toplam)%10); //birdaha  10 a modunun alinmasinin nedeni 10 sayisi gelebildigi icindir.
    }

    public String ImeDondur() {
        
        RastgeleIme();

        String Ime = "";
        for (int i = 0; i < numaralar.length; i++) {
            Ime += numaralar[i];
        }

        return Ime;
    }

    public void Gecerli_gecersiz(int[] x) {
        numaralar = x;
        if (ImeKontrol()) {
            gecerli++;
        } else {
            gecersiz++;
        }

    }

    public void SetDeger(int x, int y) {
        gecerli = x;
        gecersiz = y;
    }

    public int GetGecerli() {
        return gecerli;
    }

    public int GetGecesiz() {
        return gecersiz;
    }

    private boolean ImeKontrol() {
        byte toplam = 0;
        byte i;
        for (i = 0; i < numaralar.length; i++) {
            if (i % 2 == 1) {
                toplam += ((numaralar[i] * 2) % 10) + (numaralar[i] / 10);
            } else {
                toplam += numaralar[i];
            }
        }

        return (toplam % 10) == 0;

    }

}
