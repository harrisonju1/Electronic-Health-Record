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
    this.authService.getAll().subscribe(u => {
      u.forEach(element => {
       console.log(element); 
      });
    });

  }

  login(form: NgForm) {
    

    this.username = form.value['username'];
    this.password = form.value['password'];

    console.log(this.username);
    console.log(this.password);

    this.authService.login(this.username,this.password).subscribe(o =>{

      console.log(o);

      if (o === null){
        // unsuccessful login
        this.error="Username/Password is incorrect.";
      }
      else {
        // successful login
      }

    });

  }

}
