export class ApptRecord {
    visit_id:number;
    visit_date:Date;
    patient_id:number;
    doctor_id:number;
    visit_reason:string;

    constructor(
        visit_id:number,
        visit_date:Date,
        patient_id:number,
        doctor_id:number,
        visit_reason:string
    ){
        this.visit_id = visit_id;
        this.visit_date = visit_date;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.visit_reason = visit_reason;
    }
}