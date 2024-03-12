import entities.Departament;
import entities.Enum.WorkerLevel;
import entities.HoursContract;
import entities.Worker;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc1 = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter departament's name:");
        String departamentName = sc1.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("name:");
        String workerName = sc1.nextLine();
        System.out.print("Level:");
        String workerLevel = sc1.nextLine();
        System.out.print("Base salary:");
        double baseSalary = sc1.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));


        System.out.println("How many contracts to this worker?");
        int n = sc1.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + "data:");
            System.out.print("Date (DD/MM/YYYY):");
            Date contractDate = sdf.parse(sc1.next());
            System.out.print("Value per hour:");
            double valuePerHour = sc1.nextDouble();
            System.out.print("Duration(hours):");
            int hours = sc1.nextInt();
            HoursContract contract = new HoursContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);

        }
        System.out.println();
        System.out.print("Enter month and year to calculate income(MM/YYYY)");
        String monthAndYear = sc1.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name:" + worker.getName());
        System.out.println("Departament:" + worker.getDepartament().getName());
        System.out.println("Income for" + monthAndYear + ":"+ String.format("%.2f", worker.income(year,month)));
    }
}