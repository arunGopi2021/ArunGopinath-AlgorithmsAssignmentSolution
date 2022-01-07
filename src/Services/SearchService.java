package Services;

public class SearchService {
    public String search(double val, double[][]arr){
        //We are implementing binary search

        int low =0;
        int high = arr.length-1;
        int mid = (high-low)/2;

        while(arr[mid][0]!=val){
            if(arr[mid][0]>val){
                high = mid-1;
                if(high<low){
                    return "Value not found!";
                }
                mid = (low+high)/2;
            }else{
                low=mid+1;
                if(low>high){
                    return "Value not found!";
                }
                mid = (low+high)/2;
            }

        }//while

        return "Stock of value "+val+" is present";
    }// method  


}//class
