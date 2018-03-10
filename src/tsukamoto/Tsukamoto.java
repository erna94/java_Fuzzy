package tsukamoto;

import java.util.Scanner;
import java.lang.*;


public class Tsukamoto {
    
    static double suhu =0;
    static double kelembapan = 0;
    static double lama_penyinaran=0;
    static double hasil_akhir;
   String hasil_akhir2=""; 
    public Tsukamoto(double input_suhu,double input_kelembaban, double input_lmapenyinaran){
       suhu = input_suhu;
        kelembapan = input_kelembaban;
        lama_penyinaran =input_lmapenyinaran;  
    }
   double AxZ1, AxZ2, AxZ3, AxZ4, AxZ5, AxZ6, AxZ7, AxZ8, 
           AxZ9, AxZ10, AxZ11, AxZ12, AxZ13, AxZ14, AxZ15, 
           AxZ16, AxZ17, AxZ18, AxZ19, AxZ20, AxZ21, AxZ22, AxZ23, AxZ24;
    double input_suhu, input_kelembaban, input_lmapenyinaran;
    double µsuhu_rendah , µsuhu_sedang , µsuhu_tinggi;
    double µkelembaban_rendah , µkelembaban_sedang , µkelembaban_tinggi;
    double µlmapenyinaran_rendah , µlmapenyinaran_sedang , µlmapenyinaran_tinggi;
    double µcurahhujan_rendah, µcurahhujan_sedang, µcurahhujan_tinggi;
    double a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24;
    double z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24;  
    
