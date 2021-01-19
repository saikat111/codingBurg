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
import com.sorder.saikat.codingburg.activity.LessonsDetailsActivity;
import com.sorder.saikat.codingburg.model.CategoryModel;
import com.sorder.saikat.codingburg.model.LessonModel;

import java.util.List;

public class LessonsAdapter  extends RecyclerView.Adapter<LessonsAdapter.CategoryViewHolder> {
    private final Context mCtx;
    private final List<LessonModel> lessonModelList;
    int count;

    public LessonsAdapter(Context mCtx, List<LessonModel> categoryModelList) {
        this.mCtx = mCtx;
        this.lessonModelList = categoryModelList;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_for_items2, null);
        return new CategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        LessonModel data = lessonModelList.get(position);
        count = position;

            holder.name.setText(data.getTitle());
            holder.type.setText(data.getType());
            Glide.with(mCtx).load(data.getImage1()).into(holder.image);
            holder.title.setText(data.getTitle());
            holder.image1.setText(data.getImage1());
            holder.lecturer1.setText(data.getLecturer1());
            holder.image_title1.setText(data.getImage_title1());
            holder.lecturer2.setText(data.getLecturer2());
            holder.writer_name.setText(data.getWriter_name());
            holder.date.setText(data.getDate());
            holder.update_time.setText(data.getUpdate_time());
            holder.code1.setText(data.getCode1());
            holder.code_title1.setText(data.getCode_title1());
            holder.code2.setText(data.getCode2());
            holder.code_title2.setText(data.getCode_title2());
            holder.image2.setText(data.getImage2());
            holder.image_title2.setText(data.getCode_title2());


    }
    @Override
    public int getItemCount() {
        return lessonModelList.size();
    }
    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, type, title,lecturer1,lecturer2,code_title1,code1,code_title2,code2,image_title1,image1,image_title2,image2,writer_name,date,update_time;
        ImageView image;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
                name = itemView.findViewById(R.id.name);
                type = itemView.findViewById(R.id.type);
                image = itemView.findViewById(R.id.image);
                title = itemView.findViewById(R.id.title);
                lecturer1 = itemView.findViewById(R.id.lecturer1);
                image_title1 = itemView.findViewById(R.id.image_title1);
                image1 = itemView.findViewById(R.id.image1);
                writer_name = itemView.findViewById(R.id.writer_name);
                date = itemView.findViewById(R.id.date);
                update_time = itemView.findViewById(R.id.update_time);
                code_title1 = itemView.findViewById(R.id.code_title1);
                code1 = itemView.findViewById(R.id.code1);
                lecturer2 = itemView.findViewById(R.id.lecturer2);
                code_title2 = itemView.findViewById(R.id.code_title2);
                code2 = itemView.findViewById(R.id.code2);
                image_title2 = itemView.findViewById(R.id.image_title2);
                image2 = itemView.findViewById(R.id.image2);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), LessonsDetailsActivity.class);
                intent.putExtra("title",title.getText() );
                intent.putExtra("type",type.getText() );
                intent.putExtra("lecturer1",lecturer1.getText() );
                intent.putExtra("image1",image1.getText() );
                intent.putExtra("writer_name",writer_name.getText() );
                intent.putExtra("date",date.getText() );
                intent.putExtra("update_time",update_time.getText() );
                intent.putExtra("code_title1",code_title1.getText());
                intent.putExtra("code1",code1.getText() );
                intent.putExtra("lecturer2",lecturer2.getText() );
                intent.putExtra("code_title2",code_title2.getText());
                intent.putExtra("code2",code2.getText() );
                intent.putExtra("image_title1",image_title1.getText());
                intent.putExtra("image_title2",image_title2.getText());
                intent.putExtra("image2",image2.getText() );
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            v.getContext().startActivity(intent);
        }
    }
}
