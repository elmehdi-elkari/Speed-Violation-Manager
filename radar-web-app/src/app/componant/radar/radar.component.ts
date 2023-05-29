import { Component,OnInit } from '@angular/core';
import {Proprietaire} from "../../entities/proprietaire";
import {HttpClient} from "@angular/common/http";
import {ConfirmationService, MessageService} from "primeng/api";
import {Radar} from "../../entities/radar";

@Component({
  selector: 'app-radar',
  templateUrl: './radar.component.html',
  styleUrls: ['./radar.component.css']
})
export class RadarComponent implements OnInit{

  productDialog: boolean=false;

  products: Radar[]=[];

  product: Radar={};

  selectedProducts: Radar[]=[];

  submitted: boolean=false;

  statuses: any[]=[];

  constructor(private http:HttpClient ,private messageService: MessageService, private confirmationService: ConfirmationService) {
    http.get<Radar[]>("http://localhost:8888/RADAR-SERVICE/radars").subscribe(data=>{
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
    this.header="Ajouter un nouveau radar"
    this.product = {} ;
    this.submitted = false;
    this.productDialog = true;
  }

  header:string="";

  deleteSelectedProducts() {
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete the selected products?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.products = this.products.filter((val) => !this.selectedProducts.includes(val));
        this.selectedProducts = [];
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Products Deleted', life: 3000 });
      }
    });
  }

  editProduct(product: Radar) {
    this.header="Modifier les informations d'un radar"
    this.product = { ...product };
    this.productDialog = true;
  }

  deleteProduct(product: Radar) {
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete Radar : ' + product.id + '?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.products = this.products.filter((val) => val.id !== product.id);
        this.product = {};
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Deleted', life: 3000 });
      }
    });
  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {
    this.submitted = true;

      if (this.product.id) {
        this.products[this.findIndexById(this.product.id)] = this.product;
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Updated', life: 3000 });
      } else {
        this.product.id = Number(this.createId());

        this.products.push(this.product);
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Created', life: 3000 });
      }

      this.products = [...this.products];
      this.productDialog = false;
      this.product = {};

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


}
