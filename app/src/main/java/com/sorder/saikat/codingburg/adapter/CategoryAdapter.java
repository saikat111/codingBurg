package com.sorder.saikat.codingburg.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sorder.saikat.codingburg.R;
import com.sorder.saikat.codingburg.activity.LessonsActivity;
import com.sorder.saikat.codingburg.model.CategoryModel;

import java.util.List;

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    String poster_path;
    private final Context mCtx;
    private final List<CategoryModel> categoryModelList;

    public CategoryAdapter(Context mCtx, List<CategoryModel> categoryModelList) {
        this.mCtx = mCtx;
        this.categoryModelList = categoryModelList;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview_for_items, null);
        return new CategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel data = categoryModelList.get(position);
        holder.name.setText(data.getName());
        holder.type.setText(data.getType());
        holder.title.setText(data.getTitle());
        Glide.with(mCtx).load(data.getImage()).into(holder.image);
    }
    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }
    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, type, title;
        ImageView image;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            type = itemView.findViewById(R.id.type);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), LessonsActivity.class);
            intent.putExtra("type", type.getText().toString());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            v.getContext().startActivity(intent);
        }
    }
}
