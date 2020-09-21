package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
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

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    Disposable disposable = null;

    private BookApi getApi() {
        return RetrofitClient.getApi();
    }

    List<ModelBook> books = new ArrayList<>();

    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adapterRecycler = new AdapterRecycler(this, books);
        binding.setMyAdapter(adapterRecycler);

//        initRecyclerView();

        disposable = getApi().getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> adapterRecycler.onChange(list));
    }

    public void initRecyclerView() {

        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterRecycler = new AdapterRecycler(getApplicationContext(), books);
        recyclerView.setAdapter(adapterRecycler);

    }


}
