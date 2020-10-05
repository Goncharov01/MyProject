package com.example.myproject.retrofit;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BookApi {

    @GET("/api/books")
    Observable<ArrayList<ModelBook>> getBooks();

    @POST("/api/books/create")
    Observable<ModelBook> addBooks(@Body ModelBook modelBook);

    @DELETE("api/books/{id}")
    Observable<ResponseBody> deleteBooks(@Path("id") int i);

}
