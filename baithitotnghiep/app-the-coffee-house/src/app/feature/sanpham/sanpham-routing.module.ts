import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DachsachComponent} from './dachsach/dachsach.component';
import {TaoMoiDoAnComponent} from './tao-moi-do-an/tao-moi-do-an.component';
import {TaoMoiSachTruyenComponent} from './tao-moi-sach-truyen/tao-moi-sach-truyen.component';
import {TaoMoiThucUongComponent} from './tao-moi-thuc-uong/tao-moi-thuc-uong.component';


const routes: Routes = [
  {
    path: 'taomoi-doan', component : TaoMoiDoAnComponent
  },
  {
    path: 'taomoi-sachtruyen', component: TaoMoiSachTruyenComponent
  },
  {
    path: 'taomoi-thucuong', component: TaoMoiThucUongComponent
  },
  {
    path: 'danhsach', component : DachsachComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SanphamRoutingModule { }
