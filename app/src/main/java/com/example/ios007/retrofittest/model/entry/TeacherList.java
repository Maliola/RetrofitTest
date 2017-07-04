package com.example.ios007.retrofittest.model.entry;

import java.util.List;

/**
 * Created by ios007 on 2017/7/4.
 */

public class TeacherList extends BaseResponse{
    List<Teacher> res_data;

    public List<Teacher> getRes_data() {
        return res_data;
    }

    public void setRes_data(List<Teacher> res_data) {
        this.res_data = res_data;
    }
}
