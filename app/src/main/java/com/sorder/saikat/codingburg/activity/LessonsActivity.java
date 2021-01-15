package com.sorder.saikat.codingburg.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;
import com.sorder.saikat.codingburg.R;
import com.sorder.saikat.codingburg.adapter.CategoryAdapter;
import com.sorder.saikat.codingburg.adapter.LessonsAdapter;
import com.sorder.saikat.codingburg.api.Api;
import com.sorder.saikat.codingburg.model.CategoryModel;
import com.sorder.saikat.codingburg.model.LessonModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LessonsActivity extends AppCompatActivity {
    String type;
    RecyclerView recyclerView;
    SimpleArcLoader simpleArcLoader;
    Api api = new Api();
    List<LessonModel> lessonModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        lessonModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        simpleArcLoader = findViewById(R.id.loader);
        type = getIntent().getExtras().getString("type");
        loadData();
    }

    private void loadData() {
        /*     recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        simpleArcLoader.start();
        String url =  api.getProgrammingLanguageLessons() + type;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject getData = array.getJSONObject(i);
                        System.out.println(getData.getString("lecturer1"));
                        lessonModelList.add(new LessonModel(
                                getData.getString("url"),
                                getData.getString("title"),
                                getData.getString("type"),
                                getData.getString("lecturer1"),
                                getData.getString("lecturer2"),
                                getData.getString("code_title1"),
                                getData.getString("code1"),
                                getData.getString("code_title2"),
                                getData.getString("code2"),
                                getData.getString("image_title1"),
                                getData.getString("image1"),
                                getData.getString("image_title2"),
                                getData.getString("image2"),
                                getData.getString("writer_name"),
                                getData.getString("date"),
                                getData.getString("update_time")
                        ));
                        LessonsAdapter adapter = new LessonsAdapter(getApplicationContext(), lessonModelList);
                        recyclerView.setAdapter(adapter);
                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);

            }
        });
        Volley.newRequestQueue(this).add(request);
    }
    }
