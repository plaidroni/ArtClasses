public class Client {

    private String address;
    private String phoneNumber;
    private String fName;
    private String lName;
    private int age;
    private int classes;

    public Client(String address, String phoneNumber, String fName, String lName, int classes, int age){
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fName = fName;
        this.lName = lName;
        this.classes = classes;
        this.age = age;
    }

    public void addClasses(int classAdd){
        this.classes += classAdd;
    }

    public void checkIn(){
        this.classes -= 1;
    }

    public void setFirstName(String fname) {
        this.fName = fname;
    }

    public void setLastName(String lname) {
        this.lName = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getFirstName() {
        return this.fName;
    }


    public String getLastName() {
        return this.lName;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddress(){
        return this.address;
    }

    public int getClasses(){
        return this.classes;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
}
