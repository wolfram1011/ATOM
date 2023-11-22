public class lista {

  public static void main(String[] args) {


    // System.out.print(nodo.dato);
    ListaLigada l = new ListaLigada(1);
    l.insertar(1);
    l.insertar(3);
    l.insertar(4);
    l.insertar(5);
    l.insertarFin(6);
    l.imprimir();
    l.sorted(2,2);
    l.imprimir();
    l.eliminar(5);
    l.eliminar(4);
    l.eliminar(3);
    l.eliminar(2);
    l.eliminar(1);
    l.imprimir();
    l.eliminar(6);
    l.imprimir();
    l.insertar(1);
    l.insertarFin(6);


    // l.sorted(4,4);
    // // l.eliminar(1);
    // l.imprimir();
    // l.eliminar(5);
    // l.imprimir();
    // l.eliminar(1);
    // l.imprimir();
    // l.eliminar(2);
    // l.eliminar(3);
    // l.eliminar(4);
    // l.imprimir();


  } // void main

} //class lista



class ListaLigada{
  int dato;
  int talla = 0;
  ListaLigada anterior;
  ListaLigada nodo = null;
  ListaLigada m = null;




  ListaLigada(int dato){
    this.anterior = null;
    this.dato = dato;
    this.nodo = null;
  }

  public void insertar(int x){
    ListaLigada nuevo = new ListaLigada(x);
    nuevo.anterior = nodo;
    nodo = nuevo;
    // System.out.println(nodo.dato);
    this.talla++;

  }
  public void insertarFin(int x){
    ListaLigada nl = new ListaLigada(x);
    this.talla++;
    ListaLigada aux = nodo;
    // System.out.println(aux.dato);
    // System.out.println(aux.anterior.anterior.dato);
    if (aux == null) {
      nodo = nl;
    }else {
      while (aux.anterior != null) {
        // System.out.println(aux.anterior.dato);
        aux = aux.anterior;
      }
      aux.anterior = nl;
    }
    nl.anterior = nodo;
    nodo = nl;
  }


  public void imprimir(){
    ListaLigada cont = nodo;
    ListaLigada hola = cont.anterior;
    System.out.print("Los datos son: ");
    for (int i = talla; i > 0 ; i--) {
      System.out.print(cont.dato);
      cont = null;
      cont = hola;
      hola = null;
      hola = cont.anterior;
    }
    System.out.print("\n");
  }

  public void eliminar(int x){
    // System.out.print(nodo.dato);
    ListaLigada cont = nodo, borrador = null;
    ListaLigada hola = cont.anterior;
    boolean condicion = false;
    int i = talla;
    int y = 0;
    while( cont.dato != x && i > 0){
      borrador = null;
      borrador = cont;
      i--;
      cont = null;
      cont = hola;
      hola = null;
      hola = cont.anterior;
    }

    if (cont.dato == x) {
      this.talla--;

      if (borrador == null) {
        nodo = cont.anterior;

      }else{
        borrador.anterior = cont.anterior;

        // System.out.println(nodo);
      }
    }
  }


  public void sorted(int x, int y){
    ListaLigada sup, inf = null;
    sup = nodo;
    int i = talla;
    ListaLigada nuevo = new ListaLigada(y);
    // nuevo.anterior = nodo;
    // nodo = nuevo;
    // this.talla++;
    if (i == 1) {
      nodo.anterior = nuevo;
      this.talla++;
    }else{
      if (i != x) {
          while(i !=x){
            sup = sup.anterior;
            i--;
          }
        }
        inf = sup.anterior;
        sup.anterior = nuevo;
        nuevo.anterior = inf;
        this.talla++;
        System.out.println(sup.dato);
      }
    }
}
