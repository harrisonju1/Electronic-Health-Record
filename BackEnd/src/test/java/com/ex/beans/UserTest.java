package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class UserTest {

@Test
public void equalsTest() {
	new User().equals(null);
}

@Test
public void toStringTest() {
	new User().toString();
}

@Test
public void hashCodeTest() {
	new User().hashCode();
}

@Test
public void getIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("id");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	int expected = 823037035;
	field.set(inst, expected);
	int result = inst.getId();
	Assert.assertEquals(expected, result);
}

@Test
public void getPasswordTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("password");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.7250144";
	field.set(inst, expected);
	java.lang.String result = inst.getPassword();
	Assert.assertEquals(expected, result);
}

@Test
public void getLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("lastName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.047386944";
	field.set(inst, expected);
	java.lang.String result = inst.getLastName();
	Assert.assertEquals(expected, result);
}

@Test
public void setIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("id");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	int expected = -176001333;
	inst.setId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setRoleTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("role");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.50172824";
	inst.setRole(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setPasswordTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("password");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.044198453";
	inst.setPassword(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getUsernameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("username");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.56159925";
	field.set(inst, expected);
	java.lang.String result = inst.getUsername();
	Assert.assertEquals(expected, result);
}

@Test
public void getFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("firstName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.79567146";
	field.set(inst, expected);
	java.lang.String result = inst.getFirstName();
	Assert.assertEquals(expected, result);
}

@Test
public void setFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("firstName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.43739152";
	inst.setFirstName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("lastName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.98697656";
	inst.setLastName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getRoleTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("role");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.37411046";
	field.set(inst, expected);
	java.lang.String result = inst.getRole();
	Assert.assertEquals(expected, result);
}

@Test
public void setUsernameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("username");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.71746635";
	inst.setUsername(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
