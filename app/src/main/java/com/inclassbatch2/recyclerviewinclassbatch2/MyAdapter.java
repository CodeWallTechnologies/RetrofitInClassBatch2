package com.inclassbatch2.recyclerviewinclassbatch2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.inclassbatch2.recyclerviewinclassbatch2.databinding.ItemBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<ReviewModel> list;
    MyAdapter(List<ReviewModel> list){
        this.list  = list;
    }

    ItemBinding binding;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        ReviewModel current = list.get(position);

         holder.tv1.setText(current.author);
         holder.tv2.setText(current.roll);
//         holder.imageView.setImageResource(current.download_url);
        Glide.with(holder.itemView.getContext()).load(current.download_url).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv1,tv2;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemBinding.bind(itemView);
            tv1 = binding.textView123;
            tv2 = binding.textView234;
            imageView = binding.imageView345;

        }
    }
}
