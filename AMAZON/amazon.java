import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Main{
    
    public static final Scanner sc=new Scanner(System.in);
    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
        
    }
    
    public static void main(String[] args){

        while(true){
            clearConsole();
            System.out.println("Welcome to Amazon\n");
            System.out.println("1.Admin Login");
            System.out.println("2.Merchant Login");
            System.out.println("3.User Login");
            System.out.println("4.Exit");
            System.out.println("\nEnter your choice");
            int o=sc.nextInt();
            if(o==1){
                Admin.admin();
            }
            else if(o==2){
                Admin.merchant();
            }
            // else if(o==3){
            //     userpass();
            // }
            else if(o==4){
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }
        
    }

    //ADMIN LOGIN
}
class Admin{

    public static final Scanner sc=new Scanner(System.in);
    //  ArrayList<Java>li=new ArrayList<Java>();
    public String mer_name,mer_pass;
    public int mer_id=0;
    public String product;
    public int price=0,offer=0;
    public static int merchant_id=1000;
    public boolean mer_v=false;
    public static int curr_user=0;
    public static String cur_name,cur_pass;
    public static Map<String, List<String>> mer_products = new HashMap<>();
    static List<Admin> merchants = new ArrayList<>();
    static List<Admin> merchants1=new ArrayList<>();
    
    // Java java=new Java();
    static List<Java> li=new ArrayList<>();

    Admin(String name,String pass,String product,int price,int offer,int id,boolean verify) {
        this.mer_name = name;
        this.mer_pass = pass;
        this.mer_id = id;
        this.mer_v = verify;
        this.product=product;
        this.price=price;
        this.offer=offer;
    }

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

    public static void admin(){
        if(adminpass()){
            while(true){
                Main.clearConsole();
                System.out.println("Welcome Admin of amazon\n");
                System.out.println("1.ADD Merchants");
                System.out.println("2.REMOVE Merchants");
                System.out.println("3.APPROVE Merchants");
                System.out.println("4.View All Products");
                System.out.println("5.View all merchants");
                System.out.println("6.Exit");
                System.out.println("\nEnter your choice");
                int a=sc.nextInt();
                
                    if(a==1){
                        addmerchant();
                        sc.nextLine();
                        sc.nextLine();
                        // break;
                    }
                    else if(a==2){
                        removemerchant();
                        sc.nextLine();
                        sc.nextLine();
                    }
                    else if(a==3){
                        approvemerchant();
                        sc.nextLine();
                        sc.nextLine();
                    }
                    else if(a==4){
                        viewallproducts();
                        sc.nextLine();
                        sc.nextLine();
                    }
                    else if(a==5){
                        viewmerchants();
                        sc.nextLine();
                        sc.nextLine();
                    }
                    else if(a==6){
                        break;
                    }
            }
        }
    }

    public static void merchant(){
        while(true){
            Main.clearConsole();
            System.out.println("Enter for merchant login panel..");
            System.out.println("\n************************\n");
            System.out.println("1.New Merchant");
            System.out.println("2.Merchant login");
            System.out.println("3.Exit");
            System.out.println("\nEnter your choice");
            int a=sc.nextInt();
            if(a==1){
                addmerchant1();
                sc.nextLine();
                sc.nextLine();
            }
            else if(a==2){
                merchantinfo();
                sc.nextLine();
                sc.nextLine();
            }
            else if(a==3){
                break;
            }
            else{
                System.out.println("Invalid Input!!!");
            }
        }
    }

    public static void addmerchant(){
        Main.clearConsole();
        System.out.println("Enter Merchant Name :");
        String name=sc.next();
        sc.nextLine();
        System.out.println("Enter Password : ");
        String pass=sc.next();
        sc.nextLine();
        System.out.println("Enter Product name:");
        String product=sc.next();
        sc.nextLine();
        System.out.println("Enter Price of the Product");
        int price=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Discount offer of the Product");
        int offer=sc.nextInt();
        sc.nextLine();
        merchants.add(new Admin(name,pass,product,price,offer,++merchant_id,true));
        System.out.println("\nNew Merchant added Successfully...");
        System.out.println(merchants.size());
        System.out.println("Enter to continue");
    }

    public static void addmerchant1(){
        Main.clearConsole();
        System.out.println("Enter Merchant Name :");
        String name=sc.next();
        sc.nextLine();
        System.out.println("Enter Password : ");
        String pass=sc.next();
        sc.nextLine();
        System.out.println("Enter Product name:");
        String product=sc.next();
        sc.nextLine();
        System.out.println("Enter Price of the Product");
        int price=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Discount offer of the Product");
        int offer=sc.nextInt();
        sc.nextLine();
        merchants1.add(new Admin(name,pass,product,price,offer,++merchant_id,false));
        System.out.println("\nNew Merchant added Successfully...");
        // System.out.println(merchants.size());
        System.out.println("enter to continue");
    }

    public static void removemerchant(){
        Main.clearConsole();
        for(Admin i:merchants){
            System.out.println("ID - "+i.mer_id+" -> Name - "+i.mer_name);
        }
        System.out.println("Enter ID number to remove merchant");
        int idno=sc.nextInt();
        // sc.nextLine();
        System.out.println("Click to proceed!!\n(y/n)");
        sc.nextLine();
        String select=sc.next();
        System.out.println("Press Enter to remove");
        for(int i=0;i<merchants.size();i++){
            if(idno==merchants.get(i).mer_id && select.equals("y") ){
                merchants.remove(i);
                System.out.println("\nMerchant Removed Successfully");
            }
        }
    }

