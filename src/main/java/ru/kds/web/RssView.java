package ru.kds.web;

import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import ru.kds.service.rss.Item;
import ru.kds.service.rss.Rss;

/**
 * Rss component
 */
public class RssView extends VerticalLayout {

    private static final long serialVersionUID = 2993469206944132074L;

    private Label header;

    private Label description;

    private List<ItemView> items;

    public RssView() {
        this.setVisible(false);
        header = new Label();
        addComponent(header);
        description = new Label();
        addComponent(description);
        items = new ArrayList<>();
    }

    public void setRss(Rss rss) {
        if (rss.getChannel() != null && rss.getChannel().getItems() != null) {
            header.setValue(rss.getChannel().getTitle());
            header.setStyleName("h1");
            description.setValue(rss.getChannel().getDescription());
            description.setStyleName("light");
            items.forEach(this::removeComponent);
            for (Item item : rss.getChannel().getItems()) {
                ItemView itemView = new ItemView(item);
                items.add(itemView);
                addComponent(itemView);
            }
            this.markAsDirtyRecursive();
            this.setVisible(true);
        }
    }

    private static class ItemView extends VerticalLayout {

        private static final long serialVersionUID = -3063877115434251913L;

        private Link title;

        private Label pubDate;

        private Label description;

        public ItemView(Item item) {
            title = new Link();
            title.setWidth("100%");
            addComponent(title);
            pubDate = new Label();
            addComponent(pubDate);
            description = new Label();
            addComponent(description);
            setItem(item);
        }

        public void setItem(Item item) {
            title.setCaption(item.getTitle());
            title.setResource(new ExternalResource(item.getLink()));
            pubDate.setValue(item.getPubDate().format(DateTimeFormatter.RFC_1123_DATE_TIME));
            description.setValue(item.getDescription());
            description.setContentMode(ContentMode.HTML);
            description.setWidth("100%");
            this.markAsDirty();
        }
    }
}
