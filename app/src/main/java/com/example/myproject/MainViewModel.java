package com.example.myproject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myproject.retrofit.ModelBook;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends ViewModel {


    public MainViewModel() {
    }

    MutableLiveData<List<ModelBook>> books = new MutableLiveData<>();
    BookRepository bookRepository = new BookRepository();

    public MutableLiveData<String> titleLive = new MutableLiveData<>();
    public MutableLiveData<String> authorLive = new MutableLiveData<>();
    public MutableLiveData<String> descriptionLive = new MutableLiveData<>();

    public MutableLiveData<String> title = new MutableLiveData<>();
    public MutableLiveData<String> author = new MutableLiveData<>();
    public MutableLiveData<String> description = new MutableLiveData<>();

    public void addBooks() {
        title.setValue(titleLive.getValue());
        author.setValue(authorLive.getValue());
        description.setValue(descriptionLive.getValue());
        System.out.println("*******************" + title + "   " + author);
        ModelBook modelBook = new ModelBook(titleLive.getValue(), authorLive.getValue(), descriptionLive.getValue());

        bookRepository.addBooks(modelBook)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(book -> showBook());

        titleLive.setValue("");
        authorLive.setValue("");
        descriptionLive.setValue("");

        title.setValue(titleLive.getValue());
        author.setValue(authorLive.getValue());
        description.setValue(descriptionLive.getValue());

    }

    public void showBook() {
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        bookRepository.showBook()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    books.setValue(list);
                    System.out.println("LIIIIIIIISSSSSSTTTTT" + list);
                });

    }

    public void delete(int i) {

        bookRepository.deleteBooks(i)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        list -> System.out.println(),
                        e -> System.out.println("ERROR" + e),
                        () -> System.out.println("OK")
                );

        showBook();

        System.out.println("delete" + i);

    }
}
