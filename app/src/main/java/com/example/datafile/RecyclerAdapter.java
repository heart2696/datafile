package com.example.datafile;

import static android.media.CamcorderProfile.get;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datafile.databinding.HwlayoutBinding;
import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    ArrayList<BookItemLists> bookLists = new ArrayList<BookItemLists>();
//    private final ArrayList<BookItem> booklist;
//    public RecyclerAdapter(ArrayList<BookItem> booklist){
//        this.booklist = booklist;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hwlayout,parent,false);
        return new ViewHolder(view);
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        HwlayoutBinding binding = HwlayoutBinding.inflate(inflater, parent, false);
//        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder ViewHolder, int position) {
        ViewHolder.onBind(bookLists.get(position));

    }
//        RecyclerView.ViewHolder.onBind(bookLists.get(position));





    @Override
    public int getItemCount() {

        return bookLists.size();
    }



    protected static class ViewHolder extends RecyclerView.ViewHolder{
        private final RecyclerAdapter binding;


        public ViewHolder(HwlayoutBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
