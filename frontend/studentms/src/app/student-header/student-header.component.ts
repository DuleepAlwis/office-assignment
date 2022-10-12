import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-student-header',
  templateUrl: './student-header.component.html',
  styleUrls: ['./student-header.component.scss']
})
export class StudentHeaderComponent implements OnInit {

  constructor(@Inject(DOCUMENT) private _document:Document,private route:Router) { }

  ngOnInit() {
    this._document.body.classList.add('student-bg-color');

  }

  logout(){
    localStorage.clear();
    this.route.navigateByUrl("/studentms");
  }

  studentUpdate(){
    this.route.navigateByUrl('/studentupdate')
  }
}
