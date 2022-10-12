import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CourseContent } from '../entity/CourseContent';
import { Global } from '../entity/Global';

@Injectable({
  providedIn: 'root'
})
export class FileserviceService {
  
  private url = Global.base_url+"/file";

  constructor(private http:HttpClient) { }

  upload(file: File,csId): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);
    formData.append('csId',csId);
    const req = new HttpRequest('POST', this.url+`/saveFile`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  getFiles(csId):Observable<CourseContent[]>{
    return this.http.get<CourseContent[]>(this.url+'/getCourseFiles/'+csId);
  }

  removeFile(fileId){
    return this.http.delete(this.url+'/removeFile/'+fileId);
  }

  downloadFile(fileId){
    return this.http.get(this.url+'/downloadFile/'+fileId,{responseType: 'blob'});
  }
}
