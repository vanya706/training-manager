import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LayoutComponent} from "./layouts/layout/layout.component";
import { ProgramsComponent } from './pages/programs/programs.component';

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            {
                path: '',
                loadChildren: () => import('./pages/programs/programs.module').then(m => m.ProgramsModule)
            },
            {
                path: 'programs',
                loadChildren: () => import('./pages/programs/programs.module').then(m => m.ProgramsModule)
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {
}
