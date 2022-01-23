import java.util.*;
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
            else if(o==3){
                Admin.user();
            }
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

    public String mer_name,mer_pass;
    public int mer_id=0;

    public static String product;
    public static int pro_price=0,pro_offer=0;

    public static int merchant_id=1000;
    public static boolean mer_v=false;

    public static int curr_user=0;
    public static String cur_name,cur_pass;

    public static String usr_name,usr_pass,usr_mail,usr_phone;
    public static int usr_wallet=0;

    public static Map<String, List<String>> mer_products = new HashMap<>();

    static List<Admin> merchants = new ArrayList<>();
    static List<Admin> merchants1=new ArrayList<>();

    static List<Java> li=new ArrayList<>();

    static List<User> users=new ArrayList<>();

    static List<Order> orders=new ArrayList<>();
    static List<Order> orders_histry=new ArrayList<>();

    Admin(String name,String pass,int id,boolean verify) {
        this.mer_name = name;
        this.mer_pass = pass;
        this.mer_id = id;
        this.mer_v = verify;
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
            System.out.println("Merchant login panel..");
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
        merchants.add(new Admin(name,pass,++merchant_id,true));
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
        merchants1.add(new Admin(name,pass,++merchant_id,false));
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
                        merchants.add(new Admin(i.mer_name,i.mer_pass,i.merchant_id,i.mer_v));
                        System.out.println("Merchant Approved Successfully...");                       
                    }                   
                }
                System.out.println(merchants.size());
            }

        }
   }
    
   public static void viewallproducts(){
       System.out.println("List of ALL Mertchant products\n");
       int j=1;
       if(li.size()>0){
        for(Java i:li){
            System.out.println(j+") ID - "+i.getID()+"\n   Product - "+i.getProduct()+"\n   Price - "+i.getPrice()+"\n   Offer - "+i.getOffer()+"%\n");
            j++;
        }
       }
       else{
           System.out.println("No products found!!");
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
                    // System.out.println("Welcome "+i.mer_name+"\n");
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
            Main.clearConsole();
            System.out.println("Welcome "+cur_name+"\n");
            System.out.println("1.Add products");
            System.out.println("2.Update products");
            System.out.println("3.View Products");
            System.out.println("4.Exit");
            System.out.println("\nEnter your choice..");
            int a=sc.nextInt();
            if(a==1){
                addproducts();
                sc.nextLine();
                sc.nextLine();
            }

            else if(a==2){
                updateproducts();
                sc.nextLine();
                sc.nextLine();
            }
            else if(a==3){
                viewproducts();
                sc.nextLine();
                sc.nextLine();
                
            }
            else if(a==4){
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
        System.out.print("Enter product prize : ");
        int price=sc.nextInt();
        System.out.print("Enter offer of the product : ");
        int offer=sc.nextInt();
        System.out.println("Enter Count of your products :");
        int count=sc.nextInt();
        li.add(new Java(cur_name,curr_user,pro_name,price,offer,count));
   }

   public static void updateproducts(){
       int j=1,k=1;
        for(Java java:li) {
            
            if(java.getMerch_name().equals(cur_name))
            System.out.println(j+")\nornaProduct:\t"+java.getProduct()+"\nPrice:\t\t"+java.getPrice()+"\nOffer:\t\t"+java.getOffer()+"%\n");
            j++;
        }
        System.out.println("Enter Product number to remove:");
        String p=sc.next();
        sc.nextLine();
        for(int i=0;i<li.size();i++){
            if(p.equals(li.get(i).getProduct())){
                li.remove(i);
                System.out.println("\nRemoved Successfully");
            }
        }
   }

	public static void viewproducts() {
        int j=1;
	   for(Java java:li) {
           if(java.getMerch_name().equals(cur_name)){
			System.out.println(j+")\nProduct:\t"+java.getProduct()+"\n"+"Price:\t\t"+java.getPrice()+"\nOffer:\t\t"+java.getOffer()+"%\nCount:\t\t"+java.getCount());
            j++;
           }
        }

	}

    //USER
    public static void user(){
        while(true){
            Main.clearConsole();
            System.out.println("User login panel..");
            System.out.println("\n************************\n");
            System.out.println("1.New User");
            System.out.println("2.User login");
            System.out.println("3.Exit");
            System.out.println("\nEnter your choice");
            int a=sc.nextInt();
            if(a==1){
                newuser();
                sc.nextLine();
                sc.nextLine();
            }
            else if(a==2){
                if(users.size()>0){
                    userlogin();
                    sc.nextLine();
                    sc.nextLine();
                }
                else{
                    System.out.println("No users found");
                }
            }
            else if(a==3){
                break;
            }
            else{
                System.out.println("Invalid Input!!!");
            }
        }
    }

    public static void newuser(){
        // Main.clearConsole();
        System.out.println("Enter your name :");
        String name=sc.next();
        sc.nextLine();
        System.out.println("Enter your password :");
        String pass=sc.next();
        sc.nextLine();
        System.out.println("Conform password :");
        String cpass=sc.next();
        sc.nextLine();
        System.out.println("Enter your mail id");
        String mail=sc.next();
        sc.nextLine();
        System.out.println("Enter your Mobile number");
        String phone=sc.next();
        sc.nextLine();
        System.out.println("Enter your amount of Your wallet");
        int wallet=sc.nextInt();
        sc.nextLine();
        if(pass.equals(cpass)){
            if(mail.contains("@") && phone.length()==10){
                users.add(new User(name,pass,mail,phone,wallet));
                System.out.println("User Registered Successfully!!!");
            }
            else{
                System.out.println("Check your mailid or Mobile number");
                newuser();
            }
        }
        else{
            System.out.println("Password missmatch...Try again");
            newuser();
        }
    }

    public static void userlogin(){
        System.out.println(users.size());
        System.out.println("Enter your username :");
        String name_user=sc.next();
        sc.nextLine();
        System.out.println("Enter your password ");
        String pass_user=sc.next();
        sc.nextLine();
        
        for(User i: users){
            if(i.getUsr_name().equals(name_user) && i.getUsr_pass().equals(pass_user)){
                usr_name=i.getUsr_name();
                usr_pass=i.getUsr_pass();
                usr_mail=i.getUsr_mail();
                usr_phone=i.getUsr_phone();
                usr_wallet=i.getWallet();
                System.out.println("Login successfull");
                userlog();
            }
            else{
                System.out.println("Check password..");
            }
        }
    }

    public static void userlog(){
        while(true){
            Main.clearConsole();
            System.out.println("Welcome "+usr_name);
            System.out.println("\n\n1.View products");
            System.out.println("2.Buy products");
            System.out.println("3.View cart");
            System.out.println("4.View previous orders");;
            System.out.println("5.Exit");
            int a=sc.nextInt();
            
            if(a==1){
                Main.clearConsole();
                viewproducts_user();
                sc.nextLine();
                sc.nextLine();
            }
            else if(a==2){
                Main.clearConsole();
                buyproducts_user();
                sc.nextLine();
                sc.nextLine();
            }
            else if(a==3){
                viewcart();
                sc.nextLine();
                sc.nextLine();
            }
            else if(a==4){
                Main.clearConsole();
                viewpreviousorder();
                sc.nextLine();
                sc.nextLine();
            }
            else if(a==5){
                break;
            }
            else{
                System.out.println("Invalid Input");
            }
        }
    }

    public static void viewproducts_user(){
        System.out.println("List of All products in our store");
        int j=1;
        if(li.size()>0){
            for(Java i:li){
                System.out.println(j+")\nID - \t\t"+i.getID()+"\nProduct -\t"+i.getProduct()+"\nPrice - \t"+i.getPrice()+"\nOffer -\t\t"+i.getOffer()+"%\nNo of Products -"+i.getCount()+"\n\n");
                j++;
            }
        }
        else{
            System.out.println("No products found!!");
        }
        System.out.println("Enter to Continue");
    }

    public static void buyproducts_user(){
        System.out.println("List of All products in our store");
        int j=1;
        if(li.size()>0){
            for(Java i:li){
                System.out.println(j+")\nID -\t\t"+i.getID()+"\nProduct -\t"+i.getProduct()+"\nPrice -\t\t"+i.getPrice()+"\nOffer -\t\t"+i.getOffer()+"%\nNo of Products -"+i.getCount()+"\n\n");
                j++;
            }
        }
        else{
            System.out.println("No products found!!");
            
        }
        if(li.size()>0){          
            System.out.println("\nEnter details to add items to cart");
            System.out.println("\nEnter ID :");
            int pro_id=sc.nextInt();
            System.out.println("Enter product name");
            String pro_name=sc.next();
            System.out.println("Enter Number of products needed");
            int n=sc.nextInt();
            int t=0;
            
            for(Java i:li){
                
                if(i.getID()==pro_id && i.getProduct().equals(pro_name) && i.getCount()>0 && n<=i.getCount()){
                    System.out.println("Enter Conformation\n'Y' to add product to your cart\n'N' to Cancel it");
                    String check=sc.next();
                    if(check.equals("Y") || check.equals("y")){
                        int price=i.getPrice();
                        int offer=i.getOffer();
                        int count=i.getCount()-n;
                        // usr_wallet=usr_wallet-price;
                        product=i.getProduct();
                        pro_price=i.getPrice();
                        pro_offer=i.getOffer();
                        li.set(t,new Java(cur_name,curr_user,pro_name,price,offer,count));
                        orders.add(new Order(usr_name,pro_name,n,usr_wallet));
                        System.out.println("Products Added to cart "); 
                    }
                    else if(check.equals("N") || check.equals("n")){
                        System.out.println("Canceled!!");
                        break;
                    }
                    else{
                        System.out.println("Invalid please Check Conformation");
                    }
                }
                else if(i.getID()==pro_id && i.getProduct().equals(pro_name)){
                    System.out.println("Products not sufficient count");
                }
                t++;
            }
        }
    }

    public static void viewcart(){
        // Main.clearConsole();
        int t=0;
        for(Order i: orders){
            System.out.println("Your products\n");
            if(i.getUser_name().equals(usr_name)){
                Main.clearConsole();
                int amount=0;
                String productuser="";
                for(Java p : li){
                    if(p.getProduct().equals(i.getUser_pro())){
                        for(int x=0;x<orders.size();x++){
                            int amount1=orders.get(x).getProcount()*p.getPrice();
                            System.out.println("Products :-\t"+orders.get(x).getUser_pro());
                            System.out.println("Count    :-\t"+orders.get(x).getProcount());
                            System.out.println("Price    :-\t"+amount1+"\n");
                            amount+=amount1;
                        }
                    }
                }
                System.out.println("Amount required for your product : "+amount+"\n");
                System.out.println("\nWant to buy Product\n");
                System.out.println("Pay from your wallet (OR) Cash on Delivery\n");
                System.out.println("Press 1 to pay from your wallet");
                System.out.println("Press 2 for cash on delivery");
                System.out.println("Press 3 to remove product");
                System.out.println("Press 4 to view purchase details");
                System.out.println("Press 5 to exit");
                System.out.println("\nEnter your choice :");
                int n=sc.nextInt();
                String product=i.getUser_pro();
                int co=i.getProcount();
                // usr_wallet=i.getUser_wallet();
                if(n==1){
                    System.out.println("Your wallet Balance"+i.getUser_wallet());
                    System.out.println("Press Y to Confirm your order");
                    System.out.println("Press N to back;");
                    String c=sc.next();
                    if(amount<=usr_wallet && co>0)
                    {
                        if(c.equals("Y")|| c.equals("y")){
                        usr_wallet=usr_wallet-amount;
                        int count=0;
                        
                        orders_histry.add(new Order(usr_name,product,co,amount));
                        System.out.println(product+" - Product Purchased Successfully");
                        System.out.println("Your wallet balance"+usr_wallet);
                        }
                    }
                    else if(co<=0){
                        System.out.println("Count insuffieient");
                    }
                    else if(amount>usr_wallet){
                        System.out.println("Your wallet balance insufficient");
                    }
                    else{
                        System.out.println("Invalid Input");
                    }
                }
                else if(n==2){
                    System.out.println("Do you Want Cash on Delivery type 'yes");
                    String cod=sc.next();
                    if(cod.equals("yes")){
                        System.out.println("Enter captcha Q9W7z3");
                        String s=sc.next();
                        if(s.equals("Q9W7z3")){
                            System.out.println("Your product booked successfully!");
                        }
                        else{
                            System.out.println("Wrong Captcha");
                            // viewcart();
                        }
                    }
                }
                else if(n==3){
                    for(Java p : li){
                        if(p.getProduct().equals(i.getUser_pro())){
                            for(int x=0;x<orders.size();x++){
                                int amount1=orders.get(x).getProcount()*p.getPrice();
                                System.out.println("Products :-\t"+orders.get(x).getUser_pro());
                                System.out.println("Count    :-\t"+orders.get(x).getProcount());
                                System.out.println("Price    :-\t"+amount1);
                                amount=amount1;
                            }
                        }
                    }
                    String rem_pro=sc.next();
                    for(int j=0;j<orders.size();j++){
                        if(orders.get(j).getUser_pro().equals(rem_pro)){
                            orders.remove(j);
                            System.out.println("Products removed successfully..!!");
                        }
                    }
                }
                else if(n==4){
                    for(Order o: orders_histry){
                        System.out.println("Product - \t"+o.getUser_pro());
                        System.out.println("Price   - \t"+o.getUser_wallet());
                        System.out.println("Count   - \t"+o.getProcount());
                        System.out.println("Purchased sucessfully");
                    }
                }
                else if(n==5){
                    break;
                }
                else{
                    System.out.println("Invalid Input!!");
                }
            }
            t++;
        }
    }

    public static void viewpreviousorder(){
        for(Order i: orders){
            System.out.println("Your products\n");
            if(i.getUser_name().equals(usr_name)){
                for(Order o: orders_histry){
                    System.out.println("Product - \t"+o.getUser_pro());
                    System.out.println("Price   - \t"+o.getUser_wallet());
                    System.out.println("Count   - \t"+o.getProcount());
                    System.out.println("Purchased sucessfully");
                }
            }
        }
    }

}
class Java{
   private String Merch_name;
   private String product;
   private int price;
   private int offer;
   private int id;
   private int count;
  public Java(String Merch_name,int id,String product, int price,int offer,int count) {
	this.Merch_name =Merch_name;
    this.id=id;
	this.product = product;
	this.price = price;
	this.offer = offer;
    this.count=count;
  }
    public  String getMerch_name() {
    	return Merch_name;
    }
    
    public void setName(String Merch_name) {
    	this.Merch_name = Merch_name;
    }
    
    public int getID() {
    	return id;
    }
    
    public void setID(int id) {
    	this.id = id;
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

    public int getCount(){
        return count;
    }

    public void setCount(){
        this.count=count;
    }
}

class User{
    private String usr_name,usr_pass;
    private String usr_mail,usr_phone;
    private int wallet;
    public User(String usr_name,String usr_pass,String usr_mail,String usr_phone,int wallet){
        this.usr_name=usr_name;
        this.usr_pass=usr_pass;
        this.usr_mail=usr_mail;
        this.usr_phone=usr_phone;
        this.wallet=wallet;
    }
    public String getUsr_name(){
        return usr_name;
    }
    public void setUsr_name(String usr_name){
        this.usr_name=usr_name;
    }
    public String getUsr_pass(){
        return usr_pass;
    }
    public void setUsr_pass(String usr_pass){
        this.usr_pass=usr_pass;
    }
    public String getUsr_mail(){
        return usr_mail;
    }
    public void setUsr_mail(String usr_mail){
        this.usr_mail=usr_mail;
    }
    public String getUsr_phone(){
        return usr_phone;
    }
    public void setUsr_phone(String phone){
        this.usr_phone=usr_phone;
    }
    public int getWallet(){
        return wallet;
    }
    public void setWallet(int wallet){
        this.wallet=wallet;
    }
}

class Order{
    private String user_name,user_pro;
    private int  pro_count,user_wallet;

    public Order(String user_name,String user_pro,int pro_count,int user_wallet){
        this.user_name=user_name;
        this.user_pro=user_pro;
        this.pro_count=pro_count;
        this.user_wallet=user_wallet;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_name(String user_name){
        this.user_name=user_name;
    }

    public String getUser_pro(){
        return user_pro;
    }

    public void setUser_pro(String user_pro){
        this.user_pro=user_pro;
    }

    public int getProcount(){
        return pro_count;
    }

    public void setProcount(int pro_count){
        this.pro_count=pro_count;
    }

    public int getUser_wallet(){
        return user_wallet;
    }

    public void setUser_wallet(int userwallet){
        this.user_wallet=user_wallet;
    }
}
