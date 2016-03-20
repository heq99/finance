import { Injectable } from 'angular2/core';
import { Http, HTTP_PROVIDERS } from 'angular2/http';
import { Product } from './product';
import { Observable } from 'rxjs/Observable';
import {handleError} from "typings/dist/utils/cli";

@Injectable()
export class ProductService {
    constructor(private http:Http) {
    }

    private url = 'http://localhost:8080/products';
    private products:Product[];
    private errorMessage:string;

    getProducts() {
        return this.http.get(this.url)
            .map(res => res.json());
    }
}