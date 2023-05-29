import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {InfractionComponantComponent} from "./componant/infraction-componant/infraction-componant.component";
import {ProprietaireComponent} from "./componant/proprietaire/proprietaire.component";
import {RadarComponent} from "./componant/radar/radar.component";

const routes: Routes = [
  {
    path: "infraction",component:InfractionComponantComponent
  },
  {
    path: "proprietaire",component:ProprietaireComponent
  },
  {
    path: "radar",component:RadarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
