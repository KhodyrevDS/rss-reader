package ru.kds.service;

import javax.xml.bind.JAXBException;

/**
 * Rss service factory
 */
public class RssServiceFactory {

    public static RssService createRssService() {
        try {
            return new RssService();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
