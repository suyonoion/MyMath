package com.suyonoion.mymath.Menus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.suyonoion.mymath.R;

/**
 * Created by Suyono on 2/2/2016.
 * Copyright (c) 2016 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class fragment_page5 extends Fragment {
    View tampilpage5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceStace){
        tampilpage5 = inflater.inflate(R.layout.page5, container, false);
        TextView dev = (TextView) tampilpage5.findViewById(R.id.dev);
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDev("https://fb.com/suyono.ion");
            }
        });
        return tampilpage5;
    }

    public void goToDev(String b) {
        Uri uriUrl = Uri.parse(b);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
