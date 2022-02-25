import java.util.*;
import java.io.*;

public class Railway {
    public static final Scanner sc=new Scanner(System.in);

    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
        
    }
    public static void main(String[] ar){
        while(true){
            clearConsole();
            System.out.println("Welcome to Railway Ticket booking System\n");
            System.out.println("1.Admin Login");
            System.out.println("2.User Login");
            System.out.println("3.Exit");
            System.out.println("\nEnter your choice");
            int o=sc.nextInt();
            if(o==1){
                Train.admin();
            }
            else if(o==2){
                Train.user();
            }
            else if(o==3){
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }
    }
}

public class Train{
    public static final Scanner sc=new Scanner(System.in);
    public static int r,c,st,ed;

    
    public static String usr_name,usr_pass,usr_mail,usr_phone;
    public static List<List<Integer>>ta=new ArrayList<>();
    public static List<Waiting_list> wat = new ArrayList<>();
    public static List<User> users=new ArrayList<>();
    public static List<Booking_history> book_his=new ArrayList<>();

    static String[] bh=new String[50];
    // public String uname,upass;
    
    // Train(String name, String pass) {
    //     this.uname= name;
    //     this.upass = pass;
        
    // }

    public static void admin(){
        if(adminpass()){
            while(true){
                Railway.clearConsole();
                System.out.println("Welcome Admin of Railway Ticket Booking system");
                System.out.println("\n1.Allocation\n2.View Available seats\n3.Waiting_listing list\n4.Exit");
                System.out.println("\n.==========================================================.");
                int a=sc.nextInt();
                if(a==1){
                    System.out.println("Enter number of seats ");
                    r=sc.nextInt();
                    System.out.println("Enter number of stations ");
                    c=sc.nextInt();
                    for(int i=0;i<r;i++){
                        List<Integer>l1=new ArrayList<>();
                        for(int j=0;j<c;j++){
                            l1.add(0);
                        }
                        ta.add(l1);
                    }
                    System.out.println("Seats and Stations Created successfully");
                    System.out.println("Press enter to Continue....");
                    sc.nextLine();
                    sc.nextLine();                   
                }
                else if(a==2){
                    System.out.println("Seat pattern");
                    for(int i=0;i<r;i++){
                        for(int j=0;j<c;j++){
                            System.out.print( ta.get(i).get(j)+"  ");
                        }
                        System.out.println();
                    }
                    System.out.println("Press enter to Continue...");
                    sc.nextLine();
                    sc.nextLine();
                }
                else if(a==3){
                    System.out.println("Passengers in Waiting_listing List");
                    if(wat.size()>0){
                        for(int i=0;i<wat.size();i++){
                            System.out.println("pid: "+(wat.get(i).tid)+" "+"st point: "+(wat.get(i).st+" "+"End point: "+(wat.get(i).ed)));
                        }
                    }
                    else if(wat.size()==0){
                        System.out.println("No passenger are currently in the Waiting_listing List");
                    }
                    System.out.println("Press enter to Continue...");
                    sc.nextLine();
                    sc.nextLine();
                }
                else if(a==4){
                    System.out.println("Exit Successfully.....!");
                    break;
                }
                else{
                    System.out.println("Invalid Input!");
                    System.out.println("Try again press - 1\nTo Exit press - 0");
                    int var=sc.nextInt();
                    if(var==1)
                    continue;
                    else
                    break;
                }
            }
        }
    }

