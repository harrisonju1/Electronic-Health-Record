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
    this.authService.login("TB9999","").subscribe(o =>{

      console.log(o);

    });

  }

  login(form: NgForm) {
    this.authService.getAll().subscribe(u => {
      u.forEach(element => {
       console.log(element); 
      });
    });

    this.username = form.value['username'];
    this.password = form.value['password'];

    console.log(this.username);
    console.log(this.password);

    // this.authService.login(this.username, this.password).subscribe(o => {
    //   if (o === null){
    //     console.log(o);
    //     // Unsuccessful login
    //     this.error = 'Username/Password is incorrect';
    //   }
    //   else {

    //   }
    // });

  }

}
