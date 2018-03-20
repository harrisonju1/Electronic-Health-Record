export class VisitDetails {
    visit_id:number;
    doctor_id:number;
    patient_id:number;
    diagnoses:string;
    symptoms:string[];
    prescriptions:string[];
    treatments:string[];
    tests:string[];   

    constructor(
        visit_id:number,
        doctor_id:number,
        patient_id:number,
        diagnoses:string,
        symptoms:string[],
        prescriptions:string[],
        treatments:string[],
        tests:string[]
    ){

    }
}