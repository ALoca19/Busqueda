/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author anita
 */
public class MergeSort {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public MergeSort() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenar(int[] datos){
        this.tInicio = System.currentTimeMillis();
        ordenarDatos(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    public void ordenarMergeSort(int[] datos ){
        this.tInicio = System.currentTimeMillis();
        int longitudArreglo = datos.length-1;
        merge_sort(datos,0, longitudArreglo); 
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    
    public long gettFinal() {
        return tFinal;
    }

    public long gettInicio() {
        return tInicio;
    }

    public long gettTotal() {
        return tTotal;
    }

    private void ordenarDatos(int[] datos) { // peor de los casos  3 + 3n + 16n2  notación "O" grande O(n2)
      int i, j, aux; // 3
        for (i = 0; i < datos.length - 1; i++) { //  3(n)
            // subir la burbuja o elemento a ordenar (ajustamos en la pos que le corresponde)
            for (j = 0; j < datos.length - 1; j++) { // 16(n)(n) = 16n2
                // si entra al if se hace intercambio
                if (datos[j + 1] < datos[j]) { // 4  13
                    aux = datos[j + 1]; // 3
                    datos[j + 1] = datos[j]; // 4
                    datos[j] = aux; // 2
                }
            }
        }
    }   
    
    
    
    public void  merge_sort(int arr[], int left, int right)//(int datos[], int l, int longitud)
    {
      if(left < right){
      //Encuentra el punto medio del vector.
      int middle = (left + right) / 2;
      
      //Divide la primera y segunda mitad (llamada recursiva).
      merge_sort(arr, left, middle);
      merge_sort(arr, middle+1, right);

      //Une las mitades.
      merge(arr, left, middle, right);
    }
    }
    
   public void merge(int arr[], int left, int middle, int right) {
  //Encuentra el tamaño de los sub-vectores para unirlos.
  int n1 = middle - left + 1;
  int n2 = right - middle;

  //Vectores temporales.
  int leftArray[] = new int [n1];
  int rightArray[] = new int [n2];

  //Copia los datos a los arrays temporales.
  for (int i=0; i < n1; i++) {
    leftArray[i] = arr[left+i];
  }
  for (int j=0; j < n2; j++) {
    rightArray[j] = arr[middle + j + 1];
  }
  /* Une los vectorestemporales. */

  //Índices inicial del primer y segundo sub-vector.
  int i = 0, j = 0;

  //Índice inicial del sub-vector arr[].
  int k = left;

  //Ordenamiento.
  while (i < n1 && j < n2) {
    if (leftArray[i] <= rightArray[j]) {
      arr[k] = leftArray[i];
      i++;
    } else {
        arr[k] = rightArray[j];
        j++;
    }
    k++;
  }//Fin del while.

  /* Si quedan elementos por ordenar */
  //Copiar los elementos restantes de leftArray[].
  while (i < n1) {
    arr[k] = leftArray[i];
    i++;
    k++;
  }
  //Copiar los elementos restantes de rightArray[].
  while (j < n2) {
    arr[k] = rightArray[j];
    j++;
    k++;
  }
  }
   
  public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}
