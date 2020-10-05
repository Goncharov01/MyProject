package com.example.myproject;

import com.example.myproject.retrofit.BookApi;
import com.example.myproject.retrofit.ModelBook;
import com.example.myproject.retrofit.RetrofitClient;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;

public class BookRepository {

    private BookApi getApi() {
        return RetrofitClient.getApi();
    }

    public Observable<ArrayList<ModelBook>> showBook() {
        System.out.println("!!!!!!!!!!!!!!!!!!!");

        return getApi().getBooks();
    }

    public Observable<ModelBook> addBooks(ModelBook modelBook) {
        return getApi().addBooks(modelBook);

    }

    public Observable<ResponseBody> deleteBooks(int i) {
        return getApi().deleteBooks(i);

    }

}
