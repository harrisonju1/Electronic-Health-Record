export class User {
    id: number;
    username: string;
    first_name: string;
    last_name: string;
    role: string;

    constructor(
        id: number,
        username: string,
        first_name: string,
        last_name: string,
        role: string
    ){
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }
}