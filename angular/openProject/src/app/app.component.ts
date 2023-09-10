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
  public color: string = 'red';
  public popUp: string = 'none';
  public pokeName: string ;
  public pokeMove: string;
  public pokeMove2: string;


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



    }

    setPopUp(name: string, move: string, move2: string): void {
      this.pokeName = name;
      this.pokeMove = move;
      this.pokeMove2 = move2;
      if (this.popUp === 'inline') {
        this.popUp = 'none';
      }else if (this.popUp === 'none') {
        this.popUp = 'inline';

      }
    }
  }
