package Backtracking;



public class SubsetSum {
    static int x[];    
    // int k denotes the current index int the array we are dealing with
    public static void printSubsets(int [] arr, int currSum, int k, int target){
        
        //if current sum == target that means we have found one of the subsets
        //we can print it:
        if(currSum == target){
            for(int i = 0; i<arr.length; i++){
                if(x[i] == 1){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        //if k has reached end of array OR current sum is greater than target
        //we backtrack
        if(k>=arr.length || currSum > target){
            return;
        }
        //include
        x[k] = 1;
        printSubsets(arr, currSum+arr[k], k+1, target);

        //exclude
        x[k] = 0;
        printSubsets(arr, currSum, k+1, target);
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        x = new int[arr.length];
        printSubsets(arr, 0, 0, 10);
    }
}
