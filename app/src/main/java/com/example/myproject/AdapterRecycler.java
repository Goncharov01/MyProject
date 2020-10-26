package com.example.myproject;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.databinding.TaskListItemBinding;
import com.example.myproject.retrofit.DeleteListener;
import com.example.myproject.retrofit.ModelBook;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class AdapterRecycler extends RecyclerView.Adapter<BookItemViewHolder> {
    @Inject
    DeleteListener deleteListener;
    List<ModelBook> bookList = new ArrayList<>();

    @Inject
    public AdapterRecycler() {
//        this.deleteListener = deleteListener;

    }

    @NonNull
    @Override
    public BookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TaskListItemBinding binding = TaskListItemBinding.inflate(inflater, parent, false);
        return new BookItemViewHolder(binding.getRoot(), deleteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BookItemViewHolder holder, int position) {
        ModelBook modelBook = bookList.get(position);
        holder.bind(modelBook);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public void onChange(List<ModelBook> books) {
        bookList.clear();
        bookList.addAll(books);
        notifyDataSetChanged();
    }

}
