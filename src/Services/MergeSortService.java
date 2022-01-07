package Services;


public class MergeSortService {
    //display method
    public void display2D(double[][]arr, boolean reverse){
        if(reverse == false){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i][0]+" ");
            }//for-loop
        }else{
            for(int i=arr.length-1;i>=0;i--){
                System.out.print(arr[i][0]+" ");
            }
        }//if-else block
        System.out.println();
    }




    //merge method - (In Development Phase now)
    private static void merge2D(double[][]arr,int start, int mid, int end, int pos){
        // "pos" variable will determine which element of the 1D array to use for comparison and merging
        // when "pos" = 0, we are merging on basis "price of shares"
        // when "pos" = 1, we are merging on basis of whether there is increase in price of shares

        //Create two tmp arrays 
        double[][] leftArr = new double[mid-start+1][2];
        double[][] rightArr = new double[end-mid][2];

        //copy values to the tmp arrays
        int leftPointer =0;
        int rightPointer =0;
        for(int i=start;i<end+1;i++){
            if(i<mid+1){
                leftArr[leftPointer] = arr[i];
                leftPointer++;
            }else{
                rightArr[rightPointer] = arr[i];
                rightPointer++;
            }
        }


        //Reset the pointers
        leftPointer =0;
        rightPointer =0;
        


        // merge logic
        int k=start;
        while((leftPointer<leftArr.length) && (rightPointer<rightArr.length)){
            if(leftArr[leftPointer][pos]>rightArr[rightPointer][pos]){
                arr[k] = rightArr[rightPointer];
                rightPointer++;
                k++;
            }else{
                arr[k] = leftArr[leftPointer];
                leftPointer++;
                k++;
            }
        }//1st while block ends here




        while(k<=end){
            if(leftPointer==leftArr.length){
                //copy remaining right array elements
                arr[k] = rightArr[rightPointer];
                k++;
                rightPointer++;
            }else{
                // else copy remaining left array elements
                arr[k] = leftArr[leftPointer];
                k++;
                leftPointer++;      
            }
        }//2nd while block ends here


        
    }//merge method ends here


    //mergeSort method
    public void mergeSortMethod2D(double[][] arr, int start, int end, int pos){
        if(start<end){
            int mid = (start+end)/2;
            mergeSortMethod2D(arr, start, mid, pos);            
            mergeSortMethod2D(arr, mid+1, end, pos);
            merge2D(arr, start, mid, end, pos);
            
        }
    }//mergeSortmethod



    
    
}
