package com.owary.faora.patterns.flyweight;

import java.util.Random;
import java.util.UUID;

/**
 * @author Mensur Owary
 */
public class Image {

    private static final Random random = new Random();

    private long ID;
    private String path;
    private String filename;
    private int width;
    private int height;

    public Image(String path, String filename, int width, int height) {
        this.path = path;
        this.filename = filename;
        this.width = width;
        this.height = height;

        this.ID = random.nextInt(100000);
        System.out.println("Created an instance with ID - "+ID);
    }


}