   public static void approvemerchant(){
        System.out.println("Unapproved Merchants");
        int c=0;
        for(Admin i:merchants1){
            if(i.mer_v==false){
                System.out.println(i.mer_id+" -> "+i.mer_name);
                c++;
            }
        }
        if(c>0){
            System.out.println("Enter id number to Approve merchants");
            int id=sc.nextInt();
            System.out.println("Click to proceed !!(y/n)");
            // sc.nextLine();
            String s=sc.next();
            if(s.equals("y")){
                for(Admin i:merchants1){
                    if(i.mer_id==id && i.mer_v==false){
                        i.mer_v=true;
                        merchants.add(new Admin(i.mer_name,i.mer_pass,i.product,i.price,i.offer,i.merchant_id,i.mer_v));
                        System.out.println("Merchant Approved Successfully...");                       
                    }                   
                }
                System.out.println(merchants.size());
            }

        }
   }
    
   public static void viewallproducts(){
       System.out.println("List of ALL Mertchant products");
       int j=1;
        for(Admin i:merchants){
            System.out.println(j+") ID - "+i.mer_id+"\n   Product - "+i.product+"\n   Price - "+i.price+"\n   Offer - "+i.offer+"\n");
            j++;
        }
   }

   public static void viewmerchants(){
        System.out.println("List of ALL Merchants\n");
        int j=1;
        for(Admin i:merchants){
            System.out.println(i.mer_name+" - "+i.mer_id);
            j++;
       }
   }

   public static void merchantinfo(){
       System.out.println("Enter merchant name");
       sc.nextLine();
       String name=sc.next();
       System.out.println("Enter password");
       sc.nextLine();
       String pass=sc.next();
        for(Admin i:merchants){
            if(i.mer_name.equals(name) && i.mer_pass.equals(pass)){
                
                // while(true){
                    Main.clearConsole();
                    System.out.println("Welcome "+i.mer_name+"\n");
                    curr_user=i.mer_id;
                    cur_name=i.mer_name;
                    cur_pass=i.mer_pass;
                    merchant_login();

               
            }
            else{
                for(Admin j:merchants1){
                    if(j.mer_name.equals(name) && j.mer_pass.equals(pass)){
                        System.out.println("Wait your request is pending!!\n contact admin for approval");
                    }
                    else{
                        System.out.println("Account not fount\n Try later...\n");
                        merchantinfo();
                    }
                }
            }
        }
   }

   public static void merchant_login(){
       boolean exit=false;
        while(!exit){
            System.out.println("Welcome "+cur_name+"\n");
            System.out.println("1.Add products");
            System.out.println("2.Update products");
            System.out.println("3.View Products");
            System.out.println("4.Exit");
            System.out.println("\nEnter your choice..");
            int a=sc.nextInt();
            if(a==1){
                addproducts();
                // System.out.println("Enter to Continue...");
                sc.nextLine();
                sc.nextLine();
            }

            else if(a==3){
                viewproducts();
                sc.nextLine();
                sc.nextLine();
                
            }
            else if(a==4){
                // break;
                // sc.nextLine();
                // sc.nextLine();
                // break;
                exit=true;
            }
            else{
                System.out.println("Invalid input");
            }
        }
        
   }
   

   public static void addproducts(){
    System.out.print("Enter product name : ");
        String pro_name = sc.next().toLowerCase();
    //     // products.add(pro_name);
        System.out.print("Enter product prize : ");
        int price=sc.nextInt();
    //     products.add(price);
    //     // product.add(sc.next
        System.out.print("Enter offer of the product : ");
        int offer=sc.nextInt();
    //     // product.add(sc.next());
    //     products.add(offer);
    li.add(new Java(cur_name,pro_name,price,offer));
   }

	public static void viewproducts() {
	//    ArrayList<Java>li=new ArrayList<Java>();
	   for(Java java:li) {
           if(java.getMerch_name().equals(cur_name))
			System.out.println("Merch_Name:"+java.getMerch_name()+" , "+"Product:"+java.getProduct()+" , "+"Price:"+java.getPrice()+" , "+"Offer:"+java.getOffer()+"%");
	   }

	}
}
class Java{
   private String Merch_name;
   private String product;
   private int price;
   private int offer;
  public Java(String Merch_name,String product, int price,int offer) {
	this.Merch_name =Merch_name;
	this.product = product;
	this.price = price;
	this.offer = offer;
  }
    public  String getMerch_name() {
    	return Merch_name;
    }
    
    public void setName(String Merch_name) {
    	this.Merch_name = Merch_name;
    }
    
    public String getProduct() {
    	return product;
    }
    
    public void setProduct(String product) {
    	this.product = product;
    }
    
    public int getPrice() {
    	return price;
    }
    
    public void setPrice(int price) {
    	this.price = price;
    }
    
    public int getOffer() {
    	return offer;
    }
    
    public void setOffer(int offer) {
    	this.offer =offer;
    }
}
