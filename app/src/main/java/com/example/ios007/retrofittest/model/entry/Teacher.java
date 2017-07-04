package com.example.ios007.retrofittest.model.entry;

import java.io.Serializable;

/**
 * Created by ios007 on 2017/6/21.
 */

public class Teacher implements Serializable {
    /**
     * 教师id
     */
    private int id;
    /**
     * 名称
     */
    private String name;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 介绍
     */
    private String title;

    float praise_rate;

    int level;

    String intro;

    public Teacher(int id, String name, String avatar, String title) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.title = title;
    }

    public float getPraise_rate() {
        return praise_rate;
    }

    public void setPraise_rate(float praise_rate) {
        this.praise_rate = praise_rate;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
