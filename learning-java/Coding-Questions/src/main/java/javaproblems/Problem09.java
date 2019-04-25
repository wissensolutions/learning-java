package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * Problem 09
 * <br> Problem Statement :
 *
 * An animal shelter, which holds only dogs and cats, operates
 * on a strictly "first in, first out" basis. People must adopt
 * either the "oldest" (based on arrival time) of all animals at
 * the shelter, or they can select whether they would prefer a dog
 * or a cat (and will receive the oldest animal of that type). They
 * cannot select which specific animal they would like. Create a data
 * structure to maintain this system and implement operations such as
 * enqueue, dequeueAny, dequeueDog and dequeueCat. You may use the
 * built in linked list data structure.
 *
 * </br>
 *
 * @author WissenSolutions.
 */
public class Problem09 {
    private static final Logger logger = LoggerFactory.getLogger(Problem09.class);

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("Test1",AnimalType.DOG);
        shelter.enqueue("Test1",AnimalType.CAT);
        shelter.enqueue("Test2",AnimalType.CAT);
        shelter.enqueue("Test3",AnimalType.CAT);
        shelter.enqueue("Test4",AnimalType.DOG);

        logger.info("Animal1={}",shelter.dequeueAny());

        logger.info("Animal2={}",shelter.dequeueAny());

        logger.info("Animal3={}",shelter.dequeueAny());
    }

    static class AnimalShelter{
         private final LinkedList<Animal> catList = new LinkedList<>();
         private final LinkedList<Animal> dogList = new LinkedList<>();
         public void enqueue (String name,AnimalType iAnimalType){
             Animal newAnimal = new Animal(name,LocalDateTime.now(),iAnimalType);
             switch (iAnimalType){
                 case CAT:
                     catList.add(newAnimal);
                 case DOG:
                     dogList.add(newAnimal);
             }
         }
         public Animal dequeueAny(){
             //LinkedList maintains insertion order. So first element should be aged one
             if(catList.size() == 0){
                 return dogList.poll();
             }
             if(dogList.size() == 0){
                 return catList.poll();
             }
             Animal dogTypeAnimal = dogList.peek();
             Animal catTypeAnimal = catList.peek();
             if(dogTypeAnimal.getAgeInShelter().isAfter(catTypeAnimal.getAgeInShelter())){
                 return catList.poll();
             } else {
                 return dogList.poll();
             }

         }

        public Animal dequeueDog(){
            //LinkedList maintains insertion order. So first element should be aged one
            return dogList.poll();

        }
        public Animal dequeueCat(){
            //LinkedList maintains insertion order. So first element should be aged one
            return catList.poll();

        }

    }



    static class Animal {
        private String name;
        private LocalDateTime ageInShelter;
        private AnimalType type;

        public Animal(String iName, LocalDateTime iAgeInShelter, AnimalType iType) {
            name = iName;
            ageInShelter = iAgeInShelter;
            type = iType;
        }


        public LocalDateTime getAgeInShelter() {
            return ageInShelter;
        }


        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", type=" + type +
                    '}';
        }
    }

    public enum AnimalType {
        DOG(1),
        CAT(2);
        private int distictNumericValue;

        private AnimalType(int typeVal ){
            distictNumericValue = typeVal;
        }


    }
}
