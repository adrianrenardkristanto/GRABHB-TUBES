enum UserType{
    CUSTOMER(1), DRIVER(2), ADMIN(0);

    private int type;
    
    UserType(int type){
        this.type = type;
    }
}

interface UserMethod{
    public boolean register();
    public boolean login(String username, String password);
    public void logout();

    public String viewProfile(); // termasuk update atau ganti datanya
    public boolean changePassword(String newPwd, String oldPwd);


    public boolean verifyAdmin();
}

abstract class User implements UserMethod{
    private int ID_user;
    private String name;
    private String noTelp;
    
    private String username;
    private String password;
    private String email; 
    
    private UserType type;
    
    // Constructor
    User(String name, String noTelp, String username, String password, String email, UserType type){
        this.name = name;
        this.noTelp = noTelp;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    // Getter and setter methods 
    public int getID_user() {
        return ID_user;
    }

    public void setID_user(int iD_user) {
        ID_user = iD_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    // Methods

    // public boolean register(String name, String noTelp, String username, String password, String email ){
        
    //     return true;

    // }

    @Override
    public boolean login(String username, String password){
        // Ambil data dari database, Nanti diubah
        String usrname = "";
        String pwd = "";


        if(username.equals(usrname) && password.equals(pwd)){
            System.out.println("Welcome to Grab!");
            return true;
        }else{
            System.out.println("Incorrect username or password!");
            return false;
        }
    }
    
    public void logout(){
        System.out.println("Terima kasih!");
        
    }


    public String viewProfile(){
        return "Profile : "+name+"\nNo Telp : "+noTelp+"\nUsername : "+username+"\nEmail : "+email;
    }

    public boolean changePassword(String newPwd, String oldPwd){
        // Ambil data password dari database
        String pwd = "";


        if (oldPwd.equals(pwd)) {
            // Set new password
            pwd = newPwd;
            return true;
        }
        return false;


        // Kasus kalau lupa password lama, gimana???????
    }

    public boolean verifyAdmin(){
        return this.type == UserType.ADMIN;
    }

}


class Customer extends User{
    Customer(String name, String noTelp, String username, String password, String email){
        super(name, noTelp, username, password, email, UserType.CUSTOMER);
    }

    @Override
    public boolean register(){
        // Kalau register customer, tambahkan ke database
        return true;
    }

    @Override
    public boolean login(String username, String password){
        // Ambil data dari database, Nanti diubah
        String usrname = "Haii";
        String pwd = "hehehe";


        if(username.equals(usrname) && password.equals(pwd)){
            System.out.println("Welcome " + this.getName());
            return true;
        }else{
            System.out.println("Incorrect username or password!");
            return false;
        }
    }

    @Override
    public void logout(){
        System.out.println("Terima kasih " + this.getName());
        
    }

    @Override
    public String viewProfile(){
        return "Profile : "+this.getName()+"\nNo Telp : "+this.getNoTelp()+"\nUsername : "+this.getUsername()+"\nEmail : "+this.getEmail();
    }


    @Override
    public boolean changePassword(String newPwd, String oldPwd) {
        String pwd = this.getPassword(); // Ambil data dari objek
    
        if (oldPwd.equals(pwd)) {
            this.setPassword(newPwd); // Set new password
            System.out.println("Password berhasil diubah");
            return true;
        }
        return false;
    }
    
    @Override
    public boolean verifyAdmin(){
        return false;
    }



    // Tambahan fungsi


}

class Driver extends User{
    Driver(String name, String noTelp, String username, String password, String email){
        super(name, noTelp, username, password, email, UserType.DRIVER);
    }

    @Override
    public boolean register(){
        // Kalau register driver, tambahkan ke database
        return true;
    }

    @Override
    public boolean login(String username, String password){
        // Ambil data dari database, Nanti diubah
        String usrname = "";
        String pwd = "";


        if(username.equals(usrname) && password.equals(pwd)){
            System.out.println("Welcome " + this.getName());
            return true;
        }else{
            System.out.println("Incorrect username or password!");
            return false;
        }
    }

    @Override
    public void logout(){
        System.out.println("Terima kasih " + this.getName());
        
    }

    @Override
    public String viewProfile(){
        return "Profile : "+this.getName()+"\nNo Telp : "+this.getNoTelp()+"\nUsername : "+this.getUsername()+"\nEmail : "+this.getEmail();
    }


    @Override
    public boolean changePassword(String newPwd, String oldPwd) {
        String pwd = this.getPassword(); // Ambil data dari objek
    
        if (oldPwd.equals(pwd)) {
            this.setPassword(newPwd); // Set new password
            System.out.println("Password berhasil diubah");
            return true;
        }
        return false;
    }
    

    @Override
    public boolean verifyAdmin(){
        return false;
    }
}


public class tubes_v01{
    public static void main(String[] args) {
        System.out.println("Adrian");
        Customer cs = new Customer("Adrian", "081919191919", "Haii", "00", "adrian@email.com");

        cs.logout();
    }   
}