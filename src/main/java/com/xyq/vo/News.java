package com.xyq.vo;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private Integer nid;
    private String title;
    private Date pubdate;
    private String content;
    private Item item;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", pubdate=" + pubdate +
                ", content='" + content + '\'' +
                ", item=" + item +
                '}';
    }
}
