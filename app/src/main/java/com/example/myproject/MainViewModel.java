package com.example.myproject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myproject.retrofit.ModelBook;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<ModelBook>> books = new MutableLiveData<>();
    BookRepository bookRepository = new BookRepository();

    public MutableLiveData<String> titleLive = new MutableLiveData<>();
    public MutableLiveData<String> authorLive = new MutableLiveData<>();

    public MutableLiveData<String> title = new MutableLiveData<>();
    public MutableLiveData<String> author = new MutableLiveData<>();

    public void addBooks() {
        title.setValue(titleLive.getValue());
        author.setValue(authorLive.getValue());
        System.out.println("*******************" + title + "   " + author);
        ModelBook modelBook = new ModelBook(titleLive.getValue(), authorLive.getValue());

        bookRepository.addBooks(modelBook)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(book -> showBook());
    }

    public void showBook() {

        System.out.println("!!!!!!!!!!!!!!!!!!!");
        bookRepository.showBook()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> books.setValue(list));

    }

}
