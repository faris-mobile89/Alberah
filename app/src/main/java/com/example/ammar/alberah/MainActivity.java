package com.example.ammar.alberah;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


//    @BindView(R.id.flimage)
//    ImageView flimage;
//    @BindView(R.id.frimage)
//    ImageView frimage;
//    @BindView(R.id.slimage)
//    ImageView slimage;
//    @BindView(R.id.srimage)
//    ImageView srimage;
//    @BindView(R.id.thirdlineimage)
//    ImageView thirdlineimage;
//    @BindView(R.id.fourthrimage)
//    ImageView fourthrimage;
//    @BindView(R.id.fourthlimage)
//    ImageView fourthlimage;
//    @BindView(R.id.fifthrimage)
//    ImageView fifthrimage;
//    @BindView(R.id.fifthmimage)
//    ImageView fifthmimage;
//    @BindView(R.id.fifthlimage)
//    ImageView fifthlimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//don't forget to add this

    }
        @OnClick(R.id.frimage)
        void onfrImageClick () {
        }

        @OnClick(R.id.flimage)
        void onflimageClick () {
            Intent i = new Intent(MainActivity.this,CardActivity.class);
            startActivity(i);
        }

        @OnClick(R.id.srimage)
        void onsrimageClick () {
            Toast.makeText(getApplicationContext(), "اهلا وسهلا بكم في فعاليات الجمعية", Toast.LENGTH_LONG).show();
        }

        @OnClick(R.id.slimage)
        void onslimageclick () {
            Toast.makeText(getApplicationContext(), "اهلا وسهلا بكم في اخبار البلدة", Toast.LENGTH_LONG).show();
        }
        @OnClick(R.id.thirdlineimage)
        void onthirdlineimageclick () {
            Toast.makeText(getApplicationContext(), "اهلا وسهلا بكم في معرض الصور", Toast.LENGTH_SHORT).show();
        }
        @OnClick(R.id.fourthrimage)
        void onfourthrimageclick () {
            Toast.makeText(getApplicationContext(), "اهلا وسهلا بكم في المقالات", Toast.LENGTH_LONG).show();
        }
        @OnClick(R.id.fourthlimage)
        void onfourthimageclick () {
            Toast.makeText(getApplicationContext(), "اهلا وسهلا بكم في كفالة اليتيم", Toast.LENGTH_LONG).show();
        }
        @OnClick(R.id.fifthrimage)
        void onfifthrimageclick () {
            Toast.makeText(getApplicationContext(), "اهلا وسهلا بكم في التطوع  ", Toast.LENGTH_LONG).show();
        }
        @OnClick(R.id.fifthmimage)
        void onfifthmimageclick () {
            Toast.makeText(getApplicationContext(), "يسعدنا تواصلكم ", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:07 9816 6295"));
            Intent intent=Intent.createChooser(i,"make call with");
            startActivity(intent);

        }
        @OnClick(R.id.fifthlimage)
        void onfifthlimageclick () {
            Toast.makeText(getApplicationContext(), "من نحن ", Toast.LENGTH_LONG).show();
            Intent s = new Intent(MainActivity.this,scrollwhoWeAre.class);
            startActivity(s);
        }


    }
