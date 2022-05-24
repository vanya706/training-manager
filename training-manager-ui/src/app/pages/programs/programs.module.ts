import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule } from "@angular/router";
import { MatIconModule } from "@angular/material/icon"
import { MatToolbarModule } from "@angular/material/toolbar"
import { MatListModule } from "@angular/material/list"
import { ProgramsComponent } from './programs.component';

@NgModule({
    declarations: [
        ProgramsComponent,
    ],
    imports: [
        RouterModule,
        MatIconModule,
        MatToolbarModule,
        MatListModule,

        RouterModule.forChild([
            { path: '', component: ProgramsComponent }
        ])
    ],
    providers: [],
    exports: [
        ProgramsComponent
    ],
    bootstrap: [ProgramsComponent]
})
export class ProgramsModule {
}
