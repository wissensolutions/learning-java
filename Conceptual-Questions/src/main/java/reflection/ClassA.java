package reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassA
 * Learning
 *
 * @author WissenSolutions.
 */
public class ClassA {
    private static final Logger logger = LoggerFactory.getLogger(ClassA.class);

    private int id;
    private String name;

    private ClassA(int iId, String iName) {
        id = iId;
        name = iName;
    }

    public ClassA() {
    }

    public int getId() {
        return id;
    }

    public void setId(int iId) {
        id = iId;
    }

    public String getName() {
        return name;
    }

    public void setName(String iName) {
        name = iName;
    }

    public void printObject(){
        logger.info(toString());
    }



    public ClassA createInstance(int iId, String iName){
        return new ClassA(iId,iName);
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
