import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {LayoutComponent} from './layouts/layout/layout.component';
import {RouterModule} from "@angular/router";
import {SidebarModule} from "./components/sidebar/sidebar.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderModule } from './components/header/header.module';

@NgModule({
    declarations: [
        AppComponent,
        LayoutComponent,
    ],
    imports: [
        BrowserModule,
        RouterModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        SidebarModule,
        HeaderModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
