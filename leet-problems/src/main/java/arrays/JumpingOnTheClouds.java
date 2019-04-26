//package arrays;
//
//import org.junit.Assert;
//import org.junit.Test;
//
///**
// * @author : Wissen Solutions.
// */
//public class JumpingOnTheClouds {
//    @Test
//    public void testHealthy() {
//        Assert.assertEquals(94, jumpingOnClouds(new int[]{1, 1, 1, 0, 1, 1, 0, 0, 0, 0}, 3));
//    }
//
//    static int jumpingOnClouds(int[] c, int k) {
//        int energy = 100;
//        int i =0;
//        String[] str = new String[]{}
//        while(i <c.length){
//            i = i+k;
//            energy--;
//
//            if(c[i%c.length] ==1){
//                energy -= 2;
//            }
//
//        }
//        if(i== c.length-1-1){
//            energy--;
//        }
//        return energy;
//
//    }
//
//    public static void main() {
//        try{
//            System.out.println("1");
//            throw new Exception("test");
//            System.out.println("4");
//        } catch (Exception ex){
//            System.out.println("2");
//        } finally {
//            System.out.println("3");
//        }
//
//    }
//}
