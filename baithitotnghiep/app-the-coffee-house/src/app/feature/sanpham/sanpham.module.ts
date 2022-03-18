import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SanphamRoutingModule } from './sanpham-routing.module';
import { DachsachComponent } from './dachsach/dachsach.component';
import { TaoMoiDoAnComponent } from './tao-moi-do-an/tao-moi-do-an.component';
import { TaoMoiSachTruyenComponent } from './tao-moi-sach-truyen/tao-moi-sach-truyen.component';
import { TaoMoiThucUongComponent } from './tao-moi-thuc-uong/tao-moi-thuc-uong.component';


@NgModule({
  declarations: [ DachsachComponent, TaoMoiDoAnComponent, TaoMoiSachTruyenComponent, TaoMoiThucUongComponent],
  imports: [
    CommonModule,
    SanphamRoutingModule
  ]
})
export class SanphamModule { }
