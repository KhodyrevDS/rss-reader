package ru.kds.service.rss;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Date adapter
 */
public class DateAdapter extends XmlAdapter<String, ZonedDateTime> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

    @Override
    public String marshal(ZonedDateTime time) throws Exception {
        return formatter.format(time);
    }

    @Override
    public ZonedDateTime unmarshal(String str) throws Exception {
        return ZonedDateTime.parse(str, formatter);
    }

}
