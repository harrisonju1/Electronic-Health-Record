package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class VisitDetailsTest {

@Test
public void getDoctor_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	int expected = 495897945;
	field.set(inst, expected);
	int result = inst.getDoctor_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctor_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	int expected = -551797901;
	inst.setDoctor_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatient_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("patient_id");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	int expected = 380999177;
	field.set(inst, expected);
	int result = inst.getPatient_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatient_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("patient_id");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	int expected = 908002404;
	inst.setPatient_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDiagnosisTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("diagnosis");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	field.set(inst, expected);
	java.util.List result = inst.getDiagnosis();
	Assert.assertEquals(expected, result);
}

@Test
public void setDiagnosisTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("diagnosis");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	inst.setDiagnosis(expected);
	java.util.List result = (java.util.List)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getSymptomsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("symptoms");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	field.set(inst, expected);
	java.util.List result = inst.getSymptoms();
	Assert.assertEquals(expected, result);
}

@Test
public void setSymptomsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("symptoms");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	inst.setSymptoms(expected);
	java.util.List result = (java.util.List)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPrescriptionsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("prescriptions");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	field.set(inst, expected);
	java.util.List result = inst.getPrescriptions();
	Assert.assertEquals(expected, result);
}

@Test
public void setPrescriptionsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("prescriptions");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	inst.setPrescriptions(expected);
	java.util.List result = (java.util.List)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getTreatmentsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("treatments");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	field.set(inst, expected);
	java.util.List result = inst.getTreatments();
	Assert.assertEquals(expected, result);
}

@Test
public void setTreatmentsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("treatments");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	inst.setTreatments(expected);
	java.util.List result = (java.util.List)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setTestsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("tests");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	inst.setTests(expected);
	java.util.List result = (java.util.List)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisit_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("visit_id");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	int expected = 380271533;
	field.set(inst, expected);
	int result = inst.getVisit_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisit_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("visit_id");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	int expected = 1191029659;
	inst.setVisit_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getTestsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitDetails.class.getDeclaredField("tests");
	field.setAccessible(true);
	com.ex.beans.VisitDetails inst = new com.ex.beans.VisitDetails();
	java.util.List expected = null;
	field.set(inst, expected);
	java.util.List result = inst.getTests();
	Assert.assertEquals(expected, result);
}
}
