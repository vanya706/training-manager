import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'app-sidebar',
    templateUrl: './sidebar.component.html',
    styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

    constructor() {
    }

    public items = [
        {
            icon: 'featured_play_list',
            label: 'All Programs',
            route: 'programs'
        },
        {
            icon: 'settings',
            label: 'Settings',
            route: '/settings'
        },
    ]

    ngOnInit(): void {
    }

}
