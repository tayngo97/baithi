import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DachsachComponent } from './dachsach.component';

describe('DachsachComponent', () => {
  let component: DachsachComponent;
  let fixture: ComponentFixture<DachsachComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DachsachComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DachsachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
