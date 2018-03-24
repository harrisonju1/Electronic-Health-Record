package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class TreatmentsTest {

@Test
public void equalsTest() {
	new Treatments().equals(null);
}

@Test
public void toStringTest() {
	new Treatments().toString();
}

@Test
public void hashCodeTest() {
	new Treatments().hashCode();
}

@Test
public void getDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	com.ex.beans.Doctor expected = null;
	field.set(inst, expected);
	com.ex.beans.Doctor result = inst.getDoctor();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	com.ex.beans.Doctor expected = null;
	inst.setDoctor(expected);
	com.ex.beans.Doctor result = (com.ex.beans.Doctor)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	com.ex.beans.PatientProfile expected = null;
	field.set(inst, expected);
	com.ex.beans.PatientProfile result = inst.getPatient();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	com.ex.beans.PatientProfile expected = null;
	inst.setPatient(expected);
	com.ex.beans.PatientProfile result = (com.ex.beans.PatientProfile)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getTreatmentTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("treatment");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	java.lang.String expected = "test string 0.16965806";
	field.set(inst, expected);
	java.lang.String result = inst.getTreatment();
	Assert.assertEquals(expected, result);
}

@Test
public void setTreatmentTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("treatment");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	java.lang.String expected = "test string 0.7582882";
	inst.setTreatment(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setVisitTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("visit");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	com.ex.beans.Visit expected = null;
	inst.setVisit(expected);
	com.ex.beans.Visit result = (com.ex.beans.Visit)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getTreatment_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("treatment_id");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	int expected = 2076904873;
	field.set(inst, expected);
	int result = inst.getTreatment_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setTreatment_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("treatment_id");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	int expected = 893029131;
	inst.setTreatment_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisitTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Treatments.class.getDeclaredField("visit");
	field.setAccessible(true);
	com.ex.beans.Treatments inst = new com.ex.beans.Treatments();
	com.ex.beans.Visit expected = null;
	field.set(inst, expected);
	com.ex.beans.Visit result = inst.getVisit();
	Assert.assertEquals(expected, result);
}
}
