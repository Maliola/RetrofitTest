package com.example.ios007.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.ios007.retrofittest.model.TestModelImpl;
import com.example.ios007.retrofittest.model.entry.TeacherList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void myclick(View view){
        TestModelImpl.getInstance().getRecommendTeachers(new Callback<TeacherList>() {
            @Override
            public void onResponse(Call<TeacherList> call, Response<TeacherList> response) {
                Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TeacherList> call, Throwable t) {
                Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
