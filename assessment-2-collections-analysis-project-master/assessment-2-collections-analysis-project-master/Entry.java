public class Entry {
    private String surname;
    private String initials;
    private String telephoneExtension;

    public Entry(String surname, String initials, String telephoneExtension){
        this.surname=surname;
        this.initials=initials;
        this.telephoneExtension=telephoneExtension;
    }

    public String getTeleExt(){

        return telephoneExtension;
    }

    public String getSurname(){
        return surname;
    }

    public String getInitials(){
        return initials;
    }


    public String setTeleExt(String newNumber){
        telephoneExtension=newNumber;
        return telephoneExtension;
    }

    public String toString(){
        return ("Surname: " + surname + " Initials: " + initials +  " TelephoneExtension: " + telephoneExtension);
    }


}
