export class ApptRecord {
    visitId:number;
    visitDate:Date;
    patientId:number;
    doctorId:number;
    visitReason:string;

    constructor(
        visitID:number,
        visitDate:Date,
        patientId:number,
        doctorId:number,
        visitReason:string
    ){
        this.visitId = visitID;
        this.visitDate = visitDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitReason = visitReason;
    }
}