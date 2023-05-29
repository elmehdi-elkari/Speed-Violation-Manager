import { Component, OnInit } from '@angular/core';
import {Infraction} from "../../entities/infraction";
import {HttpClient} from "@angular/common/http";
import {Vehicule} from "../../entities/vehicule";
import {Proprietaire} from "../../entities/proprietaire";

@Component({
  selector: 'app-infraction-componant',
  templateUrl: './infraction-componant.component.html',
  styleUrls: ['./infraction-componant.component.css']
})
export class InfractionComponantComponent implements OnInit{


  constructor(private http:HttpClient) {
    http.get<Infraction[]>("http://localhost:8888/INFRACTION-SERVICE/infractions").subscribe(data=>{
      console.log(data)
      this.infractions=data;
    })
  }

  infractions:Infraction[]=[];
  first = 0;
  rows = 10;


  next() {
    this.first = this.first + this.rows;
  }

  prev() {
    this.first = this.first - this.rows;
  }

  reset() {
    this.first = 0;
  }

  isLastPage(): boolean {
    return this.infractions ? this.first === this.infractions.length - this.rows : true;
  }

  isFirstPage(): boolean {
    return this.infractions ? this.first === 0 : true;
  }

  ngOnInit(): void {


  }


  vehicule:Vehicule[]=[];
  visible:boolean=false;


  getV(vehicule:Vehicule) {
    this.vehicule=[]
    this.vehicule.push(vehicule);
    this.visible=true;
  }

  proprietaire:Proprietaire[]=[];
  visible2:boolean=false;


  getP(vehicule:Vehicule) {
    this.proprietaire=[]
    this.proprietaire.push(vehicule);
    this.visible2=true;
  }

}
