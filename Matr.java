public class Matr extends Thread {
    private int[] row;
    private int max = 0;

    public Matr(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        for (int i = 0; i < row.length; i++) {
            if (row[i] > max) {
                max = row[i];
            }
        }
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 3, 9},
            {7, 2, 8, 4},
            {6, 0, 3, 5}
        };
        Matr[] threads = new Matr[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new Matr(matrix[i]);
            threads[i].start();
        }

        try{
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());}

        int max1 = 0;
        for (int i = 0; i < threads.length; i++) {
            int rowMax = threads[i].getMax();
            if (rowMax > max1) {
                max1 = rowMax;
            }
        }

        System.out.println(max1);
    }
}