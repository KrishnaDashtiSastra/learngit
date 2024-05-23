public class DataStructures {
    public int linearSearch(int nums[], int target){
        for(int i=0;i<=nums.length-1;i++){
            if(nums[i] == target) return i;
        }
        return -1;
    }

    public int binarySearch(int nums[], int target){
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) left = mid+1;
            else right = mid -1;
        }
        return -1;
    }

}
