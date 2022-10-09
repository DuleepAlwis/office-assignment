import { Component, ElementRef, OnInit, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private el:ElementRef,private renderer:Renderer2) { }

  ngOnInit() {
  }

  ngAfterViewInit(){
    this.renderer.setStyle(this.el.nativeElement.ownerDocument.body,'backgroundColor','midnightblue');
  }

}
