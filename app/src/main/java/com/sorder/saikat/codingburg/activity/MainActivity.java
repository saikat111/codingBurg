package com.sorder.saikat.codingburg.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
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
import com.sorder.saikat.codingburg.api.Api;
import com.sorder.saikat.codingburg.model.CategoryModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Api api = new Api();
    List<CategoryModel> categoryModelList;
    LinearLayoutManager HorizontalLayout;
    SimpleArcLoader simpleArcLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoryModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        simpleArcLoader = findViewById(R.id.loader);
        loadCategory();
    }

    private void loadCategory() {
   /*     recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        simpleArcLoader.start();
        HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(HorizontalLayout);
        String url =  api.getProgrammingLanguageCategory();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject getData = array.getJSONObject(i);
                        categoryModelList.add(new CategoryModel(
                                getData.getString("url"),
                                getData.getString("name"),
                                getData.getString("title"),
                                getData.getString("type"),
                                getData.getString("image"),
                                getData.getString("date"),
                                getData.getString("update_time")
                        ));
                        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), categoryModelList);
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