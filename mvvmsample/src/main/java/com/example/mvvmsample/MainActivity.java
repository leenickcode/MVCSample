package com.example.mvvmsample;


import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.mvvmsample.databinding.ActivityMainBinding;
import com.example.mvvmsample.entity.ListBanner;
import com.example.mvvmsample.model.MyViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding =   DataBindingUtil.setContentView(this,R.layout.activity_main);
        MyViewModel viewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getBanner().observe(this, new Observer<ListBanner>() {
            @Override
            public void onChanged(ListBanner listBanner) {
                binding.setBanner(listBanner.getData().get(0));
            }
        });
    }
}
