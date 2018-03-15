import { Component, OnInit } from '@angular/core';
import { NgForm, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthorizationService } from '../../services/authorization.service';
import { Router } from '@angular/router';

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
    private authService: AuthorizationService,
    private route:Router
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

    this.username = username;
    this.password = password;

      if (this.authService.login(this.username,this.password)!=null) {
        // successful login
        
//        let userObj = o;
        // let userObj = {
        //   id:o.id,
        //   username:o.username,
        //   password:o.password,
        //   first_name:o.first_name,
        //   last_name:o.last_name,
        //   role:o.role
        // };
        this.route.navigate(['/home']);
      }
      else {
        // unsuccessful login
        this.error="Username/Password is incorrect.";
      }

    return this.username;
  }
}
