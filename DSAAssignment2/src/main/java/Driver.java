import java.util.HashMap;
import java.util.Scanner;

import static java.util.Objects.hash;

public class Driver {
    Scanner scanner = new Scanner(System.in);
    CustomNode<Object> head = null;
    CustomList<Object> list = new CustomList<>();

    int[] hashTable;
    HashMap<String, Integer> drinkIds = new HashMap<>();


    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x is greater, ignore left half
            if (arr[mid] < x)
                left = mid + 1;

                // If x is smaller, ignore right half
            else
                right = mid - 1;
        }

        // If we reach here, the element was not present
        return -1;
    }



    public int add(int item) {
        return add(item,item); //Using item as own key
    }

    public int add(int item, int key) {
        int home=hash(key),loc;
        loc=home;
        do{
            if(hashTable[loc]==0) { //Empty - store there
                System.out.println("Storing "+item+" at "+loc);
                hashTable[loc]=item;
                return loc;
            }
            else { //Collision - probe ahead by one...
                System.out.println("Can't store "+item+" at "+loc+
                        ". Trying "+(loc+1)+"...");
                loc=(loc+1)%hashTable.length;
            }

        }while(loc!=home);

        return -1;  //Table full - add failed!
    }

    public void displayHashTable(){
        System.out.println("Hash Table (using Linear Probing)\n=============");
        for(int i=0;i<hashTable.length;i++)
            System.out.println(i+". "+hashTable[i]);
    }



}
