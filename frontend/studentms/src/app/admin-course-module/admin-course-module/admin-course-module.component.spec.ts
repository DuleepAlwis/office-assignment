import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCourseModuleComponent } from './admin-course-module.component';

describe('AdminCourseModuleComponent', () => {
  let component: AdminCourseModuleComponent;
  let fixture: ComponentFixture<AdminCourseModuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCourseModuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCourseModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
