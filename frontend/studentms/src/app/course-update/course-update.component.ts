import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CourseContent } from '../entity/CourseContent';
import { CourseEntity } from '../entity/CourseEntity';
import { CourseServiceService } from '../services/course-service.service';
import { FileserviceService } from '../services/fileservice.service';
import * as fileSaver from 'file-saver'; 
@Component({
  selector: 'app-course-update',
  templateUrl: './course-update.component.html',
  styleUrls: ['./course-update.component.scss']
})
export class CourseUpdateComponent implements OnInit {

  files:CourseContent[];

  courseInfo = new FormGroup({
    //code:new FormControl('',[Validators.required]),
    name:new FormControl('',[Validators.required]),
    description:new FormControl('',[Validators.required]),
    author:new FormControl('',[Validators.required])
  });
  
  constructor(private actRoute:ActivatedRoute,private csService:CourseServiceService,private fileService:FileserviceService) { }

   csId;

  ngOnInit() {
    this.actRoute.paramMap.subscribe(
      params=>{
         this.csId = params.get('csId');
        console.log(this.csId+" helloworld");
        this.csService.getCourseById(this.csId).subscribe(
          res=>{
            this.courseInfo.get('name').setValue(res.courseName);
            this.courseInfo.get('description').setValue(res.description);
            this.courseInfo.get('author').setValue(res.author);
          }
        )
      }
    )

    this.getAllFiles();


  }

  getAllFiles(){
    this.fileService.getFiles(this.csId).subscribe(
      res=>{
        this.files = res;
      }
    )
  }

  saveCourseInfo(){
   let cs = new CourseEntity();
    cs.author = this.courseInfo.get('author').value;
    cs.courseName = this.courseInfo.get('name').value;
    cs.description = this.courseInfo.get('description').value;
    cs.id = this.csId;

    this.csService.updateCourseInfo(cs).subscribe(
      res=>{
        if(res){
          alert('Course info updated');
        }else{
          alert('Something went wrong');
        }
      }
    )
  }

  selectedFiles?:FileList;
  currentFile?:File;
  message = '';
  errorMsg = '';

  selectFile(event:any):void{
    this.selectedFiles = event.target.files;
  }

  upload():void{
    this.errorMsg = '';

    if(this.selectedFiles){
      const file:File | null = this.selectedFiles.item(0);

      if(file){
        this.currentFile = file;

        this.fileService.upload(this.currentFile,this.csId).subscribe(
          (event:any)=>{
            if(event.type===HttpEventType.UploadProgress){
              console.log(Math.round(100*event.loaded/event.total));
              if(event){
                alert("File Upload success");
                this.getAllFiles();

              }
            }else if(event instanceof HttpResponse){
              this.message = event.body.responseMessage;
            }
          },
          (err:any)=>{
            console.log(err);

            if(err.error && err.error.responseMessage){
              this.errorMsg = err.error.responseMessage;
            }else{
              this.errorMsg = 'Error occurred while uploading the file';
            }
            this.currentFile = undefined;
          }
        )

      }

      this.selectedFiles = undefined;
    }
  }

  downloadFile(fileId,fileName){
    this.fileService.downloadFile(fileId).subscribe(
      res => {
        return //this.saveFile(res.arrayBuffer, fileName);
      }
    )
  }

  removeFile(fileId){
    this.fileService.removeFile(fileId).subscribe(
      res=>{
        if(res){
          this.getAllFiles();

          alert("File removed");
        }
      }

    )
  }

  saveFile(data: any, filename?: string) {
    const blob = new Blob([data], {type: 'text/csv; charset=utf-8'});
    fileSaver.saveAs(blob, filename);
  }
}

