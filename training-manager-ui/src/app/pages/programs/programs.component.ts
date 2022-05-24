import { ProgramListDto } from './../../interfaces/programListDto.interface';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrls: ['./programs.component.scss']
})
export class ProgramsComponent implements OnInit {

  public programs: ProgramListDto[] = [];

  constructor() { }

  ngOnInit(): void {
    
  }

}
