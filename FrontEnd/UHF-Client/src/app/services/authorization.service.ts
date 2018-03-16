import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User, UserRole } from '../domain/User';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}

@Injectable()
export class AuthorizationService {

  private authorizeUrl = 'http://localhost:8080/api/authorize';

  currentUser: User;
  obj: User;

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  /* CLIENT SIDE - SET -------------------------------------------------------------------------------------------------- */
  getCurrentUser(): User {
    return this.currentUser;
  }

  /* GET FROM DB -------------------------------------------------------------------------------------------------- */
  getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.authorizeUrl);
  }

  /* LOGIN -------------------------------------------------------------------------------------------------- */
  login(username: string, password: string): Observable<User> {
    // Replace string argument with servlet URL
    console.log("login " + username + ":" + password);

    let data = username + ":" + password;
    console.log(data);
    let obs = this.http.post<User>(this.authorizeUrl, data, httpOptions);
    return obs;
  }
  loginsuccess(u: User) {
    this.currentUser = u;
    localStorage.setItem('auth', btoa(u.username + ":" + u.password));
  }

  /* LOGOUT -------------------------------------------------------------------------------------------------- */
  logout() {
    this.currentUser = null;
    localStorage.removeItem('auth');
    this.router.navigate(['/home']);
  }

  /* AUTHORIZATION --------------------------------------------------------------------------------------------------*/
  // call this to determine if the current account has this right authorization role
  isAuthorized(role: UserRole) {
    if (role == UserRole.NONE)
      return true;
    var auth = localStorage.getItem('auth');
    var cred = atob(auth).split(':');
    if (cred.length == 2) {
      this.http.post<User>(this.authorizeUrl, { "username": cred[0], "password": cred[1] }, httpOptions).subscribe((u) => {
        console.log(u);
        if (u && u.role == role) {
          return true;
        }
      });
    }
    return false;
  }

  // makes sure the current user has permission to view the page, otherwise redirect to home
  authorizePage(...roles: UserRole[]) {

    var anyoneCanAccess = false;
    for (const role of roles) {
      if (role == UserRole.NONE) {
        anyoneCanAccess = true;
        break;
      }
    }

    //get currently logged in user
    var auth = localStorage.getItem('auth');
    if (!auth) {
      if (!anyoneCanAccess)
        this.router.navigate(['/login']);
      return;
    }
    var cred = atob(auth).split(':');

    if (cred.length != 2) {
      localStorage.removeItem('auth');
      if (!anyoneCanAccess)
        this.router.navigate(['/login']);
      return;
    }

    var authorized = false;
    let data = cred[0] + ":" + cred[1];
    this.http.post<User>(this.authorizeUrl, data, httpOptions).subscribe((u) => {
      console.log(u);
      for (const role of roles) {
        if (role == UserRole.NONE || u && u.role == role) {
          console.log("authorized as " + role.toString());
          authorized = true;
          // this.currentUser = new User();
          this.currentUser = u;
          // this.currentUser.id = u.id;
          // this.currentUser.username = u.username;
          // this.currentUser.password = u.password;
          // this.currentUser.first_name = u.first_name;
          // this.currentUser.last_name = u.last_name;
          // this.currentUser.role = u.role;
          if (!this.currentUser.role)
            this.currentUser.role = UserRole.NONE;
          console.log("current user: "+this.currentUser);
          return;
        }
      }
      if (!authorized) {
        console.log("unauthorized");
        this.router.navigate(['/login']);
      }
    });
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
