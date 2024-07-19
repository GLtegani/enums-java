import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      System.out.print("Enter department's name: ");
      String department = sc.nextLine();
      System.out.println("Enter worker data: ");
      System.out.print("Name: ");
      String workerName = sc.nextLine();
      System.out.print("Level: ");
      String workerLevel = sc.nextLine();
      System.out.print("Base salary: ");
      Double baseSalary = sc.nextDouble();
      Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));

      System.out.print("How many contracts to this worker? ");
      int contracts = sc.nextInt();
      sc.nextLine();
      for(int i = 0; i < contracts; i++) {
         System.out.println("Enter contract #" + (i + 1) + " data:");
         System.out.print("Date (DD/MM/YYYY): ");
         LocalDate dateContract = LocalDate.parse(sc.nextLine(), formatter);
         System.out.print("Value per hour: ");
         Double valuePerHour = sc.nextDouble();
         System.out.print("Duration (hours): ");
         Integer hours = sc.nextInt();
         sc.nextLine();
         HourContract contract = new HourContract(dateContract, valuePerHour, hours);
         worker.addContract(contract);
      }
      System.out.println();
      System.out.print("Enter month and year to calculate income (MM/YYYY): ");
      String monthAndYear = sc.next();
      Integer month = Integer.parseInt(monthAndYear.substring(0, 2));
      Integer year = Integer.parseInt(monthAndYear.substring(3));
      System.out.println("Name: " + worker.getName());
      System.out.println("Department: " + worker.getDepartment().getName());
      System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f",  worker.income(year, month)));


      sc.close();
   }
}