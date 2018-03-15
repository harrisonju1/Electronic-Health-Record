import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-med-history-form',
  templateUrl: './med-history-form.component.html',
  styleUrls: ['./med-history-form.component.css']
})
export class MedHistoryFormComponent implements OnInit {

  val="def";
  headers=new HttpHeaders({
    "Access-Control-Allow-Origin":"*",
    "Access-Control-Allow-Headers": "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With",
    // "Access-Control-Allow-Method":"GET, PUT, POST",
    'Authorization' : 'Basic '+btoa("user:pass"),
  });
  constructor(private http: HttpClient) { 
    http.get("http://localhost:8080/api/test", {headers:this.headers}).subscribe(data => this.val = data.toString());
  }
  ngOnInit() {

  }

}
