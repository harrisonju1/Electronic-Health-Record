package com.ex.beans;

import java.util.Date;
import java.util.Objects;

public class VisitInfo {
    public int visit_id;
    public Date visit_date;
    public int patient_id;
    public int doctor_id;
    public String visit_reason;

    public VisitInfo() {
    }
    public VisitInfo(Visit v){
        this.visit_id = v.getVisitId();
        this.visit_date = v.getVisitDate();
        this.patient_id = v.getPatient().getPatientId();
        this.doctor_id = v.getDoctor().getDoctor_id();
        this.visit_reason = v.getVisitReason();
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getVisit_reason() {
        return visit_reason;
    }

    public void setVisit_reason(String visit_reason) {
        this.visit_reason = visit_reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitInfo visitInfo = (VisitInfo) o;
        return visit_id == visitInfo.visit_id &&
                patient_id == visitInfo.patient_id &&
                doctor_id == visitInfo.doctor_id &&
                Objects.equals(visit_date, visitInfo.visit_date) &&
                Objects.equals(visit_reason, visitInfo.visit_reason);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visit_id, visit_date, patient_id, doctor_id, visit_reason);
    }
}
