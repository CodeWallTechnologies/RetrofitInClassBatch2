package com.inclassbatch2.recyclerviewinclassbatch2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {
    @GET("/v2/list")
    Call<List<ReviewModel>> data();






}
