import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CourseEntity } from '../entity/CourseEntity';
import { Global } from '../entity/Global';
import { StCourse } from '../entity/StCourse';
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

  saveStCourse(stCourse:StCourse){
    return this.http.post<Boolean>(this.url+"/saveStCourse",stCourse);
  }

  updateStInfo(st:StudentEntity){
    return this.http.put<StudentEntity>(this.url+'/updateStudent',st);
  }

  getNotEnrolledCourses(stId){
    return this.http.get<CourseEntity[]>(this.url+"/getNotEnrolledCourses/"+stId);
  }

  getEnrolledCourses(stId){
    return this.http.get<CourseEntity[]>(this.url+"/getEnrolledCourses/"+stId);
  }

  removeEnrolledCourse(stId,courseId){

    return this.http.delete<Boolean>(this.url+"/removeStCourse/"+stId+"/"+courseId);
  }
}
