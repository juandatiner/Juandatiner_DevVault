import java.util.Random;

public class Secuencial {

    public static void main(String[] args) {
        int size = 1000;  // Tamaño de las matrices
        int[][] A = generarMatriz(size, size);
        int[][] B = generarMatriz(size, size);
        int[][] C = new int[size][size];  // Matriz resultado

        long inicio = System.currentTimeMillis();  // Iniciar tiempo

        // Multiplicación de matrices secuencial
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                C[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        long fin = System.currentTimeMillis();  // Finalizar tiempo

        System.out.println("Tiempo secuencial: " + (fin - inicio) + " ms");
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
