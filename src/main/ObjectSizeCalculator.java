package main;

import java.lang.reflect.Field;

public class ObjectSizeCalculator {
    private static final long HEADER_SIZE = 12;
    private static final long REFERENCE_SIZE = 4;

    public static void main(String[] args) {
        sizeOfObject(new Student("John", "010-6483-7446", "A"));
    }
    
    public static long sizeOfObject(Object input) {
        long size = 0;
        Field[] fields = input.getClass().getDeclaredFields();
        for (var field : fields) {
            field.setAccessible(true);
            if (!field.isSynthetic()) {
                if (field.getType().isPrimitive()) {
                    size += sizeOfPrimitiveType(field.getType());
                } else {
                    try {
                        String value = (String)field.get(input);
                        size += sizeOfString(value);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        size += 0;
                    } 
                }
            }
        }
        return size + HEADER_SIZE + REFERENCE_SIZE;
    }
    
    
/*************** Helper methods ********************************/    
    private static long sizeOfPrimitiveType(Class<?> primitiveType) {
        if (primitiveType.equals(int.class)) {
            return 4;
        } else if (primitiveType.equals(long.class)) {
            return 8;
        } else if (primitiveType.equals(float.class)) {
            return 4;
        } else if (primitiveType.equals(double.class)) {
            return 8;
        } else if (primitiveType.equals(byte.class)) {
            return 1;
        } else if (primitiveType.equals(short.class)) {
            return 2;
        }
        throw new IllegalArgumentException(String.format("Type: %s is not supported", primitiveType));
    }
    
    private static long sizeOfString(String inputString) {
        int stringBytesSize = inputString.getBytes().length;
        return HEADER_SIZE + REFERENCE_SIZE + stringBytesSize;
    }
}