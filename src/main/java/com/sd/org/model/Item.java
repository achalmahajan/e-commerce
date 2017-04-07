package com.sd.org.model;

import java.util.Date;

/**
 * Created by Achal on 4/3/17.
 */
public class Item {

    private String title;
    private String link;
    private String description;
    private Date pubDate;


    public Item() {
    }

    public Item(String title, String link, String description) {


        this.title = title;
        this.link = link;
        this.description = description;
//        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
