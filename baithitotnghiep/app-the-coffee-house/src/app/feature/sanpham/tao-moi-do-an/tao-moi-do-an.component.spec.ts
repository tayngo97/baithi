import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaoMoiDoAnComponent } from './tao-moi-do-an.component';

describe('TaoMoiDoAnComponent', () => {
  let component: TaoMoiDoAnComponent;
  let fixture: ComponentFixture<TaoMoiDoAnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaoMoiDoAnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaoMoiDoAnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
