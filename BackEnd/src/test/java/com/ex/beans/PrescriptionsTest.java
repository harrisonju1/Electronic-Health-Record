package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class PrescriptionsTest {

@Test
public void equalsTest() {
	new Prescriptions().equals(null);
}

@Test
public void toStringTest() {
	new Prescriptions().toString();
}

@Test
public void hashCodeTest() {
	new Prescriptions().hashCode();
}

@Test
public void getPrescription_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("prescription_id");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	int expected = -1760353813;
	field.set(inst, expected);
	int result = inst.getPrescription_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setPrescription_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("prescription_id");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	int expected = -1607873260;
	inst.setPrescription_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	com.ex.beans.PatientProfile expected = null;
	field.set(inst, expected);
	com.ex.beans.PatientProfile result = inst.getPatient();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	com.ex.beans.PatientProfile expected = null;
	inst.setPatient(expected);
	com.ex.beans.PatientProfile result = (com.ex.beans.PatientProfile)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	com.ex.beans.Doctor expected = null;
	field.set(inst, expected);
	com.ex.beans.Doctor result = inst.getDoctor();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	com.ex.beans.Doctor expected = null;
	inst.setDoctor(expected);
	com.ex.beans.Doctor result = (com.ex.beans.Doctor)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisitTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("visit");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	com.ex.beans.Visit expected = null;
	field.set(inst, expected);
	com.ex.beans.Visit result = inst.getVisit();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisitTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("visit");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	com.ex.beans.Visit expected = null;
	inst.setVisit(expected);
	com.ex.beans.Visit result = (com.ex.beans.Visit)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDrugsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("drugs");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	java.lang.String expected = "test string 0.6387345";
	field.set(inst, expected);
	java.lang.String result = inst.getDrugs();
	Assert.assertEquals(expected, result);
}

@Test
public void setDrugsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Prescriptions.class.getDeclaredField("drugs");
	field.setAccessible(true);
	com.ex.beans.Prescriptions inst = new com.ex.beans.Prescriptions();
	java.lang.String expected = "test string 0.48587656";
	inst.setDrugs(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
