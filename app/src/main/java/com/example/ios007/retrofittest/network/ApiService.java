package com.example.ios007.retrofittest.network;

import com.example.ios007.retrofittest.model.entry.TeacherList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ios007 on 2017/7/4.
 */

public interface ApiService {
    @GET("views/find/teacher")
    Call<TeacherList> getRecommendTeachers();
}
