package com.example.elodieapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    TextView titre;
    TextView detail;
    ConstraintLayout layout;
    Bundle b = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = getIntent().getExtras();
        String purl = b.getString("purl");
        final String ptitle = b.getString("ptitle");
        String pdetail = b.getString("pdetail");

        layout = this.findViewById(R.id.detail_layout);
        titre = this.findViewById(R.id.titre);
        detail = this.findViewById(R.id.detail);
        detail.setText(pdetail);
        detail.setTextColor(Color.WHITE);
        titre.setText(ptitle);
        titre.setTextColor(Color.WHITE);
        setBackgroundActivity(purl, MainActivity.this);



        /*
        final ArrayList<Integer> list = new ArrayList<>();
        list.add(R.mipmap.tortue);
        list.add(R.mipmap.renard);
        list.add(R.mipmap.baleine);
        list.add(R.mipmap.crocodile);
        list.add(R.mipmap.tigre);
        list.add(R.mipmap.husky);
        list.add(R.mipmap.loup);
        list.add(R.mipmap.koala);
        list.add(R.mipmap.renarddesneiges);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int imageAleatoire = getRandomElement(list,16);

                if(imageAleatoire == R.mipmap.renard) {

                    titre.setText("Renard");

                } else if (imageAleatoire == R.mipmap.baleine){

                    titre.setText("Baleine");

                }else if (imageAleatoire == R.mipmap.koala){

                    titre.setText("Koala");

                }else if (imageAleatoire == R.mipmap.loup){

                    titre.setText("Loup");

                }else if (imageAleatoire == R.mipmap.crocodile){

                    titre.setText("Crocodile");

                }else if (imageAleatoire == R.mipmap.tigre){

                    titre.setText("Tigre");

                }else if (imageAleatoire == R.mipmap.tortue){

                    titre.setText("Tortue");

                }else if (imageAleatoire == R.mipmap.husky){

                    titre.setText("Husky");

                }else {
                    titre.setText("Renard des neiges");
                }
                titre.setText(ptitle + "test");

                image.setImageResource(imageAleatoire);

            }
        });
    }
    // Function select an element base on index and return an element
    public int getRandomElement(ArrayList<Integer> list, int bound)
    {
        // ThreadLocalRandom generate a int type number
        return list.get(ThreadLocalRandom.current()
                .nextInt(list.size())
                % bound);
                */
    }

    public void setBackgroundActivity(String url, Activity activity) {
        Glide.with(activity)
                .load(url)
                .into(new CustomTarget<Drawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        layout.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

    }
}
