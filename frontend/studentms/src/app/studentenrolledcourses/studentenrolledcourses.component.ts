import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { CourseEntity } from '../entity/CourseEntity';
import { StudentServiceService } from '../services/student-service.service';

@Component({
  selector: 'app-studentenrolledcourses',
  templateUrl: './studentenrolledcourses.component.html',
  styleUrls: ['./studentenrolledcourses.component.scss']
})
export class StudentenrolledcoursesComponent implements OnInit {

  courses:CourseEntity[];

  constructor(private stService:StudentServiceService,private route:Router) { }

  ngOnInit() {
    this.getEnrolledCourses();
  }

  getEnrolledCourses(){
    const stId = JSON.parse(localStorage.getItem("user")).id;

    this.stService.getEnrolledCourses(stId).subscribe(
      res=>{
        if(res!=null){
          this.courses = res;
        }
      }
    )

  }

  removeCourse(courseId){

    let stId = JSON.parse(localStorage.getItem("user")).id;
    this.stService.removeEnrolledCourse(stId,courseId).subscribe(
      res=>{
        if(res){
          this.getEnrolledCourses();
        }
        else{
          alert("Something went wrong");
        }
      }
    )
  }

  viewCourseData(csId){
    this.route.navigateByUrl('/studentviewcourse/'+csId);
  }

}
