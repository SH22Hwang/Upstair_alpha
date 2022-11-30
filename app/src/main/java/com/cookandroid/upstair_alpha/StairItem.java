package com.cookandroid.upstair_alpha;

public class StairItem {
    private int id;             // 글 id
    private String postDate;    // 작성일
    private String content;     // 내용
    private String picture;     // 사진

    public StairItem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
