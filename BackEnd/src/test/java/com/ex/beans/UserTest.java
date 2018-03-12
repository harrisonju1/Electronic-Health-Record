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
	int expected = -1402329482;
	field.set(inst, expected);
	int result = inst.getId();
	Assert.assertEquals(expected, result);
}

@Test
public void getPasswordTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("password");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.6154956";
	field.set(inst, expected);
	java.lang.String result = inst.getPassword();
	Assert.assertEquals(expected, result);
}

@Test
public void setPasswordTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("password");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.098624945";
	inst.setPassword(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("firstName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.60209376";
	field.set(inst, expected);
	java.lang.String result = inst.getFirstName();
	Assert.assertEquals(expected, result);
}

@Test
public void setFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("firstName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.062405586";
	inst.setFirstName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("lastName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.95573545";
	field.set(inst, expected);
	java.lang.String result = inst.getLastName();
	Assert.assertEquals(expected, result);
}

@Test
public void setIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("id");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	int expected = 1502584926;
	inst.setId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getUsernameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("username");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.8518651";
	field.set(inst, expected);
	java.lang.String result = inst.getUsername();
	Assert.assertEquals(expected, result);
}

@Test
public void setUsernameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("username");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.8097102";
	inst.setUsername(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getRoleTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("role");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.98702407";
	field.set(inst, expected);
	java.lang.String result = inst.getRole();
	Assert.assertEquals(expected, result);
}

@Test
public void setRoleTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("role");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.054679394";
	inst.setRole(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("lastName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.82622224";
	inst.setLastName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
