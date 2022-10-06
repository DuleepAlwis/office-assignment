import { Component, OnInit } from '@angular/core';
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

  constructor(private authService:AuthenticationService,private router:Router) { }

  ngOnInit() {
  }

  login(){
    console.log("Hello");
    let email = this.loginInfo.get("email").value;
    let password = this.loginInfo.get("password").value;
    this.authService.login(email,password).subscribe(
      res=>{
        if(res!=null){
              this.router.navigateByUrl("/studenthome");
        }
      }
    )
  }

}
