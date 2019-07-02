import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DesignComponent } from './design/design.component';
import { CartComponent } from './cart/cart.component';
import { RecentTacosComponent } from './recents/recents.component';
import { CloudTitleComponent } from './cloud-title/cloudtitle.component';
import { GroupBoxComponent } from './group-box/groupbox.component';
import { BigButtonComponent } from './big-button/bigbutton.component';
import { HomeComponent } from './home/home.component';
import { NonWrapsPipe } from './recents/NonWrapsPipe';
import { WrapsPipe } from './recents/WrapsPipe';
import { ApiService } from './api/ApiService';
import { CartService } from './cart/cart-service';



@NgModule({
  declarations: [
    AppComponent,
    DesignComponent,
    CartComponent,
    RecentTacosComponent,
    CloudTitleComponent,
    GroupBoxComponent,
    BigButtonComponent,
    HomeComponent,
    NonWrapsPipe,
    WrapsPipe
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [
    CartService,
    ApiService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
