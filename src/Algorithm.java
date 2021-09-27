import java.util.Arrays;

public class Algorithm {

    public static void main(String[] args) {
        int[] example = {5, 2, 4, 6, 1, 3, 2, 6};
        System.out.println(Arrays.toString(example));
        sort(example, 0, example.length - 1);
    }


    static void sort(int[] arrayA, int indexLeft, int indexRight) {
        if (indexLeft < 0 || indexRight > arrayA.length - 1) {
            System.out.println("Array Index Out Of Bounds Exception, for array you must enter an index from 0 to length [A] -1");
        } else {
            int temp;
            if ((indexRight - indexLeft) < 2) {
                if (arrayA[indexLeft] > arrayA[indexRight]) {
                    temp = arrayA[indexLeft];
                    arrayA[indexLeft] = arrayA[indexRight];
                    arrayA[indexRight] = temp;
                }
            } else {
                int middle = (indexLeft + indexRight) / 2;
                sort(arrayA, indexLeft, middle);
                sort(arrayA, middle + 1, indexRight);
                merge(arrayA, indexLeft, middle, indexRight);
            }
        }
    }


    static void merge(int[] arrayA, int indexLeft, int middle, int indexRight) {
        int[] bufferArray = new int[arrayA.length];
        int startIndexLeftHalf = indexLeft;
        int startIndexRightHalf = middle + 1;
        int count = 0;

// comparing numbers of arrays and writing less
        while (startIndexLeftHalf <= middle && startIndexRightHalf <= indexRight) {
            if (arrayA[startIndexLeftHalf] <= arrayA[startIndexRightHalf]) {
                bufferArray[count] = arrayA[startIndexLeftHalf];
                startIndexLeftHalf++;
            } else {
                bufferArray[count] = arrayA[startIndexRightHalf];
                startIndexRightHalf++;
            }
            count++;
        }

// if all numbers from the right half are less than the first number of the left half
        while (startIndexLeftHalf <= middle) {
            bufferArray[count] = arrayA[startIndexLeftHalf];
            startIndexLeftHalf++;
            count++;
        }
        while (startIndexRightHalf <= indexRight) {
            bufferArray[count] = arrayA[startIndexRightHalf];
            startIndexRightHalf++;
            count++;
        }

        for (int i = 0; i < count; i++) {
            arrayA[indexLeft + i] = bufferArray[i];
        }
        System.out.println(Arrays.toString(bufferArray));
    }
}
