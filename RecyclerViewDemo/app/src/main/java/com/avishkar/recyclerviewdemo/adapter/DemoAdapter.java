package com.avishkar.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.avishkar.recyclerviewdemo.R;
import com.avishkar.recyclerviewdemo.model.DemoModel;

import java.util.ArrayList;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<DemoModel> demoList;//null ;
    //[{title ,desc},{title, desc},{title,dec},] -> MainActivity
    public DemoAdapter(Context context, ArrayList<DemoModel> d) {
        this.context = context;
        this.demoList = d;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.demo_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DemoModel model =  demoList.get(position); //DemoModel -> {title, desc}
        holder.tvTitle.setText(model.getTitle());
        holder.tvDescription.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return demoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
