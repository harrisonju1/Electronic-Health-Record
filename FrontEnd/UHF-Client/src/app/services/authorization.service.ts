import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../domain/User';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
}

@Injectable()
export class AuthorizationService {

  private usersUrl = 'api/users';

  currentUser: User;
  obj:User;

  constructor(
    private http: HttpClient
  ) { }

  getAll():Observable<User[]>{
    return this.http.get<User[]>(this.usersUrl);
  }

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

  getUser(obs: Observable<User[]>) {
    let userArr;
    obs.subscribe(o => {
      userArr = o;
      console.log(o);
      console.log(userArr);

      o.forEach(element => {
        console.log(element);
      });

      console.log(userArr[0])
    });
  }

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
