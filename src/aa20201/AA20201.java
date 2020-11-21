/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa20201;

import aa20201.data.Grafica;
import busquedas.BusquedaSecuencial;
import busquedas.Busquedas;
import busquedas.GeneradorDatos;
import ordenamiento.Burbuja;
import ordenamiento.MergeSort;

/**
 *
 * @author working
 */
public class AA20201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n = 5000;
        int[] aux;
        double[] tiempos = new double[n];
        double[] tiempo2 = new double[n];
        Burbuja b = new Burbuja();
        Burbuja b2 = new Burbuja();
        
        MergeSort m = new MergeSort();
        MergeSort m2 = new MergeSort();
       
        // complejidad algoritmica Sumatoria ( Generar los datos aleatorios + busqueda + almacenar el tiempo)
        for (int j = 0; j < n; j++){
            //aux = GeneradorDatos.generarArregloInt(j,1000);
            aux=GeneradorDatos.generarArregloFormaDesendente(j);
            
            m.ordenarMergeSort(aux);
            
            m2.ordenarMergeSort(aux);
            
            
            //b.ordenar(aux);
            //b2.ordenar(aux);
            /*for(int i=0; i<aux.length; i++)
            {
                System.out.print("Antes: "+aux[i]+" ");
            }
            System.out.println("");*/
//            b.ordenarInsertSort(aux);
            
            /*for(int i=0; i<aux.length; i++)
            {
                System.out.print("B1: "+aux[i]+" ");
            }
            System.out.println("");*/
 //           b2.ordenarInsertSort(aux);
            
           /* for(int i=0; i<aux.length; i++)
            {
                System.out.print("B2: "+aux[i]+" ");
            }
            
            System.out.println("");*/
            tiempos[j] = (int) m.gettTotal();
            tiempo2[j]=(int) m2.gettTotal();
            //System.out.println("j= "+j+" :"+tiempos[j]);
        }  
        System.out.println();
        Grafica g1 = new Grafica("N","Tiempo","Tiempos");
        g1.agregarSerie("t1",tiempos);
        g1.agregarSerie("t2",tiempo2);
        g1.crearGrafica();
        g1.muestraGrafica();
       
       
    }
    
}
