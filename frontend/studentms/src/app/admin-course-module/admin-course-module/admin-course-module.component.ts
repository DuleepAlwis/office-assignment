import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CourseEntity } from 'src/app/entity/CourseEntity';
import { CourseServiceService } from 'src/app/services/course-service.service';

@Component({
  selector: 'app-admin-course-module',
  templateUrl: './admin-course-module.component.html',
  styleUrls: ['./admin-course-module.component.scss']
})
export class AdminCourseModuleComponent implements OnInit {

  constructor(private router:Router,private courseService:CourseServiceService) { }

  courseInfo = new FormGroup({
    //code:new FormControl('',[Validators.required]),
    name:new FormControl('',[Validators.required]),
    description:new FormControl('',[Validators.required]),
    author:new FormControl('',[Validators.required])
  });

  show = false;
  ngOnInit() {
    this.getPaginationNext();
  }
  
  startNumber = 0;
  previousNumber = 0;
  courses:CourseEntity[];
  

  addNewCourse(){
    this.show = !this.show;
  }

  saveCourseInfo(){

    let course:CourseEntity = new CourseEntity();
     //course.CODE = this.courseInfo.get("code").value;
    course.courseName = this.courseInfo.get("name").value;
    course.description = this.courseInfo.get("description").value;
    course.author = this.courseInfo.get("author").value;

    this.courseService.saveCourseInfo(course).subscribe(
      res=>{
        if(res){
          alert("Course info saved");
        }else{
          alert("Something went wrong");
        }
      }
    )

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
