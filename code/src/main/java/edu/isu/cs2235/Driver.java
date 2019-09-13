package edu.isu.cs2235;

import edu.isu.cs2235.algorithms.ArraySearch;
import edu.isu.cs2235.algorithms.impl.BinarySearch;
import edu.isu.cs2235.algorithms.impl.LinearSearch;
import edu.isu.cs2235.algorithms.impl.RecursiveBinarySearch;
import edu.isu.cs2235.algorithms.impl.RecursiveLinearSearch;

import java.util.Random;

import static java.lang.System.nanoTime;

/**
 * @author Brigham Campbell
 */
public class Driver {

    // rng is global so we don't get patterns in the randomness by re-instantiating the object rapidly
    Random rng = new Random();

    // These variables determine what exactly happens during our test of the algorithms' performances.
    int numberOfTriesToAverage = 10000;
    int[] arraySizes = { 300, 600, 900, 1200, 1500, 1800, 2100, 2400, 2700, 3000 };
    ArraySearch[] searchMethods = { new BinarySearch(), new LinearSearch(), new RecursiveBinarySearch(), new RecursiveLinearSearch() };

    public static void main(String[] args) {
        Driver driver = new Driver();
        if(args.length > 0 && args[0] != null) {
            driver.numberOfTriesToAverage = Integer.parseInt(args[0]);
        }
	driver.run();
    }

    /**
     * Performs the tests on each object in searchMethods, outputting the results to stdout.
     */
    public void run() {
        System.out.print("arraySize");
        for(ArraySearch searchMethod : searchMethods) {
            System.out.print(',' + searchMethod.getClass().getSimpleName());
        }
        System.out.println();

        for(int arraySize : arraySizes) {
            System.out.print(arraySize);
            Integer[] array = generateRandomIntArray(arraySize);

            for(ArraySearch searchMethod : searchMethods) {
                long totalDeltaTime = 0;
                for(int i = 0; i < numberOfTriesToAverage; i += 1) {
                    Integer randomArrayElement = array[rng.nextInt(array.length)];

                    long beginTime = System.nanoTime();
                    searchMethod.search(array, randomArrayElement);
                    long deltaTime = System.nanoTime() - beginTime;

                    totalDeltaTime += deltaTime;
                }
                System.out.print(',');
                System.out.print(totalDeltaTime / numberOfTriesToAverage);
            }
            System.out.println();
        }
    }

    /**
     *
     * @param size Size of array to generate.
     * @return An array populated with random values. The values are always
     * sorted in ascending order.
     */
    public Integer[] generateRandomIntArray(int size) {
        Integer[] array = new Integer[size];
        Integer value = 0;
        for(int i = 0; i < array.length; i += 1) {
            value += rng.nextInt(3);
            array[i] = value;
        }
        return array;
    }
}
