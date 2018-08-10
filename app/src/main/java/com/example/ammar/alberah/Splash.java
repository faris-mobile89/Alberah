package com.example.ammar.alberah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.ammar.alberah.R;

import static com.example.ammar.alberah.R.drawable.logoberah;

public class Splash extends Activity {
    private ImageView splashImageView;
    boolean splashloading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashImageView = new ImageView(this);
        splashImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        splashImageView.setImageResource(logoberah);
        setContentView(splashImageView);
        splashloading = true;
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                splashloading = false;
                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();
            }

        }, 3000);

    }

}