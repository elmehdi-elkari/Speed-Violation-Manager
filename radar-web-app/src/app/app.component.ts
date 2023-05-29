import { Component,OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import {Infraction} from "./entities/infraction";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  items: MenuItem[]=[];

  home: MenuItem={};

  ngOnInit() {
    this.items = [{ label: 'Propriétaire',routerLink:'/proprietaire' }, { label: 'Infraction',routerLink: '/infraction' }, { label: 'Radar',routerLink:"/radar" }];
    this.home = { icon: 'pi pi-home' };
  }

}
