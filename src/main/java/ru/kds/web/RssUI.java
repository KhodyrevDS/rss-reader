package ru.kds.web;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.net.MalformedURLException;
import ru.kds.service.RssService;
import ru.kds.service.RssServiceFactory;
import ru.kds.service.rss.Rss;

/**
 * RSS UI
 */
@Theme("rss")
public class RssUI extends UI {

    private static final long serialVersionUID = 3633316816173746409L;

    private RssService rssService = RssServiceFactory.createRssService();

    private TextField url;

    private RssView rssView;

    @Override
    protected void init(VaadinRequest request) {
        setTheme("rss");
        final GridLayout layout = new GridLayout();
        layout.setWidth(100, Unit.PERCENTAGE);
        layout.setColumns(3);
        layout.setRows(1);
        layout.setColumnExpandRatio(0, 0.1f);
        layout.setColumnExpandRatio(1, 0.8f);
        layout.setColumnExpandRatio(2, 0.1f);
        setContent(layout);

        VerticalLayout verticalLayout = new VerticalLayout();
        layout.addComponent(verticalLayout, 1, 0);


        verticalLayout.addComponent(buildLoadingBox());
        rssView = new RssView();
        rssView.setWidth(100, Unit.PERCENTAGE);
        verticalLayout.addComponent(rssView);
    }

    private Component buildLoadingBox() {
        url = new TextField();
        url.setPlaceholder("RSS url");
        url.setWidth(300, Unit.PIXELS);
        HorizontalLayout loadingBox = new HorizontalLayout();
        loadingBox.addComponent(url);
        Button loadButton = new Button("Load");
        loadButton.addClickListener(event -> loadRss());
        loadingBox.addComponent(loadButton);

        return loadingBox;
    }

    private void loadRss() {
        if (url.getValue() != null && !url.getValue().isEmpty()) {
            try {
                Rss rss = rssService.getFeed(url.getValue());
                rssView.setRss(rss);
            } catch (MalformedURLException e) {
                Notification.show("Invalid RSS url", "", Notification.Type.ERROR_MESSAGE);
            } catch (Exception e) {
                Notification.show("Unable to load RSS from " + url.getValue(), "", Notification.Type.ERROR_MESSAGE);
            }
        }
    }
}
