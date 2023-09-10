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
  public stockClasses;

  contructor(){}

  ngOnInit(){
    this.stock = new Stock('Test Stock Company','TSC',85,80);
    let diff = (this.stock.price/this.stock.previousPrice)-1;
    let largeChange = Math.abs(diff)>0.01;
    this.stockStyles = {
      "color": this.stock.isPositiveChange() ? "green" : "red",
      "font-size": largeChange ? "1.2em" : "0.8em"
    };

    // this.stockClasses = {
    //   "positive":this.stock.isPositiveChange(),
    //   "negative":!this.stock.isPositiveChange(),
    //   "large-change":largeChange,
    //   "small-change": !largeChange
    // };
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
// pag 42
