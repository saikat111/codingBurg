package com.sorder.saikat.codingburg.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.sorder.saikat.codingburg.R;
import com.sorder.saikat.codingburg.adapter.CategoryAdapter;
import com.sorder.saikat.codingburg.adapter.NewsAdapter;
import com.sorder.saikat.codingburg.adapter.SliderAdapterExample;
import com.sorder.saikat.codingburg.api.Api;
import com.sorder.saikat.codingburg.model.CategoryModel;
import com.sorder.saikat.codingburg.model.NewsModel;
import com.sorder.saikat.codingburg.model.SliderItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView type1,type2,type3;
    RecyclerView recyclerView, recyclerView2,recyclerView3 ,recyclerView4;
    Api api = new Api();
    List<CategoryModel> categoryModelList;
    List<CategoryModel> dbModelList;
    List<CategoryModel> fwModelList;
    List<NewsModel> newsModelList;
    List<SliderItem> slideModelList;
    LinearLayoutManager HorizontalLayout;
    SimpleArcLoader simpleArcLoader, simpleArcLoader2,simpleArcLoader3, simpleArcLoader4;
    SliderView sliderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = findViewById(R.id.imageSlider);

/*        SliderAdapterExample adapter = new SliderAdapterExample(this);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();*/


        type1 = findViewById(R.id.type1);
        type2 = findViewById(R.id.type2);
        type3 = findViewById(R.id.type3);
        categoryModelList = new ArrayList<>();
        dbModelList = new ArrayList<>();
        fwModelList = new ArrayList<>();
        newsModelList = new ArrayList<>();
        slideModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView2 = findViewById(R.id.recyclerview2);
        recyclerView3 = findViewById(R.id.recyclerview3);
        recyclerView4 = findViewById(R.id.recyclerview4);
        simpleArcLoader = findViewById(R.id.loader);
        simpleArcLoader2 = findViewById(R.id.loader2);
        simpleArcLoader3 = findViewById(R.id.loader3);
        simpleArcLoader4 = findViewById(R.id.loader4);
        loadCategory();
        loadNews();
        loadDb();
        loadframework();
        loadSlider();
    }

    private void loadSlider() {
        String url =  api.getFrameworkCategory();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject getData = array.getJSONObject(i);
                        slideModelList.add(new SliderItem(
                                getData.getString("image"),
                                getData.getString("title")

                        ));
                        SliderAdapterExample adapter = new SliderAdapterExample(getApplicationContext(), slideModelList);
                        sliderView.setSliderAdapter(adapter);
                        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
                        sliderView.setIndicatorSelectedColor(Color.WHITE);
                        sliderView.setIndicatorUnselectedColor(Color.GRAY);
                        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
                        sliderView.startAutoCycle();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(request);

    }

    private void loadframework() {
          /*     recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        simpleArcLoader4.start();
        type2.setText(getString(R.string.fw));
        HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView4.setLayoutManager(HorizontalLayout);
        String url =  api.getFrameworkCategory();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject getData = array.getJSONObject(i);
                        fwModelList.add(new CategoryModel(
                                getData.getString("url"),
                                getData.getString("name"),
                                getData.getString("title"),
                                getData.getString("type"),
                                getData.getString("image"),
                                getData.getString("date"),
                                getData.getString("update_time")
                        ));
                        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), fwModelList);
                        recyclerView4.setAdapter(adapter);
                        simpleArcLoader4.stop();
                        simpleArcLoader4.setVisibility(View.GONE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader4.stop();
                    simpleArcLoader4.setVisibility(View.GONE);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader4.stop();
                simpleArcLoader4.setVisibility(View.GONE);

            }
        });
        Volley.newRequestQueue(this).add(request);
    }

    private void loadDb() {
        /*     recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        simpleArcLoader3.start();
        type3.setText(getString(R.string.db));

        HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView3.setLayoutManager(HorizontalLayout);
        String url =  api.getDbCategory();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject getData = array.getJSONObject(i);
                        dbModelList.add(new CategoryModel(
                                getData.getString("url"),
                                getData.getString("name"),
                                getData.getString("title"),
                                getData.getString("type"),
                                getData.getString("image"),
                                getData.getString("date"),
                                getData.getString("update_time")
                        ));
                        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), dbModelList);
                        recyclerView3.setAdapter(adapter);
                        simpleArcLoader3.stop();
                        simpleArcLoader3.setVisibility(View.GONE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader3.stop();
                    simpleArcLoader3.setVisibility(View.GONE);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader3.stop();
                simpleArcLoader3.setVisibility(View.GONE);

            }
        });
        Volley.newRequestQueue(this).add(request);
    }

    private void loadNews() {
             recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        simpleArcLoader2.start();


    /*    HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(HorizontalLayout);*/
        String url =  api.getNews();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject getData = array.getJSONObject(i);
                        newsModelList.add(new NewsModel(
                                getData.getString("title"),
                                getData.getString("news"),
                                getData.getString("image"),
                                getData.getString("writer_name"),
                                getData.getString("date"),
                                getData.getString("update_time")
                        ));
                        NewsAdapter adapter = new NewsAdapter(getApplicationContext(), newsModelList);
                        recyclerView2.setAdapter(adapter);
                        simpleArcLoader2.stop();
                        simpleArcLoader2.setVisibility(View.GONE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader2.stop();
                    simpleArcLoader2.setVisibility(View.GONE);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader2.stop();
                simpleArcLoader2.setVisibility(View.GONE);

            }
        });
        Volley.newRequestQueue(this).add(request);
    }

    private void loadCategory() {
   /*     recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        simpleArcLoader.start();
        type1.setText(getString(R.string.pl));
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