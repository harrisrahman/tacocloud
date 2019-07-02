import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DesignComponent } from './design/design.component';
import { RecentTacosComponent } from './recents/recents.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
{
path: 'home',
component: HomeComponent
},
{
path: 'design',
component: DesignComponent
},
{
path: 'recents',
component: RecentTacosComponent
},
{
path: 'cart',
component: CartComponent
},
{
path: '**',
redirectTo: 'home',
pathMatch: 'full'
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,
  {
    enableTracing: true
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
