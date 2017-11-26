package ru.kds.service.rss;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Item
 */
public class Item implements Serializable {

    private static final long serialVersionUID = -4633572016600761635L;

    private String title;

    private String link;

    private String description;

    private String author;

    private ZonedDateTime pubDate;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public ZonedDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(ZonedDateTime pubDate) {
        this.pubDate = pubDate;
    }
}
