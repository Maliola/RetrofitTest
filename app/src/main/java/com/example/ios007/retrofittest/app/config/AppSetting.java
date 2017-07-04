package com.example.ios007.retrofittest.app.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.ios007.retrofittest.app.ParamsUtils;
import com.example.ios007.retrofittest.model.entry.User;

/**
 * Created by ios007 on 2017/7/4.
 */

public class AppSetting {
    Context mContext;
    private SharedPreferences mGlobalPreferences;
    private static final String SHARED_PREFERENCES_NAME = "com.example.ios007.retrofittest.config.setting";
    public final StringPreference COOKIE_TOKEN_USERID = new StringPreference(ParamsUtils.COOKIE_TOKEN_USERID, "");
    public final StringPreference COOKIE_INFO_LOGINTYPE = new StringPreference("COOKIE_INFO_LOGINTYPE", "1");
    public final StringPreference COOKIE_INFO_PASSWORD = new StringPreference(ParamsUtils.COOKIE_INFO_PASSWORD, "");
    public final StringPreference COOKIE_INFO_ROLEACCOUNT = new StringPreference(ParamsUtils.COOKIE_INFO_ROLEACCOUNT, "");
    public final StringPreference COOKIE_INFO_ROLENAME = new StringPreference(ParamsUtils.COOKIE_INFO_ROLENAME, "");
    public final StringPreference COOKIE_INFO_PORTRAIT = new StringPreference(ParamsUtils.COOKIE_INFO_PORTRAIT, "");
    public final IntPreference COOKIE_INFO_LEVEL = new IntPreference(ParamsUtils.COOKIE_INFO_LEVEL, 0);
    public final StringPreference COOKIE_INFO_SEX = new StringPreference(ParamsUtils.COOKIE_INFO_SEX, "");
    public final StringPreference COOKIE_INFO_AGE = new StringPreference(ParamsUtils.COOKIE_INFO_AGE, "");
    public final StringPreference COOKIE_INFO_PLACE = new StringPreference(ParamsUtils.COOKIE_INFO_PLACE, "");
    public final BooleanPreference COOKIE_INFO_LIGITED = new BooleanPreference("COOKIE_INFO_LIGITED", false);
    public final BooleanPreference COOKIE_ISVIP = new BooleanPreference(ParamsUtils.COOKIE_ISVIP, false);
    public final StringPreference COOKIE_INFO_TOKEN = new StringPreference(ParamsUtils.COOKIE_INFO_TOKEN, "");

    public AppSetting(Context context) {
        this.mContext = context;
        mGlobalPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }
    /**
     * 获取当前用户信息
     *
     * @return
     */
    public User getUser() {
        String rolename = COOKIE_TOKEN_USERID.getValue();
        User user = null;
        if (!TextUtils.isEmpty(rolename)) {
            user = new User();
            user.setLoginType(COOKIE_INFO_LOGINTYPE.getValue());
            user.setPassword(COOKIE_INFO_PASSWORD.getValue());
            user.setUserAccount(COOKIE_INFO_ROLEACCOUNT.getValue());
            user.setNickName(COOKIE_INFO_ROLENAME.getValue());
            user.setAvatar(COOKIE_INFO_PORTRAIT.getValue());
            user.setVipLevel(COOKIE_INFO_LEVEL.getValue());
            user.setUserId(COOKIE_TOKEN_USERID.getValue());
            user.setGender(COOKIE_INFO_SEX.getValue());
            user.setBirthday(COOKIE_INFO_AGE.getValue());
            user.setDistrict(COOKIE_INFO_PLACE.getValue());
            user.setLighted(COOKIE_INFO_LIGITED.getValue());
            user.setVip(COOKIE_ISVIP.getValue());
            user.setToken(COOKIE_INFO_TOKEN.getValue());
        }

        return user;
    }
    /**
     * 布尔型参数保存
     */
    public class BooleanPreference extends CommonPreference<Boolean> {
        private BooleanPreference(String id, boolean defaultValue) {
            super(id, defaultValue);
        }

        @Override
        public Boolean getValue() {
            return mGlobalPreferences.getBoolean(getId(), getDefaultValue());
        }

        @Override
        public boolean setValue(Boolean val) {
            return mGlobalPreferences.edit().putBoolean(getId(), val).commit();
        }
    }
    /**
     * 整型数值参数保存
     */
    public class IntPreference extends CommonPreference<Integer> {
        private IntPreference(String id, int defaultValue) {
            super(id, defaultValue);
        }

        @Override
        public Integer getValue() {
            return mGlobalPreferences.getInt(getId(), getDefaultValue());
        }

        @Override
        public boolean setValue(Integer val) {
            return mGlobalPreferences.edit().putInt(getId(), val).commit();
        }
    }
    /**
     * String参数保存
     */
    public class StringPreference extends CommonPreference<String> {

        public StringPreference(String id, String defaultValue) {
            super(id, defaultValue);
        }

        @Override
        public String getValue() {
            return mGlobalPreferences.getString(getId(), getDefaultValue());
        }

        @Override
        public boolean setValue(String val) {
            return mGlobalPreferences.edit().putString(getId(), val).commit();
        }
    }
    public abstract class CommonPreference<T> {
        private final String id;
        private T defaultValue;

        public CommonPreference(String id, T defaultValue) {
            this.id = id;
            this.defaultValue = defaultValue;
        }

        protected T getDefaultValue() {
            return defaultValue;
        }

        public abstract T getValue();

        public abstract boolean setValue(T val);

        public String getId() {
            return id;
        }

        /**
         * 重置为初始值
         */
        public void resetToDefault() {
            setValue(getDefaultValue());
        }
    }
}
