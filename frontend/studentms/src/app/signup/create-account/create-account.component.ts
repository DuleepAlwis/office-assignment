import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
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
  
  constructor(@Inject(DOCUMENT) private _document:Document,private stService:StudentServiceService) { }

  ngOnInit() {
   // this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'backgroundColor','midnightblue');
   this._document.body.classList.add('login-bg-color');

  }

  signup(){

    let st = new StudentEntity();

    st.name = this.userInfo.get("name").value;
    st.email = this.userInfo.get("email").value;
    st.password = this.userInfo.get("password").value;
    let name = this.userInfo.get("name").value;
    let email = this.userInfo.get("email").value;
    let password = this.userInfo.get("password").value;
    if(name!='' && email!='' && password!='' && this.emailValidator(email)){

      this.stService.saveStudent(st).subscribe(
        res=>{
          if(res==true){
            alert("Student info saved");
          }else{
            alert("User all ready exists");
          }
          this.userInfo.get('name').setValue('');
          this.userInfo.get('email').setValue('');
          this.userInfo.get('password').setValue('');
  
        }
      );
    }else{
      alert("Fill all fields properly");
    }
    
  }

  emailValidator(email){
    if(email!='' && email!=null){
      let atIndex = email.indexOf('@');
      let dotIndex = email.indexOf('.');
      console.log(atIndex+" "+dotIndex);
      if(atIndex!=(-1) && dotIndex!=(-1) && atIndex<dotIndex){
        return true;
      }else{
        return false;
      }
    }else{
      return false;
    }
    
  }

}
