import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CourseEntity } from '../entity/CourseEntity';
import { Global } from '../entity/Global';

@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {

  private url = Global.base_url+"/course";

  constructor(private http:HttpClient) { }

  saveCourseInfo(course:CourseEntity){

    return this.http.post(this.url+"/createCourse",course);

  }

  getAllCourses(startNumber: number):Observable<CourseEntity[]>{
    
    return this.http.get<CourseEntity[]>(this.url+"/getPagination/"+startNumber);

  }

  getNotEnrolledCourses(stId){
    return this.http.get<CourseEntity[]>(this.url+"/getNotEnrolledCourses/"+stId);
  }

  getCourses(){
    return this.http.get<CourseEntity[]>(this.url+"/enrolledNonenrolled");
  }
}
