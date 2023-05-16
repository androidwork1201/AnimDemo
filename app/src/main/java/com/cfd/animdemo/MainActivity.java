package com.cfd.animdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.cfd.animdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.open.setOnClickListener(v -> {
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
            binding.top.bringToFront();
            openLayout();
        });
    }


    private void openLayout() {

        //------------向下
        Animation open = AnimationUtils.loadAnimation(getBaseContext(), R.anim.open);
        open.setDuration(150);
        Animation down = AnimationUtils.loadAnimation(getBaseContext(), R.anim.down);
        down.setDuration(150);

        //------------向上
        Animation close = AnimationUtils.loadAnimation(getBaseContext(), R.anim.close);
        close.setDuration(100);
        Animation up = AnimationUtils.loadAnimation(getBaseContext(), R.anim.up);
        up.setDuration(500);



        if (!isOpen) {
            isOpen = true;
            binding.line.setAnimation(open);
            binding.line.setVisibility(View.VISIBLE);

            binding.bottom.setAnimation(down);
            binding.bottom.setVisibility(View.VISIBLE);

        } else {
            isOpen = false;

            binding.line.setAnimation(close);
            binding.line.setVisibility(View.INVISIBLE);

            binding.bottom.setAnimation(up);
            binding.bottom.setVisibility(View.GONE);


        }
    }
}