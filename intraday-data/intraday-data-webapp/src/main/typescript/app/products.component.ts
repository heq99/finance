import { Component, OnInit } from 'angular2/core';
import { Router } from 'angular2/router';

import { Product } from './product';
import { ProductService } from "./product.service";
@Component({
    selector: 'my-heroes',
    templateUrl: 'app/products.component.html',
    styleUrls: ['app/products.component.css'],
})
export class ProductsComponent implements OnInit {
    title = 'List of Products';
    products : Product[];
    errorMessage : string;
    selectedProduct: Product;
    constructor(
        private _productService: ProductService,
        private _router: Router
    ) { }
    ngOnInit() {
        this.getProducts();
    }
    onSelect(product: Product) { this.selectedProduct = product; }
    getProducts() {
        //this._productService.getProducts()
        //    .subscribe(
        //        products => this.products = products,
        //        error => this.errorMessage = <any>error
        //    );
        this._productService.getProducts()
            .subscribe(products => this.products = products);
    }
    gotoDetail() {
        //this._router.navigate(['HeroDetail', { id: this.selectedProduct.id }]);
    }
}
