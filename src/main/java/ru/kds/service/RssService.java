package ru.kds.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import ru.kds.service.rss.Rss;

import static javax.xml.bind.JAXBContext.newInstance;

/**
 * Rss service
 */
public class RssService {

    private final JAXBContext jaxbContext;

    public RssService() throws JAXBException {
        this.jaxbContext = newInstance(Rss.class);
    }

    public Rss getFeed(String urlString) throws IOException, JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        URL url = new URL(urlString);
        InputStream xml = url.openStream();
        JAXBElement<Rss> element = unmarshaller.unmarshal(new StreamSource(xml), Rss.class);
        return element.getValue();
    }
}
