import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthorizationService } from '../../services/authorization.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  error: string;

  loggedIn: boolean;

  constructor(
    private authService: AuthorizationService
  ) { }

  ngOnInit() {
  }

  login(form: NgForm) {
    this.username = form.value['username'];
    this.password = form.value['password'];

    this.authService.login(this.username, this.password).subscribe(o => {
      if (o === null){
        // Unsuccessful login
        this.error = 'Username or Password is incorrect';
      }
    })

  }

}
