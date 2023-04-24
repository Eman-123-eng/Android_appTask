package com.example.task2eman_ziad;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    // Variable declaration for available views on UI
    private TextView name_text;
    private TextView tag_text;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();


        name_text = findViewById(R.id.splash_name);
        tag_text = findViewById(R.id.splash_name_tag);
        progressBar = findViewById(R.id.progressBar);

        name_text.setVisibility(View.INVISIBLE);
        tag_text.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

        int START_TIME = 1500;
        new Handler().postDelayed(() -> {
            Animation fade = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in);
            name_text.startAnimation(fade);
            tag_text.startAnimation(fade);
            name_text.setVisibility(View.VISIBLE);
            tag_text.setVisibility(View.VISIBLE);

        }, START_TIME);

        // Handling time delay for launching next activity
        int LAUNCH_TIME = 3900;
        new Handler().postDelayed(() -> {
            progressBar.setVisibility(View.VISIBLE);
            Intent intentMain = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intentMain);

            finish();

        }, LAUNCH_TIME);
    }
}