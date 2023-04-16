import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'openProject';
  public pokeUrl = undefined ;
  public firstGenPokemonIdsBody = undefined ;
  public firstGenPokeDetails :  any[];
  // public doc: string = "";


    public docTest(): void {
      const fetchFirstGenPokemons = async () => {
        const firstGenPokemonIdsResponse = await fetch('https://pokeapi.co/api/v2/type/8/');
        const firstGenPokemonIdsBody = await firstGenPokemonIdsResponse.json();
        this.pokeUrl = firstGenPokemonIdsBody.pokemon;

         const firstGenPokemonDetails = await Promise.all(
          firstGenPokemonIdsBody.pokemon.map(async (p: any) => {
            const pDetails = await fetch(p.pokemon.url);


            return await pDetails.json();
          })
         );
      this.firstGenPokeDetails = firstGenPokemonDetails;
      };
      fetchFirstGenPokemons();

      // const firstGenPokemonIdsBody = "undefined" ;
      // fetch('https://pokeapi.co/api/v2/type/8/')
      // .then(response =>  response.json())
      // .then(body => {this.firstGenPokemonIdsBody = body;
      //   this.pokeUrl = body.pokemon;
      // });

      // firstGenPokemonIdsBody.pokemon.map( (p) =>{
      //   fetch(p.pokemon.url)
      //   .then(body => );
      //   return await pDetails.json();
      //
      // })



    }
  }
