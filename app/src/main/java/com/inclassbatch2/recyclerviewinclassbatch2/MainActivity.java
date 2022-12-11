package com.inclassbatch2.recyclerviewinclassbatch2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.inclassbatch2.recyclerviewinclassbatch2.databinding.ActivityMainBinding;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<ReviewModel> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(this);
        binding.rvInMain.setLayoutManager(layoutManager);
        binding.rvInMain.setHasFixedSize(true);

        try {
                getDataFromNetwork();
        }catch (Exception e){
//            getStaticData();
//            adapter = new MyAdapter(getStaticData());
//            binding.rvInMain.setAdapter(adapter);
        }






    }

    private void createRecyclerView(List<ReviewModel> dataFromNetwork) {
        adapter = new MyAdapter(dataFromNetwork);
        binding.rvInMain.setAdapter(adapter);
    }

    private List<ReviewModel> getDataFromNetwork() {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://picsum.photos")
                .build().create(JsonPlaceHolder.class).data().enqueue(new Callback<List<ReviewModel>>() {
                    @Override
                    public void onResponse(Call<List<ReviewModel>> call, Response<List<ReviewModel>> response) {
                   List<ReviewModel> list = response.body();
                   createRecyclerView(list);
                    }

                    @Override
                    public void onFailure(Call<List<ReviewModel>> call, Throwable t) {
                        Log.d("TAG", "onFailure: "+t.getMessage());
                    }
                });

        return  list;
    }

//    private List<ReviewModel> getStaticData() {
//        List<ReviewModel> list = new ArrayList<>();
//        list.add(new ReviewModel("Aung Kaung Moe","Student",R.drawable.agkgmoe_review));
//        list.add(new ReviewModel("Gene","Student",R.drawable.gene));
//        list.add(new ReviewModel("Hnin","Student",R.drawable.hnn));
//        list.add(new ReviewModel("Htet Wai Lwin","Student",R.drawable.htetwailwin_review));
//        return list;
//    }
}