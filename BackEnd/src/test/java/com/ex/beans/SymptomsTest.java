package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class SymptomsTest {

@Test
public void equalsTest() {
	new Symptoms().equals(null);
}

@Test
public void toStringTest() {
	new Symptoms().toString();
}

@Test
public void hashCodeTest() {
	new Symptoms().hashCode();
}

@Test
public void getSymptom_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("symptom_id");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	int expected = 883210992;
	field.set(inst, expected);
	int result = inst.getSymptom_id();
	Assert.assertEquals(expected, result);
}

@Test
public void getVisitTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("visit");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	com.ex.beans.Visit expected = null;
	field.set(inst, expected);
	com.ex.beans.Visit result = inst.getVisit();
	Assert.assertEquals(expected, result);
}

@Test
public void setSymptom_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("symptom_id");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	int expected = -473752626;
	inst.setSymptom_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	com.ex.beans.PatientProfile expected = null;
	field.set(inst, expected);
	com.ex.beans.PatientProfile result = inst.getPatient();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	com.ex.beans.PatientProfile expected = null;
	inst.setPatient(expected);
	com.ex.beans.PatientProfile result = (com.ex.beans.PatientProfile)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	com.ex.beans.Doctor expected = null;
	field.set(inst, expected);
	com.ex.beans.Doctor result = inst.getDoctor();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	com.ex.beans.Doctor expected = null;
	inst.setDoctor(expected);
	com.ex.beans.Doctor result = (com.ex.beans.Doctor)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setVisitTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("visit");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	com.ex.beans.Visit expected = null;
	inst.setVisit(expected);
	com.ex.beans.Visit result = (com.ex.beans.Visit)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getSymptomsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("symptoms");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	java.lang.String expected = "test string 0.827314";
	field.set(inst, expected);
	java.lang.String result = inst.getSymptoms();
	Assert.assertEquals(expected, result);
}

@Test
public void setSymptomsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Symptoms.class.getDeclaredField("symptoms");
	field.setAccessible(true);
	com.ex.beans.Symptoms inst = new com.ex.beans.Symptoms();
	java.lang.String expected = "test string 0.9603153";
	inst.setSymptoms(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
