package com.owary.faora.patterns.flyweight;

import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

/**
 * @author Mensur Owary
 */
public class ImageService {

    private static Map<String, Image> pathImageInstance = new WeakHashMap<>();
    private static Random random = new Random();

    public static Image loadImage(String path){
        if (pathImageInstance.containsKey(path)) {
            return pathImageInstance.get(path);
        }else{
            String[] parts = path.split("\\\\");
            String filename = parts[parts.length-1];
            Image image = new Image(path, filename, random.nextInt(1000), random.nextInt(1000));
            pathImageInstance.put(path, image);
            return image;
        }
    }

    public static int getTotalInstanceCount() {
        return pathImageInstance.size();
    }


}
