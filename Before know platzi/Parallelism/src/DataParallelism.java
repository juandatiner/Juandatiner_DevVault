class DataParallelism implements Runnable {
    private int[] array;
    private int start;
    private int end;
    private double sum;  // Resultado parcial

    public DataParallelism(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];  // Sumar elementos de la porción asignada
        }
    }

    public double getSum() {
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        int size = 1000000;
        int[] array = new int[size];

        // Llenar el arreglo con valores
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

        // Crear dos hilos para paralelizar el cálculo
        DataParallelism p1 = new DataParallelism(array, 0, size / 2);
        DataParallelism p2 = new DataParallelism(array, size / 2, size);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        long startTime = System.nanoTime();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long endTime = System.nanoTime();

        // Calcular el promedio sumando las partes y dividiendo entre el tamaño total
        double totalSum = p1.getSum() + p2.getSum();
        double average = totalSum / size;

        System.out.println("Promedio: " + average);
        System.out.println("Tiempo de ejecución (ms): " + (endTime - startTime) / 1_000_000);
    }
}