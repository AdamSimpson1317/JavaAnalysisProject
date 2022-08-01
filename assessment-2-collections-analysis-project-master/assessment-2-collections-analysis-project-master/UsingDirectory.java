import java.util.*;
import java.io.*;

public class UsingDirectory {

    public static void main(String[] args) throws FileNotFoundException{
        Directory.ArrayDirectory array = new Directory.ArrayDirectory();
        Directory.ListDirectory list = new Directory.ListDirectory();
        Directory.HashDirectory hash = new Directory.HashDirectory();


        List<String> arrayTempTimeList = new ArrayList<>();
        List<String> listTempTimeList = new ArrayList<>();
        List<String> hashTempTimeList = new ArrayList<>();

        List<List> allList = new ArrayList<>();

        List<List> arrayTimeList = new ArrayList<>();
        List<List> listTimeList = new ArrayList<>();
        List<List> hashTimeList = new ArrayList<>();

        StopWatch watch = new StopWatch();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter filename here:");
        String filename = input.next();


        Scanner file = new Scanner(new FileReader(filename));

        allList = Insert.insert(watch, file, array, list, hash);

        arrayTimeList.add(allList.get(0));
        listTimeList.add(allList.get(1));
        hashTimeList.add(allList.get(2));


        int count = 0;
        int index = 499;
        long time;

        arrayTempTimeList = new ArrayList<>();
        listTempTimeList = new ArrayList<>();
        hashTempTimeList = new ArrayList<>();

        for(int i = 0; i < array.toArrayList().size(); i++){
            String surnameToLookup = array.toArrayList().get(index).getSurname();
            watch.start();
            array.lookupExtension(surnameToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            arrayTempTimeList.add(Long.toString(time));
            watch.reset();
        }

        for(int i = 0; i < list.toArrayList().size(); i++){
            String surnameToLookup = list.toArrayList().get(index).getSurname();
            watch.start();
            list.lookupExtension(surnameToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            listTempTimeList.add(Long.toString(time));
            watch.reset();
        }

        for(int i = 0; i < hash.toArrayList().size(); i++){
            String surnameToLookup = hash.toArrayList().get(index).getSurname();
            watch.start();
            hash.lookupExtension(surnameToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            hashTempTimeList.add(Long.toString(time));
            watch.reset();
        }

        arrayTimeList.add(arrayTempTimeList);
        listTimeList.add(listTempTimeList);
        hashTimeList.add(hashTempTimeList);

        arrayTempTimeList = new ArrayList<>();
        listTempTimeList = new ArrayList<>();
        hashTempTimeList = new ArrayList<>();


        while (array.toArrayList().size() > 0){
            if (count == 2){
                index-=1;
                count = 0;
            }
            count += 1;
            String surnameToLookup = array.toArrayList().get(index).getSurname();
            watch.start();
            array.deleteEntryUsingName(surnameToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            arrayTempTimeList.add(Long.toString(time));
            watch.reset();
        }


        count = 0;
        index = 499;

        while (list.toArrayList().size() > 0){
            if (count == 2){
                index-=1;
                count = 0;
            }
            count += 1;
            String surnameToLookup = list.toArrayList().get(index).getSurname();
            watch.start();
            list.deleteEntryUsingName(surnameToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            listTempTimeList.add(Long.toString(time));
            watch.reset();
        }


        count = 0;
        index = 499;



        while (hash.toArrayList().size() > 0){
            if (count == 2){
                index-=1;
                count = 0;
            }
            count += 1;
            String surnameToLookup = hash.toArrayList().get(index).getSurname();
            watch.start();
            hash.deleteEntryUsingName(surnameToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            hashTempTimeList.add(Long.toString(time));
            watch.reset();
        }

        arrayTimeList.add(arrayTempTimeList);
        listTimeList.add(listTempTimeList);
        hashTimeList.add(hashTempTimeList);

        Scanner file2 = new Scanner(new FileReader(filename));

        Insert.insert(watch, file2, array, list, hash);

        count = 0;
        index = 499;

        arrayTempTimeList = new ArrayList<>();
        listTempTimeList = new ArrayList<>();
        hashTempTimeList = new ArrayList<>();

        while (array.toArrayList().size() > 0){
            if (count == 2){
                index-=1;
                count = 0;
            }
            count += 1;
            String extensionToLookup = array.toArrayList().get(index).getTeleExt();
            watch.start();
            array.deleteEntryUsingExtension(extensionToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            arrayTempTimeList.add(Long.toString(time));
            watch.reset();
        }


        count = 0;
        index = 499;

        while (list.toArrayList().size() > 0){
            if (count == 2){
                index-=1;
                count = 0;
            }
            count += 1;
            String extensionToLookup = list.toArrayList().get(index).getTeleExt();
            watch.start();
            list.deleteEntryUsingExtension(extensionToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            listTempTimeList.add(Long.toString(time));
            watch.reset();
        }


        count = 0;
        index = 499;


        while (hash.toArrayList().size() > 0){
            if (count == 2){
                index-=1;
                count = 0;
            }
            count += 1;
            String extensionToLookup = hash.toArrayList().get(index).getTeleExt();
            watch.start();
            hash.deleteEntryUsingExtension(extensionToLookup);
            watch.stop();
            time = watch.getElapsedTime();
            hashTempTimeList.add(Long.toString(time));
            watch.reset();
        }


        arrayTimeList.add(arrayTempTimeList);
        listTimeList.add(listTempTimeList);
        hashTimeList.add(hashTempTimeList);


        List<String> values = Output.performanceTest(arrayTimeList, listTimeList, hashTimeList);
        System.out.println(values);

        File textFile = new File("Analysis.txt");
        PrintWriter writeText = new PrintWriter(textFile);
        int typeCount = 0;
        int writeCount = 0;

        for(int i= 0; i < values.size(); i++ ){

            if(writeCount == 0){

                if(typeCount == 0){
                    writeText.write("Insert Test: ");
                    writeText.write("\r\n");
                    typeCount += 1;
                }

                else if(typeCount == 1){
                    writeText.write("Lookup Test: ");
                    writeText.write("\r\n");
                    typeCount += 1;
                }

                else if(typeCount == 2){
                    writeText.write("Delete Surname Test: ");
                    writeText.write("\r\n");
                    typeCount += 1;
                }

                else if(typeCount == 3){
                    writeText.write("Delete Extension Test: ");
                    writeText.write("\r\n");
                    typeCount = 0;
                }

                writeText.write("Average: ");
                writeCount += 1;
            }
            else if (writeCount == 1) {
                writeText.write("Best: ");
                writeCount += 1;
            }

            else if (writeCount == 2){
                writeText.write("Worst: ");
                writeCount = 0;
            }
            writeText.write(values.get(i));
            writeText.write("\r\n");
        }

        writeText.close();

        System.out.print("Please input how many you want to insert.");
            int howManyToInsert = input.nextInt();
            for (int i = 0; i < howManyToInsert; i++){
                System.out.print("Please input the user surname, initials and telephone extension.");
                String userInput = input.next() ;
                String[] splittedInput = userInput.split(",");
                if (splittedInput[2].length() != 5){
                    System.out.println("This is not a valid extension.");
                    i = i-1;
            }
                Entry entry = new Entry(splittedInput[0], splittedInput[1], splittedInput[2]);
                array.insertEntry(entry);
                list.insertEntry(entry);
                hash.insertEntry(entry);


            }
            List<Entry> asciiTable;

            asciiTable = Output.outputting(array, list, hash);

            File outFile = new File("H:\\CSC1035\\Assessment2\\results.csv");
            PrintWriter writeFile = new PrintWriter(outFile);
            for(int i = 0; i < asciiTable.size(); i++){
                writeFile.println(asciiTable.get(i).getSurname() + "," + asciiTable.get(i).getInitials() + "," +
                        asciiTable.get(i).getTeleExt());

            }
            writeFile.close();



        }

    }
