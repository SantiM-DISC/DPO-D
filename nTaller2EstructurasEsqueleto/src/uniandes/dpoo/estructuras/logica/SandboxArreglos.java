package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	//Creamos nuevo array que será la copia
        int[] copiaEnteros= new int[arregloEnteros.length];
        
        //Recorremos el array original, dandole los valores de este al nuevo array
        for(int i = 0; i< arregloEnteros.length; i++) {
        	copiaEnteros[i] = arregloEnteros[i];
        }
        return copiaEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        String[] copiaCadenas = new String[arregloCadenas.length];
        for(int i = 0; i < arregloCadenas.length; i++) {
        	copiaCadenas[i] = arregloCadenas[i];
        }
    return copiaCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	//retornamos el tamaño del array :v
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	//tomar el tamaño del array
    int tamanho= arregloEnteros.length;
    //crear nuevo array y darle el tamaño del array anterior + 1
    int[] nuevoArray = new int[tamanho + 1];
    //recorrer el array principal y darle los elementos existentes al nuevo arreglo
    for (int i = 0; i<tamanho; i++) {
    	nuevoArray[i] = arregloEnteros[i];
    }
    //Se agrega el nuevo entero a la posicion tamaño para que quede de último
    nuevoArray[tamanho] = entero;
    //cambiamos variables para evitar problemas 
    arregloEnteros = nuevoArray;
    
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	int tamanio = arregloCadenas.length;
    	String[] nuevoArray = new String[tamanio + 1];
    	for (int i = 0; i < tamanio; i++) {
    		nuevoArray[i] = arregloCadenas[i];
    	}
    nuevoArray[tamanio] = cadena;
    arregloCadenas = nuevoArray;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        int conteo = 0;
        //tomamos los valores que son diferentes al valor que se desea eliminar
        for (int num : arregloEnteros) {
            if (num != valor) {
                conteo++;
            }
        }    
        // nuevo arreglo con la cantidad necesaria de espacio
        int[] nuevoArray = new int[conteo];
        
        // simplemente copiamos todos los valores que no sean valor
        int index = 0;
        for (int num : arregloEnteros) {
            if (num != valor) {
                nuevoArray[index] = num;
                index++;
            }
        }       
        arregloEnteros = nuevoArray;
    }    	
    

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int conteo = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (!arregloCadenas[i].equals(cadena)) {
                conteo++;
            }
        }
        String[] nuevoArray = new String[conteo];
        int index = 0; // Índice auxiliar para el nuevo arreglo
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (!arregloCadenas[i].equals(cadena)) {
                nuevoArray[index] = arregloCadenas[i];
                index++;
            }
        }
