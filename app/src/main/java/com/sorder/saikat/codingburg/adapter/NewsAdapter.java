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
import com.sorder.saikat.codingburg.model.NewsModel;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.CategoryViewHolder> {
    String poster_path;
    private final Context mCtx;
    private final List<NewsModel> newsModelList;

    public NewsAdapter(Context mCtx, List<NewsModel> newsModelList) {
        this.mCtx = mCtx;
        this.newsModelList = newsModelList;
    }
    @NonNull
    @Override
    public NewsAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.news, null);
        return new NewsAdapter.CategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.CategoryViewHolder holder, int position) {
        NewsModel data = newsModelList.get(position);
        holder.title.setText(data.getTitle());
        holder.news.setText(data.getNews());
        holder.date.setText(data.getDate());
        holder.writer_name.setText(data.getWriter_name());
        Glide.with(mCtx).load(data.getImage()).into(holder.image);
    }
    @Override
    public int getItemCount() {
        return newsModelList.size();
    }
    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, news, writer_name,date;
        ImageView image;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
            news = itemView.findViewById(R.id.news);
            writer_name = (TextView) itemView.findViewById(R.id.writer_name);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }

        @Override
        public void onClick(View v) {
            /*Intent intent = new Intent(v.getContext(), LessonsActivity.class);
            intent.putExtra("type", type.getText().toString());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            v.getContext().startActivity(intent);*/
        }
    }
}
