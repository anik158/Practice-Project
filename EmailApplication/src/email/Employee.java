package email;

import java.util.Random;
import java.util.Scanner;



public class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private String company;
    private String name;
    private String email;
    private String password;
    private String mailCapacity = 1024+" MB";
    private String alternateEmail;
    public static String choose;


    Scanner scan = new Scanner(System.in);

    public Employee() {
        this.name = getFirstName() +" "+getLastName();
        this.company = getCompany();
        this.department = determineDepartment();

        /*
        Here we have tried to make it user-friendly by giving option to user, what kind of option he wants.
         */
        System.out.println("What do you want?");
        System.out.println("1.Auto generated mail?\n2.User defined");
        System.out.print("Choice: ");
        String choice = scan.nextLine();
        boolean determine = true;

        while (determine){
            if(choice.equals("1") || choice.equals("2")){
                switch (choice){
                    case "1":
                        if(choose.equals("1")|| choose.equals("2")){
                            this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toLowerCase()
                                    +"."+company.toLowerCase()+".com";
                        }else{
                            this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+company.toLowerCase()+
                                    ".com";
                        }
                        break;
                    case "2":
                        System.out.println("Enter only local-part(jsmith@)");
                        setAlternateEmail(scan.nextLine());
                        if(choose.equals("1")|| choose.equals("2")|| choose.equals("3")){
                            this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toLowerCase()
                                    +"."+company.toLowerCase()+".com";
                        }else{
                            this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+company.toLowerCase()+
                                    ".com";
                        }
                        break;
                    default:
                        System.out.println("Something went wrong");
                }
                determine = false;
            }else{
                choice = scan.nextLine();
            }
        }

        System.out.println("What do you want?");
        System.out.println("1.Auto generated password?\n2.User defined password");
        System.out.print("Choice: ");
        choice = scan.nextLine();

        boolean determineOne = true;

        while (determineOne){
            if(choice.equals("1") || choice.equals("2")){
                switch (choice){
                    case "1":
                        this.password = generatePassword();
                        break;
                    case "2":
                        System.out.print("Enter your passcode: ");
                        setPassword(scan.nextLine());
                        this.password = getPassword();
                        break;
                    default:
                        System.out.println("Something went wrong");
                }
                break;
            }else{
                choice = scan.nextLine();
            }
        }



    }

    public String getFirstName(){
        System.out.print("Enter first name: ");
        this.firstName = scan.nextLine();
        return  this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.print("Enter last name: ");
        this.lastName = scan.nextLine();
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        System.out.print("Enter company name: ");
        this.company = scan.nextLine();
        return company;
    }

    public String getMailCapacity() {
        return mailCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    /**
     * We have determined the department.
     * The outcome should be null or String value.
     * @return department
     */
    public String determineDepartment(){
        System.out.println("Choose a department: ");
        System.out.println("1.Sales\n2.Development\n3.Accounting\n4.Press any key(if it does not imply)");
       choose = scan.nextLine();

        switch (choose){
            case "1":
                return "Sales";

            case "2":
                return "Development";
            case "3":
                return "Accounting";

            default:
                return "The person does not belong to any department";
        }
    }


    /**
     * We have generated a password, which contains eight characters.
     * We have used 'Random' class to make it successful.
     * It will return a password which will contain any letters from  alphabet
     * and any digits from ten digits. and some special characters
     * @return password
     */

    public String generatePassword(){
        Random rand = new Random();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$";

        char[] passContainer = new char[8];
        for (int i = 0; i < 8; i++) {
            int num=0;
            boolean operation = true;
            while (operation) {
                num = rand.nextInt(100);
                if(num<39){
                    break;
                }
            }
            passContainer[i] = letters.charAt(num);
        }
        String password = String.valueOf(passContainer);
        return  password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * It will display the email information of the employee.
     */

    public  void display(){
        System.out.println("---------------------------------");
        System.out.println("Email Information:");
        System.out.println("Email account's of "+name);
        System.out.println("Department: "+department+"\nEmail: "+email+"\nPassword: "+
                password+"\nMail Capacity: "+mailCapacity);
        System.out.println("---------------------------------");
    }
}
