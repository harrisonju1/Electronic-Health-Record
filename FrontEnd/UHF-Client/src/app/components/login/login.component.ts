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
    private route: Router
  ) {
    authService.authorizePage(UserRole.NONE);
  }

  ngOnInit() {

  }

  login(username: string, password: string) {
    // $event.preventDefault();
    this.error = null;
    this.username = username;
    this.password = password;

    this.authService.login(this.username, this.password).subscribe(o => {
      if (o && o.username == username) {
        console.log("logged in!");
        this.route.navigate(['/home']);
        this.authService.loginsuccess(o);
      } else {
        // unsuccessful login
        console.log("login failed");
        this.error = "Username/Password is incorrect.";
      }
    });

    return this.username;
  }
}
