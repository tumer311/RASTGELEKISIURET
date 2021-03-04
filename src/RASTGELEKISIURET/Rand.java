/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

import java.util.Random;

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
public class Rand {
    
    private static Random rnd;
    
    public static int RastgeleSayi(int deger)
    {
       
     
       if(rnd==null)                //random nesnesi bir kere olusuyor.
       {
           rnd=new Random();        //sinif olusturulmadan cagrilmasi icin static yapildi.
       }
        
        return rnd.nextInt(deger);
        
        
    }
    
    
    
}
