package main;

import java.lang.reflect.Array;

public class ArrayReflection {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        if (arr.getClass().isArray()) {
            System.out.println("===== is Array =====");
            Class<?> clazz = arr.getClass().getComponentType();
            int len = Array.getLength(arr);

            for (int i = 0; i < len; i++) {
                System.out.println(Array.get(arr, i));
            }
        }
    }

    public Object getArrayEliment(Object array, int index) {
        int len = Array.getLength(array);
        index = (index < 0) ? len + index : index;
        return Array.get(array, index);
    }
}
