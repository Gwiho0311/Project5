package com.crud.board;
import java.util.Date;

public class BoardVO {
    private int seq;
    private String tag;
    private String writer;
    private String content;
    private String birthdate;
    private String country;
    private String gender;
    private String regdate;

    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getBirthdate() { return birthdate;}
    public void setBirthdate(String birthdate) { this.birthdate = birthdate;}

    public String getCountry() { return country;}
    public void setCountry(String country) { this.country = country;}
    public String getGender() { return gender;}
    public void setGender(String gender) { this.gender = gender;}
    public String getRegdate() {
        return regdate;
    }
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}