import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Global } from '../entity/Global';
import { StudentEntity } from '../entity/StudentEntity';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  private url = Global.base_url+"/student";

  constructor(private http:HttpClient) { }

  saveStudent(st:StudentEntity):Observable<Boolean>{

    return this.http.post<Boolean>(this.url+"/createStudent",st);
  }

   getAllStudents(startNumber: number):Observable<StudentEntity[]>{
    
    return this.http.get<StudentEntity[]>(this.url+"/getPagination/"+startNumber);

  }


}
