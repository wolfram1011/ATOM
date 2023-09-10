import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View,Image,FlatList } from 'react-native';
import React, {Component} from 'react';


const DATA = [
  {
    id:"1",
    title:"Data Structures"
  },
  {
    id:"2",
    title:"STL"
  },
  {
    id:"3",
    title:"C++"
  },
  {
    id:"4",
    title:"Java"
  },
  {
    id:"5",
    title:"Python"
  },
  {
    id:"6",
    title:"CP"
  },
  {
    id:"7",
    title:"ReactJs"
  },
  {
    id:"8",
    title:"NodeJs"
  },
  {
    id:"9",
    title:"MongoDb"
  },
  {
    id:"10",
    title:"ExpressJs"
  },
  {
    id:"11",
    title:"PHP"
  },
  {
    id:"12",
    title:"MySql"
  },
];

const Item = ({title}) => (
  <View >
    <Text>{title}</Text>
  </View>
);

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Open up App.js to start working on your app!</Text>
      <Text>Open up App.js to start working on your app!</Text>
      <Image source={require('./calaca.jpg')}
       style={{width: 400, height: 400}} />
      <Image source={{uri: 'https://www.caracteristicass.de/wp-content/uploads/2018/08/caracteristicas-de-los-nahuatl.jpg'}}
       style={{width: 400, height: 400}} />
      <StatusBar style="auto" />
      <View style={styles.second}>
      <Text>que paso react  </Text>
      </View>

      <View>
      <FlatList
        data={DATA}
        renderItem={({item}) => <Item title={item.title} />}
        keyExtractor={item => item.id}
      /> </View>




    </View>

  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  second:{
    backgroundColor: 'blue',
  },



});
