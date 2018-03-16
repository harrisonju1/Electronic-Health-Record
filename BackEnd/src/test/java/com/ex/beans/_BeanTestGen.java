package com.ex.beans;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Random;

public class _BeanTestGen {
    public static void main(String[] args) {
//        GenTestFor(User.class);
    }
    static void GenTestFor(Class bean) {
        System.out.println("generating test for "+bean.getName());
        StringBuilder testText = new StringBuilder();
        String className = bean.getSimpleName();
        testText.append("package com.ex.beans;\n\nimport com.ex.beans.*;\nimport org.junit.*;\nimport java.util.ArrayList;\nimport java.util.List;\nimport java.lang.reflect.Field;\n\n");
        testText.append("public class "+className+"Test {\n");

        Method[] declaredMethods = bean.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            testText.append("\n@Test\npublic void "+declaredMethods[i].getName()+"Test() ");
            if (declaredMethods[i].getName().contains("get") || declaredMethods[i].getName().contains("set")) {
                testText.append("throws NoSuchFieldException, IllegalAccessException {\n");
                String fieldName = declaredMethods[i].getName().replace("get", "").replace("set", "");
                fieldName = fieldName.substring(0,1).toLowerCase() + fieldName.substring(1);
                Type fieldType = null;
                try {
                    fieldType = bean.getDeclaredField(fieldName).getType();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                String fieldTypeName = fieldType.getTypeName().replace("$", ".");
                testText.append("\tField field = "+bean.getName()+".class.getDeclaredField(\""+fieldName+"\");\n");
                testText.append("\tfield.setAccessible(true);\n");
                testText.append("\t"+bean.getName() + " inst = new "+bean.getName()+"();\n");
                testText.append("\t"+fieldTypeName+" expected = "+getTestValueForType(fieldType)+";\n");
                if (declaredMethods[i].getName().contains("get")) {
                    testText.append("\tfield.set(inst, expected);\n");
                    testText.append("\t"+fieldTypeName+" result = inst."+declaredMethods[i].getName()+"();\n");
                }
                else {
                    testText.append("\tinst."+declaredMethods[i].getName()+"(expected);\n");
                    testText.append("\t"+fieldTypeName+" result = ("+fieldTypeName+")field.get(inst);\n");
                }
                testText.append("\tAssert.assertEquals(expected, result"+(fieldTypeName.equals("double")?", 0":"")+");\n");
            } else {
                testText.append("{\n");
                String nullParams = "";
                for (int j = 0; j <declaredMethods[i].getParameterCount(); j++) {
                    nullParams+=getTestValueForType(declaredMethods[i].getGenericParameterTypes()[j]);
                    if (j!=declaredMethods[i].getParameterCount()-1)
                        nullParams+=", ";
                }
                testText.append("\tnew "+className+"(" + ")."+declaredMethods[i].getName()+"(" +nullParams + ");\n");
            }
            testText.append("}\n");
        }
        testText.append("}\n");
        String filename = "src/test/java/com/ex/beans/"+className+"Test.java";
        try {
            FileWriter fileWriter = new FileWriter(filename, false);
            fileWriter.write(testText.toString());
            fileWriter.close();
            System.out.println("made file: "+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String getTestValueForType(Type type) {
        if (type.getTypeName().equals("int"))
            return String.valueOf(new Random().nextInt());
        if (type.getTypeName().equals("double"))
            return String.valueOf(new Random().nextDouble());
        if (type.getTypeName().equals("java.lang.String"))
            return String.valueOf("\"test string "+new Random().nextFloat()+"\"");
        if (type.getTypeName().equals("java.sql.Date"))
            return String.valueOf("java.sql.Date.valueOf(java.time.LocalDate.now())");
        if (type.getTypeName().equals("java.sql.Time"))
            return String.valueOf("java.sql.Time.valueOf(java.time.LocalTime.now())");
        if (type.getTypeName().equals("byte[]"))
            return String.valueOf("new byte[]{1,2,3}");
//        System.out.println(""+type.getTypeName());
        return "null";
    }
}
