import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule } from "@angular/router";
import { MatIconModule } from "@angular/material/icon"
import { MatTooltipModule } from "@angular/material/tooltip"
import { HeaderComponent } from './header.component';

@NgModule({
    declarations: [
        HeaderComponent,
    ],
    imports: [
        BrowserModule,
        RouterModule,
        MatIconModule,
    ],
    providers: [],
    exports: [
        HeaderComponent
    ],
    bootstrap: [HeaderComponent]
})
export class HeaderModule {
}
