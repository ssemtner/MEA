package com.mymealiving;

import javafx.fxml.FXMLLoader;

public class Options {
    public static boolean isFontLarge, isFontSmall = false;
    public static boolean isFontMedium = true;

    public static final int[] mediumFontSizes = new int[]{ 64, 40, 38, 36, 24, 20, 18, 16 };
    public static final int[] largeFontSizes = new int[]{ 64, 40, 38, 36, 24, 20, 18, 16 };
    public static final int[] smallFontSizes = new int[]{ 64, 40, 38, 36, 24, 20, 18, 16 };

//    public static void putFonts(FXMLLoader loader, char fSize) {
//        int[] sizes;
//        switch (fSize) {
//            case 'l':
//                sizes = largeFontSizes;
//                break;
//            case 's':
//                sizes = smallFontSizes;
//                break;
//            default:
//                sizes = mediumFontSizes;
//        }
//
//        for (int i = 0; i < 8; i++) {
//            loader.getNamespace().put("f" + (i + 1), Integer.toString(sizes[i]));
//            System.out.println("f" + (i + 1) + "   |   " + Integer.toString(sizes[i]));
//        }
//    }
}
