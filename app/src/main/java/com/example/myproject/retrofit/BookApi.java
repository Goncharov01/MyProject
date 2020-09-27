package com.example.myproject.retrofit;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BookApi {

    @GET("/api/books")
    Observable<ArrayList<ModelBook>> getBooks();

    @POST("/api/books/create")
    Observable<ModelBook> addBooks(@Body ModelBook modelBook);

}
