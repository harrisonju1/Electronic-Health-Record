export class VisitDetails {
    visit_id:number;
    doctor_id:number;
    patient_id:number;
    diagnoses:string[];
    symptoms:string[];
    prescriptions:string[];
    treatments:string[];
    tests:string[];   

    constructor(
        visit_id:number,
        doctor_id:number,
        patient_id:number,
        diagnoses:string[],
        symptoms:string[],
        prescriptions:string[],
        treatments:string[],
        tests:string[]
    ){
        this.visit_id = visit_id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.diagnoses = diagnoses;
        this.symptoms = symptoms;
        this.prescriptions = prescriptions;
        this.treatments = treatments;
        this.tests = tests;
    }
}