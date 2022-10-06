import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Global } from '../entity/Global';
import { StudentEntity } from '../entity/StudentEntity';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private url = Global.base_url+"/student";

  constructor(private http:HttpClient) { }

  login(email,password){

    return this.http.get<StudentEntity>(this.url+"/login/"+email+"/"+password);
    
  }
}
