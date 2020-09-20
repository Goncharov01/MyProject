package com.example.myproject.retrofit;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BookApi {

    @GET("/api/books")
    Call<List<ModelBook>> getBooks();

}
