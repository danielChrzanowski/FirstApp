package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstET = findViewById(R.id.firstNum);
                EditText secondET = findViewById(R.id.secondNum);
                TextView resultTV = findViewById(R.id.result);
                showInterstitial();
                try {
                    int num1 = Integer.parseInt(firstET.getText().toString());
                    int num2 = Integer.parseInt(secondET.getText().toString());

                    int result = num1 + num2;
                    resultTV.setText((String.valueOf(result)));
                } catch (NumberFormatException e) {
                    startActivity(new Intent(MainActivity.this, PopClass.class));
                }

            }
        });

        //banner
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //interstitial
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed(){
                super.onAdClosed();
               // finish();
            }
        });

    }

    public void showInterstitial(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
          // finish();
        }
    }

    @Override
    public void onBackPressed(){
       showInterstitial();
    }
}
