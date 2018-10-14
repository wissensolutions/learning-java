//package concurrency;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.*;
//import java.util.concurrent.BrokenBarrierException;
//import java.util.concurrent.CyclicBarrier;
//
///**
// * CyclicBarrierDemo
// * Learning
// *
// * @author WissenSolutions.
// */
//public class CyclicBarrierDemo {
//    private static final Logger logger = LoggerFactory.getLogger(CyclicBarrierDemo.class);
//    private CyclicBarrier cyclicBarrier;
//    private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<T>());
//    private Random random = new Random();
//    private int NUM_PARTIAL_RESULTS;
//    private int NUM_WORKERS;
//    public static void main(String[] args) {
//        final CyclicBarrier barrier = new CyclicBarrier(3);
//        Thread serviceOneThread = new Thread(()-> System.out.println(1));
//        Thread serviceTwoThread = new Thread(()->System.out.println(2));
//        serviceOneThread.start();
//        serviceTwoThread.start();
//        try {
//            barrier.await();
//        } catch (InterruptedException e) {
//            System.out.println("Main Thread interrupted!");
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            System.out.println("Main Thread interrupted!");
//            e.printStackTrace();
//        }
//        System.out.println("Ending both the services at"+new Date());
//
//
//    }
//
//
//}
