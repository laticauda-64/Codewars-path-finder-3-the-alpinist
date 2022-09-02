package org.example;

import org.example.foo.Finder;

public class Main {
    public static void main(String[] args) {

        String a = ".W.\n"+
                ".W.\n"+
                "...",

        b = ".W.\n"+
                ".W.\n"+
                "W..",

        d = "......\n"+
                "......\n"+
                "......\n"+
                "......\n"+
                ".....W\n"+
                "....W.";

        System.out.println(Finder.pathFinder(a));
        System.out.println(Finder.pathFinder(b));
        System.out.println(Finder.pathFinder(d));

    }
}

