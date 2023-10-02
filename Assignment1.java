//Student: Jonathan Clement
//Prof. Jillian Morgan
//Class: CSCI 1302
//Date: 8/19/2021


public class Assignment1
{
   public static void main(String[] args)
   {
      String[] months = {"January","Febuary","March"};
      String[] employees = {"Trenton","Marley","Ronin","Ivy"};
      double[][] sales =  {{2420.89,3299.99,4277.88},
                           {7355.07,4470.89,9236.13},
                           {6856.72,6038.08,3518.80},
                           {8531.36,3037.39,9146.95}};
      
      for(int i = 0; i < sales.length; i++)
      {
         double totalSales = 0;
         for(int j = 0; j < sales[0].length; j++)
         {  
            totalSales += sales[i][j];
         }
        
         System.out.println(employees[i] + " sold $" + totalSales + " this month.");
      }
      
      System.out.println();
      
      for(int i = 0; i < sales.length; i++)
      {
         double totalSales = 0;
         for(int j = 0; j < sales[0].length; j++)
         {  
            totalSales += sales[i][j];
         }
         double totalSalesAverage;
         
         totalSalesAverage = totalSales/3;
            
                    
      }
      
            
   }

}