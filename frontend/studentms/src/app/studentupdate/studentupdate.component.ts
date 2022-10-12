import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { StudentEntity } from '../entity/StudentEntity';
import { StudentServiceService } from '../services/student-service.service';

@Component({
  selector: 'app-studentupdate',
  templateUrl: './studentupdate.component.html',
  styleUrls: ['./studentupdate.component.scss']
})
export class StudentupdateComponent implements OnInit {

  studentInfo = new FormGroup({
    name:new FormControl('',[Validators.required]),
    email:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required])
  });

  constructor(private stService:StudentServiceService) { }

  ngOnInit() {
    let st = JSON.parse(localStorage.getItem('user'));
    this.studentInfo.get('name').setValue(st.name);
    this.studentInfo.get('email').setValue(st.email);
    this.studentInfo.get('password').setValue(st.password);
  }

  saveStudentInfo(){
   let st = new StudentEntity();
   st.id = JSON.parse(localStorage.getItem('user')).id;
   st.name = this.studentInfo.get('name').value;
   st.email = this.studentInfo.get('email').value;
   st.password = this.studentInfo.get('password').value;

   let name = this.studentInfo.get('name').value;
   let email = this.studentInfo.get('email').value;
   let password = this.studentInfo.get('password').value;

if(name != null && name!='' && email !=null && email!='' && password != null && password!='' ){
  this.stService.updateStInfo(st).subscribe(
    res=>{
      if(res){
        alert("Student info updated");
        localStorage.clear();
        localStorage.setItem("user",JSON.stringify(st));
      }else{
        alert("Something went wrong");
      }
    }
  )
  }else{
    alert('Fill all the fields');
  }
}
    

}
