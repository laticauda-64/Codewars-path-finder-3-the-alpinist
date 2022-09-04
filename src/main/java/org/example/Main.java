package org.example;

import org.example.foo.Finder;

public class Main {
    public static void main(String[] args) {

     String     a = "000\n"+
                    "000\n"+
                    "000",

                b = "010\n"+
                    "010\n"+
                    "010",

                c = "010\n"+
                    "101\n"+
                    "010",

                d = "0707\n"+
                    "7070\n"+
                    "0707\n"+
                    "7070",

                e = "700000\n"+
                    "077770\n"+
                    "077770\n"+
                    "077770\n"+
                    "077770\n"+
                    "000007",

                f = "777000\n"+
                    "007000\n"+
                    "007000\n"+
                    "007000\n"+
                    "007000\n"+
                    "007777",

                g = "000000\n"+
                    "000000\n"+
                    "000000\n"+
                    "000010\n"+
                    "000109\n"+
                    "001010";

        System.out.println(Finder.pathFinder(a));
        System.out.println(Finder.pathFinder(b));
        System.out.println(Finder.pathFinder(c));
        System.out.println(Finder.pathFinder(d));
        System.out.println(Finder.pathFinder(e));
        System.out.println(Finder.pathFinder(f));
        System.out.println(Finder.pathFinder(g));

    }
}

