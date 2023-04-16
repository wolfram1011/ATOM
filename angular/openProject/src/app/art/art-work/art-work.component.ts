import { Component } from '@angular/core';

@Component({
  selector: 'app-art-work',
  templateUrl: './art-work.component.html',
  styleUrls: ['./art-work.component.css']
})
export class ArtWorkComponent {
  public name: string = 'Test Stock Company';
  public code: string = 'TSC';
  public price: number = 85;
  public previousPrice:number = 80;
  public color: string = "purple";
  public tarea: string;

  public constructor(){
    this.name = 'change in name';
  }

  public setCar(): string {
    this.name = 'test function_change name';
    return this.name;
  }

  public divColor(): void {
  this.color = "orange";
  }

  addTask(item: string){
    this.tarea = item;
  }
}
