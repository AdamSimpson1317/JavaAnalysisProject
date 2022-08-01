/**
 * @author Bradley Read
 * @version 1.0
 * @since 03-02-2020
 */

import java.lang.reflect.Array;
import java.util.*;

public interface Directory {

    /**
     * Insert a new entry into the directory.
     *
     * @param entry the new entry to add
     */
    void insertEntry(Entry entry);

    /**
     * Remove an entry from the directory using their surname.
     *
     * @param surname the surname of the entry to remove
     */
    void deleteEntryUsingName(String surname);

    /**
     * Remove an entry from the directory using their extension number.
     *
     * @param number the extension number of the entry to remove
     */
    void deleteEntryUsingExtension(String number);

    /**
     * Update an entry's extension number using their surname.
     *
     * @param surname   surname of the entry to be updated
     * @param newNumber the new number
     */
    void updateExtensionUsingName(String surname, String newNumber);

    /**
     * Get the extension number of an entry using their surname.
     *
     * @param surname the surname of the entry
     * @return the extension number of the entry
     */
    String lookupExtension(String surname);

    /**
     * Return an array list of all entries in the directory.
     *
     * @return an array list of all entries
     */
    List<Entry> toArrayList();

class ArrayDirectory implements Directory{

    private Entry[] arrayOfEntries;
    private Entry[] tempArray;
    private int arrayIndex = 0 ;

    public void insertEntry(Entry entry){
        if(arrayIndex == 0){
            arrayOfEntries = new Entry[1];
            arrayOfEntries[arrayIndex] = entry;
            arrayIndex += 1;
        }
        else{
            tempArray = new Entry[arrayIndex + 1];
            for(int i = 0; i < arrayOfEntries.length; i++){
                tempArray[i] = arrayOfEntries[i];
            }
            tempArray[arrayIndex] = entry;
            arrayOfEntries = tempArray;
            arrayIndex += 1;

        }

    }

    public void deleteEntryUsingName(String surname){
        for(int i=0; i < arrayOfEntries.length; i++){
            if (arrayOfEntries[i].getSurname().equals(surname)) {
                tempArray = new Entry[arrayIndex - 1];
                int count = 0;
                for(int j=0; j < arrayOfEntries.length; j++){
                    if (j != i){
                        tempArray[count] = arrayOfEntries[j];
                        count += 1;
                    }
                }
                arrayOfEntries = new Entry[arrayIndex - 1];
                arrayOfEntries = tempArray;
                arrayIndex = arrayIndex - 1;
            }
        }


    }

    public void deleteEntryUsingExtension(String number){
        for(int i=0; i < arrayOfEntries.length; i++){
            if (arrayOfEntries[i].getTeleExt().equals(number)) {
                tempArray = new Entry[arrayIndex - 1];
                int count = 0;
                for(int j=0; j < arrayOfEntries.length; j++){
                    if (j != i){
                        tempArray[count] = arrayOfEntries[j];
                        count += 1;
                    }
                }
                arrayOfEntries = new Entry[arrayIndex - 1];
                arrayOfEntries = tempArray;
                arrayIndex = arrayIndex - 1;
            }
        }

    }

    public void updateExtensionUsingName(String surname, String newNumber){
        for(int i=0; i < arrayOfEntries.length; i++){
            if (arrayOfEntries[i].getSurname().equals(surname)) {
                arrayOfEntries[i].setTeleExt(newNumber);
            }
        }
    }

    public String lookupExtension(String surname){
        String teleExt = "";
        for(int i=0; i < arrayOfEntries.length; i++){
            if (arrayOfEntries[i].getSurname().equals(surname)) {
                teleExt = arrayOfEntries[i].getTeleExt();
            }
        }
        return teleExt;
    }

    public List<Entry> toArrayList(){
        List<Entry> listOfEntries = new ArrayList<>();
        for (int i = 0; i < arrayOfEntries.length; i++){
            listOfEntries.add(arrayOfEntries[i]);
        }
        return listOfEntries;
    }

}

    class ListDirectory implements Directory{

        private ArrayList<Entry> listOfEntries = new ArrayList<>();
        private int listIndex = 0 ;

        public void insertEntry(Entry entry){
            listOfEntries.add(entry);
        }

        public void deleteEntryUsingName(String surname){
            for(int i=0; i < listOfEntries.size(); i++){
                if (listOfEntries.get(i).getSurname().equals(surname)) {
                    listOfEntries.remove(i);
                    }
                }
        }

        public void deleteEntryUsingExtension(String number){
            for(int i=0; i < listOfEntries.size(); i++){
                if (listOfEntries.get(i).getTeleExt().equals(number)) {
                    listOfEntries.remove(i);
                }
            }
        }

        public void updateExtensionUsingName(String surname, String newNumber){
            for(int i=0; i < listOfEntries.size(); i++){
                if (listOfEntries.get(i).getSurname().equals(surname)) {
                    listOfEntries.get(i).setTeleExt(newNumber);
                }
            }
        }

        public String lookupExtension(String surname){
            String teleExt = "";
            for(int i=0; i < listOfEntries.size(); i++){
                if (listOfEntries.get(i).getSurname().equals(surname)) {
                    teleExt = listOfEntries.get(i).getTeleExt();
                }
            }
            return teleExt;
        }

        public List<Entry> toArrayList(){
            return listOfEntries;
        }

    }

    class HashDirectory implements Directory{

        private Map<String, Entry> snameMapOfEntries = new HashMap<>();
        private Map<String, Entry> extensionMapOfEntries = new HashMap<>();

        public void insertEntry(Entry entry){
            String sname = entry.getSurname();
            String telephoneExtension = entry.getTeleExt();
            snameMapOfEntries.put(sname, entry);
            extensionMapOfEntries.put(telephoneExtension, entry);


        }

        public void deleteEntryUsingName(String surname){

            extensionMapOfEntries.remove(snameMapOfEntries.get(surname).getTeleExt());
            snameMapOfEntries.remove(surname);

        }

        public void deleteEntryUsingExtension(String number){

            snameMapOfEntries.remove(extensionMapOfEntries.get(number).getSurname());
            extensionMapOfEntries.remove(number);

        }

        public void updateExtensionUsingName(String surname, String newNumber){

            extensionMapOfEntries.remove(snameMapOfEntries.get(surname).getTeleExt());
            snameMapOfEntries.get(surname).setTeleExt(newNumber);
            extensionMapOfEntries.put(newNumber, snameMapOfEntries.get(surname));

        }

        public String lookupExtension(String surname){
            String extension = snameMapOfEntries.get(surname).getTeleExt();
            return extension;
        }

        public List<Entry> toArrayList(){
            List<Entry> mapOfEntries = new ArrayList<>();

            for(Map.Entry snameEntry : snameMapOfEntries.entrySet()){
                mapOfEntries.add(snameMapOfEntries.get(snameEntry.getKey()));
            }

            return mapOfEntries;
        }

    }

}