import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule } from "@angular/router";
import { MatIconModule } from "@angular/material/icon"
import { MatTooltipModule } from "@angular/material/tooltip"
import { SidebarComponent } from './sidebar.component';

@NgModule({
    declarations: [
        SidebarComponent,
    ],
    imports: [
        BrowserModule,
        RouterModule,
        MatIconModule,
        MatTooltipModule
    ],
    providers: [],
    exports: [
        SidebarComponent
    ],
    bootstrap: [SidebarComponent]
})
export class SidebarModule {
}
