package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class VisitTest {

@Test
public void equalsTest() {
	new Visit().equals(null);
}

@Test
public void toStringTest() {
	new Visit().toString();
}

@Test
public void hashCodeTest() {
	new Visit().hashCode();
}

@Test
public void getVisit_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("visit_id");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	int expected = 221803429;
	field.set(inst, expected);
	int result = inst.getVisit_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisit_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("visit_id");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	int expected = 661305214;
	inst.setVisit_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisit_dateTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("visit_date");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	java.util.Date expected = null;
	field.set(inst, expected);
	java.util.Date result = inst.getVisit_date();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisit_dateTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("visit_date");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	java.util.Date expected = null;
	inst.setVisit_date(expected);
	java.util.Date result = (java.util.Date)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	com.ex.beans.PatientProfile expected = null;
	field.set(inst, expected);
	com.ex.beans.PatientProfile result = inst.getPatient();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	com.ex.beans.PatientProfile expected = null;
	inst.setPatient(expected);
	com.ex.beans.PatientProfile result = (com.ex.beans.PatientProfile)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	com.ex.beans.Doctor expected = null;
	field.set(inst, expected);
	com.ex.beans.Doctor result = inst.getDoctor();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	com.ex.beans.Doctor expected = null;
	inst.setDoctor(expected);
	com.ex.beans.Doctor result = (com.ex.beans.Doctor)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisit_reasonTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("visit_reason");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	java.lang.String expected = "test string 0.6105007";
	field.set(inst, expected);
	java.lang.String result = inst.getVisit_reason();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisit_reasonTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Visit.class.getDeclaredField("visit_reason");
	field.setAccessible(true);
	com.ex.beans.Visit inst = new com.ex.beans.Visit();
	java.lang.String expected = "test string 0.054064095";
	inst.setVisit_reason(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
