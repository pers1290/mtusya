public class MyThread extends Thread {
    private double[] a;
    private double sum = 0;

    public MyThread(double[] a) {
        this.a = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
    }

    public double getSum() {
        return sum;
    }

    public static void main(String[] args) {
        double[] a = {1.0, 4.5, 0.6, 8.2, 23.1};
        int mid = a.length / 2;

        double[] m1 = new double[mid];
        double[] m2 = new double[a.length - mid];
        
        System.arraycopy(a, 0, m1, 0, mid);
        System.arraycopy(a, mid, m2, 0, a.length - mid);

        MyThread tr1 = new MyThread(m1);
        MyThread tr2 = new MyThread(m2);

        tr1.start();
        tr2.start();
        try {
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        

        double sum1 = tr1.getSum() + tr2.getSum();
        System.out.println(sum1);
    }
}