import {Proprietaire} from "./proprietaire";

export interface Vehicule{
  id?:number;
  numeroMatricule?:string;
  marque?:string;
  puissanceFiscale?:string;
  proprietaire ?: Proprietaire;

}
