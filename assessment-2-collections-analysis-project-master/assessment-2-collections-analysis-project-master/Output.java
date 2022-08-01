import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Output {

    public static List outputting(Directory.ArrayDirectory array, Directory.ListDirectory list, Directory.HashDirectory hash){
        List<Entry> asciiTable = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Please input which directory you want to use: ");
        int choice = input.nextInt();

        if(choice == 1){
            asciiTable = array.toArrayList();

        }

        else if(choice == 2){
            asciiTable = list.toArrayList();

        }

        else if(choice == 3){
            asciiTable = hash.toArrayList();

        }
        System.out.println("|---------------------+--------------------+---------------------|");
        System.out.println("|       Surname       |      Initials      |      Extension      |");
        System.out.println("|---------------------+--------------------+---------------------|");
        for(int i = 0; i <asciiTable.size(); i++){
            System.out.println("|" + String.format("%-20s ", asciiTable.get(i).getSurname()) + "|" +
                    String.format("%-20s", asciiTable.get(i).getInitials()) + "|" +
                    String.format("%-20s ", asciiTable.get(i).getTeleExt()) + "|");
        }
        System.out.println("|---------------------+--------------------+---------------------|");

        return asciiTable;
    }

   public static List performanceTest(List<List> arrayTimeList, List<List> listTimeList, List<List> hashTimeList){

        List values = new ArrayList<>();

        for(int i = 0; i < 4; i ++) {
            long total = Analysis.total(arrayTimeList.get(i));
            double average = Analysis.averageCase(total, arrayTimeList.get(i).size());
            long best = Analysis.bestCase(arrayTimeList.get(i));
            long worse = Analysis.worseCase(arrayTimeList.get(i));
            values.add(Double.toString(average));
            values.add(Long.toString(best));
            values.add(Long.toString(worse));
        }

       for(int i = 0; i < 4; i ++) {
           long total = Analysis.total(listTimeList.get(i));
           double average = Analysis.averageCase(total, listTimeList.get(i).size());
           long best = Analysis.bestCase(listTimeList.get(i));
           long worse = Analysis.worseCase(listTimeList.get(i));
           values.add(Double.toString(average));
           values.add(Long.toString(best));
           values.add(Long.toString(worse));
       }

       for(int i = 0; i < 4; i ++) {
           long total = Analysis.total(hashTimeList.get(i));
           double average = Analysis.averageCase(total, hashTimeList.get(i).size());
           long best = Analysis.bestCase(hashTimeList.get(i));
           long worse = Analysis.worseCase(hashTimeList.get(i));
           values.add(Double.toString(average));
           values.add(Long.toString(best));
           values.add(Long.toString(worse));
       }


        return values;
    }

}
