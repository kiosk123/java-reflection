package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Class<String> stringClass = String.class;

        Map<String, Integer> mapObject = new HashMap<>();

        Class<?> hashMapClass = mapObject.getClass();

        // Nested 클래스에 접근할때 Nested 클래스 앞에 $를 붙인다
        Class<?> squareClass = Class.forName("main.App$Square");

        printClassInfo(stringClass, hashMapClass, squareClass);

        Drawable circleObject = () -> { return 0; }; // anonymous false -> 람다식 사용시 결과
        var circleObject2 = new Drawable() { // anonymous true
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };

        printClassInfo2(Collection.class, boolean.class, int[][].class, Color.class, circleObject.getClass(), circleObject2.getClass());

    }

    private static void printClassInfo(Class<?> ... classes) {
        for (Class<?> clazz : classes) {
            System.out.println(String.format("class name : %s, class package name : %s",
                clazz.getSimpleName(),
                clazz.getPackageName()));

            Class<?> [] implementedInterfaces = clazz.getInterfaces();
            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(String.format("class %s implements : %s", 
                    clazz.getSimpleName(),
                    implementedInterface.getSimpleName()));
            }

            System.out.println();
            System.out.println();
        }
    }

    private static void printClassInfo2(Class<?> ... classes) {
        for (Class<?> clazz : classes) {
            System.out.println(String.format("class name : %s, class package name : %s",
                clazz.getSimpleName(),
                clazz.getPackageName()));

            Class<?> [] implementedInterfaces = clazz.getInterfaces();
            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(String.format("class %s implements : %s", 
                    clazz.getSimpleName(),
                    implementedInterface.getSimpleName()));
            }

            System.out.println("Is array : " + clazz.isArray());
            System.out.println("Is primitive : " + clazz.isPrimitive());
            System.out.println("Is enum : " + clazz.isEnum());
            System.out.println("Is interface : " + clazz.isInterface());
            System.out.println("Is anonymous : " + clazz.isAnonymousClass());

            System.out.println();
            System.out.println();
        }
    }

    private static class Square implements Drawable {
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }
}
