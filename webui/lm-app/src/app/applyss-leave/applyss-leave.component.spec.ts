import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyssLeaveComponent } from './applyss-leave.component';

describe('ApplyssLeaveComponent', () => {
  let component: ApplyssLeaveComponent;
  let fixture: ComponentFixture<ApplyssLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplyssLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplyssLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
