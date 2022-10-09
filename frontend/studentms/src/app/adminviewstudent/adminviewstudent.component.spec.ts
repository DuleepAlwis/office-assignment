import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminviewstudentComponent } from './adminviewstudent.component';

describe('AdminviewstudentComponent', () => {
  let component: AdminviewstudentComponent;
  let fixture: ComponentFixture<AdminviewstudentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminviewstudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminviewstudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
