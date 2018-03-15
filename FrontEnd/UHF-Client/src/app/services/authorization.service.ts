import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User, UserRole } from '../domain/User';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': 'Basic ' + btoa('username' + ':' + 'password') })
}

@Injectable()
export class AuthorizationService {

  private usersUrl = 'http://localhost:8080/api/authorize';

  currentUser: User;
  obj: User;

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  /* CLIENT SIDE - SET -------------------------------------------------------------------------------------------------- */
  setCurrentUser(user: User) {
    this.currentUser = user;
    console.log(this.currentUser);
  }

  getCurrentUser(): User {
    return this.currentUser;
  }

  /* GET FROM DB -------------------------------------------------------------------------------------------------- */
  getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  // getUser(obs: Observable<User[]>) {
  //   let userArr;
  //   obs.subscribe(o => {
  //     userArr = o;
  //     console.log(o);
  //     console.log(userArr);

  //     o.forEach(element => {
  //       console.log(element);
  //     });

  //     console.log(userArr[0])
  //   });
  // }

  /* LOGIN -------------------------------------------------------------------------------------------------- */

  login(username: string, password: string): User {
    // Replace string argument with servlet URL
    console.log(username);
    console.log(password);

    this.obj = {
      "id": 0,
      "username": username,
      "password": password,
      "first_name": "TEST",
      "last_name": "TEST",
      "role": UserRole.NONE
    };

    this.http.post<User>(this.usersUrl, { "username": username, "password": password }, httpOptions).subscribe(o => {
      if (o && o.username == username) {
        console.log("logged in!");
        this.currentUser = o;
        localStorage.setItem('auth', btoa(username + ":" + password));
      } else {
        console.log("login failed");
      }
    });
    // this.authService.setCurrentUser(userObj);
    // this.authService.assignToken(username);
    return this.currentUser;
  }

  // assignToken(username:string){
  //   if (username){
  //     localStorage.setItem('magickey', JSON.stringify({username:username}));
  //   }
  // }

  /* LOGOUT -------------------------------------------------------------------------------------------------- */
  logout() {
    this.currentUser = null;
    // localStorage.removeItem('magickey');
    localStorage.removeItem('auth');
    this.router.navigate(['/home']);
  }

  /* AUTHORIZATION --------------------------------------------------------------------------------------------------*/
  // call this to determine if the current account has this right authorization role
  authorize(role: UserRole) {
    if (role == UserRole.NONE)
      return true;
    var auth = localStorage.getItem('auth');
    var cred = atob(auth).split(':');
    if (cred.length == 2) {
      this.http.post<User>(this.usersUrl, { "username": cred[0], "password": cred[1] }, httpOptions).subscribe((u) => {
        console.log(u);
        if (u && u.role == role) {
          return true;
        }
      });
    }
    return false;
  }

  /* HANDLE ERRORS -------------------------------------------------------------------------------------------------- */
  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
