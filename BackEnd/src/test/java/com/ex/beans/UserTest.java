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
public void getPasswordTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("password");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.14908606";
	field.set(inst, expected);
	java.lang.String result = inst.getPassword();
	Assert.assertEquals(expected, result);
}

@Test
public void getEmployeeIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("employeeId");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	int expected = 44013684;
	field.set(inst, expected);
	int result = inst.getEmployeeId();
	Assert.assertEquals(expected, result);
}

@Test
public void getFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("firstName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.5975782";
	field.set(inst, expected);
	java.lang.String result = inst.getFirstName();
	Assert.assertEquals(expected, result);
}

@Test
public void setFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("firstName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.81849235";
	inst.setFirstName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setRoleTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("role");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.9924548";
	inst.setRole(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setUsernameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("username");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.53521645";
	inst.setUsername(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("lastName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.07205945";
	field.set(inst, expected);
	java.lang.String result = inst.getLastName();
	Assert.assertEquals(expected, result);
}

@Test
public void setLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("lastName");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.8402856";
	inst.setLastName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getUsernameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("username");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.08607972";
	field.set(inst, expected);
	java.lang.String result = inst.getUsername();
	Assert.assertEquals(expected, result);
}

@Test
public void setEmployeeIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("employeeId");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	int expected = -1734960812;
	inst.setEmployeeId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setPasswordTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("password");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.48177737";
	inst.setPassword(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getRoleTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.User.class.getDeclaredField("role");
	field.setAccessible(true);
	com.ex.beans.User inst = new com.ex.beans.User();
	java.lang.String expected = "test string 0.6412445";
	field.set(inst, expected);
	java.lang.String result = inst.getRole();
	Assert.assertEquals(expected, result);
}
}
