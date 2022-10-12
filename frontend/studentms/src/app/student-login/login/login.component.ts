import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginInfo = new FormGroup({
    email:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required])
  });

  
  constructor( @Inject(DOCUMENT) private _document:Document,private authService:AuthenticationService,private router:Router) { }

  ngOnInit() {

    this._document.body.classList.add('login-bg-color');

  }

  login(){
    console.log("Hello");
    let email = this.loginInfo.get("email").value;
    let password = this.loginInfo.get("password").value;
    if(email!=null && email != '' && password != null && password!=''){
      this.authService.login(email,password).subscribe(
        res=>{
          if(res!=null){
                this.authService.st = res;
                localStorage.setItem("user",JSON.stringify(res));
                
                this.router.navigateByUrl("/studenthome");
          }
        }
      )
    }else{
      alert('Fill the fields');
    }
    
  }

}
