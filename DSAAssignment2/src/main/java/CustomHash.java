import java.util.HashMap;
import java.util.Scanner;

public class CustomHash {
    int[] hashTable;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomNode<Object> head = null;
        CustomList<Object> list = new CustomList<>();
        HashMap<String, Integer> drinkIds = new HashMap<>();
        CustomHash ch = new CustomHash(100);
        Scanner k = new Scanner(System.in);
        int item;
        boolean running = true;




        list.add(new Drink<>("NewDrink", "A Drink that is new", "Waterford", "image.com"));

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add Show");
            System.out.println("2. Add Performance");
            System.out.println("3. Add Customer");

            int choice = scanner.nextInt();
            scanner.nextLine();


        }
        System.out.println();

    }




    public int hash(int key) {
        return key%hashTable.length*31;
    }

    public CustomHash(int size) {
        hashTable=new int [size];
    }

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
