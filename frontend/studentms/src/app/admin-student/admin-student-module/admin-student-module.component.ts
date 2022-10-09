import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { StudentEntity } from 'src/app/entity/StudentEntity';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-admin-student-module',
  templateUrl: './admin-student-module.component.html',
  styleUrls: ['./admin-student-module.component.scss']
})
export class AdminStudentModuleComponent implements OnInit {

   students:StudentEntity[];
    show:boolean = false;

   
   startNumber = 0;
   previousNumber = 0;

  constructor(private stService:StudentServiceService,private route:Router) { }


  ngOnInit(){
    this.getPaginationNext();
  }

  getPaginationNext(){
    this.stService.getAllStudents(this.startNumber).subscribe(
      res=>{
      
        if(res!=null){
          this.students = res;

        }
      }
    );
    this.previousNumber = this.startNumber;
    this.startNumber = this.startNumber + 10;
  }

  viewStudentDetails(stId){
  
    this.route.navigateByUrl('/admin-view-student/'+stId);
  }
  

  

  getPaginationPrevious(){
    this.stService.getAllStudents(this.previousNumber).subscribe(
      res=>{
      
        if(res!=null){
          this.students = res;

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

