import java.util.HashMap;
import java.util.Scanner;


public class CustomHash {
    Object[] hashTable;


    public CustomHash(int size) {
        hashTable=new Object [size];
    }

    public int hash(int key) {
        return key%hashTable.length;
    }

  /*  public int hashCode(Drink item) {
        int hash = 7;
        hash = 31 * hash + (int) id;
        hash = 31 * hash + (Drink.name == null ? 0 : name.hashCode());
        hash = 31 * hash + (email == null ? 0 : email.hashCode());
        return hash;
    }

   */


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
            System.out.println(i+". "+hashTable[i]);
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
            System.out.println("\nPlease choose an option:");
            ch.toString();
            System.out.println();
            System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine();



        }
        System.out.println();

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













}
