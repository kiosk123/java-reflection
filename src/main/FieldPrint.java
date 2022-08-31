package main;

import java.lang.reflect.Field;

public class FieldPrint {
    public static void main(String[] args) {
        Student std = new Student("John", "010-6483-7446", "A");
        
        Class<?> clazz = std.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (var field : fields) {
            System.out.println("Field Name : " + field.getName() + ", Field Type : " + field.getType().getName());
        }
        
        System.out.println("==============");

        fields = clazz.getFields();
        for (var field : fields) {
            System.out.println("Field Name : " + field.getName() + ", Field Type : " + field.getType().getName());
        } 
        
        fields = clazz.getSuperclass().getFields();
        System.out.println("==============");
        
        for (var field: fields) {
            System.out.println("Field Name : " + field.getName() + ", Field Type : " + field.getType().getName());
        }
    }
}
