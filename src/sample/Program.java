package sample;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter departament's name ");
        String departamentName  = sc.nextLine();
        Departament departament = new Departament(departamentName);

        System.out.println("Enter worker Name: ");
        String workerName = sc.nextLine();
        System.out.println("Enter level: ");
        String level = sc.nextLine();
        System.out.println("Enter base salary: ");
        Double baseSalary = sc.nextDouble();

        System.out.println("How many contracts to this worker? ");
        int contractsNumbers = sc.nextInt();

        WorkerLevel workerLevel = WorkerLevel.valueOf(level);
        Worker worker = new Worker(workerName, workerLevel, baseSalary, departament);

        for(int i=0; i<contractsNumbers; i++){
            int count = i+1;
            System.out.println("Enter contract #" + count + " data:");
            System.out.println("Enter date (DD/MM/YYYY): ");
            sc.nextLine();
            String dataInformada = sc.nextLine();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date data = dateFormat.parse(dataInformada);

            System.out.println("Enter value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("Enter durantion (hours): ");
            int hours = sc.nextInt();

            HourContract hourContract = new HourContract(data, valuePerHour, hours);

            worker.addContract(hourContract);

        }

        System.out.println("Enter month ad year to calculate income (MM/YYYY) ");
        sc.nextLine();
        String monthYear = sc.nextLine();
        int month = Integer.parseInt(monthYear.substring(0,2));
        int year = Integer.parseInt(monthYear.substring(3,7));


        System.out.println("Name: " +  worker.getName());
        System.out.println("Departament: " +  worker.getDepartament().getName());
        System.out.println("Income for " + monthYear + ": "+ worker.income(year, month));

        sc.close();
    }
}