    public String proses(){
    // INISIALISAI VARIBEL SUHU
    
    double suhu_rendah_bawah = 25.7, suhu_rendah_atas = 28;
    double suhu_sedang_bawah = 27.5, suhu_sedang_tengah = 28.7 , suhu_sedang_atas = 29.9;
    double suhu_tinggi_bawah = 29.5, suhu_tinggi_atas = 31;
    
    // INISIALISAI VARIBEL KELEMBABAN
    double kelembaban_rendah_bawah = 59, kelembaban_rendah_atas = 70;
    double kelembaban_sedang_bawah = 68, kelembaban_sedang_tengah = 74, kelembaban_sedang_atas = 80;
    double kelembaban_tinggi_bawah = 78, kelembaban_tinggi_atas = 92;
    
    // INISIALISAI VARIBEL LAMA PENYINARAN
    double lmapenyinaran_rendah_bawah = 0, lmapenyinaran_rendah_atas = 40;
    double lmapenyinaran_sedang_bawah = 35, lmapenyinaran_sedang_tengah = 57.5 , lmapenyinaran_sedang_atas = 80;
    double lmapenyinaran_tinggi_bawah = 75, lmapenyinaran_tinggi_atas = 100;
    
    // INISIALISASI VARIABEL CURAH HUJAN
    double curahhujan_rendah_bawah = 0, curahhujan_rendah_atas = 9;
    double curahhujan_sedang_bawah = 5, curahhujan_sedang_tengah = 12, curahhujan_sedang_atas = 19;
    double curahhujan_tinggi_bawah = 15, curahhujan_tinggi_atas = 50;
     
   
        //fuzzyfikasi
        // fungsi keanggotaan suhu rendah
        if (suhu < suhu_rendah_bawah )
        µsuhu_rendah = 1;
        else if (suhu_rendah_bawah <= suhu && suhu <= suhu_rendah_atas)
        µsuhu_rendah = (suhu_rendah_atas - suhu) / (suhu_rendah_atas - suhu_rendah_bawah);
        else
        µsuhu_rendah = 0;        
        
        // fungsi keanggotaan suhu sedang
        if(suhu_sedang_bawah <= suhu && suhu <= suhu_sedang_tengah)
        µsuhu_sedang = (suhu - suhu_sedang_bawah) / (suhu_sedang_tengah - suhu_sedang_bawah);    
        else if (suhu_sedang_tengah <= suhu && suhu <= suhu_sedang_atas)
        µsuhu_sedang = (suhu_sedang_atas - suhu) / (suhu_sedang_atas - suhu_sedang_tengah);    
        else 
        µsuhu_sedang = 0;
        
        //fungsi keanggotaan suhu tinggi
        if (suhu < suhu_tinggi_bawah )
        µsuhu_tinggi = 0;
        else if (suhu_tinggi_bawah <= suhu && suhu <= suhu_tinggi_atas)
        µsuhu_tinggi = (suhu - suhu_tinggi_bawah) / (suhu_tinggi_atas - suhu_tinggi_bawah);
        else 
        µsuhu_tinggi = 1;    
       
        // fungsi keanggotaan kelembaban rendah
        if (kelembapan < kelembaban_rendah_bawah )
        µkelembaban_rendah = 1;
        else if (kelembaban_rendah_bawah <= kelembapan && kelembapan <= kelembaban_rendah_atas)
        µkelembaban_rendah = (kelembaban_rendah_atas - kelembapan) / (kelembaban_rendah_atas - kelembaban_rendah_bawah);
        else
        µkelembaban_rendah = 0;        
       
        // fungsi keanggotaan kelembaban sedang
        if(kelembaban_sedang_bawah <= kelembapan && kelembapan <= kelembaban_sedang_tengah)
        µkelembaban_sedang = (kelembapan - kelembaban_sedang_bawah) / (kelembaban_sedang_tengah - kelembaban_sedang_bawah);    
        else if (kelembaban_sedang_tengah <= kelembapan && kelembapan <= kelembaban_sedang_atas)
        µkelembaban_sedang = (kelembaban_sedang_atas - kelembapan) / (kelembaban_sedang_atas - kelembaban_sedang_tengah);    
        else 
        µkelembaban_sedang = 0;
        
        //fungsi keanggotaan kelembaban tinggi
        if (kelembapan < kelembaban_tinggi_bawah )
        µkelembaban_tinggi = 0;
        else if (kelembaban_tinggi_bawah <= kelembapan && kelembapan <= kelembaban_tinggi_atas)
        µkelembaban_tinggi = (kelembapan - kelembaban_tinggi_bawah) / (kelembaban_tinggi_atas - kelembaban_tinggi_bawah);
        else 
        µkelembaban_tinggi = 1;    
        
        // fungsi keanggotaan lama penyinaran rendah
        if (lama_penyinaran < lmapenyinaran_rendah_bawah )
        µlmapenyinaran_rendah = 1;
        else if (lmapenyinaran_rendah_bawah <= lama_penyinaran && lama_penyinaran <= lmapenyinaran_rendah_atas)
        µlmapenyinaran_rendah = (lmapenyinaran_rendah_atas - lama_penyinaran) / (lmapenyinaran_rendah_atas - lmapenyinaran_rendah_bawah);
        else
        µlmapenyinaran_rendah = 0;
        
        // fungsi keanggotaan lama penyinaran sedang
        if(lmapenyinaran_sedang_bawah <= lama_penyinaran && lama_penyinaran <= lmapenyinaran_sedang_tengah)
        µlmapenyinaran_sedang = (lama_penyinaran - lmapenyinaran_sedang_bawah) / (lmapenyinaran_sedang_tengah - lmapenyinaran_sedang_bawah);    
        else if (lmapenyinaran_sedang_tengah <= lama_penyinaran && lama_penyinaran <= lmapenyinaran_sedang_atas)
        µlmapenyinaran_sedang = (lmapenyinaran_sedang_atas - lama_penyinaran) / (lmapenyinaran_sedang_atas - lmapenyinaran_sedang_tengah);    
        else 
        µlmapenyinaran_sedang = 0;
        
        //fungsi keanggotaan lama penyinaran tinggi
        if (lama_penyinaran < lmapenyinaran_tinggi_bawah )
        µlmapenyinaran_tinggi = 0;
        else if (lmapenyinaran_tinggi_bawah <= lama_penyinaran && lama_penyinaran <= lmapenyinaran_tinggi_atas)
        µlmapenyinaran_tinggi = (lama_penyinaran - lmapenyinaran_tinggi_bawah) / (lmapenyinaran_tinggi_atas - lmapenyinaran_tinggi_bawah);
        else 
        µlmapenyinaran_tinggi = 1;
        System.out.println("");
        
        
        
        //MENGHITUNG INFERENSI (MENGHITUNG NILAI TIAP RULE)
        
        //RULE 1
        // IF	Suhu	Rendah	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Tinggi
        double a1b = Math.min(µsuhu_rendah,µkelembaban_rendah);
        a1= Math.min(a1b, µlmapenyinaran_rendah);
        z1 = curahhujan_tinggi_atas -(a1*(curahhujan_tinggi_atas - curahhujan_tinggi_bawah));
        AxZ1 = a1*z1;
        
        //RULE 2
        // IF	Suhu	Rendah	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Tinggi
        double a2b = Math.min(µsuhu_rendah,µkelembaban_rendah);
        a2= Math.min(a2b, µlmapenyinaran_sedang);
        z2 = curahhujan_tinggi_atas -(a2*(curahhujan_tinggi_atas - curahhujan_tinggi_bawah));
        AxZ2 = a2*z2;
        
        //RULE 3
        // IF	Suhu	Rendah	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Tinggi
        double a3b = Math.min(µsuhu_rendah,µkelembaban_rendah);
        a3= Math.min(a3b, µlmapenyinaran_tinggi);
        z3 = curahhujan_tinggi_atas -(a3*(curahhujan_tinggi_atas - curahhujan_tinggi_bawah));
        AxZ3 = a3*z3;
        
        //RULE 4
        // IF	Suhu	Rendah	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Tinggi
//        double a4b = Math.min(µsuhu_rendah,µkelembaban_rendah);
//        a4= Math.min(a4b, µlmapenyinaran_rendah);
//        z4 = curahhujan_tinggi_atas -(a4*(curahhujan_tinggi_atas - curahhujan_tinggi_bawah));
//        AxZ4 = a4*z4;
//        
        //RULE 4
        // IF	Suhu	Rendah	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Tinggi
        double a5b = Math.min(µsuhu_rendah,µkelembaban_sedang);
        a5= Math.min(a5b, µlmapenyinaran_sedang);
        z5 = curahhujan_tinggi_atas -(a5*(curahhujan_tinggi_atas - curahhujan_tinggi_bawah));
        AxZ5 = a5*z5;
        
        //RULE 5
        // IF	Suhu	Rendah	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Tinggi
        double a6b = Math.min(µsuhu_rendah,µkelembaban_sedang);
        a6= Math.min(a6b, µlmapenyinaran_tinggi);
        z6 = curahhujan_tinggi_atas -(a6*(curahhujan_tinggi_atas - curahhujan_tinggi_bawah));
        AxZ6 = a6*z6;
        
        //RULE 6
        // IF	Suhu	Rendah	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Tinggi
        double a7b = Math.min(µsuhu_rendah,µkelembaban_sedang);
        a7= Math.min(a7b, µlmapenyinaran_rendah);
        z7 = curahhujan_tinggi_atas -(a7*(curahhujan_tinggi_atas - curahhujan_tinggi_bawah));
        AxZ7 = a7*z7;
        
        //RULE 8
        // IF	Suhu	Rendah	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Tinggi
//        double a8b = Math.min(µsuhu_rendah,µkelembaban_sedang);
//        a8= Math.min(a8b, µlmapenyinaran_sedang);
//        z8 = curahhujan_tinggi_atas -(a8*(curahhujan_tinggi_atas - curahhujan_tinggi_bawah));
//        AxZ8 = a8*z8;
        
        //RULE 7
        // IF	Suhu	Sedang	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Rendah
        double a9b = Math.min(µsuhu_sedang,µkelembaban_tinggi);
        a9= Math.min(a9b, µlmapenyinaran_tinggi);
        z9 = curahhujan_rendah_atas -(a9*(curahhujan_rendah_atas - curahhujan_rendah_bawah));
        AxZ9 = a9*z9;
        
        //RULE 8
        // IF	Suhu	Sedang	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Rendah
        double a10b = Math.min(µsuhu_sedang,µkelembaban_tinggi);
        a10= Math.min(a10b, µlmapenyinaran_rendah);
        z10 = curahhujan_rendah_atas -(a10*(curahhujan_rendah_atas - curahhujan_rendah_bawah));
        AxZ10 = a10*z10;
        
        //RULE 9
        // IF	Suhu	Sedang	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Rendah
        double a11b = Math.min(µsuhu_sedang,µkelembaban_tinggi);
        a11= Math.min(a11b, µlmapenyinaran_sedang);
        z11 = curahhujan_rendah_atas -(a11*(curahhujan_rendah_atas - curahhujan_rendah_bawah));
        AxZ11 = a11*z11;
        
        //RULE 12
        // IF	Suhu	Sedang	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Rendah
//        double a12b = Math.min(µsuhu_sedang,µkelembaban_tinggi);
//        a12= Math.min(a12b, µlmapenyinaran_tinggi);
//        z12 = curahhujan_rendah_atas -(a12*(curahhujan_rendah_atas - curahhujan_rendah_bawah));
//        AxZ12 = a12*z12;
        
        //RULE 10
        // IF	Suhu	Sedang	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Rendah
        double a13b = Math.min(µsuhu_sedang,µkelembaban_rendah);
        a13= Math.min(a13b, µlmapenyinaran_rendah);
        z13 = curahhujan_rendah_atas -(a13*(curahhujan_rendah_atas - curahhujan_rendah_bawah));
        AxZ13 = a13*z13;
        
        //RULE 11
        // IF	Suhu	Sedang	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Rendah
        double a14b = Math.min(µsuhu_sedang,µkelembaban_rendah);
        a14= Math.min(a14b, µlmapenyinaran_sedang);
        z14 = curahhujan_rendah_atas -(a14*(curahhujan_rendah_atas - curahhujan_rendah_bawah));
        AxZ14 = a14*z14;
        
        //RULE 12
        // IF	Suhu	Sedang	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Rendah
        double a15b = Math.min(µsuhu_sedang,µkelembaban_rendah);
        a15= Math.min(a15b, µlmapenyinaran_tinggi);
        z15 = curahhujan_rendah_atas -(a15*(curahhujan_rendah_atas - curahhujan_rendah_bawah));
        AxZ15 = a15*z15;
        
        //RULE 16
        // IF	Suhu	Sedang	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Rendah
//        double a16b = Math.min(µsuhu_sedang,µkelembaban_rendah);
//        a16= Math.min(a16b, µlmapenyinaran_rendah);
//        z16 = curahhujan_rendah_atas -(a16*(curahhujan_rendah_atas - curahhujan_rendah_bawah));
//        AxZ16 = a16*z16;
        
        //RULE 13
        // IF	Suhu	Tinggi	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Sedang
        double a17b = Math.min(µsuhu_tinggi,µkelembaban_sedang);
        a17= Math.min(a17b, µlmapenyinaran_sedang);
        z17 = curahhujan_sedang_atas -(a17*(curahhujan_sedang_atas - curahhujan_sedang_bawah));
        AxZ17 = a17*z17;
        
        //RULE 14
        // IF	Suhu	Tinggi	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Sedang
        double a18b = Math.min(µsuhu_tinggi,µkelembaban_sedang);
        a18= Math.min(a18b, µlmapenyinaran_tinggi);
        z18 = curahhujan_sedang_atas -(a18*(curahhujan_sedang_atas - curahhujan_sedang_bawah));
        AxZ18 = a18*z18;
        
        //RULE 15
        // IF	Suhu	Tinggi	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Sedang
        double a19b = Math.min(µsuhu_tinggi,µkelembaban_sedang);
        a19= Math.min(a19b, µlmapenyinaran_rendah);
        z19 = curahhujan_sedang_atas -(a19*(curahhujan_sedang_atas - curahhujan_sedang_bawah));
        AxZ19 = a19*z19;
        
        //RULE 20
        // IF	Suhu	Tinggi	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Sedang
//        double a20b = Math.min(µsuhu_tinggi,µkelembaban_sedang);
//        a20= Math.min(a20b, µlmapenyinaran_sedang);
//        z20 = curahhujan_sedang_atas -(a20*(curahhujan_sedang_atas - curahhujan_sedang_bawah));
//        AxZ20 = a20*z20;
        
        //RULE 16
        // IF	Suhu	Tinggi	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Sedang
        double a21b = Math.min(µsuhu_tinggi,µkelembaban_tinggi);
        a21= Math.min(a21b, µlmapenyinaran_tinggi);
        z21 = curahhujan_sedang_atas -(a21*(curahhujan_sedang_atas - curahhujan_sedang_bawah));
        AxZ21 = a21*z21;
        
        //RULE 17
        // IF	Suhu	Tinggi	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Sedang
        double a22b = Math.min(µsuhu_tinggi,µkelembaban_tinggi);
        a22= Math.min(a22b, µlmapenyinaran_rendah);
        z22 = curahhujan_sedang_atas -(a22*(curahhujan_sedang_atas - curahhujan_sedang_bawah));
        AxZ22 = a22*z22;
        
        //RULE 18
        // IF	Suhu	Tinggi	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Sedang
        double a23b = Math.min(µsuhu_tinggi,µkelembaban_tinggi);
        a23= Math.min(a23b, µlmapenyinaran_sedang);
        z23 = curahhujan_sedang_atas -(a23*(curahhujan_sedang_atas - curahhujan_sedang_bawah));
        AxZ23 = a23*z23;
        
        //RULE 24
        // IF	Suhu	Tinggi	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Sedang
//        double a24b = Math.min(µsuhu_tinggi,µkelembaban_tinggi);
//        a24= Math.min(a24b, µlmapenyinaran_tinggi);
//        z24 = curahhujan_sedang_atas -(a24*(curahhujan_sedang_atas - curahhujan_sedang_bawah));
//        AxZ24 = a24*z24;
        // PERHITUNGAN DEFUZYYFIKASI
        
        double sum_AxZ = AxZ1 + AxZ2 + AxZ3  + AxZ5 + AxZ6 + AxZ7 
                       + AxZ9 + AxZ10 + AxZ11  + AxZ13 + AxZ14 + AxZ15  
                       + AxZ17 + AxZ18 + AxZ19  + AxZ21 + AxZ22 + AxZ23  ;
        double sum_A = a1 + a2 + a3  + a5 + a6 + a7  + a9 + a10 + a11 +
                  a13 + a14 + a15 +  a17 + a18 + a19 +  a21 + a22 + a23 ;
        hasil_akhir = sum_AxZ / sum_A;
       // fungsi keanggotaan curah hujan rendah
        if (hasil_akhir < curahhujan_rendah_bawah )
        µcurahhujan_rendah = 1;
        else if (curahhujan_rendah_bawah <= hasil_akhir && hasil_akhir <= curahhujan_rendah_atas)
        µcurahhujan_rendah = (curahhujan_rendah_atas - hasil_akhir) / (curahhujan_rendah_atas - curahhujan_rendah_bawah);
        else
        µcurahhujan_rendah = 0;        
       
        // fungsi keanggotaan curah hujan sedang
        if(curahhujan_sedang_bawah <= hasil_akhir && hasil_akhir <= curahhujan_sedang_tengah)
        µcurahhujan_sedang = (hasil_akhir - curahhujan_sedang_bawah) / (curahhujan_sedang_tengah - curahhujan_sedang_bawah);    
        else if (curahhujan_sedang_tengah <= hasil_akhir && hasil_akhir <= curahhujan_sedang_atas)
        µcurahhujan_sedang = (curahhujan_sedang_atas - hasil_akhir) / (curahhujan_sedang_atas - curahhujan_sedang_tengah);    
        else 
        µcurahhujan_sedang = 0;
        
        //fungsi keanggotaan curah hujan tinggi
        if (hasil_akhir < curahhujan_tinggi_bawah )
        µcurahhujan_tinggi = 0;
        else if (curahhujan_tinggi_bawah <= hasil_akhir && hasil_akhir <= curahhujan_tinggi_atas)
        µcurahhujan_tinggi = (hasil_akhir - curahhujan_tinggi_bawah) / (curahhujan_tinggi_atas - curahhujan_tinggi_bawah);
        else 
        µcurahhujan_tinggi = 1;
        
        // membandingkan masing2 fungsi keanggotaan untuk mencari hasil akhir
        if (µcurahhujan_rendah > µcurahhujan_sedang && µcurahhujan_rendah > µcurahhujan_tinggi)
              hasil_akhir2 = "Curah Hujan Rendah";
            //System.out.println("Curah Hujan Rendah");
        else if (µcurahhujan_sedang > µcurahhujan_rendah && µcurahhujan_sedang > µcurahhujan_tinggi)
           // System.out.println("Curah Hujan Sedang");
             hasil_akhir2 = "Curah Hujan sedang";
        else if (µcurahhujan_tinggi > µcurahhujan_rendah && µcurahhujan_tinggi > µcurahhujan_sedang)
            //System.out.println("Curah Hujan Tinggi");
            hasil_akhir2 = "Curah Hujan Tinggi";
        else
            //System.out.println("Curah Hujan Sangat Tinggi");
            hasil_akhir2 = "Curah Hujan Sangat Tinggi";
        return hasil_akhir2;
    }

