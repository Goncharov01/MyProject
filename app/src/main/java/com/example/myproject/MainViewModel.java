package com.example.myproject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.retrofit.BookApi;
import com.example.myproject.retrofit.ModelBook;
import com.example.myproject.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private BookApi getApi() {
        return RetrofitClient.getApi();
    }

    List<ModelBook> books = new ArrayList<>();
    Disposable disposable = null;
    RecyclerView recyclerView;

    public MutableLiveData<String> titleLive = new MutableLiveData<>();
    public MutableLiveData<String> authorLive = new MutableLiveData<>();

    public MutableLiveData<String> title = new MutableLiveData<>();
    public MutableLiveData<String> author = new MutableLiveData<>();



    public void addBooks() {
        title.setValue(titleLive.getValue());
        author.setValue(authorLive.getValue());
        System.out.println("9999999999999999999999" + title + "   " + author);
    }

    public void showBook() {

        System.out.println("!!!!!!!!!!!!!!!!!!!");

        disposable = getApi().getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> System.out.println("&&&&&&&&&&&&&&" + list));
//                .subscribe(list -> adapterRecycler.onChange(list));

    }


}
