package com.owary.faora.algorithms.multimedia.median_cut;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MedianCutAlgorithm {

    public static List<List<Color>> buckets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // read the image
        BufferedImage img = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResourceAsStream("img.jpg")));

        int pixel, red, green, blue;
        int h = img.getHeight(), w = img.getWidth();

        List<Color> colors = new ArrayList<>();

        // collect all the pixels
        for(int yy = 0 ; yy < h; yy++) {
            for (int xx = 0; xx < w; xx++) {
                pixel = img.getRGB(xx, yy);
                red = (pixel >> 16) & 0x0ff;
                green = (pixel >> 8) & 0x0ff;
                blue = (pixel) & 0x0ff;

                colors.add(new Color(red, green, blue));
            }
        }

        // perform median cut
        medianCut(colors, 4);

        System.out.println(buckets.size());

        // sort by luminance
        List<Color> collect = buckets.stream()
                .map(MedianCutAlgorithm::average)
                .sorted(Comparator.comparing(MedianCutAlgorithm::findLuminance))
                .collect(Collectors.toList());

        // logging
        collect.forEach(e -> {
            System.out.printf("{red:%d, green:%d, blue:%d}\n", e.getRed(), e.getGreen(), e.getBlue());
        });

        // show it in GUI
        new Visualizer(collect);

    }

    /**
     * Finds the brightness of the color
     * @param color input color
     * @return brightness of the color
     */
    public static double findLuminance(Color color){
        int red = color.getRed();
        int blue = color.getBlue();
        int green = color.getGreen();
        return 0.2126 * red + 0.7152 * green + 0.0722 * blue;
    }

    /**
     * This method averages the colors in the color list
     * @param colors is the bucket
     * @return averaged color
     */
    public static Color average(List<Color> colors) {
        int red=0; int green=0; int blue=0;
        for (Color color : colors) {
            red += color.getRed();
            green += color.getGreen();
            blue += color.getBlue();
        }
        int size = colors.size();
        return new Color(red/size, green/size, blue/size);
    }

    /**
     * Median-cut algorithm.
     * Steps :
     * 1. Get the RGB color array of the image
     * 2. Find the color which has the most range (that is maxColor - minColor range)
     * 3. Sort by the color with the greatest range
     * 4. Divide the array into 2 buckets and perform the same process on them
     * 5. After the partition completes, find the average of the colors in the buckets
     * @param colors - list of colors in the image
     * @param depth - maximum depth
     */
    public static void medianCut(List<Color> colors, int depth){
        if (depth > 0) {
            int red, green, blue;

            int minBlue = 256, maxBlue = -1;
            int minRed = 256, maxRed = -1;
            int minGreen = 256, maxGreen = -1;


            for (Color color : colors) {
                red = color.getRed();
                green = color.getGreen();
                blue = color.getBlue();
                // find max and min of each color
                if (red > maxRed) { maxRed = red;} if (red < minRed) {minRed = red;}
                if (green > maxGreen) { maxGreen = green;} if (green < minGreen) {minGreen = green;}
                if (blue > maxBlue) { maxBlue = blue;} if (blue < minBlue) {minBlue = blue;}
            }

            // find the ranges
            int redRange = maxRed - minRed;
            int greenRange = maxGreen - minGreen;
            int blueRange = maxBlue - minBlue;

            // sort by the greatest ranged color
            if (blueRange > redRange && blueRange > greenRange) {
                colors.sort(Comparator.comparing(Color::getBlue));
            } else if (greenRange > redRange && greenRange > blueRange) {
                colors.sort(Comparator.comparing(Color::getGreen));
            } else if (redRange > blueRange && redRange > greenRange) {
                colors.sort(Comparator.comparing(Color::getRed));
            }

            int size = colors.size();
            // divide the list in 2
            List<Color> colors1 = colors.subList(0, size / 2);
            List<Color> colors2 = colors.subList(size / 2 + 1, size);

            // if we have reached the end of the depth limit, then add the leaves to the bucket
            if (depth == 1) {
                buckets.add(colors1);
                buckets.add(colors2);
            }
            // recursion part
            medianCut(colors1, depth - 1);
            medianCut(colors2, depth - 1);
        }
    }

}
