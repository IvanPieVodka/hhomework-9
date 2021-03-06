package fmi.informatics.task9;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.Rock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyClass {
    public static void edno() {
        Stream.of(Student.StudentGenerator.make(),
                Student.StudentGenerator.make(),
                Student.StudentGenerator.make())
                .filter(s -> s.getName().length() >= 5)
                .sorted((s2, s1) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);
    }

    public static void dve(){
        Stream.of("Lamborghini", "Ferrari", "Lada", "Chaika")
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void tri(){
        List<Student> studs = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            studs.add(Student.StudentGenerator.make());
        }
        String studNames = studs.stream()
                .sorted((s2, s1) -> s1.getName().compareTo(s2.getName()))
                .map(s -> s.getName())
                .reduce((s1, s2) -> {
                    if (s2 != null) return s1 + ", " + s2;
                    return s1;
                })
                .get();
        System.out.println(studNames);
    }

    public static void chetiri(){
        IntStream.iterate(0, i -> i + 1)
                .skip(5)
                .limit(10)
                .forEach(i -> {
                    if (i % 2 == 0)
                        System.out.println(i);
                });
    }

    public static void pet(){
        Rock rock = new Rock();
        rock.drop(390);
    }
}
