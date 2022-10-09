import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { StudentEntity } from 'src/app/entity/StudentEntity';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.scss']
})
export class CreateAccountComponent implements OnInit {

  userInfo = new FormGroup({
    name:new FormControl('',[Validators.required]),
    email:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required])
  });
  renderer: any;
  el: any;
  
  constructor(private stService:StudentServiceService) { }

  ngOnInit() {
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'backgroundColor','midnightblue');

  }

  signup(){

    let st = new StudentEntity();

    st.name = this.userInfo.get("name").value;
    st.email = this.userInfo.get("email").value;
    st.password = this.userInfo.get("password").value;

    this.stService.saveStudent(st).subscribe(
      res=>{
        if(res==true){
          alert("Student info saved");
        }
      }
    );
  }

}
