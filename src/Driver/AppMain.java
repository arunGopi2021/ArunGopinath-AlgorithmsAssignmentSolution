package Driver;
import java.util.Scanner;

import Services.MergeSortService;
import Services.SearchService;
import Services.StockPerformance;


public class AppMain {

    private static void menuDisplay(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("Enter the operation that you want to perform");
        System.out.println("1. Display the companies stock prices in ascending order");
        System.out.println("2. Display the companies stock prices in descending order");
        System.out.println("3. Display the total no of companies for which stock prices rose today");
        System.out.println("4. Display the total no of companies for which stock prices declined today");
        System.out.println("5. Search a specific stock price");
        System.out.println("6. Press 0 to exit");
        System.out.println("------------------------------------------------------------------");
    }



    public static void main(String[] args) {
        Scanner scnObj = new Scanner(System.in);

        // Get the number of companies from the user
        System.out.print("\nEnter the number of companies: ");
        int numOfCompanies = scnObj.nextInt();


       /*
       For this problem we will use 2-D array.
       Each 1-D Array's first entry will be the price of the stock
       Each 1-D Array's second entry will indicate whether price has increased or decreased.

       We will use "-1.0" to signify that the price has decreased.
       We will use "0.0" to signify that the price has increased.    
       */

       double[][] stocksData = new double[numOfCompanies][2];
       String priceIncreaseOrDecrease;



       // Get stock data from the User

       for(int i=0; i<numOfCompanies; i++){
            System.out.println("Enter the current stock price of company "+(i+1));
            stocksData[i][0] = scnObj.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday? True/False");
            priceIncreaseOrDecrease = scnObj.next().toLowerCase();
            if((priceIncreaseOrDecrease.equals("t")) || (priceIncreaseOrDecrease.equals("true"))){
                stocksData[i][1] = 0;
            }else{
                stocksData[i][1] = -1;
            }

       }// for loop




       // Display Menu and Collect the user choice and exceute the appropriate function
       // Create helper variable for user choice.
       // Initialize objects from the Service package

       int userChoice;
       MergeSortService mergeSortServiceObject = new MergeSortService();
       StockPerformance stockPerformanceObject = new StockPerformance();  
       SearchService searchObject = new SearchService();     
       

       
       do{
        menuDisplay();
        userChoice = scnObj.nextInt();
        switch(userChoice){
            case 1:{
                System.out.println("Displaying stocks in ascending order");
                mergeSortServiceObject.mergeSortMethod2D(stocksData, 0, numOfCompanies-1, 0);
                mergeSortServiceObject.display2D(stocksData,false);
                break;
            }
            case 2:{
                System.out.println("Displaying stocks in descending order");
                mergeSortServiceObject.mergeSortMethod2D(stocksData, 0, numOfCompanies-1, 0);
                mergeSortServiceObject.display2D(stocksData,true);
                break;
            }
            case 3:{
                System.out.println("Displaying stocks whose prices have increased");
                mergeSortServiceObject.mergeSortMethod2D(stocksData, 0, numOfCompanies-1, 1);
                System.out.println("Number of companies whose stock prices increased: "+ 
                stockPerformanceObject.stocksIncreased(stocksData));
                break;
            }
            case 4:{
                System.out.println("Displaying stocks whose prices have decreased");
                mergeSortServiceObject.mergeSortMethod2D(stocksData, 0, numOfCompanies-1, 1);
                System.out.println("Number of companies whose stock prices decreased: "+ 
                stockPerformanceObject.stocksDecreased(stocksData));
                break;
            }
            case 5:{
                System.out.println("Enter a stock price to search");
                mergeSortServiceObject.mergeSortMethod2D(stocksData, 0, numOfCompanies-1, 0);
                double valToBeFound = scnObj.nextDouble();
                System.out.println(searchObject.search(valToBeFound, stocksData));
                break;
            }
            default:{
                System.out.println("Exited Successfully");
                userChoice = 0;
            }
        }// switch block
       }while(userChoice != 0);
      
       scnObj.close();
    }// main method
    
}
