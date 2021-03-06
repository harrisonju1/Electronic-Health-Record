export enum UserRole {
    NONE = "",
    PATIENT = "PATIENT",
    DOCTOR = "DOCTOR",
    ADMIN = "ADMIN",
}

export class User {
    id: number;
    username: string;
    password: string;
    first_name: string;
    last_name: string;
    role: UserRole;

    // constructor(
    //     id: number,
    //     username: string,
    //     password:string,
    //     first_name: string,
    //     last_name: string,
    //     role: string
    // ){
    //     this.id = id;
    //     this.username = username;
    //     this.password = password;
    //     this.first_name = first_name;
    //     this.last_name = last_name;
    //     this.role = role;
    // }
}