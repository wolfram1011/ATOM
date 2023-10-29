public class LinkedList {

  public static void main(String[] args) {
  }

}


class NodoLEG{
  int dato;
  NodoLEG siguiente;

  NodoLEG(int dato){
    this(dato,null);
  }
  NodoLEG(int dato, NodoLEG siguiente){
    this.dato = dato;
    this.siguiente = siguiente;
  }
}

public class LEG {
  protected NodoLEG primero;
  protected int talla;
  public LEG(){
    primero = null;
    talla = 0;
  }

    public void insertar(int x){
      // primero = new NodoLEG(x,primero); this.talla++;
      NodoLEG nuevo = new NodoLEG(x);
      nuevo.siguiente = primero;
      primero = nuevo; this.talla++;
    }
}
