class Task1 implements Runnable {
    private String searchFileName;

    public Task1(String searchFileName) {
        this.searchFileName = searchFileName;
    }

    @Override
    public void run() {
        System.out.println("Iniciando búsqueda del archivo: " + searchFileName);
        // Simulación de búsqueda de archivo
        try {
            Thread.sleep(2000); // Simular tiempo de búsqueda
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Archivo encontrado: " + searchFileName);
    }
}

class Task2 implements Runnable {
    private String compressFileName;

    public Task2(String compressFileName) {
        this.compressFileName = compressFileName;
    }

    @Override
    public void run() {
        System.out.println("Iniciando compresión del archivo: " + compressFileName);
        // Simulación de compresión de archivo
        try {
            Thread.sleep(3000); // Simular tiempo de compresión
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Archivo comprimido: " + compressFileName);
    }
}

public class TaskParallelism {
    public static void main(String[] args) throws InterruptedException {
        // Crear tareas
        Task1 searchTask = new Task1("documento.txt");
        Task2 compressTask = new Task2("imagen.png");

        // Crear y lanzar hilos
        Thread t1 = new Thread(searchTask);
        Thread t2 = new Thread(compressTask);

        long startTime = System.nanoTime();
        t1.start();
        t2.start();

        // Esperar que ambas tareas terminen
        t1.join();
        t2.join();
        long endTime = System.nanoTime();

        System.out.println("Tareas completadas.");
        System.out.println("Tiempo total (ms): " + (endTime - startTime) / 1_000_000);
    }
}