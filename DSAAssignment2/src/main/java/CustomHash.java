import java.util.HashMap;
import java.util.Scanner;

public class CustomHash {
    Drink[] hashTable;




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomNode<Object> head = null;
        HashMap<String, Integer> drinkIds = new HashMap<>();
        CustomHash ch = new CustomHash(100);
        Scanner k = new Scanner(System.in);
        int item;
        boolean running = true;




       // ch.add(new Drink<>("NewDrink", "A Drink that is new", "Waterford", "image.com"));

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add Show");
            System.out.println("2. Add Performance");
            System.out.println("3. Add Customer");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a new Show to the list
                   // displayHashTable();
            }


        }
        System.out.println();

    }




    public int hash(int key) {
        return key%hashTable.length*31;
    }

    public CustomHash(int size) {
        hashTable=new Drink [size];
    }

    public static int binarySearch(Drink[] arr, Drink x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Compare x with the element at mid using compareTo()
            int comparison = x.compareTo(arr[mid]);

            if (comparison == 0)
                return mid;

            if (comparison > 0)
                left = mid + 1;

            else
                right = mid - 1;
        }

        // If we reach here, the element was not present
        return -1;
    }




    public int add(Drink item, int key) {
        int home=hash(key),loc;
        loc=home;
        do{
            if(hashTable[loc]==null) { //Empty - store there
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

    public  void displayHashTable(){
        System.out.println("Hash Table (using Linear Probing)\n=============");
        for(int i=0;i<hashTable.length;i++)
            System.out.println(i+". "+hashTable[i]);
    }







}
