import { Component, OnInit } from '@angular/core';
import { StCourse } from 'src/app/entity/StCourse';
import { CourseServiceService } from 'src/app/services/course-service.service';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.scss']
})
export class StudentHomeComponent implements OnInit {

   courses = [];
  startNumber = 0;
  previousNumber = 0;

  constructor(private courseService:CourseServiceService,private stService:StudentServiceService) { }

  ngOnInit() {
    //this.getPaginationNext();
    this.getNotEnrolledCourses();
  }

  getNotEnrolledCourses(){
    this.stService.getNotEnrolledCourses(JSON.parse(localStorage.getItem("user")).id).subscribe(
      res=>{
        if(this.courses!=null){
          this.courses = res;

        }
      }
    );
  }

  saveStudentCourse(courseId){

    let stc:StCourse  = new StCourse();

    stc.studentId = JSON.parse(localStorage.getItem("user")).id;
    stc.courseId = courseId;
    this.stService.saveStCourse(stc).subscribe(
      res=>{
        if(res){
          this.getNotEnrolledCourses();

          alert("Student is allocated to the course");
        }
      }
    );
  }

  getPaginationNext(){
    this.courseService.getAllCourses(this.startNumber).subscribe(
      res=>{
      
        if(res!=null){
          this.courses = res;
          console.log(res);

        }
      }
    );
    this.previousNumber = this.startNumber;
    this.startNumber = this.startNumber + 10;
  }

  

  

  getPaginationPrevious(){
    this.courseService.getAllCourses(this.previousNumber).subscribe(
      res=>{
      
        if(res!=null){
          this.courses = res;

        }
      }
    );
    this.startNumber = this.previousNumber;
    this.previousNumber = this.previousNumber - 10;
    if(this.previousNumber<0){
      this.previousNumber = 0;
    }
  }
}
