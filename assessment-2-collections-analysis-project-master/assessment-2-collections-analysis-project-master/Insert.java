import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Insert {

    public static List<List> insert(StopWatch watch, Scanner file, Directory.ArrayDirectory array, Directory.ListDirectory list,
                       Directory.HashDirectory hash){
        List<String> arrayTempTimeList = new ArrayList<>();
        List<String> listTempTimeList = new ArrayList<>();
        List<String> hashTempTimeList = new ArrayList<>();

        long time;

        while(file.hasNextLine()) {
            String line = file.nextLine();
            String[] temp = line.split(",");
            String surname = temp[0];
            String initials = temp[1];
            String telephoneExtension = temp[2];

            Entry entry = new Entry(surname, initials, telephoneExtension);

            watch.start();
            array.insertEntry(entry);
            watch.stop();
            time = watch.getElapsedTime();
            arrayTempTimeList.add(Long.toString(time));
            watch.reset();


            watch.start();
            list.insertEntry(entry);
            watch.stop();
            time = watch.getElapsedTime();
            listTempTimeList.add(Long.toString(time));
            watch.reset();

            watch.start();
            hash.insertEntry(entry);
            watch.stop();
            time = watch.getElapsedTime();
            hashTempTimeList.add(Long.toString(time));
            watch.reset();


        }

        List<List> allList = new ArrayList<>();
        allList.add(arrayTempTimeList);
        allList.add(listTempTimeList);
        allList.add(hashTempTimeList);

        return allList;
    }

}
