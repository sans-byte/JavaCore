package CollectionFramwork;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListInJava {
    public static void main(String[] args) {
        int[] arr = new int[4];
        System.out.println(arr[1]); //This will give 0
        ArrayList<Integer> arrayList = new ArrayList<>(5); //We cannot use premitives here 
        // System.out.println(arrayList.get(0)); // Will give out of bound here
        arrayList.add(10);
        arrayList.add(50);
        arrayList.add(40);
        arrayList.add(60);
        arrayList.add(10);
        arrayList.add(50);
        arrayList.add(40);
        arrayList.add(60);
        arrayList.add(10);
        arrayList.add(50);
        arrayList.add(40);
        arrayList.add(60);
        System.out.println(arrayList); //Here ArrayList calles its toString method internally by itself
        System.out.println(arrayList.remove(4)); //they also return what is removed or changed
        System.out.println(arrayList.set(5, 2000));
        System.out.println(arrayList);

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr1 = new ArrayList<>();

        for(int i=0;i<5;i++){
            arr1.add(sc.nextInt());
        }

        //to get any value
        System.out.println(arr1.get(3)); //arr1[] syntax wont work here
        System.out.println(arr1);
    }

}
