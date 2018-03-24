package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class DoctorTest {

@Test
public void equalsTest() {
	new Doctor().equals(null);
}

@Test
public void toStringTest() {
	new Doctor().toString();
}

@Test
public void hashCodeTest() {
	new Doctor().hashCode();
}

@Test
public void getFieldTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Doctor.class.getDeclaredField("field");
	field.setAccessible(true);
	com.ex.beans.Doctor inst = new com.ex.beans.Doctor();
	java.lang.String expected = "test string 0.40988958";
	field.set(inst, expected);
	java.lang.String result = inst.getField();
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctor_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Doctor.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	com.ex.beans.Doctor inst = new com.ex.beans.Doctor();
	int expected = 2122852024;
	field.set(inst, expected);
	int result = inst.getDoctor_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setFieldTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Doctor.class.getDeclaredField("field");
	field.setAccessible(true);
	com.ex.beans.Doctor inst = new com.ex.beans.Doctor();
	java.lang.String expected = "test string 0.7466621";
	inst.setField(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctor_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Doctor.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	com.ex.beans.Doctor inst = new com.ex.beans.Doctor();
	int expected = -2073251026;
	inst.setDoctor_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getFirst_nameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Doctor.class.getDeclaredField("first_name");
	field.setAccessible(true);
	com.ex.beans.Doctor inst = new com.ex.beans.Doctor();
	java.lang.String expected = "test string 0.17554212";
	field.set(inst, expected);
	java.lang.String result = inst.getFirst_name();
	Assert.assertEquals(expected, result);
}

@Test
public void setFirst_nameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Doctor.class.getDeclaredField("first_name");
	field.setAccessible(true);
	com.ex.beans.Doctor inst = new com.ex.beans.Doctor();
	java.lang.String expected = "test string 0.6621856";
	inst.setFirst_name(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getLast_nameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Doctor.class.getDeclaredField("last_name");
	field.setAccessible(true);
	com.ex.beans.Doctor inst = new com.ex.beans.Doctor();
	java.lang.String expected = "test string 0.37889457";
	field.set(inst, expected);
	java.lang.String result = inst.getLast_name();
	Assert.assertEquals(expected, result);
}

@Test
public void setLast_nameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Doctor.class.getDeclaredField("last_name");
	field.setAccessible(true);
	com.ex.beans.Doctor inst = new com.ex.beans.Doctor();
	java.lang.String expected = "test string 0.6467739";
	inst.setLast_name(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
