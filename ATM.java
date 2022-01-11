import java.util.*;
import java.io.*;
class ATM{
    
    public static final Scanner sc=new Scanner(System.in);

    //CLEAR SCREEN
    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
        
    }
    
    static ATM[] atm;

    public String username,userpin;
    public int userbalance=0;
    public ArrayList<String> User_Statement;
    

    ATM(String username,String userpin,int userbalance){
        this.username=username;
        this.userpin=userpin;
        this.userbalance=userbalance;
    }
    
    //CURRENCY BASE
    static int co_2000=10;
    static int co_500=10;
    static int co_200=10;
    static int co_100=10;

    public static int withdraw1(int withdraw,int usrbalance){

        // int co_2000=10;
        // int co_500=10;
        // int co_200=10;
        // int co_100=10;

        int cu_2000=co_2000;
        int cu_500=co_500;
        int cu_200=co_200;
        int cu_100=co_100;

        int c_2000=0;
        int c_500=0;
        int c_200=0;
        int c_100=0;

        if(withdraw<usrbalance){
            
            // System.out.println(co_2000+" "+co_500+" "+co_200+" "+co_100);
        while(withdraw>0){
            if(co_2000>0 && withdraw>=2000){
                withdraw-=2000;
                co_2000-=1;
                c_2000+=1;
            }
            else if(co_500>0 && withdraw>=500){
                withdraw-=500;
                co_500-=1;
                c_500+=1;
            }
            else if(co_200>0 && withdraw>=200){
                withdraw-=200;
                co_200-=1;
                c_200+=1;
            }
            else if(co_100>0 && withdraw>=100){
                withdraw-=100;
                co_100-=1;
                c_100+=1;
            }          
            else{
                System.out.print("Insuff");
                co_2000=cu_2000;
                co_500=cu_500;
                co_200=cu_200;
                co_100=cu_100;
                c_2000=0;c_500=0;c_200=0;c_100=0;
                break;
            }
        }
        // System.out.println(co_2000+" "+co_500+" "+co_200+" "+co_100);
        System.out.println("\n___Amount deducted___\n2000 rs notes : "+c_2000+"\n500 rs notes : "+c_500+"\n200 rs notes : "+c_200+"\n100 rs notes : "+c_100);
        }
        int usrbal=((2000*co_2000)+(500*co_500)+(200*co_200)+(100*co_100));
        // return with;
        return usrbal;
    }

    //CHECK BALANCE
    public static int balance1(int n1,int n2,int n3,int n4){
        int co_2000=0;
        int co_500=0;
        int co_200=0;
        int co_100=0;

        co_2000=co_2000+n1;
        co_500=co_500+n2;
        co_200=co_200+n3;
        co_100=co_100+n4;

        int balance=(co_2000*2000)+(co_500*500)+(co_200*200)+(co_100*100);

        return balance;
    }
    
    //ADMIN LOGIN
    public static boolean adminpass(){
        Boolean b=true;
        for(int x=1;x<=3;x++){
            int a=1;
            // sc.nextLine();
            System.out.println();  
            System.out.println("_____Login info______");
            System.out.println();
            System.out.print("Enter your Admin_name : ");     
            String name=sc.nextLine();
            System.out.print("Enter password : ");     
            String password=sc.nextLine();
            if(name.equals("Admin") && password.equals("admin") && a<=3){
                System.out.println("Hello.."+name);
                System.out.println("______________");
                b=true;
                break;
                
            }
            else{
                System.out.println();
                System.out.println("Invalid name and password");
                a+=1;
                b=false;
                if(x==1){
                    System.out.println("1 Attempt over, 2 Attempt`s left");
                }
                else if(x==2){
                    System.out.println("2 Attempt`s over, 1 Attempt left");
                }
                else if(x==3){
                    System.out.println("Attempts over!!!!!");
                    break;
                }
                // sc.nextLine();
                // break;
            }
        }
        return b;
        // sc.close();
    }

    //USER LOGIN 
    
    public static int userpass(int p1,int p2,int p3){
        Boolean b=true;
        int currentuser=-1;
        for(int x=1;x<=3;x++){
            int a=1;
            // sc.nextLine();
            System.out.println();  
            System.out.println("_____Login info______");
            System.out.println();
            System.out.print("Enter your Username : ");     
            String name=sc.nextLine();
            System.out.print("Enter pin number : ");     
            String password=sc.nextLine();
            
            if (atm[p1].username.equals(name) && atm[p1].userpin.equals(password)){
                currentuser = p1;                    
                b=true;
                break;
            }
            else if(atm[p2].username.equals(name) && atm[p2].userpin.equals(password)){
                currentuser = p2;                    
                b=true;
                break;
            }
            else if(atm[p3].username.equals(name) && atm[p3].userpin.equals(password)) {
                currentuser = p3;                    
                b=true;
                break;
            }
            else{
                System.out.println();
                System.out.println("Invalid name and password");
                a+=1;
                b=false;
                if(x==1){
                    System.out.println("1 Attempt over, 2 Attempt`s left");
                }
                else if(x==2){
                    System.out.println("2 Attempt`s over, 1 Attempt left");
                }
                else if(x==3){
                    System.out.println("Attempts over!!!!!");
                    break;
                }
            }
        }
        return currentuser;
    }

