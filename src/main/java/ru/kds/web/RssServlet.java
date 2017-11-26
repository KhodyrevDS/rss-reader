package ru.kds.web;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import javax.servlet.annotation.WebServlet;

/**
 * Rss servlet
 */
@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(
        productionMode = false,
        ui = RssUI.class)
public class RssServlet extends VaadinServlet {}
