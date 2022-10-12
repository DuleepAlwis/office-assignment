import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CourseContent } from '../entity/CourseContent';
import { FileserviceService } from '../services/fileservice.service';

@Component({
  selector: 'app-studentviewcourse',
  templateUrl: './studentviewcourse.component.html',
  styleUrls: ['./studentviewcourse.component.scss']
})
export class StudentviewcourseComponent implements OnInit {

  constructor(private actRoute:ActivatedRoute,private fileService:FileserviceService) { }

  csId;
files:CourseContent[];

  ngOnInit() {

    this.actRoute.paramMap.subscribe(
      params=>{
         this.csId = params.get('csId');
        console.log(this.csId+" helloworld");
        this.fileService.getFiles(this.csId).subscribe(
          res=>{
            if(res){
              this.files = res;
            }
          }
        )
      }
    )
  }

  downloadFile(fileId,fileName){
    console.log(fileId+" "+fileName);
  }
}
