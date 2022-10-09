import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.scss']
})
export class AdminHeaderComponent implements OnInit {

  constructor(@Inject(DOCUMENT) private _document:Document) { }

  ngOnInit() {
    this._document.body.classList.add('admin-bg-color');

  }

}
