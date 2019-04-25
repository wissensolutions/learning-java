//package hash;
//
//import com.google.common.collect.HashBasedTable;
//import com.google.common.collect.Table;
//import org.apache.commons.lang3.tuple.ImmutablePair;
//import org.apache.commons.lang3.tuple.Pair;
//
///**
// * @author : Wissen Solutions.
// */
//public class GuavaHashTableExample {
//    public static void main(String[] args){
//        Table<Pair<String,String>, String, String> matrix
//                = HashBasedTable.create();
//        matrix.put(ImmutablePair.of("Gizmo1","band1"), "BTR1","ZPart1");
//        matrix.put(ImmutablePair.of("Gizmo2","band2"), "BTR2","ZPart2");
//        matrix.put(ImmutablePair.of("Gizmo3","band3"), "BTR3","ZPart3");
//        matrix.put(ImmutablePair.of("Gizmo1","band3"), "BTR4","ZPart4");
//        matrix.put(ImmutablePair.of("Gizmo1","band2"), "BTR5","ZPart5");
//        matrix.put(ImmutablePair.of("Gizmo2","band1"), "BTR6","ZPart6");
//
//        System.out.println(matrix.column( "BTR1").keySet());
//        System.out.println(matrix.row( ImmutablePair.of("Gizmo1","band1")));
//
//    }
//
//}