     public void print(){
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("                                 SELAMAT DATANG DI SISTEM");
        System.out.println("                                   PREDIKSI CURAH HUJAN ");
        System.out.println("                                 Algoritma Fuzzy Tsukamoto");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("");
        
        System.out.println("===========================================================================================");
        System.out.println("= Parameter || Suhu Udara  || Kelembaban Udara || Lama Penyinaran Matahari || Curah Hujan =");
        System.out.println("===========================================================================================");
        System.out.println("= Rendah    || 25.7 - 28   ||     59 - 70      ||         0 - 40           ||    0 - 9    =");
        System.out.println("= Sedang    || 27.5 - 29.9 ||     68 - 80      ||         35 - 80          ||    5 - 19   =");
        System.out.println("= Tinggi    || 29.5 - 31   ||     78 - 92      ||         75 - 100         ||    15 - 50  =");
        System.out.println("==========================================================================================="); 
        System.out.println("Inputan Suhu : "+suhu);
        System.out.println("Inputan Kelembapan : "+kelembapan);
        System.out.println("Inputan Lama Penyinaran :"+lama_penyinaran);
        System.out.println("=============================================================================================================================");
        System.out.println("                                                              RULE                                        ");
        System.out.println("=============================================================================================================================");
        System.out.println(
"1	IF	Suhu	Rendah	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Tinggi\n" +
"2	IF	Suhu	Rendah	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Tinggi\n" +
"3	IF	Suhu	Rendah	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Tinggi\n" +
"4	IF	Suhu	Rendah	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Tinggi\n" +
"5	IF	Suhu	Rendah	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Tinggi\n" +
"6	IF	Suhu	Rendah	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Tinggi\n" +
"7	IF	Suhu	Sedang	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Rendah\n" +
"8	IF	Suhu	Sedang	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Rendah\n" +
"9	IF	Suhu	Sedang	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Rendah\n" +
"10	IF	Suhu	Sedang	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Rendah\n" +
"11	IF	Suhu	Sedang	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Rendah\n" +
"12	IF	Suhu	Sedang	AND	Kelembaban	Rendah	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Rendah\n" +
"13	IF	Suhu	Tinggi	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Sedang\n" +
"14	IF	Suhu	Tinggi	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Sedang\n" +
"15	IF	Suhu	Tinggi	AND	Kelembaban	Sedang	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Sedang\n" +
"16	IF	Suhu	Tinggi	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Tinggi	THEN	Curah Hujan	Sedang\n" +
"17	IF	Suhu	Tinggi	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Rendah	THEN	Curah Hujan	Sedang\n" +
"18	IF	Suhu	Tinggi	AND	Kelembaban	Tinggi	AND	Lama Penyinaran	Sedang	THEN	Curah Hujan	Sedang");
        System.out.println("=============================================================================================================================");
        System.out.println("");
        System.out.println("====================================================================");
        System.out.println("             FUNGSI KEANGGOTAAN TIAP VARIABEL");
        System.out.println("====================================================================");
        System.out.printf("Parameter\t || µSuhu\t || µKelembaban\t || µLama Penyinaran\n");
        System.out.println("====================================================================");
        System.out.printf("Rendah\t\t || " +"%.2f",µsuhu_rendah);
        System.out.printf("\t || " +"%.2f",µkelembaban_rendah);
        System.out.printf("\t || " +"%.2f",µlmapenyinaran_rendah);
        System.out.printf("\n");
        System.out.printf("Sedang\t\t || " +"%.2f",µsuhu_sedang);
        System.out.printf("\t || " +"%.2f",µkelembaban_sedang);
        System.out.printf("\t || " +"%.2f",µlmapenyinaran_sedang);
        System.out.printf("\n");
        System.out.printf("Tinggi\t\t || " +"%.2f",µsuhu_tinggi);
        System.out.printf("\t || " +"%.2f",µkelembaban_tinggi);
        System.out.printf("\t || " +"%.2f",µlmapenyinaran_tinggi);
        System.out.printf("\n");
        System.out.println("====================================================================");
        System.out.println("");
        
        System.out.println("=====================================================");
        System.out.println("                  Nilai Tiap Rule");
        System.out.println("=====================================================");
        System.out.println("Rule\t\tA\t\tZ\t\tAxZ");
        System.out.println("=====================================================");
        System.out.println("R1\t\t"+String.format("%.1f",a1)+"\t\t"+String.format("%.1f",z1)+"\t\t"+String.format("%.1f",AxZ1));
        System.out.println("R2\t\t"+String.format("%.1f",a2)+"\t\t"+String.format("%.1f",z2)+"\t\t"+String.format("%.1f",AxZ2));
        System.out.println("R3\t\t"+String.format("%.1f",a3)+"\t\t"+String.format("%.1f",z3)+"\t\t"+String.format("%.1f",AxZ3));
        //System.out.println("R4\t\t"+String.format("%.1f",a4)+"\t\t"+String.format("%.1f",z4)+"\t\t"+String.format("%.1f",AxZ4));
        System.out.println("R4\t\t"+String.format("%.1f",a5)+"\t\t"+String.format("%.1f",z5)+"\t\t"+String.format("%.1f",AxZ5));
        System.out.println("R5\t\t"+String.format("%.1f",a6)+"\t\t"+String.format("%.1f",z6)+"\t\t"+String.format("%.1f",AxZ6));
        System.out.println("R6\t\t"+String.format("%.1f",a7)+"\t\t"+String.format("%.1f",z7)+"\t\t"+String.format("%.1f",AxZ7));
        //System.out.println("R8\t\t"+String.format("%.1f",a8)+"\t\t"+String.format("%.1f",z8)+"\t\t"+String.format("%.1f",AxZ8));
        System.out.println("R7\t\t"+String.format("%.1f",a9)+"\t\t"+String.format("%.1f",z9)+"\t\t"+String.format("%.1f",AxZ9));
        System.out.println("R8\t\t"+String.format("%.1f",a10)+"\t\t"+String.format("%.1f",z10)+"\t\t"+String.format("%.1f",AxZ10));
        System.out.println("R9\t\t"+String.format("%.1f",a11)+"\t\t"+String.format("%.1f",z11)+"\t\t"+String.format("%.1f",AxZ11));
        //System.out.println("R12\t\t"+String.format("%.1f",a12)+"\t\t"+String.format("%.1f",z12)+"\t\t"+String.format("%.1f",AxZ12));
        System.out.println("R10\t\t"+String.format("%.1f",a13)+"\t\t"+String.format("%.1f",z13)+"\t\t"+String.format("%.1f",AxZ13));
        System.out.println("R11\t\t"+String.format("%.1f",a14)+"\t\t"+String.format("%.1f",z14)+"\t\t"+String.format("%.1f",AxZ14));
        System.out.println("R12\t\t"+String.format("%.1f",a15)+"\t\t"+String.format("%.1f",z15)+"\t\t"+String.format("%.1f",AxZ15));
        //System.out.println("R16\t\t"+String.format("%.1f",a16)+"\t\t"+String.format("%.1f",z16)+"\t\t"+String.format("%.1f",AxZ16));
        System.out.println("R13\t\t"+String.format("%.1f",a17)+"\t\t"+String.format("%.1f",z17)+"\t\t"+String.format("%.1f",AxZ17));
        System.out.println("R14\t\t"+String.format("%.1f",a18)+"\t\t"+String.format("%.1f",z18)+"\t\t"+String.format("%.1f",AxZ18));
        System.out.println("R15\t\t"+String.format("%.1f",a19)+"\t\t"+String.format("%.1f",z19)+"\t\t"+String.format("%.1f",AxZ19));
        //System.out.println("R20\t\t"+String.format("%.1f",a20)+"\t\t"+String.format("%.1f",z20)+"\t\t"+String.format("%.1f",AxZ20));
        System.out.println("R16\t\t"+String.format("%.1f",a21)+"\t\t"+String.format("%.1f",z21)+"\t\t"+String.format("%.1f",AxZ21));
        System.out.println("R17\t\t"+String.format("%.1f",a22)+"\t\t"+String.format("%.1f",z22)+"\t\t"+String.format("%.1f",AxZ22));
        System.out.println("R18\t\t"+String.format("%.1f",a23)+"\t\t"+String.format("%.1f",z23)+"\t\t"+String.format("%.1f",AxZ23));
        //System.out.println("R24\t\t"+String.format("%.1f",a24)+"\t\t"+String.format("%.1f",z24)+"\t\t"+String.format("%.1f",AxZ24));
        System.out.println("");
        System.out.println("Hasil Prediksi Hujan : "+hasil_akhir2);
        System.out.printf("Dengan Intensitas Curah Hujan Sebesar : "+ "%.2f",hasil_akhir);
        System.out.println("");
        System.out.println("=======================================");
        System.out.println("µCurah Hujan Rendah : " + String.format("%.2f",µcurahhujan_rendah));
        System.out.println("µCurah Hujan Sedang : " + String.format("%.2f",µcurahhujan_sedang));
        System.out.println("µCurah Hujan Tinggi : " + String.format("%.2f",µcurahhujan_tinggi));
        System.out.println("=======================================");
   }
}