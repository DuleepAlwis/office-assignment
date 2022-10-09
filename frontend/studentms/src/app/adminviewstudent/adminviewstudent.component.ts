import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CourseEntity } from '../entity/CourseEntity';
import { StudentServiceService } from '../services/student-service.service';

@Component({
  selector: 'app-adminviewstudent',
  templateUrl: './adminviewstudent.component.html',
  styleUrls: ['./adminviewstudent.component.scss']
})
export class AdminviewstudentComponent implements OnInit {

  courses:CourseEntity[];

  constructor(private stService:StudentServiceService,private actRoute:ActivatedRoute) { }

  ngOnInit() {
    this.getEnrolledCourses();
    this.actRoute.paramMap.subscribe(
      params=>{
        let stId = params.get('id');
        this.getEnrolledCourses(stId);
      }
    )
  }

  getEnrolledCourses(stId){
    
    this.stService.getEnrolledCourses(stId).subscribe(
      res=>{
        if(res!=null){
          this.courses = res;
        }
      }
    )

  }

}
