import {Vehicule} from "./vehicule";
import {Radar} from "./radar";
import {Proprietaire} from "./proprietaire";

export interface Infraction{

  id?: number ;
  date?:Date;
  vitesseVehicule?:number;
  montant?:number;
  vehicule?:Vehicule;
  radar?:Radar;

}
