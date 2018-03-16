package com.ex.beans;

import org.junit.*;

import java.lang.reflect.Field;

public class patientProfileTest {

@Test
public void equalsTest() {
	new PatientProfile().equals(null);
}

@Test
public void toStringTest() {
	new PatientProfile().toString();
}

@Test
public void hashCodeTest() {
	new PatientProfile().hashCode();
}

@Test
public void getAddressTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("address");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.673778";
	field.set(inst, expected);
	java.lang.String result = inst.getAddress();
	Assert.assertEquals(expected, result);
}

@Test
public void getStateTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("state");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.22667062";
	field.set(inst, expected);
	java.lang.String result = inst.getState();
	Assert.assertEquals(expected, result);
}

@Test
public void getPatientIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("patient_id");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = -77293257;
	field.set(inst, expected);
	int result = inst.getPatientId();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatientIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("patient_id");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = 1314298498;
	inst.setPatientId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctorIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = 2134944539;
	field.set(inst, expected);
	int result = inst.getDoctorId();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctorIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = 2062405886;
	inst.setDoctorId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("firstName");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.96823597";
	field.set(inst, expected);
	java.lang.String result = inst.getFirstName();
	Assert.assertEquals(expected, result);
}

@Test
public void setFirstNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("firstName");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.84833175";
	inst.setFirstName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("lastName");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.46337652";
	field.set(inst, expected);
	java.lang.String result = inst.getLastName();
	Assert.assertEquals(expected, result);
}

@Test
public void setLastNameTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("lastName");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.0024869442";
	inst.setLastName(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getSsnTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("ssn");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = 2137307037;
	field.set(inst, expected);
	int result = inst.getSsn();
	Assert.assertEquals(expected, result);
}

@Test
public void setSsnTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("ssn");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = 1849012168;
	inst.setSsn(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDobTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("dob");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.util.Date expected = null;
	field.set(inst, expected);
	java.util.Date result = inst.getDob();
	Assert.assertEquals(expected, result);
}

@Test
public void setDobTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("dob");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.util.Date expected = null;
	inst.setDob(expected);
	java.util.Date result = (java.util.Date)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPhone_numberTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("phone_number");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = -554519734;
	field.set(inst, expected);
	int result = inst.getPhone_number();
	Assert.assertEquals(expected, result);
}

@Test
public void setPhone_numberTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("phone_number");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = 990243347;
	inst.setPhone_number(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getEmailTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("email");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.88047737";
	field.set(inst, expected);
	java.lang.String result = inst.getEmail();
	Assert.assertEquals(expected, result);
}

@Test
public void setEmailTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("email");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.8532906";
	inst.setEmail(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getMarital_statusTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("marital_status");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.36146134";
	field.set(inst, expected);
	java.lang.String result = inst.getMarital_status();
	Assert.assertEquals(expected, result);
}

@Test
public void setMarital_statusTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("marital_status");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.16380882";
	inst.setMarital_status(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getGenderTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("gender");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.65126574";
	field.set(inst, expected);
	java.lang.String result = inst.getGender();
	Assert.assertEquals(expected, result);
}

@Test
public void setGenderTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("gender");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.79775643";
	inst.setGender(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getEthnicityTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("ethnicity");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.35412836";
	field.set(inst, expected);
	java.lang.String result = inst.getEthnicity();
	Assert.assertEquals(expected, result);
}

@Test
public void setEthnicityTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("ethnicity");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.32053733";
	inst.setEthnicity(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getOccupationTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("occupation");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.18948084";
	field.set(inst, expected);
	java.lang.String result = inst.getOccupation();
	Assert.assertEquals(expected, result);
}

@Test
public void setOccupationTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("occupation");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.14600968";
	inst.setOccupation(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getCityTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("city");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.8770384";
	field.set(inst, expected);
	java.lang.String result = inst.getCity();
	Assert.assertEquals(expected, result);
}

@Test
public void setCityTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("city");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.43077415";
	inst.setCity(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setStateTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("state");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.68789476";
	inst.setState(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getZipcodeTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("zipcode");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = -797481116;
	field.set(inst, expected);
	int result = inst.getZipcode();
	Assert.assertEquals(expected, result);
}

@Test
public void setZipcodeTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("zipcode");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = -2028689366;
	inst.setZipcode(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getInsurance_providerTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("insurance_provider");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.9693048";
	field.set(inst, expected);
	java.lang.String result = inst.getInsurance_provider();
	Assert.assertEquals(expected, result);
}

@Test
public void setInsurance_providerTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("insurance_provider");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.91986203";
	inst.setInsurance_provider(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getInsuranceIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("insurance_id");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = 1035045275;
	field.set(inst, expected);
	int result = inst.getInsuranceId();
	Assert.assertEquals(expected, result);
}

@Test
public void setInsuranceIdTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("insurance_id");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	int expected = 191915541;
	inst.setInsuranceId(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void setAddressTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = PatientProfile.class.getDeclaredField("address");
	field.setAccessible(true);
	PatientProfile inst = new PatientProfile();
	java.lang.String expected = "test string 0.6913258";
	inst.setAddress(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
