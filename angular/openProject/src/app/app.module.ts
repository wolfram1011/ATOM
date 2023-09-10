import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ArtWorkComponent } from './art/art-work/art-work.component';

@NgModule({
  declarations: [
    AppComponent,
    ArtWorkComponent
  ],
  imports: [
    BrowserModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
