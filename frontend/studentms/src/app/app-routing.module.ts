import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminCourseModuleComponent } from './admin-course-module/admin-course-module/admin-course-module.component';
import { AdminStudentModuleComponent } from './admin-student/admin-student-module/admin-student-module.component';
import { AdminviewstudentComponent } from './adminviewstudent/adminviewstudent.component';
import { EnrolledCoursesComponent } from './enrolled-courses/enrolled-courses.component';
import { HomeComponent } from './home/home/home.component';
import { CreateAccountComponent } from './signup/create-account/create-account.component';
import { StudentHomeComponent } from './student-home/student-home/student-home.component';
import { LoginComponent } from './student-login/login/login.component';
import { StudentenrolledcoursesComponent } from './studentenrolledcourses/studentenrolledcourses.component';


const routes: Routes = [
  {
    path:'studentms-admin-panel',
    component:HomeComponent
  },
  {
    path:'studentmodule',
    component:AdminStudentModuleComponent
  },
  {
    path:'admin-courses',
    component:AdminCourseModuleComponent
  },
  {
    path:'studentms',
    component:LoginComponent
  },
  {
    path:'signin',
    component:CreateAccountComponent
  },
  {
    path:'studenthome',
    component:StudentHomeComponent
  },
  {
    path:'studentenrolledcourses',
    component:StudentenrolledcoursesComponent
  },
  {
    path:'admin-view-student/:id',
    component:AdminviewstudentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
