package mini_project;
import java.util.Scanner;

public class DMart_Shopping_Application {
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean continue_shopping=true;
        while(continue_shopping)
        {
            System.out.println("enter the total purchase amount");
            double purchase_amount=sc.nextDouble();
             if(purchase_amount<0){
                System.out.println(" negative value not allowed");
                //sc.next();
                }
            
            else if(purchase_amount>=3000 && purchase_amount<5000)
            {
                System.out.println("you get a flat RS 500 discount, that is you have to pay after RS 500 discount : "+(purchase_amount-500));
            }
            else if(purchase_amount>=5000 && purchase_amount<10000)
            {
                System.err.println("you get 30% discount on total bill");
                double  discont_amount=purchase_amount*30/100;
                System.out.println("after discount of 30% ,your amount is :"+(purchase_amount-discont_amount));

            }
            else if(purchase_amount>=1000 && purchase_amount<15000)
            {
                System.out.println("you get a free mixer");
            }
            else if(purchase_amount>=15000)
            {
                System.out.println("you get a suit case");
            }
            else 
            {
                System.out.println("no discounts or free gift are available");
            }
              

        
           

           System.out.println("Do you want to enter any another purchase amount ?(yes/no)");
           String response=sc.next();
           if(!response.equalsIgnoreCase("yes"))
           {
            continue_shopping=false;
           }
        }
    
        System.out.println("thank you ......visit again");
            
        }
        }
    
    
    

