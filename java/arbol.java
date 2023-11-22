import java.util.Random;

public class arbol {

  public static void main(String[] args) {

    ArbolBinario bt = new ArbolBinario();
    bt.sumar(1);
    bt.sumar(2);
    bt.sumar(3);
    bt.sumar(4);
    bt.sumar(5);
    bt.sumar(6);
    bt.sumar(7);
    bt.contieneNodo(1);
    bt.contieneNodo(5);
    bt.contieneNodo(4);





  } // void main

} //class lista

class Node {
  int value;
  Node left;
  Node right;

  Node(int value){
    this.value = value;
    right = null;
    left = null;
  }
}

public class ArbolBinario{
  Node raiz;
  private Node addRecursive(Node nodo, int value){
    Random rand = new Random();
    int n = rand.nextInt(10);
    if(nodo == null){
      return new Node(value);
    }
    if(n%2 ==0){
      nodo.left = addRecursive(nodo.left,value);
    }else if (n%2 != 0){
      nodo.right = addRecursive(nodo.right, value);
    }else {
      return nodo;
    }
    return nodo;
  }

  public void sumar(int value){
    raiz = addRecursive(raiz, value);
  }

  private boolean contenerNodoRecursivo(Node nodo, int value){
    if(nodo == null){
      return false;
    }
    if(value == nodo.value){
      return true;
    }
    return value < nodo.value
      ? contenerNodoRecursivo(nodo.left, value)
      : contenerNodoRecursivo(nodo.right, value);
  }

  public boolean contieneNodo(int value) {
    return contenerNodoRecursivo(raiz, value);
}
}
