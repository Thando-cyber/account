package Operator. Operator1;
import java.util.*;

//import Operator.Customer.Address;

public class AccountTester {
  
    public static Customer.Address getAddress(Scanner in){
        String houseNo="",city="";
        int postalCode=0;
        
        //Get the address information from the user
        System.out.println("-----------Address Details-------------");
        System.out.print("House No.: ");
        houseNo = in.next();
        System.out.print("Street: ");
        String stret1 = in.next();
        String stret2 = in.next();
        String Street = stret1+stret2;
        System.out.print("City: ");
        city = in.next();
        System.out.print("Postal Code: ");
        postalCode = in.nextInt();
        Customer.Address address= new Customer.Address(Street,city,houseNo,postalCode);;
        // Create the Address object
        return address;
    }
    
    /**
    get the Customers information, instantiate and return the Customer object
    @param in
    @return 
    */
    public static Customer getCustomer(Scanner in){
        String idNo=""; 
        int age=0;
        char gender=' ';
        Customer.Address address=null;
        
        //Get the customer information
        System.out.println("-----------Customer Details-------------");
        System.out.print("ID Number: ");
        idNo = in.next();
        System.out.print("Name: ");
        String name1 = in.next();
        String name2 = in.next();
        String name = name1+" "+name2;
        System.out.print("Age: ");
        age = in.nextInt();
        System.out.print("Gender(F/M): ");
        gender = in.next().toUpperCase().charAt(0);
        address = getAddress(in);       //invoke the method to get the Address information
        
        Customer customer = new Customer(idNo,name,age,gender,address); // Create the Customer
        return customer;
    }
    
    /**
    get the Account information, instantiate and return the Account Object
    @param in
    @return 
    */
    public static Account openAccount(Scanner in){
        int phoneNo=0;
        Customer customer=null;
        
        //Get the account holders Phone number
        System.out.println("-----------New Account Details-------------");
        System.out.print("Phone number: +27 ");
        in = new Scanner(System.in);
        phoneNo = in.nextInt();
        
        customer = getCustomer(in); // invoke the method to get the customer details
        
        Account account = new Account(phoneNo,customer); // Create the Account
        return account;
    }
    
    /**
    search for the supplied phone number and return its position if found.
        otherwise -1 is returned.
    @param phoneNo
    @return 
    */
    public static int searchAccount(int phoneNo){
        for(int i=0;i<accountList.size();i++){
            if (accountList.get(i).getPhoneNo() == phoneNo){
                return i; // return the relevant position in the array
            }
        }
        return -1;
    }
    
    //Static Array for keeping the list of Accounts    
    static ArrayList<Account> accountList= new ArrayList<Account>();
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int choice =0;
        
        do{           
            System.out.println("---------------------------------------------------");
            System.out.println("Enter a number (1,2,3 or 4) to indicate your choice");
            System.out.println("1-Open an Account");
            System.out.println("2-Get Points");
            System.out.println("3-Get Bonus Airtime");
            System.out.println("4-Display Account Details");
            System.out.println("-1 to stop");
            System.out.println("---------------------------------------------------");
            System.out.print("Your choice:");
            choice = scan.nextInt();
            
            if (choice ==1){//Option 1
                accountList.add(openAccount(scan));
                
            }else if(choice == 2){//Option 2
                System.out.println("Customer phone number:");
                int phoneNo = scan.nextInt();
                
                int result = searchAccount(phoneNo);
                if(result !=-1){
                    System.out.println("Amount of airtime bought:");
                    int airTime = scan.nextInt();
                    
                    accountList.get(result).updatePointsBalance(airTime);
                }else{
                    throw new IllegalArgumentException("Unregistered phone number");
                }
                
            }else if(choice == 3){//Option 3
                System.out.println("Customer phone number:0");
                int phoneNo = scan.nextInt();
                
                int result = searchAccount(phoneNo);
                if(result !=-1){
                    double bonusAirTime = accountList.get(result).getBonusAirtimes();
                    System.out.println(phoneNo+" has R"+bonusAirTime+" bonus airtime");
                }else{
                    throw new IllegalArgumentException("Unregistered phone number");
                }
                
            }else if(choice == 4){//Option 4
                System.out.println("Customer phone number: 0");
                int phoneNo = scan.nextInt();
                
                int result = searchAccount(phoneNo);
                if(result !=-1){
                    System.out.println(accountList.get(result).toString());
                }else{
                    throw new IllegalArgumentException("Unregistered phone number");
                }
            }
                        
        }while(choice !=-1); // Stop option chosen        
    }
}
