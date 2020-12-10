package com.example.myproject;

import androidx.recyclerview.widget.DiffUtil;

import com.example.myproject.retrofit.ModelBook;

import java.util.ArrayList;
import java.util.List;

public class BookDiffUtil extends DiffUtil.Callback {

    List<ModelBook> oldList = new ArrayList<>();
    List<ModelBook> newList = new ArrayList<>();

    public BookDiffUtil(List<ModelBook> oldList, List<ModelBook> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        ModelBook modelBookOld = oldList.get(oldItemPosition);
        ModelBook modelBookNew = newList.get(newItemPosition);
        return modelBookOld.getId() == modelBookNew.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        ModelBook modelBookOld = oldList.get(oldItemPosition);
        ModelBook modelBookNew = newList.get(newItemPosition);

        return modelBookOld.getAuthor().equals(modelBookNew.getAuthor())
                && modelBookOld.getTitle() == modelBookNew.getTitle()
                && modelBookOld.getDescription() == modelBookNew.getDescription();
    }

}


