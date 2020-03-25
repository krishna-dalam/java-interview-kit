package interviewprep.questions.sorting;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> input = new ArrayList<>();
        for(int i=0; i<n; i++)
            input.add(scanner.nextInt());
        List<Integer> res = sort(input);
        for(int i=0; i< n; i++)
            System.out.println(res.get(i));
    }


    private static List<Integer> sort(List<Integer> arrayToSort) {

        List<List<Integer>> buckets = splitIntoUnsortedBuckets(arrayToSort);

        for(List<Integer> bucket  : buckets){
            Collections.sort(bucket);
        }

        return concatenateSortedBuckets(buckets);
    }

    private static List<Integer> concatenateSortedBuckets(List<List<Integer>> buckets){
        List<Integer> sortedArray = new LinkedList<>();
        for(List<Integer> bucket : buckets){
            sortedArray.addAll(bucket);
        }
        return sortedArray;
    }

    private static List<List<Integer>> splitIntoUnsortedBuckets(List<Integer> initialList){

        final int max = findMax(initialList);
        final int min = findMin(initialList);
        final int numberOfBuckets = initialList.size();
        final int range = max - min +1;
        final int bucketSize = ( range + initialList.size() -1 )/ initialList.size();

        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < numberOfBuckets; i++) buckets.add(new ArrayList<>());

        //distribute the data
        for (int i : initialList) {
            buckets.get(hash(i, min, bucketSize)).add(i);
        }
        return buckets;

    }

    private static int findMin(List<Integer> input) {
        int m = Integer.MAX_VALUE;
        for (int i : input){
            m = Math.min(i, m);
        }
        return m;
    }

    private static int findMax(List<Integer> input){
        int m = Integer.MIN_VALUE;
        for (int i : input){
            m = Math.max(i, m);
        }
        return m;
    }

    private static int hash(int i, int min, int bucketSize) {
        return (i - min )/ bucketSize;
    }
}


//Link : http://pages.cs.wisc.edu/~siff/CS367/Notes/sorting.html