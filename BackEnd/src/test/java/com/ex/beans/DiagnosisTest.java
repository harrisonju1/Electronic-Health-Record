package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class DiagnosisTest {

@Test
public void equalsTest() {
	new Diagnosis().equals(null);
}

@Test
public void toStringTest() {
	new Diagnosis().toString();
}

@Test
public void hashCodeTest() {
	new Diagnosis().hashCode();
}

@Test
public void getDiagnosis_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("diagnosis_id");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	int expected = -1459272421;
	field.set(inst, expected);
	int result = inst.getDiagnosis_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setDiagnosis_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("diagnosis_id");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	int expected = 274672930;
	inst.setDiagnosis_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	com.ex.beans.PatientProfile expected = null;
	field.set(inst, expected);
	com.ex.beans.PatientProfile result = inst.getPatient();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatientTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("patient");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	com.ex.beans.PatientProfile expected = null;
	inst.setPatient(expected);
	com.ex.beans.PatientProfile result = (com.ex.beans.PatientProfile)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	com.ex.beans.Doctor expected = null;
	field.set(inst, expected);
	com.ex.beans.Doctor result = inst.getDoctor();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	com.ex.beans.Doctor expected = null;
	inst.setDoctor(expected);
	com.ex.beans.Doctor result = (com.ex.beans.Doctor)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisitTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("visit");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	com.ex.beans.Visit expected = null;
	field.set(inst, expected);
	com.ex.beans.Visit result = inst.getVisit();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisitTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("visit");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	com.ex.beans.Visit expected = null;
	inst.setVisit(expected);
	com.ex.beans.Visit result = (com.ex.beans.Visit)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDiagnosisTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("diagnosis");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	java.lang.String expected = "test string 0.26111108";
	field.set(inst, expected);
	java.lang.String result = inst.getDiagnosis();
	Assert.assertEquals(expected, result);
}

@Test
public void setDiagnosisTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.Diagnosis.class.getDeclaredField("diagnosis");
	field.setAccessible(true);
	com.ex.beans.Diagnosis inst = new com.ex.beans.Diagnosis();
	java.lang.String expected = "test string 0.78324";
	inst.setDiagnosis(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
