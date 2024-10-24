import java.util.Random;

public class Paralelo {
    public static void main(String[] args) throws InterruptedException {
        int size = 1000;  // Tamaño de las matrices
        int[][] A = generarMatriz(size, size);
        int[][] B = generarMatriz(size, size);
        int[][] C = new int[size][size];  // Matriz resultado

        long inicio = System.currentTimeMillis();  // Iniciar tiempo

        // Crear y lanzar 4 threads para hacer la multiplicación en paralelo
        Thread t1 = new Thread(new Multiplicador(A, B, C, 0, size / 4));
        Thread t2 = new Thread(new Multiplicador(A, B, C, size / 4, size / 2));
        Thread t3 = new Thread(new Multiplicador(A, B, C, size / 2, 3 * size / 4));
        Thread t4 = new Thread(new Multiplicador(A, B, C, 3 * size / 4, size));

        //El hilo 1 procesa las filas 0 a 249.
        //El hilo 2 procesa las filas 250 a 499.
        //El hilo 3 procesa las filas 500 a 749.
        //El hilo 4 procesa las filas 750 a 999.

            t1.start();
            t2.start();
            t3.start();
            t4.start();

        // Esperar a que los 4 threads terminen
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        long fin = System.currentTimeMillis();  // Finalizar tiempo

            System.out.println("Tiempo paralelo: " + (fin - inicio) + " ms");
    }

    // Método para generar una matriz con valores aleatorios
    private static int[][] generarMatriz(int filas, int columnas) {
        Random random = new Random();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(10);  // Números entre 0 y 9
            }
        }
        return matriz;
    }
}

