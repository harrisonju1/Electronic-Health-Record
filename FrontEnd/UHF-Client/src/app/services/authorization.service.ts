import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../domain/User';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
}

@Injectable()
export class AuthorizationService {

  private usersUrl = 'api/users';

  currentUser: User;
  obj:User;

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  /* CLIENT SIDE - SET -------------------------------------------------------------------------------------------------- */
  setCurrentUser(user:User){
    this.currentUser = user;
    console.log(this.currentUser);
  }  

  getCurrentUser():User{
    return this.currentUser;
  }

  /* GET FROM DB -------------------------------------------------------------------------------------------------- */
  getAll():Observable<User[]>{
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

  login(username: string, password: string): Observable<User>{
      // Replace string argument with servlet URL
      console.log(username);
      console.log(password);

      this.obj = {
                  "id":0, 
                  "username": username, 
                  "password": password,
                  "first_name":"TEST",
                  "last_name":"TEST", 
                  "role":"TEST"
                };

      return this.http.post<User>(this.usersUrl, {"username":username, "password":password}, httpOptions); 
  }

  assignToken(username:string){
    if (username){
      localStorage.setItem('magickey', JSON.stringify({username:username}));
    }
  }

  /* LOGOUT -------------------------------------------------------------------------------------------------- */
  logout(){
    this.currentUser = null;
    localStorage.removeItem('magickey');
    this.router.navigate(['/home']);
    
  }

  /* HANDLE ERRORS -------------------------------------------------------------------------------------------------- */
  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
