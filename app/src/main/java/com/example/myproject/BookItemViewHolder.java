package com.example.myproject;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.databinding.TaskListItemBinding;
import com.example.myproject.retrofit.DeleteListener;
import com.example.myproject.retrofit.ModelBook;

public class BookItemViewHolder extends RecyclerView.ViewHolder {

    TaskListItemBinding binding;
    DeleteListener deleteListener;
    BookRepository bookRepository = new BookRepository();

    public BookItemViewHolder(View v, DeleteListener deleteListener) {
        super(v);
        binding = DataBindingUtil.bind(v);
        this.deleteListener = deleteListener;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.model, obj);
        binding.executePendingBindings();
        binding.getRoot().findViewById(R.id.layoutList).setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        Toast.makeText(view.getContext(), "Delete book", Toast.LENGTH_LONG).show();
                        deleteListener.delete(((ModelBook) obj).getId());

                        return false;
                    }
                }
        );
    }

}