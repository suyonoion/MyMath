package com.suyonoion.mymath.Menus;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.suyonoion.mymath.R;

/**
 * Created by Suyono on 2/2/2016.
 * Copyright (c) 2016 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class fragment_page1 extends Fragment {
    Animation shake;
    View tampilpage1;
    String var_a, var_b, var_c,
            var_d, var_e, var_f;
    double x,y, db_a, db_b, db_c, db_d, db_e, db_f;
    EditText editText_a, editText_b, editText_c, //persamaan (i)
             editText_d, editText_e, editText_f; //persamaan (ii)
    TextView txtHasil_x, txtHasil_y, txtHasil_xy;
    /* penyamaan persamaan (i) */
    TextView tvPenyamaanKiri1, tvPenyamaanKiri2, tvPenyamaanKiri3,
                tvPenyamaanKanan1, tvPenyamaanKanan2, tvPenyamaanKanan3_atas, tvPenyamaanKanan3_bawah;
    /* penyamaan persamaan (ii) */
    TextView tvPenyamaanKiri1_ii, tvPenyamaanKiri2_ii, tvPenyamaanKiri3_ii,
            tvPenyamaanKanan1_ii, tvPenyamaanKanan2_ii, tvPenyamaanKanan3_atas_ii, tvPenyamaanKanan3_bawah_ii;
    TextView tvMaka_kiri1_atas, tvMaka_kiri1_bawah, tvMaka_kanan1_atas,tvMaka_kanan1_bawah,
                tvMaka_kiri2, tvMaka_kanan2,
                tvMaka_kiri3, tvMaka_kanan3,
                tvMaka_kiri4, tvMaka_kanan4,
                tvMaka_kiri5, tvMaka_kanan5, tvMaka_kanan6_atas, tvMaka_kanan6_bawah,
                tvMaka_kanan7, tvKetemu;
    TextView tvmasuk_persamaan_i_baris1_atas, tvmasuk_persamaan_i_baris1_bawah,
            tvmasuk_persamaan_i_baris2_atas, tvmasuk_persamaan_i_baris2_bawah,
            tvmasuk_persamaan_i_baris3_atas, tvmasuk_persamaan_i_baris3_bawah,
            tvmasuk_persamaan_i_baris4;

    String kanan2, kanan2_ii;

    Button btnHasil, btnSubstitusi, btnEliminasi, btnDeterminan, btnGrafik, btnClear;
    LinearLayout penyelesaianSPLDV, metodePenyamaanSPLDV, persamaan_i, persamaan_ii, maka_x, maka_y;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceStace){
        tampilpage1 = inflater.inflate(R.layout.page1, container, false);
        shake = AnimationUtils.loadAnimation(getContext(),R.anim.shake);
        /** Persamaan (i) **/
        editText_a = (EditText) tampilpage1.findViewById(R.id.EditTxt_a);
        editText_b = (EditText) tampilpage1.findViewById(R.id.EditTxt_b);
        editText_c = (EditText) tampilpage1.findViewById(R.id.EditTxt_c);
        /** Persamaan (ii) **/
        editText_d = (EditText) tampilpage1.findViewById(R.id.EditTxt_d);
        editText_e = (EditText) tampilpage1.findViewById(R.id.EditTxt_e);
        editText_f = (EditText) tampilpage1.findViewById(R.id.EditTxt_f);
        /** hasil */
        txtHasil_x = (TextView) tampilpage1.findViewById(R.id.hasilSPLDV_x);
        txtHasil_y = (TextView) tampilpage1.findViewById(R.id.hasilSPLDV_y);
        txtHasil_xy = (TextView) tampilpage1.findViewById(R.id.hasilSPLDV_xy);
        // persamaan (i) - spldv_penyamaan
        tvPenyamaanKiri1 = (TextView) tampilpage1.findViewById(R.id.penyamaan_kiri1);
        tvPenyamaanKiri2 = (TextView) tampilpage1.findViewById(R.id.penyamaan_kiri2);
        tvPenyamaanKiri3 = (TextView) tampilpage1.findViewById(R.id.penyamaan_kiri3);
        tvPenyamaanKanan1 = (TextView) tampilpage1.findViewById(R.id.penyamaan_kanan1);
        tvPenyamaanKanan2 = (TextView) tampilpage1.findViewById(R.id.penyamaan_kanan2);
        tvPenyamaanKanan3_atas = (TextView) tampilpage1.findViewById(R.id.penyamaan_kanan3_atas);
        tvPenyamaanKanan3_bawah = (TextView) tampilpage1.findViewById(R.id.penyamaan_kanan3_bawah);
        // persamaan (ii) - spldv_penyamaan
        tvPenyamaanKiri1_ii = (TextView) tampilpage1.findViewById(R.id.penyamaan_kiri1_ii);
        tvPenyamaanKiri2_ii = (TextView) tampilpage1.findViewById(R.id.penyamaan_kiri2_ii);
        tvPenyamaanKiri3_ii = (TextView) tampilpage1.findViewById(R.id.penyamaan_kiri3_ii);
        tvPenyamaanKanan1_ii = (TextView) tampilpage1.findViewById(R.id.penyamaan_kanan1_ii);
        tvPenyamaanKanan2_ii = (TextView) tampilpage1.findViewById(R.id.penyamaan_kanan2_ii);
        tvPenyamaanKanan3_atas_ii = (TextView) tampilpage1.findViewById(R.id.penyamaan_kanan3_ii_atas);
        tvPenyamaanKanan3_bawah_ii = (TextView) tampilpage1.findViewById(R.id.penyamaan_kanan3_ii_bawah);
        // maka
        tvMaka_kiri1_atas= (TextView) tampilpage1.findViewById(R.id.maka_kiri1_atas);
        tvMaka_kiri1_bawah= (TextView) tampilpage1.findViewById(R.id.maka_kiri1_bawah);
        tvMaka_kanan1_atas= (TextView) tampilpage1.findViewById(R.id.maka_kanan1_atas);
        tvMaka_kanan1_bawah= (TextView) tampilpage1.findViewById(R.id.maka_kanan1_bawah);
        tvMaka_kiri2= (TextView) tampilpage1.findViewById(R.id.maka_kiri2);
        tvMaka_kanan2= (TextView) tampilpage1.findViewById(R.id.maka_kanan2);
        tvMaka_kiri3= (TextView) tampilpage1.findViewById(R.id.maka_kiri3);
        tvMaka_kanan3= (TextView) tampilpage1.findViewById(R.id.maka_kanan3);
        tvMaka_kiri4= (TextView) tampilpage1.findViewById(R.id.maka_kiri4);
        tvMaka_kanan4= (TextView) tampilpage1.findViewById(R.id.maka_kanan4);
        tvMaka_kiri5= (TextView) tampilpage1.findViewById(R.id.maka_kiri5);
        tvMaka_kanan5= (TextView) tampilpage1.findViewById(R.id.maka_kanan5);
        tvMaka_kanan6_atas = (TextView) tampilpage1.findViewById(R.id.maka_kanan6_atas);
        tvMaka_kanan6_bawah= (TextView) tampilpage1.findViewById(R.id.maka_kanan6_bawah);
        tvMaka_kanan7= (TextView) tampilpage1.findViewById(R.id.maka_kanan7);
        tvKetemu = (TextView) tampilpage1.findViewById(R.id.ketemu);
        // proses maka masukkan
        tvmasuk_persamaan_i_baris1_atas = (TextView) tampilpage1.findViewById(R.id.masuk_persamaan_i_baris1_atas);
        tvmasuk_persamaan_i_baris1_bawah = (TextView) tampilpage1.findViewById(R.id.masuk_persamaan_i_baris1_bawah);
        tvmasuk_persamaan_i_baris2_atas = (TextView) tampilpage1.findViewById(R.id.masuk_persamaan_i_baris2_atas);
        tvmasuk_persamaan_i_baris2_bawah = (TextView) tampilpage1.findViewById(R.id.masuk_persamaan_i_baris2_bawah);
        tvmasuk_persamaan_i_baris3_atas = (TextView) tampilpage1.findViewById(R.id.masuk_persamaan_i_baris3_atas);
        tvmasuk_persamaan_i_baris3_bawah = (TextView) tampilpage1.findViewById(R.id.masuk_persamaan_i_baris3_bawah);
        tvmasuk_persamaan_i_baris4 = (TextView) tampilpage1.findViewById(R.id.masuk_persamaan_i_baris4);
        // spldv.xml
        penyelesaianSPLDV = (LinearLayout) tampilpage1.findViewById(R.id.penyelesaianSPLDV);
        metodePenyamaanSPLDV = (LinearLayout) tampilpage1.findViewById(R.id.metode_penyamaan);
        persamaan_i = (LinearLayout) tampilpage1.findViewById(R.id.persamaan_i);
        persamaan_ii = (LinearLayout) tampilpage1.findViewById(R.id.persamaan_ii);
        maka_x = (LinearLayout) tampilpage1.findViewById(R.id.maka_x);
        maka_y = (LinearLayout) tampilpage1.findViewById(R.id.maka_y);

        btnHasil = (Button) tampilpage1.findViewById(R.id.btnHasil);
        btnSubstitusi = (Button) tampilpage1.findViewById(R.id.btnSubstitusi);
        btnEliminasi = (Button) tampilpage1.findViewById(R.id.btnEliminasi);
        btnDeterminan = (Button) tampilpage1.findViewById(R.id.btnDeterminan);
        btnGrafik = (Button) tampilpage1.findViewById(R.id.btnGrafik);
        /** Button Proses */
        prosesButton();
        return tampilpage1;
    }

    private void prosesButton() {
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHasil.startAnimation(shake);
                btnGrafik.setVisibility(View.GONE);
                btnEliminasi.setVisibility(View.GONE);
                btnDeterminan.setVisibility(View.GONE);
                btnSubstitusi.setVisibility(View.GONE);
                hasil();
            }
        });
        btnSubstitusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubstitusi.startAnimation(shake);
                btnGrafik.setVisibility(View.GONE);
                btnEliminasi.setVisibility(View.GONE);
                btnDeterminan.setVisibility(View.GONE);
                btnHasil.setVisibility(View.GONE);
                Toast.makeText(getContext(),"Metode Substitusi \n Masih Kosong Belum Dibuat, Thanks for Review :)",Toast.LENGTH_SHORT).show();
            }
        });
        btnEliminasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEliminasi.startAnimation(shake);
                btnGrafik.setVisibility(View.GONE);
                btnHasil.setVisibility(View.GONE);
                btnDeterminan.setVisibility(View.GONE);
                btnSubstitusi.setVisibility(View.GONE);
                Toast.makeText(getContext(),"Metode Eliminasi \n Masih Kosong Belum Dibuat, Thanks for Review :)",Toast.LENGTH_SHORT).show();
            }
        });
        btnGrafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGrafik.startAnimation(shake);
                btnHasil.setVisibility(View.GONE);
                btnEliminasi.setVisibility(View.GONE);
                btnDeterminan.setVisibility(View.GONE);
                btnSubstitusi.setVisibility(View.GONE);
                Toast.makeText(getContext(),"Metode Grafik \n Masih Kosong Belum Dibuat, Thanks for Review :)",Toast.LENGTH_SHORT).show();
            }
        });
        btnDeterminan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDeterminan.startAnimation(shake);
                btnGrafik.setVisibility(View.GONE);
                btnEliminasi.setVisibility(View.GONE);
                btnHasil.setVisibility(View.GONE);
                btnSubstitusi.setVisibility(View.GONE);
                Toast.makeText(getContext(),"Metode Determinan \n Masih Kosong Belum Dibuat, Thanks for Review :)",Toast.LENGTH_SHORT).show();
            }
        });
        btnClear = (Button) tampilpage1.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClear.startAnimation(shake);
                editText_a.setText("");editText_b.setText("");editText_c.setText("");
                editText_d.setText("");editText_e.setText("");editText_f.setText("");
                btnHasil.setVisibility(View.VISIBLE);
                btnGrafik.setVisibility(View.VISIBLE);
                btnEliminasi.setVisibility(View.VISIBLE);
                btnDeterminan.setVisibility(View.VISIBLE);
                btnSubstitusi.setVisibility(View.VISIBLE);
                penyelesaianSPLDV.setVisibility(View.GONE);
                metodePenyamaanSPLDV.setVisibility(View.GONE);
            }
        });
        penyelesaianSPLDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                penyelesaianSPLDV.startAnimation(shake);
            }
        });
        persamaan_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persamaan_i.startAnimation(shake);
            }
        });
        persamaan_ii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persamaan_ii.startAnimation(shake);
            }
        });
        maka_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maka_y.startAnimation(shake);
            }
        });
        maka_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maka_x.startAnimation(shake);
            }
        });
        tvKetemu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetemu.startAnimation(shake);
            }
        });
    }


    private void prosesMakaMasukkan() {
        String baris1atas = fmt(db_c)+"+"+(fmt(db_b*-1))+"("+fmt(y)+")";
        String baris2atas = fmt(db_c)+"+"+(fmt((db_b*-1)*y));
        String atas = fmt(db_c+((db_b*-1)*y));
        baris1atas = baris1atas.replace("+-","-"); baris2atas = baris2atas.replace("+-","-");
        baris1atas = baris1atas.replace("--","+"); baris2atas = baris2atas.replace("--","+");
        tvmasuk_persamaan_i_baris1_atas.setText(baris1atas);
        tvmasuk_persamaan_i_baris1_bawah.setText(fmt(db_a));
        tvmasuk_persamaan_i_baris2_atas.setText(baris2atas);
        tvmasuk_persamaan_i_baris2_bawah.setText(fmt(db_a));
        tvmasuk_persamaan_i_baris3_atas.setText(atas);
        tvmasuk_persamaan_i_baris3_bawah.setText(fmt(db_a));
        tvmasuk_persamaan_i_baris4.setText(fmt(x));

    }

    private void prosesMaka() {
        // baris1
        tvMaka_kiri1_atas.setText(kanan2); tvMaka_kanan1_atas.setText(kanan2_ii);
        tvMaka_kiri1_bawah.setText(fmt(db_a)); tvMaka_kanan1_bawah.setText(fmt(db_d));
        // baris2
        tvMaka_kiri2.setText(fmt(db_d)+"("+kanan2+")"); tvMaka_kanan2.setText(fmt(db_a)+"("+kanan2_ii+")");
        // baris3
        String makakiri3 = fmt(db_d*db_c)+"+"+(fmt(db_d*(db_b*-1)))+"y";
        String makakanan3 = fmt(db_a*db_f)+"+"+(fmt(db_a*(db_e*-1)))+"y";
        makakiri3 = makakiri3.replace("+-","-"); makakanan3 = makakanan3.replace("+-","-");
        makakiri3 = makakiri3.replace("--","+"); makakanan3 = makakanan3.replace("--","+");
        tvMaka_kiri3.setText(makakiri3); tvMaka_kanan3.setText(makakanan3);
        // baris4
        String makakiri4 = fmt(db_d*(db_b*-1))+"y+"+fmt((db_a*(db_e*-1))*-1)+"y";
        String makakanan4 = fmt(db_a*db_f)+fmt((db_d*db_c*-1));
        makakiri4 = makakiri4.replace("+-","-"); makakanan4 = makakanan4.replace("+-","-");
        makakiri4 = makakiri4.replace("--","+"); makakanan4 = makakanan4.replace("--","+");
        tvMaka_kiri4.setText(makakiri4); tvMaka_kanan4.setText(makakanan4);
        // baris 5
        tvMaka_kiri5.setText(fmt((db_d*(db_b*-1))+((db_a*(db_e*-1))*-1))+"y"); tvMaka_kanan5.setText(fmt((db_a*db_f)+((db_d*db_c*-1))));
        // baris 6
        tvMaka_kanan6_atas.setText(fmt((db_a*db_f)+((db_d*db_c*-1)))); tvMaka_kanan6_bawah.setText(fmt((db_d*(db_b*-1))+((db_a*(db_e*-1))*-1)));
        /** FULL RUMUS baris 7**/
        tvMaka_kanan7.setText(fmt(((db_a * db_f) + ((db_d * db_c * -1))) / ((db_d*(db_b*-1))+((db_a*(db_e*-1))*-1))));
        tvKetemu.setText("y sudah ketemu yaitu y = "+fmt(y)+" \n masukkan y ke persamaan (i)");
    }

    private void prosesPenyamaan() {
        tvPenyamaanKiri1.setText(fmt(db_a)+"x+"+fmt(db_b)+"y"); tvPenyamaanKanan1.setText(""+fmt(db_c)+"");
        tvPenyamaanKiri2.setText(fmt(db_a)+"x");
        kanan2 = fmt(db_c)+"+"+(fmt(db_b*-1))+"y";
        kanan2 = kanan2.replace("+-","-");
        tvPenyamaanKanan2.setText(kanan2);
        tvPenyamaanKiri3.setText("x"); tvPenyamaanKanan3_atas.setText(kanan2); tvPenyamaanKanan3_bawah.setText(fmt(db_a));

    }

    private void prosesPenyamaan_ii() {
        tvPenyamaanKiri1_ii.setText(fmt(db_d)+"x+"+fmt(db_e)+"y"); tvPenyamaanKanan1_ii.setText(""+fmt(db_f)+"");
        tvPenyamaanKiri2_ii.setText(fmt(db_d)+"x");
        kanan2_ii = fmt(db_f)+"+"+(fmt(db_e*-1))+"y";
        kanan2_ii = kanan2_ii.replace("+-","-");
        tvPenyamaanKanan2_ii.setText(kanan2_ii);
        tvPenyamaanKiri3_ii.setText("x"); tvPenyamaanKanan3_atas_ii.setText(kanan2_ii); tvPenyamaanKanan3_bawah_ii.setText(fmt(db_d));

    }

    protected void hasil(){
        var_a = editText_a.getText().toString();
        if(var_a.isEmpty()){
            db_a=1;
        } else {
            db_a = Double.parseDouble(var_a);
        }

        var_b = editText_b.getText().toString();
        if(var_b.isEmpty()){
            db_b=1;
        } else {
            db_b = Double.parseDouble(var_b);
        }

        var_c = editText_c.getText().toString();
        if(var_c.isEmpty()){
            db_c=0;
            txtHasil_xy.setText("Nilai tidak boleh kosong atau coba ketik = 0");
        } else {
            db_c = Double.parseDouble(var_c);
        }

        var_d = editText_d.getText().toString();
        if(var_d.isEmpty()){
            db_d=1;
        } else {
            db_d = Double.parseDouble(var_d);
        }

        var_e = editText_e.getText().toString();
        if(var_e.isEmpty()){
            db_e=1;
        } else {
            db_e = Double.parseDouble(var_e);
        }

        var_f = editText_f.getText().toString();
        if(var_f.isEmpty()){
            db_f=0;
            txtHasil_xy.setText("Nilai tidak boleh kosong atau coba ketik = 0");
        } else {
            db_f = Double.parseDouble(var_f);
        }

        try {
            x = ((db_c * db_e) - (db_f * db_b)) / ((db_a * db_e) - (db_d * db_b));
            y = (db_c - (db_a * x)) / db_b;
            if(Double.isNaN(x) || Double.isInfinite(x)){
                Toast.makeText(getContext(),"Gagal",Toast.LENGTH_SHORT).show();
                penyelesaianSPLDV.setVisibility(View.VISIBLE);
                kesalahan();
                metodePenyamaanSPLDV.setVisibility(View.GONE);
            } else {
                penyelesaianSPLDV.setVisibility(View.VISIBLE);
                metodePenyamaanSPLDV.setVisibility(View.VISIBLE);
                prosesPenyamaan();
                prosesPenyamaan_ii();
                prosesMaka();
                prosesMakaMasukkan();
                String strX = fmt(x);
                String strY = fmt(y);
                txtHasil_x.setText("x = "+strX);
                txtHasil_y.setText("y = "+strY);
                txtHasil_xy.setText("HP = { ( " + strX + " , " + strY + " ) }");
                Toast.makeText(getContext(),"Sukses",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            penyelesaianSPLDV.setVisibility(View.VISIBLE);
            kesalahan();
            metodePenyamaanSPLDV.setVisibility(View.GONE);
        }

    }

    public static String fmt(double d){
        if(d==(long) d)
            return String.format("%d", (long) d);
        else return String.format("%.2f", d);
    }

    private void kesalahan(){
        String peringatan = "Kesalahan...! \n Masukkan nilai dengan benar..!! \n atau anda belum mengedit nilai apapun \n" +
                "Keterangan : NaN / infinite.";
        penyelesaianSPLDV.setBackgroundColor(Color.RED);
        txtHasil_x.setText("Tampaknya");
        txtHasil_x.setTextColor(Color.WHITE);
        txtHasil_y.setText("ada sesuatu yang salah ?");
        txtHasil_y.setTextColor(Color.WHITE);
        txtHasil_xy.setText(peringatan);
        txtHasil_xy.setTextColor(Color.RED);
    }

}
