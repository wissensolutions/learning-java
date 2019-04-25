package javaproblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <br> Problem Statement:
 *
 * Using lambda expressions, write a function
 * "List<Integer> getRandomSubset(List<Integer> list)"
 * that returns a random subset of arbitrary size.
 * All subsets including the empty subset are likely
 * equally to be chosen.
 *
 * For Ex: if list contains : 1,2,3,4,5,6,7,8,9
 * Return Values should be subset of these list. i.e some numbers will be missed
 * </br>
 *
 *
 * @author WissenSolutions.
 */
public class Problem01 {
    private static final Logger logger = LoggerFactory.getLogger(Problem01.class);

    public static void main(String[] args) {
        logger.info("List={}",getRandomSubsetUsingLoop(Arrays.asList(1,2,3,4,5,6,7,8,9)));
        logger.info("List={}",getRandomSubsetUsingStream(Arrays.asList(1,2,3,4,5,6,7,8,9)));
    }

    /**
     * Method to get random subset using advanced java loop
     * NOTE : We will use random to solve this problem. There can be other better ways
     *
     */
    public static List<Integer> getRandomSubsetUsingLoop(List<Integer> list) {
        List<Integer> randomSubset = new ArrayList<>();
        Random random = new Random();
        for (Integer item : list) {
            if (random.nextBoolean()) {
                randomSubset.add(item);
            }
        }
        return randomSubset;
    }

    public static List<Integer> getRandomSubsetUsingStream(List<Integer> list) {
        Random random = new Random();
        return list.stream().filter(item->random.nextBoolean()).collect(Collectors.toList());
    }
}
