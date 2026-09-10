package com.example.cli;

import com.example.math.Interval;

public class App {

    public static void main(String[] args) {

        // Uso:
        // App union "[1,3]" "[2,10]"
        // App inter "[1,3]" "[2,10]"
        // App contiene "[1,3]" 2.5
        // App len "[1,3]"

        if (args.length == 0) {
            System.out.println("Uso: union|inter|contiene|len ...");
            return;
        }

        String op = args[0];

        switch (op) {

            case "union" -> {
                var a = Interval.parse(args[1]);
                var b = Interval.parse(args[2]);

                System.out.println(
                        a.union(b)
                                .map(Object::toString)
                                .orElse("∅")
                );
            }

            case "inter" -> {
                var a = Interval.parse(args[1]);
                var b = Interval.parse(args[2]);

                System.out.println(
                        a.intersection(b)
                                .map(Object::toString)
                                .orElse("∅")
                );
            }

            case "contiene" -> {
                var a = Interval.parse(args[1]);
                double x = Double.parseDouble(args[2]);

                System.out.println(a.contains(x));
            }

            case "len" -> {
                var a = Interval.parse(args[1]);

                System.out.println(a.length());
            }

            default -> System.out.println("op no soportada");
        }
    }
}