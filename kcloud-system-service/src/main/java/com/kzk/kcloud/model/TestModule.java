package com.kzk.kcloud.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class TestModule implements Kmodule {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        System.out.println("==============================================");
        System.out.println("======================TestModule>>>========================");
        System.out.println("==============================================");
        System.out.println("Before setUrl:" + this.url);
        System.out.println("setUrl:" + url);
        System.out.println("==============================================");
        System.out.println("======================TestModule>>>========================");
        System.out.println("==============================================");
        this.url = url;
    }
}
