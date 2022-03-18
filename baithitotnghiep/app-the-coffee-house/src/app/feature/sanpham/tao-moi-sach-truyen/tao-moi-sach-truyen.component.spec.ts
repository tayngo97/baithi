import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaoMoiSachTruyenComponent } from './tao-moi-sach-truyen.component';

describe('TaoMoiSachTruyenComponent', () => {
  let component: TaoMoiSachTruyenComponent;
  let fixture: ComponentFixture<TaoMoiSachTruyenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaoMoiSachTruyenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaoMoiSachTruyenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
