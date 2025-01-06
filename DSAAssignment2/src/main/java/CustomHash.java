import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;


public class CustomHash<T> {
    Object[] hashTable;


    public CustomHash(int size) {
        hashTable=new Object [size];
    }

    public int hash(int key) {
        return key%hashTable.length;
    }






    public int add(Object item, int key) {
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

    public void displayHashTable(){
        System.out.println("Hash Table (using Linear Probing)\n=============");
        for(int i=0;i<hashTable.length;i++)
            if(hashTable[i]!=null)
            System.out.println(i+". "+hashTable[i]);
    }

    public  int binarySearch(Drink[] arr, Drink x) {
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



    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        for (int sp = 0; sp < arr.length - 1; sp++) {
            int smallestIndex = sp;
            for (int i = sp + 1; i < arr.length; i++) {
                if (comparator.compare(arr[i], arr[smallestIndex]) < 0) {
                    smallestIndex = i;
                }
            }
            if (smallestIndex != sp) {
                T temp = arr[sp];
                arr[sp] = arr[smallestIndex];
                arr[smallestIndex] = temp;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomHash ch = new CustomHash(60);
        Scanner k = new Scanner(System.in);
        int item;
        boolean running = true;





       ch.add(new Drink("NewDrink1", "A Drink that is new", "Waterford", "image.com"), 2139012);
        ch.add(new Drink("NewDrink2", "A Drink that is new", "Waterford", "image.com"), 2139013);
        ch.add(new Drink("NewDrink3", "A Drink that is new", "Waterford", "image.com"), 2139014);
        ch.add(new Drink("NewDrink4", "A Drink that is new", "Waterford", "image.com"), 2139015);
        ch.add(new Drink("NewDrink5", "A Drink that is new", "Waterford", "image.com"), 2139016);
        ch.add(new Ingredient("barley","Tibet",45),2134132 );


        while (running) {


            System.out.println("1. Print out the Entire hashtable without nulls");
            System.out.println("2. Add a new Drink");
            System.out.println("3. Add a new Ingredient");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    ch.displayHashTable();

                break;

                case 2:  // Add a new Drink to the HashTable
                    System.out.print("Enter Drink Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Drink Description: ");
                    String description = scanner.nextLine();
                    System.out.println("Enter The Location of the Drinks origin");
                    String location = scanner.nextLine();
                    System.out.println("Enter a url of the drink");
                    String url = scanner.nextLine();


                    int hashCode = name.length()*7 + description.length()*13;


                    Drink Drink = new Drink(name,description,location,url);
                    ch.add(Drink,hashCode);

                    System.out.println("Drink added at index." + hashCode);
                    break;

                case 3:
                    //Add a new ingredient to the hash Table
                    System.out.print("Enter Ingredient Name: ");
                    String iName = scanner.nextLine();
                    System.out.println("Enter Ingredient Description: ");
                    String iDescription = scanner.nextLine();
                    System.out.println("Enter a url of the drink");
                    float ABV = scanner.nextFloat();


                    int iHashCode = iName.length()*7 + iDescription.length()*13;


                    Ingredient Ingredient = new Ingredient(iName,iDescription,ABV);
                    ch.add(Ingredient,iHashCode);

                    System.out.println("Ingredient added at index." + iHashCode);
                    break;

                case 4:





            }







        }
        System.out.println();

    }






















}
