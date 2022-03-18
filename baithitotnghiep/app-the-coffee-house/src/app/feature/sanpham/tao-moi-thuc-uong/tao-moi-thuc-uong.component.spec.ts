import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaoMoiThucUongComponent } from './tao-moi-thuc-uong.component';

describe('TaoMoiThucUongComponent', () => {
  let component: TaoMoiThucUongComponent;
  let fixture: ComponentFixture<TaoMoiThucUongComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaoMoiThucUongComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaoMoiThucUongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
