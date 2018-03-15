package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class PatientHistoryTest {

@Test
public void equalsTest() {
	new PatientHistory().equals(null);
}

@Test
public void toStringTest() {
	new PatientHistory().toString();
}

@Test
public void hashCodeTest() {
	new PatientHistory().hashCode();
}

@Test
public void getHistoryIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("historyId");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	int expected = 221777901;
	field.set(inst, expected);
	int result = inst.getHistoryId();
	Assert.assertEquals(expected, result);
}

@Test
public void setHistoryIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("historyId");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	int expected = 614141706;
	inst.setHistoryId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatientIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("patientId");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	int expected = 1009002851;
	field.set(inst, expected);
	int result = inst.getPatientId();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatientIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("patientId");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	int expected = -853820223;
	inst.setPatientId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctorIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("doctorId");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	int expected = -137756105;
	field.set(inst, expected);
	int result = inst.getDoctorId();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctorIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("doctorId");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	int expected = -1700096108;
	inst.setDoctorId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("firstName");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String expected = "test string 0.7460709";
	field.set(inst, expected);
	java.lang.String result = inst.getFirstName();
	Assert.assertEquals(expected, result);
}

@Test
public void setFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("firstName");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String expected = "test string 0.69239986";
	inst.setFirstName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("lastName");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String expected = "test string 0.7950679";
	field.set(inst, expected);
	java.lang.String result = inst.getLastName();
	Assert.assertEquals(expected, result);
}

@Test
public void setLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("lastName");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String expected = "test string 0.017451763";
	inst.setLastName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getAgeTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("age");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	int expected = -837082829;
	field.set(inst, expected);
	int result = inst.getAge();
	Assert.assertEquals(expected, result);
}

@Test
public void setAgeTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("age");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	int expected = -670532639;
	inst.setAge(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getAllergiesTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("allergies");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String[] expected = null;
	field.set(inst, expected);
	java.lang.String[] result = inst.getAllergies();
	Assert.assertEquals(expected, result);
}

@Test
public void setAllergiesTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("allergies");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String[] expected = null;
	inst.setAllergies(expected);
	java.lang.String[] result = (java.lang.String[])field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisitReasonTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("visitReason");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String expected = "test string 0.5868852";
	field.set(inst, expected);
	java.lang.String result = inst.getVisitReason();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisitReasonTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("visitReason");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String expected = "test string 0.579161";
	inst.setVisitReason(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getSymptomsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("symptoms");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	org.json.simple.JSONObject expected = null;
	field.set(inst, expected);
	org.json.simple.JSONObject result = inst.getSymptoms();
	Assert.assertEquals(expected, result);
}

@Test
public void setSymptomsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("symptoms");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	org.json.simple.JSONObject expected = null;
	inst.setSymptoms(expected);
	org.json.simple.JSONObject result = (org.json.simple.JSONObject)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getTestsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("tests");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	org.json.simple.JSONObject expected = null;
	field.set(inst, expected);
	org.json.simple.JSONObject result = inst.getTests();
	Assert.assertEquals(expected, result);
}

@Test
public void setTestsTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("tests");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	org.json.simple.JSONObject expected = null;
	inst.setTests(expected);
	org.json.simple.JSONObject result = (org.json.simple.JSONObject)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getTreatmentHistoryTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("treatmentHistory");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	org.json.simple.JSONObject expected = null;
	field.set(inst, expected);
	org.json.simple.JSONObject result = inst.getTreatmentHistory();
	Assert.assertEquals(expected, result);
}

@Test
public void setTreatmentHistoryTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("treatmentHistory");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	org.json.simple.JSONObject expected = null;
	inst.setTreatmentHistory(expected);
	org.json.simple.JSONObject result = (org.json.simple.JSONObject)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDrugHistoryTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("drugHistory");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	org.json.simple.JSONObject expected = null;
	field.set(inst, expected);
	org.json.simple.JSONObject result = inst.getDrugHistory();
	Assert.assertEquals(expected, result);
}

@Test
public void setDrugHistoryTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("drugHistory");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	org.json.simple.JSONObject expected = null;
	inst.setDrugHistory(expected);
	org.json.simple.JSONObject result = (org.json.simple.JSONObject)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getCurrentPrescriptionTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("currentPrescription");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String expected = "test string 0.382832";
	field.set(inst, expected);
	java.lang.String result = inst.getCurrentPrescription();
	Assert.assertEquals(expected, result);
}

@Test
public void setCurrentPrescriptionTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientHistory.class.getDeclaredField("currentPrescription");
	field.setAccessible(true);
	com.ex.beans.PatientHistory inst = new com.ex.beans.PatientHistory();
	java.lang.String expected = "test string 0.43005365";
	inst.setCurrentPrescription(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
