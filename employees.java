import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class employee{
    String name;
    int salary;
    int time;

    public employee(String employeeName){
        name = employeeName;
        // System.out.println("the employees name is: " + employeeName);
    }

    public String eName(){
        return name;
    }



    public void time(int weekTime){
        time = weekTime;
    }

    public int getTime(){
        return time;
    }

    public void finance(int yearSalary){
        salary = yearSalary;
    }

    public int getFinance(){
        return salary;
    }

    public static void main(String []args){
        Scanner myScanner = new Scanner(System.in);
        boolean user = true;
        while (user){
            System.out.print("employee name: ");
            String empName = myScanner.nextLine();
            employee person = new employee(empName);

            System.out.print("Hours per week: ");
            int weekHours = myScanner.nextInt();
            person.time(weekHours);

            System.out.print("Yearly pay: ");
            int yearsFinance = myScanner.nextInt();
            person.finance(yearsFinance);

            try{
                FileWriter employeeFile = new FileWriter(person.eName() + ".txt");
                employeeFile.write("Name: " + person.eName() + "\n");
                employeeFile.write("Time Per Week: " + person.getTime() + "\n");
                employeeFile.write("Yearly pay without overtime: " + person.getFinance() + "\n");
                employeeFile.close();
            }catch(IOException e){
                System.out.println("File creation error " + e);
            }
            System.out.print("add another employee? [true/false]");
            boolean add = myScanner.nextBoolean();
            if(add == false){
                user = false;
            }
        }
        myScanner.close();
    }
}
