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
import com.sorder.saikat.codingburg.model.LessonModel;

import java.util.List;

public class LessonsAdapter  extends RecyclerView.Adapter<LessonsAdapter.CategoryViewHolder> {
    String poster_path;
    private final Context mCtx;
    private final List<LessonModel> lessonModelList;

    public LessonsAdapter(Context mCtx, List<LessonModel> categoryModelList) {
        this.mCtx = mCtx;
        this.lessonModelList = categoryModelList;
    }
    @NonNull
    @Override
    public LessonsAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_for_items2, null);
        return new LessonsAdapter.CategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LessonsAdapter.CategoryViewHolder holder, int position) {
       LessonModel data = lessonModelList.get(position);
        holder.name.setText(data.getTitle());
        holder.type.setText(data.getType());
        Glide.with(mCtx).load(data.getImage1()).into(holder.image);
    }
    @Override
    public int getItemCount() {
        return lessonModelList.size();
    }
    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, type;
        ImageView image;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            type = itemView.findViewById(R.id.type);
            image = itemView.findViewById(R.id.image);
        }

        @Override
        public void onClick(View v) {
            /*Intent intent = new Intent(v.getContext(), LessonsActivity.class);
            intent.putExtra("type", type.getText().toString());
            v.getContext().startActivity(intent);*/
        }
    }
}
