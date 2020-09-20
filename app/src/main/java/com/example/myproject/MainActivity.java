package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myproject.retrofit.BookApi;
import com.example.myproject.retrofit.ModelBook;
import com.example.myproject.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private BookApi getApi() {
        return RetrofitClient.getApi();
    }

    List<ModelBook> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<List<ModelBook>> book = getApi().getBooks();

        book.enqueue(new Callback<List<ModelBook>>() {
            @Override
            public void onResponse(Call<List<ModelBook>> call, Response<List<ModelBook>> response) {
                books = response.body();
                System.out.println("@@@@@@@@@@@@" + books);
            }

            @Override
            public void onFailure(Call<List<ModelBook>> call, Throwable t) {
                System.out.println("ERROR");
            }
        });

    }
}
