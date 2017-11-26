package ru.kds.service.rss;

import java.io.Serializable;

/**
 * Image is a sub-element of {@link Channel}
 */
public class Image implements Serializable {

    private static final long serialVersionUID = 4642523045943274517L;

    private String url;

    private String title;

    private String link;

    private Integer width;

    private Integer height;

    private Integer description;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }
}
