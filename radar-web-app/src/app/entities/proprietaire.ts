import {Vehicule} from "./vehicule";

export interface Proprietaire{

  id?:number;
  nom?:string;
  dateNaissance?:Date;
  email?:string;
  vehicules?:Vehicule[];

}
