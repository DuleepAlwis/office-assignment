import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentenrolledcoursesComponent } from './studentenrolledcourses.component';

describe('StudentenrolledcoursesComponent', () => {
  let component: StudentenrolledcoursesComponent;
  let fixture: ComponentFixture<StudentenrolledcoursesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentenrolledcoursesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentenrolledcoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
