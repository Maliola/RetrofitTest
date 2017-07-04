package com.example.ios007.retrofittest.model;

import com.example.ios007.retrofittest.model.entry.TeacherList;

import retrofit2.Callback;

/**
 * Created by ios007 on 2017/7/4.
 */

public interface TestInterface {
    void getRecommendTeachers(Callback<TeacherList> callback);
}
