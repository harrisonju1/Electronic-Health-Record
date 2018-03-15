export enum UserRole {
    NONE = 1,
    PATIENT = 2,
    DOCTOR = 4,
    ADMIN = 8,
}

export class User {
    id: number;
    username: string;
    password:string;
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