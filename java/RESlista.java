public class lista {

  public static void main(String[] args) {


    // System.out.print(nodo.dato);
    ListaLigada l = new ListaLigada();
    l.insertar(1);
    l.insertar(2);
    l.insertar(3);
    l.insertar(4);
    System.out.println("nodo inicio: "+l.inicio.dato+" nodo actual: "+ l.nodo.dato);
    l.eliminar(1);
    l.imprimir();
    l.eliminar(2);
    l.imprimir();
    l.eliminar(3);
    l.imprimir();
    l.eliminar(4);
    l.insertar(1);
    l.insertar(2);
    l.insertar(3);
    l.insertar(4);
    l.insertar(5);
    l.imprimir();
    l.eliminar(1);
    l.eliminar(5);
    l.imprimir();
    l.eliminar(2);
    l.eliminar(3);
    l.imprimir();
    l.eliminar(4);
    l.insertar(4);
    l.insertar(6);
    l.insertar(10);
    l.imprimir();
    l.eliminar(10);
    l.imprimir();
    l.insertar(8);
    l.insertar(5);
    l.insertar(2);
    l.insertar(9);
    l.imprimir();
    System.out.println("Se encotnro el dato: "+l.buscar(2));
    l.imprimir();
    l.insertar(1,0);
    l.insertar(7,4);
    l.insertar(3,7);
    l.imprimir();
    l.eliminar(5);
    l.eliminar(3);
    l.eliminar(4);
    l.imprimir();
    l.eliminar(6);
    l.eliminar(9);
    l.eliminar(1);
    l.imprimir();
    l.eliminar(8);
    l.eliminar(7);
    l.eliminar(2);
    l.insertar(4);
    l.imprimir();












  } // void main

} //class lista

class Node {
  Node siguiente;
  int dato;

  Node(int dato){
    this.dato = dato;
    this.siguiente = null;

  }

}

class ListaLigada{
  int talla = 0;
  Node nodo,inicio = null;

  public Node insertarRecursive(Node cuenca, int dato, int indice){
    System.out.println("indice"+indice);
    if (cuenca == null) {
      System.out.println("if no hay nodos");
      Node nuevo = new Node(dato);
      nodo = nuevo;
      return nuevo;

    }

    if (indice == 0) {
      System.out.println("if entre numeros");
      Node nuevo = new Node(dato);
      nuevo.siguiente = cuenca;
      return nuevo;

    }
    indice--;
    cuenca.siguiente = insertarRecursive(cuenca.siguiente,dato,indice);
    return cuenca;

  }

  public void insertar(int dato, int indice){

    inicio = insertarRecursive(inicio,dato, indice);
    talla++;
  }


  public void insertar(int x){
    if (nodo == null) {
      Node nuevo = new Node(x);
      nuevo.siguiente = nodo;
      nodo = nuevo;
      inicio = nuevo;
      this.talla++;

    }else {
      Node nuevo = new Node(x);
      nodo.siguiente = nuevo;
      nodo = nuevo;
      this.talla++;
    }

  }

  public boolean imprimirRecursivo(Node nodo){

    System.out.print(nodo.dato);
    if (nodo.siguiente == null) {
      System.out.println("\n");
      return true;
    }

    return imprimirRecursivo(nodo.siguiente);
  }

  public void imprimir(){
    System.out.print("Los datos son: ");
    imprimirRecursivo(inicio);
  }

  public Node eliminarRecursivo(Node nodo,int dato){

    if (nodo.dato == dato) {
      return nodo.siguiente;
    }

    nodo.siguiente = eliminarRecursivo(nodo.siguiente,dato);

    return nodo;
  }

  public Node actualizarRecursivo(Node nodo){

    if (nodo.siguiente == null) {

      return nodo;

    }


    return actualizarRecursivo(nodo.siguiente);

  }

  public void eliminar(int dato){
    if (talla == 1) {
      nodo = null;
      inicio = null;

    }else {
      inicio = eliminarRecursivo(inicio, dato);
      if (nodo.dato == dato) {
        nodo = actualizarRecursivo(inicio);

      }
    }

    talla--;

  }

  public boolean buscarRecursivo(Node nodo, int dato){

    if (nodo == null) {
      return false;
    }
    if (nodo.dato == dato) {
      return true;

    }


    return buscarRecursivo(nodo.siguiente, dato);

  }

  public boolean buscar(int dato){
    return buscarRecursivo(inicio, dato);

  }

}//funcion
