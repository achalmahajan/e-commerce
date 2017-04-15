package com.sd.org.model;

import java.util.Date;

/**
 * Created by Achal on 4/3/17.
 */
public class Item {

    private String title;
    private String link;
    private String content;
    private String description;
    private String pubDate;
    private String thumbnailLink;


    public Item() {
    }

    public Item(String title, String link, String description, String pubDate, String content, String thumbnailLink) {


        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.content = content;
        this.thumbnailLink = thumbnailLink;
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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }
}
