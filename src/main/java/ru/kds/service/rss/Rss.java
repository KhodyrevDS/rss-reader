package ru.kds.service.rss;

import java.io.Serializable;

/**
 * Rss
 */

public class Rss implements Serializable {

    private static final long serialVersionUID = -848983175805989801L;

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
