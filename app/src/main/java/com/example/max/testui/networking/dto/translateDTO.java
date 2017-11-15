package com.example.max.testui.networking.dto;

import java.util.List;

/**
 * Created by max on 11/9/17.
 */

public class translateDTO {

    private  int code;
    private String lang;
    private List<String> text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

}
