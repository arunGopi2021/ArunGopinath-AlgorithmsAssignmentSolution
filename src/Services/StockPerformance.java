package Services;

public class StockPerformance {
    public int stocksIncreased(double[][]arr){
        int count =0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i][1]==0){
                count = count +1;
            }else{
                return count;
            }
        }

        return count;
    }

    public int stocksDecreased(double[][]arr){

        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i][1]==-1){
                count = count +1;
            }else{
                return count;
            }
        }

        return count;
        
    }
}