arregloCadenas = nuevoArray;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion < 0 ) {
    	posicion = 0;
    	}    	
    	
    	else if (posicion >= arregloEnteros.length) {
    		posicion = arregloEnteros.length;
    	}
    int[] nuevoArray = new int[arregloEnteros.length + 1];
    
    for (int i=0; i < posicion; i++) {
    	nuevoArray[i] = arregloEnteros[i];
    }
    nuevoArray[posicion] = entero;
    
    for (int i = posicion; i < arregloEnteros.length; i++) {
        nuevoArray[i + 1] = arregloEnteros[i];
    }
    
    arregloEnteros = nuevoArray;
    
    
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (posicion < 0 || posicion >= arregloEnteros.length) {
            return;
        }
        
        
        int[] nuevoArray = new int[arregloEnteros.length - 1];
        
        for (int i = 0; i < posicion; i++) {
            nuevoArray[i] = arregloEnteros[i];
        }
        
        for (int i = posicion; i < nuevoArray.length; i++) {
            nuevoArray[i] = arregloEnteros[i + 1];
        }

        arregloEnteros = nuevoArray;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] nuevoArreglo = new int[valores.length];
    	for (int i = 0; i < valores.length; i++) {
    		nuevoArreglo[i] = (int) valores[i];
    	}
    
    	arregloEnteros = nuevoArreglo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] nuevoArreglo = new String[objetos.length];
    	for (int i = 0; i < objetos.length; i++) {
    		nuevoArreglo[i] = objetos[i].toString();
    	}
    arregloCadenas = nuevoArreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int[] nuevoArreglo = new int[arregloEnteros.length];
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if(arregloEnteros[i] < 0) {
    		nuevoArreglo[i] = arregloEnteros[i] * -1; 
    	}
    		else {
    			nuevoArreglo[i] = arregloEnteros[i];
    	}
       	}
    		arregloEnteros = nuevoArreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    //metodo particion para colocar el pivote en la posicion correcta
    private int particion(String[] arr, int in, int fi) {
        // Se escoge el último elemento del arreglo como pivote
        String pivot = arr[fi];
        
        // i representa la posición en la que se ubicó el último elemento menor o igual al pivote
        int i = in - 1;
        
        // Se recorre el arreglo desde el índice in hasta fi - 1.
        for (int j = in; j < fi; j++) {
        	
            // El método compareTo devuelve un número negativo si arr[j] es lexicográficamente menor que el pivote
            if (arr[j].compareTo(pivot) <= 0) {
                // Si arr[j] es menor o igual que el pivote, se incrementa i para definir la nueva posición
                i++;
                
                // Se intercambian los elementos en las posiciones i y j
                // Esto coloca a arr[j] en la sección de elementos menores o iguales al pivote.
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Una vez finalizado el bucle, i indica la última posición en la que se colocó un elemento menor o igual al pivote.
        // Se intercambia el pivote (arr[high]) con el elemento que está en la posición i + 1, dejando al pivote en su pos final ordenada
        String temp = arr[i + 1];
        arr[i + 1] = arr[fi];
        arr[fi] = temp;
        
        // Se retorna la posición final del pivote.
        return i + 1;
    }
    private void quickSort(String[] arr, int in, int fi) {
    	// in es el indice inicial del arreglo a ordenar
    	// fi es el indice final del arreglo a ordenar
    //se verifica que el arreglo tenga al menos dos elementos, y si se cumple la condicion, entonces el arreglo ya está ordenado
    if (in < fi) {
    	//obtenemos el indice del pivote, y el método de particion reorganiza los elementos, colocando el pivote en su posición final
    	int indicePivote = particion(arr, in, fi);
    	//aplicamos recursivamente quicksort en la parte izquieda del pivote
    	quickSort(arr, in, indicePivote - 1);
    	//aplicamos recursivamente quicksort en la parte derecha del pivote
    	quickSort(arr,  indicePivote + 1, fi);
    }
    
    }
    public void organizarCadenas( )
    {
    	//para este caso usaré el algoritmo de quicksort aplicado a la cadena de strings
    	quickSort(arregloCadenas, 0, arregloCadenas.length -1);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int contador = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
        	int elemento = arregloEnteros[i];
        	if (elemento == valor) {
        		contador += 1;
        	}
         
        }
     return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int contador = 0;
        
        for (int i = 0; i < arregloCadenas.length; i++) {
            if(arregloCadenas[i].equalsIgnoreCase(cadena)) {
            	contador++;
            }
        }
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	//levamos el conteo de cuantas veces aparece el valor
        int conteo = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
        	if(arregloEnteros[i] == valor) {
        		conteo++;
        	}
        }
        
        //retornamos un arreglo vacio si no se encuentra el valor
        if(conteo == 0) {
        	return new int[0];
        }
        // creamos un arreglo con el tamaño del conteo
        int[] arrayPosiciones = new int[conteo];
        
        //rellenamos el arreglo con las posiciones en las que se encuentra valor
        int indice = 0;
        
        for (int i = 0; i < arregloEnteros.length; i++) {
        	if(arregloEnteros[i] == valor){
        		arrayPosiciones[indice] = i;
        		indice++;
        	}
        }
        return arrayPosiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
        //como buena practica, verificaremos si el arreglo está vacío
    	if (arregloEnteros.length == 0) {
    		return arregloEnteros;
    	}
    	//inicializamos variables asignandolas al primer elemento del arreglo por que no se sabe si el array está ordenado
    	int min = arregloEnteros[0];
    	int max = arregloEnteros[0];
    	//recorremos el arreglo mientras vamos actualizando los valores de las variables
    	//iniciamos en el indice 1 porque la comparacion empieza de una vez
    	for (int i = 1; i < arregloEnteros.length; i++) {
    		int indice = arregloEnteros[i];
    		if (indice < min) {
    			min = indice;
    		}
    		if (indice > max) {
    			max = indice;
    		}
    		
    	}
    	//creamos un nuevo arreglo para retornar lo requerido
    	int[] arregloFinal = new int[2];
    	arregloFinal[0] = min;
    	arregloFinal[1] = max;
    	
    	return arregloFinal;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        HashMap<Integer, Integer> histograma= new HashMap<>();
        
        for (int num : arregloEnteros) {
            // Si el número ya se encuentra en el mapa, se incrementa su contador
            if (histograma.containsKey(num)) {
                histograma.put(num, histograma.get(num) + 1);
            } else {
                // Si no se encuentra, se agrega al mapa con un contador inicial de 1
                histograma.put(num, 1);
            }
        }
        
        // Retornar el mapa que contiene el histograma.
        return histograma;
        
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	//inicializar contador
        int repetidos = 0;
        //recorrer el array 
        for(int i = 0; i<arregloEnteros.length; i++) {
        	int elem = arregloEnteros[i];
        	boolean procesado = false;
        	//recorrer desde el inicio hasta el elemento anterior a i para saber si ese elemento ya fue procesado
        	for (int j= 0; j < i; j++) { 
        		int elem_1= arregloEnteros[j];
        		//verificar
        		if (elem == elem_1) {
        			procesado = true;
        			break;
        		}
        	}
        	//
        	if (!procesado) {
                int apariciones = contarApariciones(elem);
                if (apariciones > 1) {
                    repetidos++;}
                }
        }
     return repetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
    	for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != otroArreglo[i]) {
                return false;
            }
        }
    	return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	//verificamos longitudes
        if(arregloEnteros.length != otroArreglo.length) {
        	return false;
        }
        //creamos mapa para llevar el conteo de cuanto aparece cada numero
        HashMap<Integer, Integer> mapaConteo = new HashMap<>();
        //Contamos las frecuencias 
        for (int num : arregloEnteros) {
        	mapaConteo.put(num, mapaConteo.getOrDefault(num, 0)+1);        	
        }
        //recorremos el otro arreglo
        for (int num : otroArreglo) {
        	//si no existe la llave dentro del mapa entonces no esta en el primer arreglo
        	if (!mapaConteo.containsKey(num)) {
        		return false;
        	}
        	//disminuimos el contador para el numero encontrado para tener el balance en 0
        	mapaConteo.put(num, mapaConteo.get(num)-1);
        	//si el conteo cae debajo de 0, entonces este numero aparece mas veces en el segundo arreglo
        	if (mapaConteo.get(num) < 0) {
        		return false;
        	}
        }
        
        //aseguramos que todos los contadores den 0
        for(int count : mapaConteo.values()) {
        	if (count!=0) {
        		return false;
        	}
        }
        //si todo funciona retornamos true
        return true;
        
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] nuevoArreglo = new int[cantidad];
    	
    	for (int i = 0; i < cantidad; i++) {
    		//con esta formula generamos un nro aleatorio entre el minimo y el maximo, incluyendolos
    		int numeroAleatorio = (int)(Math.random() * (maximo - minimo + 1)) + minimo;
    		nuevoArreglo[i] = numeroAleatorio;
    	}
    	arregloEnteros = nuevoArreglo;
    }

}
