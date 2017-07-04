package com.example.ios007.retrofittest.model;

import com.example.ios007.retrofittest.app.config.AppApplication;
import com.example.ios007.retrofittest.model.entry.TeacherList;
import com.example.ios007.retrofittest.network.HttpControl;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by ios007 on 2017/7/4.
 */

public class TestModelImpl implements TestInterface {
    private static TestModelImpl INSTANCE;

    public synchronized static TestModelImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestModelImpl();
        }
        return INSTANCE;
    }

    @Override
    public void getRecommendTeachers(Callback<TeacherList> callback) {
        Call<TeacherList> call = HttpControl.getInstance(AppApplication.getInstance()).getDefaltService().getRecommendTeachers();
        call.enqueue(callback);
    }
}
