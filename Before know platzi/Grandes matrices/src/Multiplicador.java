// Clase que representa la tarea que hará cada Thread
class Multiplicador implements Runnable {
    private int[][] A, B, C;
    private int inicio, fin;

    public Multiplicador(int[][] A, int[][] B, int[][] C, int inicio, int fin) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        int size = A.length;  // Asumimos matrices cuadradas
        for (int i = inicio; i < fin; i++) {
            for (int j = 0; j < size; j++) {
                C[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }
}


