package hust.soict.oop.aims;
public class MemoryDaemon implements Runnable {
    public void run() {
        Runtime rt = Runtime.getRuntime();
        long used, memoryUsed = 0;
        while (true) {
            used = rt.totalMemory() - rt.freeMemory();
            if (used != memoryUsed) {
                System.out.println("\tMemory used = " + used);
                memoryUsed = used;
            }
        }
    }
}
