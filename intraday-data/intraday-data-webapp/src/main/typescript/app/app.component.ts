import { Component } from 'angular2/core';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from 'angular2/router';
import { ProductService } from './product.service';
import { ProductsComponent } from './products.component';

@Component({
    selector: 'my-app',
    template: `
  <h1>{{title}}</h1>
  <nav>
    <a [routerLink]="['Products']">Products</a>
  </nav>
  <router-outlet></router-outlet>
`,
    styleUrls: ['app/app.component.css'],
    directives: [ROUTER_DIRECTIVES],
    providers: [
        ROUTER_PROVIDERS,
        ProductService
    ]})
@RouteConfig([
    {
        path: '/products',
        name: 'Products',
        component: ProductsComponent,
        useAsDefault: true
    },
])
export class AppComponent {
    title = 'Product List';
}
