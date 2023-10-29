public class DobleQueue{
  public static void main(String[] args) {
    DobleCola d = new DobleCola(5);
    // d.enQueueRight(1);
    d.enQueueLeft(5);
    d.enQueueLeft(4);
    d.enQueueLeft(3);
    d.enQueueRight(1);
    d.enQueueRight(2);
        d.display();
    d.enQueueRight(6);
    d.deQueueRight();
    d.display();
    d.deQueueRight();
    d.display();
    d.deQueueRight();
    d.display();
    d.deQueueRight();
    // d.deQueueLeft();
    // d.deQueueLeft();
    for (int f :d.q ) {
      System.out.print(f);

    }
  }
}


class DobleCola{
    public int inicio, fin, tamaño, value, cont;
    int q[];

    DobleCola(int tamaño) {
      this.tamaño = tamaño;
      this.cont = 0;
      this.fin = this.inicio = -1;
      this.q = new int[tamaño];
    }

    boolean isEmpty(){
      if(fin == -1 && inicio == -1){
        return true;
      }else{
        return false;
      }
    }

    boolean isFull(){
      if (cont == tamaño) {
        return true;
      }else{
        return false;
      }
    }

    void enQueueRight(int item){
      if (isFull()) {
        System.out.println("Esta lleno la cola circular");
      }else if(inicio == -1 && fin == -1){
        fin++;
        inicio++;
        q[fin] = item;
        System.out.println("Esta el elemento: "+item);
        cont++;
      }else{
        fin = (fin+1)%tamaño;
        q[fin] = item;
        System.out.println("Esta el elemento: "+item);
        cont++;
      }
    }

    void enQueueLeft(int item){
      if (isFull()) {
        System.out.println("Esta lleno la cola circular");
      }else if(inicio == -1 && fin == -1){
        inicio=tamaño-1;
        fin = tamaño-1;
        q[fin] = item;
        System.out.println("Esta el elemento: "+item);
        cont++;
      }else{
        inicio = (inicio-1)%tamaño;
        q[inicio] = item;
        System.out.println("Esta el elemento: "+item);
        cont++;
      }
    }

    int deQueueLeft(){
      if(isEmpty()){
        System.out.println("La cola circular esta vacia");
      }else if(inicio == fin && inicio != -1 && fin != -1){
        value = q[inicio];
        inicio = -1;
        fin = -1;
        for (int i = 0;i < tamaño  ;i++ ) {
          q[i] = 0;
        }
        cont--;
      }else{
        value = q[inicio];
        q[inicio] = 0;
        inicio = (inicio +1)%tamaño;
        cont--;
      }
      return value;
    }


    int deQueueRight(){
      if(isEmpty()){
        System.out.println("La cola circular esta vacia");
      }else if(inicio == fin && inicio != -1 && fin != -1){
        value = q[inicio];
        inicio = -1;
        fin = -1;
        for (int i = 0;i < tamaño  ;i++ ) {
          q[i] = 0;
        }
        cont--;
      }else{
        value = q[fin];
        q[fin] = 0;
        if (fin == 0) fin = 5;
        fin = (fin -1)%tamaño;
        cont--;
      }
      return value;
    }

    void display(){
      if(isEmpty()){
        System.out.println("Esta vacia la cola circular");
      }else{
        System.out.println("Los elementos de la cola circular son: ");
        for (int i = inicio;i != fin ; i=(i+1)%tamaño ) {
            System.out.print(q[i]+" ");

        }
        System.out.print(q[fin]+"\n");

      }
    }




}
