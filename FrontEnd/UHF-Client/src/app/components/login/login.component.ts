import { Component, OnInit } from '@angular/core';
import { NgForm, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthorizationService } from '../../services/authorization.service';
import { User, UserRole } from '../../domain/User';
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
  ) { 
    authService.authorizePage(UserRole.NONE);
  }

  ngOnInit() {

  }

  login(username:string, password:string){
    // $event.preventDefault();

    this.username = username;
    this.password = password;

      if (this.authService.login(this.username,this.password)!=null) {
        // successful login
        this.route.navigate(['/home']);
      }
      else {
        // unsuccessful login
        this.error="Username/Password is incorrect.";
      }

    return this.username;
  }
}
