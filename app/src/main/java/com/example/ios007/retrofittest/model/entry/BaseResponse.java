package com.example.ios007.retrofittest.model.entry;

/**
 * Created by stone on 2017/6/16.
 *
 */

public class BaseResponse {
    /**
     *   "prompt-msg": "string,用户提示信息",
     "prompt-type": "string,TOAST/DIALOG 默认为TOAST",
     "res-code": "string,返回码",
     "res-msg": "string,返回信息"
     */

    String prompt_msg;
    String res_code;
    String prompt_type;
    String res_msg;

    public String getPrompt_msg() {
        return prompt_msg;
    }

    public void setPrompt_msg(String prompt_msg) {
        this.prompt_msg = prompt_msg;
    }

    public String getRes_code() {
        return res_code;
    }

    public void setRes_code(String res_code) {
        this.res_code = res_code;
    }

    public String getPrompt_type() {
        return prompt_type;
    }

    public void setPrompt_type(String prompt_type) {
        this.prompt_type = prompt_type;
    }

    public String getRes_msg() {
        return res_msg;
    }

    public void setRes_msg(String res_msg) {
        this.res_msg = res_msg;
    }
}
