import { Component,OnInit } from '@angular/core';

import {Stock} from '../model/stock';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit{
  // public name: string;
  // public code: string;
  // public price: number;
  // public previousPrice: number;
  // public positiveChange: boolean;
  // public favorite: boolean;
  public stock: Stock;

  contructor(){}

  ngOnInit(){
    this.stock = new Stock('Test Stock Company','TSC',85,80);
    // this.name = 'Test Stock Company';
    // this.code = 'TSC';
    // this.price = 85;
    // this.previousPrice = 80;
    // this.positiveChange = this.price >= this.previousPrice;
    // this.favorite = false;
  }
    toggleFavorite(event: any){
      console.log('We are toggling the favorite state for this stock',event);
      this.stock.favorite = !this.stock.favorite;
      // this.favorite = !this.favorite;
    }
}
