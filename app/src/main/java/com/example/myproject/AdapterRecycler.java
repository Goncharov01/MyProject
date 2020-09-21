package com.example.myproject;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.retrofit.ModelBook;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.RecyclerViewHolder> {

    Context context;
    List<ModelBook> bookList = new ArrayList<>();

    public AdapterRecycler(Context context, List<ModelBook> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView id;
        private TextView title;
        private TextView author;
        private TextView description;
        private TextView published;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idView);
            title = itemView.findViewById(R.id.titleView);
            author = itemView.findViewById(R.id.authorView);
            description = itemView.findViewById(R.id.descriptionView);
            published = itemView.findViewById(R.id.publishedView);
        }

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_list_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if (bookList != null) {
            ModelBook modelBook = this.bookList.get(position);

//            holder.id.setText(modelBook.getId());
            holder.title.setText(modelBook.getTitle());
            holder.author.setText(modelBook.getAuthor());
            holder.description.setText(modelBook.getDescription());
//            holder.published.setText(modelBook.getPublished());

        }
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
