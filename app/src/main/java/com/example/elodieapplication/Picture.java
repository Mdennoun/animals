package com.example.elodieapplication;

public class Picture {

    private String title;
    private String detail;
    private String url;

    public Picture(String title, String detail, String url) {
        this.title = title;
        this.detail = detail;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
