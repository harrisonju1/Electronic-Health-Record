import { Component, OnInit } from '@angular/core';
import { NgForm, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthorizationService } from '../../services/authorization.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = "test";
  password: string;
  error: string;

  loggedIn: boolean;

  constructor(
    private authService: AuthorizationService
  ) { }

  ngOnInit() {
    // this.authService.getAll().subscribe(u => {
    //   u.forEach(element => {
    //    console.log(element); 
    //   });
    // });

  }

  login(username:string, password:string){
    // $event.preventDefault();

    console.log(username);
    console.log(password);

    this.username = username;
    this.password = password;

      this.authService.login(this.username,this.password).subscribe(o =>{

      console.log(o);

      if (o === null){
        // unsuccessful login
        this.error="Username/Password is incorrect.";
      }
      else if (o != null && this.username == o.username && this.password == o.password){
        // successful login
        
        let userObj = {
          id:o.id,
          username:o.username,
          password:o.password,
          first_name:o.first_name,
          last_name:o.last_name,
          role:o.role
        };
        this.authService.setCurrentUser(userObj);
      }

    });

    return this.username;
  }
  // login(form: NgForm) {

  //   this.username = form.value['username'];
  //   this.password = form.value['password'];

  //   console.log(this.username);
  //   console.log(this.password);

  //   // this.authService.login(this.username,this.password).subscribe(o =>{

  //   //   console.log(o);

  //   //   if (o === null){
  //   //     // unsuccessful login
  //   //     this.error="Username/Password is incorrect.";
  //   //   }
  //   //   else {
  //   //     // successful login
  //   //   }

  //   // });

  // }

}
