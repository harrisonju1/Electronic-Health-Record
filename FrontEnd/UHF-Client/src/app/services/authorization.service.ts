import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../domain/User';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type ': 'application/json'})
}

@Injectable()
export class AuthorizationService {

  private usersUrl = 'api/users';

  currentUser: User;

  constructor(
    private http: HttpClient
  ) { }

  getAll():Observable<User[]>{
    return this.http.get<User[]>(this.usersUrl);
  }

  login(username: string, password: string): User{
      // Replace string argument with servlet URL
    //   console.log(username);
    //   console.log(password);

    //   let obs = this.http.post<User>(this.usersUrl, { "username": username, "password": password }); 

    //   obs.pipe(
    //     catchError(this.handleError('login'))
    //   );

    //   console.log(obs);

    // return obs;

    // MESSING AROUND
    let obs = this.getAll();
    let user = this.getUser(obs);
    return user;
  }

  getUser( obs: Observable<User[]>) : User {
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

    while(userArr === undefined){
      // if (userArr != undefined){
      //   return userArr[0];
      // }
    }

    return userArr[0];
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
