import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home/home.component';
import { AdminStudentModuleComponent } from './admin-student/admin-student-module/admin-student-module.component';
import { AdminCourseModuleComponent } from './admin-course-module/admin-course-module/admin-course-module.component';
import { StudentServiceService } from './services/student-service.service';
import { LoginComponent } from './student-login/login/login.component';
import { CreateAccountComponent } from './signup/create-account/create-account.component';
import { StudentHomeComponent } from './student-home/student-home/student-home.component';
import { StudentHeaderComponent } from './student-header/student-header.component';
import { EnrolledCoursesComponent } from './enrolled-courses/enrolled-courses.component';
import { StudentenrolledcoursesComponent } from './studentenrolledcourses/studentenrolledcourses.component';
import { AdminviewstudentComponent } from './adminviewstudent/adminviewstudent.component';
import { AdminHeaderComponent } from './admin-header/admin-header.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminStudentModuleComponent,
    AdminCourseModuleComponent,
    LoginComponent,
    CreateAccountComponent,
    StudentHomeComponent,
    StudentHeaderComponent,
    EnrolledCoursesComponent,
    StudentenrolledcoursesComponent,
    AdminviewstudentComponent,
    AdminHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [StudentServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
