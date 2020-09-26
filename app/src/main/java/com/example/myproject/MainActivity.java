package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myproject.databinding.ActivityMainBinding;
import com.example.myproject.retrofit.BookApi;
import com.example.myproject.retrofit.ModelBook;
import com.example.myproject.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    List<ModelBook> books = new ArrayList<>();

    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        mainViewModel = new MainViewModel();
        adapterRecycler = new AdapterRecycler(this, books);
        binding.setMyAdapter(adapterRecycler);
        binding.setViewModel(mainViewModel);

//        initRecyclerView();

    }

    public void initRecyclerView() {

        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterRecycler = new AdapterRecycler(getApplicationContext(), books);
        recyclerView.setAdapter(adapterRecycler);

    }

}
