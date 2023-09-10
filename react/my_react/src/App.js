import './App.css';
import React,{ useState, useEffect } from 'react';

const firstGenPokemonPath = 'https://pokeapi.co/api/v2/type/13/';
function App(){

  const [firstGenPokemonDetails, setfirstGenPokemonDetails] = useState([]);
  const [pokemonurl,setpokemonurl] = useState([]);
  const [test,setTest] = useState(['test']);
  // const listItems = firstGenPokemonDetails.map(( i ) =>
  //   <div id = "pokeDiv">{i.name} </div> );
// text added

  useEffect(() => {
    const fetchFirstGenPokemons = async () => {
      const firstGenPokemonIdsResponse = await fetch(firstGenPokemonPath);
      const firstGenPokemonIdsBody = await firstGenPokemonIdsResponse.json();
      setpokemonurl(firstGenPokemonIdsBody.pokemon);

      const firstGenPokemonDetails = await Promise.all(
        firstGenPokemonIdsBody.pokemon.map(async (p) => {
          var pDetails = await fetch(p.pokemon.url);


          return await pDetails.json();
        })
      );

      setfirstGenPokemonDetails(firstGenPokemonDetails);

    };

    fetchFirstGenPokemons();

  }, []);


  return (

    <div>

<h2 style = {{textAlign: "center"}}>  pokemon! </h2>


      <div id = 'pokeContainer'> <ul id = 'listStyle'>
      {firstGenPokemonDetails.map((i) => <div id = "pokeDiv">
      <p style={{color: "white", marginTop: "0px"}}>{i.name} </p>
      <img src={i.sprites.front_default} alt="Logo" id= "pokeImage"/> </div>)} </ul>


      </div>





    </div>



  );
}



export default App;
