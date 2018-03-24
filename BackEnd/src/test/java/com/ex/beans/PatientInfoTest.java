package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class PatientInfoTest {

@Test
public void equalsTest() {
	new PatientInfo().equals(null);
}

@Test
public void toStringTest() {
	new PatientInfo().toString();
}

@Test
public void hashCodeTest() {
	new PatientInfo().hashCode();
}

@Test
public void getAddressTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("address");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.7560724";
	field.set(inst, expected);
	java.lang.String result = inst.getAddress();
	Assert.assertEquals(expected, result);
}

@Test
public void getStateTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("state");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.034534633";
	field.set(inst, expected);
	java.lang.String result = inst.getState();
	Assert.assertEquals(expected, result);
}

@Test
public void getSsnTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("ssn");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = -1521611492;
	field.set(inst, expected);
	int result = inst.getSsn();
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctor_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = 398413494;
	field.set(inst, expected);
	int result = inst.getDoctor_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctor_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = 216179849;
	inst.setDoctor_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatient_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("patient_id");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = 480819139;
	field.set(inst, expected);
	int result = inst.getPatient_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatient_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("patient_id");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = 2114645075;
	inst.setPatient_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	com.ex.beans.Doctor expected = null;
	field.set(inst, expected);
	com.ex.beans.Doctor result = inst.getDoctor();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctorTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("doctor");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	com.ex.beans.Doctor expected = null;
	inst.setDoctor(expected);
	com.ex.beans.Doctor result = (com.ex.beans.Doctor)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getFirst_nameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("first_name");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.53503495";
	field.set(inst, expected);
	java.lang.String result = inst.getFirst_name();
	Assert.assertEquals(expected, result);
}

@Test
public void setFirst_nameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("first_name");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.7604701";
	inst.setFirst_name(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getLast_nameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("last_name");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.90635914";
	field.set(inst, expected);
	java.lang.String result = inst.getLast_name();
	Assert.assertEquals(expected, result);
}

@Test
public void setLast_nameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("last_name");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.90172523";
	inst.setLast_name(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setSsnTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("ssn");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = -1623198364;
	inst.setSsn(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDobTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("dob");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.util.Date expected = null;
	field.set(inst, expected);
	java.util.Date result = inst.getDob();
	Assert.assertEquals(expected, result);
}

@Test
public void setDobTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("dob");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.util.Date expected = null;
	inst.setDob(expected);
	java.util.Date result = (java.util.Date)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPhone_numberTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("phone_number");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.57085544";
	field.set(inst, expected);
	java.lang.String result = inst.getPhone_number();
	Assert.assertEquals(expected, result);
}

@Test
public void setPhone_numberTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("phone_number");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.23940492";
	inst.setPhone_number(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getEmailTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("email");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.9717215";
	field.set(inst, expected);
	java.lang.String result = inst.getEmail();
	Assert.assertEquals(expected, result);
}

@Test
public void setEmailTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("email");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.10407275";
	inst.setEmail(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getMarital_statusTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("marital_status");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.9821199";
	field.set(inst, expected);
	java.lang.String result = inst.getMarital_status();
	Assert.assertEquals(expected, result);
}

@Test
public void setMarital_statusTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("marital_status");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.8081352";
	inst.setMarital_status(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getGenderTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("gender");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.86587536";
	field.set(inst, expected);
	java.lang.String result = inst.getGender();
	Assert.assertEquals(expected, result);
}

@Test
public void setGenderTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("gender");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.46519285";
	inst.setGender(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getEthnicityTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("ethnicity");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.6879162";
	field.set(inst, expected);
	java.lang.String result = inst.getEthnicity();
	Assert.assertEquals(expected, result);
}

@Test
public void setEthnicityTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("ethnicity");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.44436467";
	inst.setEthnicity(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getOccupationTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("occupation");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.7815664";
	field.set(inst, expected);
	java.lang.String result = inst.getOccupation();
	Assert.assertEquals(expected, result);
}

@Test
public void setOccupationTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("occupation");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.55397785";
	inst.setOccupation(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getCityTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("city");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.5535063";
	field.set(inst, expected);
	java.lang.String result = inst.getCity();
	Assert.assertEquals(expected, result);
}

@Test
public void setCityTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("city");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.51604754";
	inst.setCity(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setStateTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("state");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.8482351";
	inst.setState(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getZipcodeTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("zipcode");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = 142891021;
	field.set(inst, expected);
	int result = inst.getZipcode();
	Assert.assertEquals(expected, result);
}

@Test
public void setZipcodeTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("zipcode");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = 1608675237;
	inst.setZipcode(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getInsurance_providerTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("insurance_provider");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.09748429";
	field.set(inst, expected);
	java.lang.String result = inst.getInsurance_provider();
	Assert.assertEquals(expected, result);
}

@Test
public void setInsurance_providerTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("insurance_provider");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.05999607";
	inst.setInsurance_provider(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getInsurance_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("insurance_id");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = 794635392;
	field.set(inst, expected);
	int result = inst.getInsurance_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setInsurance_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("insurance_id");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	int expected = 129078072;
	inst.setInsurance_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setAddressTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.PatientInfo.class.getDeclaredField("address");
	field.setAccessible(true);
	com.ex.beans.PatientInfo inst = new com.ex.beans.PatientInfo();
	java.lang.String expected = "test string 0.86784655";
	inst.setAddress(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
