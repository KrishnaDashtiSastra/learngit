


public class App{ 
    public static void main(String [] args) {
        int nums[] = {5,7,8,11,13};
        int target  = 11;
        int stepl = 0;
        int resultl = linearSearch(nums, target,stepl);
        int stepb = 0;
        int resultb = binarySearch(nums, target,stepb);
        if(resultl == -1) System.out.println("LinearSearch: Element not found");
        else System.out.println("LinearSearch: Element found at index: "+resultl);
        if(resultb == -1) System.out.println("BinarySearch: Element not found");
        else System.out.println("BinarySearch: Element found at index: "+resultb);
        System.out.println("LinearSearch Steps: "+stepl);
        System.out.println("BinarySearch Steps: "+stepb);
    }

    public static int linearSearch(int nums[], int target, int step){
        for(int i=0;i<=nums.length-1;i++){
            step++;
            if(nums[i] == target) return i;
        }
        System.out.println("LinearSearch Steps: "+step);
        return -1;
    }

    public static int binarySearch(int nums[], int target, int step){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            step++;
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) left = mid+1;
            else right = mid -1;
        }
        System.out.println("BinarySearch Steps: "+step);
        return -1;
    }
}
