package map;


import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author : Wissen Solutions.
 */
public class TreeMapExample {

    public static void main(String[] args){
        TreeMap<Employee,String> map = new TreeMap<>((o1, o2) -> {
            if(o1.id>o2.id){
                return 1;
            } else if(o1.id<o2.id){
                return -1;
            } else {
                return 0;
            }
        });
        map.put(new Employee(100,"test"),"Dept1");
        map.put(new Employee(101,"test1"),"Dept2");
        map.put(new Employee(102,"test2"),"Dept3");
        map.put(new Employee(103,"test3"),"Dept1");
        System.out.println(map);
        System.out.println("Last Key"+ map.lastKey());
        System.out.println("first Key"+ map.firstKey());
        System.out.println("floor Entry"+ map.floorEntry(new Employee(103,"test2")));
        System.out.println("Higher Entry"+ map.higherEntry(new Employee(101,"test1")));
        System.out.println("Lower Entry"+ map.lowerEntry(new Employee(101,"test1")));
        System.out.println("Descending Map"+ map.descendingMap());
        System.out.println("poll first entry"+ map.pollFirstEntry());
        System.out.println("Descending Map"+ map.descendingMap());
    }
    private static class Employee{
        private int id;
        private String name;

        public Employee(int iId, String iName) {
            id = iId;
            name = iName;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
