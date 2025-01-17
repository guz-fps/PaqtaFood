package com.paqta.paqtafood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.paqta.paqtafood.ui.user.login.Login;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        Animation animacion3 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_derecha);

//        TextView byTextView = findViewById(R.id.byTextView);
//        TextView paqtaFoodTextView = findViewById(R.id.logoTextView);
        ImageView logoImgView = findViewById(R.id.logoImageView);

//        byTextView.setAnimation(animacion1);
//        paqtaFoodTextView.setAnimation(animacion2);
        logoImgView.setAnimation(animacion3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(logoImgView, "logoImageTrans");
//                pairs[1] = new Pair<View, String>(byTextView, "textTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }

        }, 4000);

    }
}