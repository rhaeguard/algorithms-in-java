package com.owary.faora.patterns.flyweight;

/**
 * @author Mensur Owary
 */
public class Main {

    public static void main(String[] args) {
        // This will only create 5 instances...
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\dog.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\cat.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\pig.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\pigeon.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\mouse.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\dog.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\pig.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\cat.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\dog.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\dog.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\cat.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\pigeon.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\pig.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\mouse.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\dog.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\cat.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\pig.jpg");
        ImageService.loadImage("C:\\algorithms\\src\\main\\resources\\dog.jpg");

        System.out.println(ImageService.getTotalInstanceCount());
    }

}
