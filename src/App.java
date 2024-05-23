


public class App{ 
    public static void main(String [] args) {
        int nums[] = {5,7,8,11,13};
        int target  = 11;

        DataStructures ds = new DataStructures();

        int resultl = ds.linearSearch(nums, target);
        int resultb = ds.binarySearch(nums, target);
        if(resultl == -1) System.out.println("LinearSearch: Element not found");
        else System.out.println("LinearSearch: Element found at index: "+resultl);
        if(resultb == -1) System.out.println("BinarySearch: Element not found");
        else System.out.println("BinarySearch: Element found at index: "+resultb);
    }

    

    
}
