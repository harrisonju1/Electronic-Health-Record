package com.ex.beans;

import com.ex.beans.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class VisitInfoTest {

@Test
public void equalsTest() {
	new VisitInfo().equals(null);
}

@Test
public void hashCodeTest() {
	new VisitInfo().hashCode();
}

@Test
public void getVisit_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("visit_id");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	int expected = -2128293019;
	field.set(inst, expected);
	int result = inst.getVisit_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisit_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("visit_id");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	int expected = -1080462153;
	inst.setVisit_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisit_dateTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("visit_date");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	java.util.Date expected = null;
	field.set(inst, expected);
	java.util.Date result = inst.getVisit_date();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisit_dateTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("visit_date");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	java.util.Date expected = null;
	inst.setVisit_date(expected);
	java.util.Date result = (java.util.Date)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getPatient_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("patient_id");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	int expected = 55302268;
	field.set(inst, expected);
	int result = inst.getPatient_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setPatient_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("patient_id");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	int expected = -641138406;
	inst.setPatient_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getDoctor_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	int expected = 2117953359;
	field.set(inst, expected);
	int result = inst.getDoctor_id();
	Assert.assertEquals(expected, result);
}

@Test
public void setDoctor_idTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("doctor_id");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	int expected = -658638945;
	inst.setDoctor_id(expected);
	int result = (int)field.get(inst);
	Assert.assertEquals(expected, result);
}

@Test
public void getVisit_reasonTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("visit_reason");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	java.lang.String expected = "test string 0.10650903";
	field.set(inst, expected);
	java.lang.String result = inst.getVisit_reason();
	Assert.assertEquals(expected, result);
}

@Test
public void setVisit_reasonTest() throws NoSuchFieldException, IllegalAccessException {
	Field field = com.ex.beans.VisitInfo.class.getDeclaredField("visit_reason");
	field.setAccessible(true);
	com.ex.beans.VisitInfo inst = new com.ex.beans.VisitInfo();
	java.lang.String expected = "test string 0.3525449";
	inst.setVisit_reason(expected);
	java.lang.String result = (java.lang.String)field.get(inst);
	Assert.assertEquals(expected, result);
}
}