public static void main(String args[]){
      
    Scanner sc=new Scanner(System.in);
    
    int balance=balance1(10,10,10,10);
    int withdraw;
    clearConsole();
    System.out.println("Welcome to ATM");

    //Users
    
    atm = new ATM[3];
    atm[0] = new ATM("raj", "1234", 5000);
    atm[0].User_Statement = new ArrayList<>();
    atm[1] = new ATM("rajesh", "1234", 6000);
    atm[1].User_Statement = new ArrayList<>();
    atm[2] = new ATM("ram", "1234", 3000);
    atm[2].User_Statement = new ArrayList<>();

    while(true){
        System.out.println("_________________________");
        System.out.println("Select your UserType...");
        System.out.println();
        System.out.println("1.Admin");
        System.out.println("2.User");
        System.out.println("3.Exit");
        System.out.println();
        int n=sc.nextInt();
        
        switch(n){
            case 1:
            clearConsole();
            if(adminpass()){
            System.out.println("Welcome Admin");
            System.out.println();
            System.out.println("1.Cash deposit");
            System.out.println("2.Check balance");
            System.out.println("3.Logout Admin");
            System.out.println();
            System.out.println("Note :-  You can perform only one operation at a time...");
            System.out.println();
            System.out.print("Enter your choise : ");
            int m=sc.nextInt();
            if(m==1){
                System.out.println("Enter amount to deposit : ");
                System.out.println();
                System.out.println("Enter 2000 rupee notes : ");
                int n1=sc.nextInt();
                System.out.println("Enter 500 rupee notes : ");  
                int n2=sc.nextInt();     
                System.out.println("Enter 200 rupee notes : ");  
                int n3=sc.nextInt();     
                System.out.println("Enter 100 rupee notes : ");  
                int n4=sc.nextInt();  
                System.out.println();

                
                balance+=balance1(n1,n2,n3,n4);
                co_2000+=n1;
                co_500+=n2;
                co_200+=n3;
                co_100+=n4;

                System.out.print("Rs : ");
                System.out.print(balance);
                System.out.print("-/");
                System.out.println();
                System.out.println("Your money Deposited Successfully...");
            }
            else if(m==2){
                System.out.println("Currect ATM balance : Rs"+balance+"-/");
                
            }
            else if(m==3){
                clearConsole();
                System.out.println("Logut Successfull!!");
                System.out.println();
                System.out.println("Thank you for using ATM");
                break;           
            }
            else{
                System.out.println("Ivalid Input");
                System.out.println("Please check the input and try againi !!!");
            }
            }  
            break;

            case 2:
            clearConsole();
            int p1=0,p2=1,p3=2;
            int c=-1;
            boolean b=false;
            int cur=userpass(p1, p2, p3);
            if(cur==0){
                c=0;
                b=true;
            }
            else if(cur==1){
                c=1;
                b=true;
            }
            else if(cur==2){
                c=2;
                b=true;
            }

            if(b==true){
            // System.out.println(c);
            clearConsole();
            System.out.println();
            System.out.println("--- Welcome User ---");
            System.out.println("\n Hello..."+atm[c].username+"\n");
            System.out.println("1.Withdraw Amount");
            System.out.println("2.Check account balance");
            System.out.println("3.Check ATM Balance");
            System.out.println("4.Mini Statement");
            System.out.println("5.Change you Pin");
            System.out.println("6.Exit");
            System.out.println();
            System.out.println("NOTE:-  You can perform only one operation at a time");
            System.out.println();
            System.out.println("Enter your choise");
            int o=sc.nextInt();
                      
            if(o==1){
                System.out.print("Enter amount to withdraw : ");
                
                withdraw=sc.nextInt();
                // System.out.println(withdraw+" "+atm[c].userbalance);
                if(balance>=withdraw && withdraw>0 && atm[c].userbalance>=withdraw && withdraw%100==0){
                    withdraw1(withdraw,atm[c].userbalance);
                    balance=balance-withdraw;
                    atm[c].userbalance=atm[c].userbalance-withdraw;
                    System.out.println("\nATM Balance : "+balance+"-/\n");
                    System.out.println("Your account balance : Rs :"+atm[c].userbalance+"-/\n- - - - - - - - ");
                    System.out.println("Please collect your cash");
                    String date = java.time.LocalDateTime.now() + "\nWithdrawn Amount -" +withdraw+"\nYour account balance - "+atm[c].userbalance+"\n";
                    atm[c].User_Statement.add(date);
                    
                }
                else if(balance<withdraw){
                    System.out.println("Insufficient balance");
                    System.out.println("Available amount at ATM - Rs : "+balance+"-/");
                }
                else{
                    System.out.println("Invalid Amount...");
                    System.out.println("Your Account balance - Rs : "+atm[c].userbalance+"-/");                   
                }
            }
            else if(o==2){
                System.out.println("Rs : "+atm[c].userbalance+"-/");
                
            }
            else if(o==3){
                System.out.println("Current ATMbalance is "+balance+"-/");
            }
            else if(o==4){
                System.out.println("Mini Statement !");
                if(atm[c].User_Statement.size()>=1){
                    for (int k = 0; k < atm[c].User_Statement.size(); k++) {
                        System.out.println(atm[c].User_Statement.get(k));
                    }
                break;
                }
                else{
                    System.out.println("\nThere is no transactions yet...");
                    break;
                }
            }
            else if(o==5){
                System.out.print("Enter the Old Pin: ");
                String oldpin = sc.next();
                sc.nextLine();
                System.out.print("Enter new pin: ");
                String newpin = sc.nextLine();
                // sc.nextLine();
                if(atm[c].userpin.equals(oldpin)){
                atm[c].userpin = newpin;
                System.out.println("Pin has been changed Successfully !!!");
                break;
                }
                else{
                    System.out.println("Incorrect old pin...");
                }
            }
            else if(o==6){
                clearConsole();
                System.out.println("Exit Successfully!!!");
                System.out.println();
                System.out.println("Thank you for using ATM");
                break;
            }
            else{
                System.out.println("Invalid Input");
                System.out.println("Please check the input and try again...");
            }
            }
            break;
            case 3:
                clearConsole();
                System.out.println("Exit Successfully!!!");
                System.out.println();
                System.out.println("Thank you for using ATM");
                System.out.println("__________________________");
                System.exit(0);
                break;
        }
    }
}
}
