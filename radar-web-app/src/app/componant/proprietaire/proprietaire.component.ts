import { Component ,OnInit} from '@angular/core';
//import { ConfirmationService, MessageService } from 'primeng/api';
import {Proprietaire} from "../../entities/proprietaire";
import {HttpClient} from "@angular/common/http";
import {Vehicule} from "../../entities/vehicule";
import {ConfirmationService, MessageService} from "primeng/api";
@Component({
  selector: 'app-proprietaire',
  templateUrl: './proprietaire.component.html',
  styleUrls: ['./proprietaire.component.css']
})
export class ProprietaireComponent implements OnInit{

  productDialog: boolean=false;

  products: Proprietaire[]=[];

  product: Proprietaire={};

  selectedProducts: Proprietaire[]=[];

  submitted: boolean=false;

  statuses: any[]=[];

  constructor(private http:HttpClient ,private messageService: MessageService, private confirmationService: ConfirmationService) {
    http.get<Proprietaire[]>("http://localhost:8888/IMMATRICULATION-SERVICE/proprietaires").subscribe(data=>{
      console.log(data)
      this.products=data;
    })
  }

  ngOnInit() {
    //this.productService.getProducts().then((data) => (this.products = data));

    this.statuses = [
      { label: 'INSTOCK', value: 'instock' },
      { label: 'LOWSTOCK', value: 'lowstock' },
      { label: 'OUTOFSTOCK', value: 'outofstock' }
    ];
  }

  openNew() {
    this.product = {} ;
    this.submitted = false;
    this.productDialog = true;
  }

  deleteSelectedProducts() {
    this.confirmationService.confirm({
      message: 'Êtes-vous sûr de vouloir supprimer la sélection ?',
      header: 'Confirmer',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.products = this.products.filter((val) => !this.selectedProducts.includes(val));
        this.selectedProducts = [];
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Deleted', life: 3000 });
      }
    });
  }

  editProduct(product: Proprietaire) {
    this.product = { ...product };
    this.productDialog = true;
  }

  deleteProduct(product: Proprietaire) {
    this.confirmationService.confirm({
      message: 'Êtes-vous sûr de vouloir supprimer ' + product.nom + '?',
      header: 'Confirmer',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.products = this.products.filter((val) => val.id !== product.id);
        this.product = {};
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: ' Deleted', life: 3000 });
      }
    });
  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {
    this.submitted = true;

    if (this.product.nom?.trim()) {
      if (this.product.id) {
        this.products[this.findIndexById(this.product.id)] = this.product;
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Updated', life: 3000 });
      } else {
        this.product.id = Number(this.createId());

        this.products.push(this.product);
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Created', life: 3000 });
      }

      this.products = [...this.products];
      this.productDialog = false;
      this.product = {};
    }
  }

  findIndexById(id: number): number {
    let index = -1;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id === id) {
        index = i;
        break;
      }
    }

    return index;
  }

  createId(): number {
    let id = '';
    var chars = '0123456789';
    for (var i = 0; i < 5; i++) {
      id += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    return Number(id);
  }

  getSeverity(status: string) {
    switch (status) {
      case 'INSTOCK':
        return 'success';
      case 'LOWSTOCK':
        return 'warning';
      case 'OUTOFSTOCK':
        return 'danger';
      default : return ""
    }
  }

  vehicules:Vehicule[]=[];
  visible:boolean=false;


  getV(id:number) {

    this.http.get<Vehicule[]>(`http://localhost:8888/IMMATRICULATION-SERVICE/vehicules/prop/${id}`).subscribe(data=>{
      console.log(data)
      this.vehicules = [... data];
    })
    this.visible=true;
  }



}
