package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.databinding.TaskListItemBinding;
import com.example.myproject.retrofit.ModelBook;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<BookItemViewHolder> {

    Context context;
    List<ModelBook> bookList = new ArrayList<>();

    public AdapterRecycler(Context context, List<ModelBook> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TaskListItemBinding binding = TaskListItemBinding.inflate(inflater, parent, false);
        return new BookItemViewHolder(binding.getRoot());
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