    public static boolean adminpass(){
        Boolean b=true;
        for(int x=1;x<=3;x++){
            int a=1;
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
            }
        }
        return b;
    }

    public static void user(){
        while(true){
            Railway.clearConsole();
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
                userlogin();
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

    public static void newuser(){
        Railway.clearConsole();
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
        // System.out.println("Enter your amount of Your wallet");
        // int wallet=sc.nextInt();
        // sc.nextLine();
        if(pass.equals(cpass)){
            if(mail.contains("@") && phone.length()==10){
                users.add(new User(name,pass,mail,phone));
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
        int i1=0;
        for(User i: users){
            if(i.getUsr_name().equals(name_user) && i.getUsr_pass().equals(pass_user)){
                usr_name=i.getUsr_name();
                usr_pass=i.getUsr_pass();
                usr_mail=i.getUsr_mail();
                usr_phone=i.getUsr_phone();
                System.out.println("Login successfull");
                userlog(i1);
            }
            else{
                System.out.println("Check password..");
            }
            i1++;
        }
    }

    public static void userlog(int cur_usr){
        while(true){
            Railway.clearConsole();
            System.out.println("Welcome "+usr_name);
            System.out.println("1.Book ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.Booking History");
            System.out.println("4.View Seat availability");
            System.out.println("5.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.println("Seats Availability\n");
                for(int i=0;i<r;i++){
                    for(int j=0;j<c;j++){
                        System.out.print( ta.get(i).get(j)+"  ");
                    }
                    System.out.println();
                }
                System.out.println("\n\nEnter start station number");
                st=sc.nextInt();
                st-=1;
                System.out.println("Enter destination station number");
                ed=sc.nextInt();
                ed-=1;
                int fl=0;
                int i;
                for( i=0;i<ta.size();i++){
                    int c=0;
                    for(int j=st;j<=ed;j++){
                        c+=ta.get(i).get(j);
                    }
                    if(c==0){
                        alloc(i,st,ed,cur_usr+1);
                        fl=1;
                        System.out.println("Ticket Booked succesfully \nSno: "+(i+1)+" Ticket id: "+(cur_usr+1));
                        // bh[cur_usr+1]="SeatNo: "+Integer.toString(i+1)+" Ticket id: "+Integer.toString(cur_usr+1);
                        String date = java.time.LocalDateTime.now() + "\nSno. -" +(i+1)+"\nTicket ID : "+(cur_usr+1);
                        bh[cur_usr]=date;
                        book_his.add(new Booking_history(usr_name,date));
                        break;
                    }
                }
                if(fl==0){
                    System.out.println("No seats available now! You are added to Waiting_listing list");
                    // bh[cur_usr+1]="SeatNo: 0"+" Ticket id: "+Integer.toString(cur_usr+1);
                    // bh[cur_usr+1]=bh[cur_usr+1]+" -->Waiting_listing List";
                    
                    wat.add(new Waiting_list((cur_usr+1), st, ed));

                }
            }
            else if(ch==2){
                System.out.println("Enter the ticket id to cancel");
                int a=sc.nextInt();
                for(int i=0;i<r;i++){
                    for(int j=0;j<c;j++){
                        if (a==ta.get(i).get(j)){
                            ta.get(i).set(j, 0);
                        }
                    }
                }
                bh[cur_usr+1]=bh[cur_usr+1]+" -->Cancelled";
                System.out.println("Ticket cancelled Succesfully");
                sc.nextLine();
                sc.nextLine();
                // tcancel();

            }
            else if(ch==3){
                System.out.println("Your booking History");
                // System.out.println(bh[cur_usr+1]);
                // for(int i=0;i<book_his.size();i++){
                    for(Booking_history b:book_his){
                        if(b.getUser_name().equals(usr_name)){
                            System.out.println("\n"+b.getUser_name()+" -> "+b.getUser_data());
                        }
                    }
                    // break;
                // }
                sc.nextLine();
                sc.nextLine();
            }
            else if(ch==4){
                System.out.println("Seats Availability\n");
                for(int i=0;i<r;i++){
                    for(int j=0;j<c;j++){
                        System.out.print( ta.get(i).get(j)+"  ");
                    }
                    System.out.println();
                }
                System.out.println("Press Enter to Continue...!");
                sc.nextLine();
                sc.nextLine();
            }
            else if(ch==5){
                System.out.println("Exit successfully");
                break;
            }
            else{
                System.out.println("Invalid Input\n\nEnter to try Again....");
            }
        }
    }

    public static void alloc(int i,int st,int ed,int cur_usr){
        for(int j=st;j<=ed;j++){
            ta.get(i).set(j, cur_usr);
        }
    }
}


class Waiting_list{
    public int tid;
    public int st;
    public int ed;

    Waiting_list(int td,int sta,int end){
        this.tid=td;
        this.st=sta;
        this.ed=end;
    }
}

class User{
    private String usr_name,usr_pass;
    private String usr_mail,usr_phone;
    public User(String usr_name,String usr_pass,String usr_mail,String usr_phone){
        this.usr_name=usr_name;
        this.usr_pass=usr_pass;
        this.usr_mail=usr_mail;
        this.usr_phone=usr_phone;
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
}

class Booking_history{
    public String user_name,user_data;

    public Booking_history(String user_name,String data){
        this.user_name=user_name;
        this.user_data=data;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_name(String user_name){
        this.user_name=user_name;
    }

    public String getUser_data(){
        return user_data;
    }

    public void setUser_data(String user_data){
        this.user_data=user_data;
    }
}
