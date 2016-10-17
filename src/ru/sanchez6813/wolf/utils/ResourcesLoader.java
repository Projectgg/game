package ru.sanchez6813.wolf.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Alex on 17.10.2016.
 */
public final class ResourcesLoader {
    private ResourcesLoader() {
        // don't instantiate
    }

    private static final String DRAWABLES_BASE_PATH = "/resources/drawable/";

    public static Image loadDrawableIgnoreErrors(String drawableName) {
        String fullPath = DRAWABLES_BASE_PATH + drawableName;
        try {
            return ImageIO.read(ResourcesLoader.class.getResource(fullPath));
        } catch (IOException e) {
            System.out.println("Failed to load drawable, path=" + fullPath + ", exception=" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}