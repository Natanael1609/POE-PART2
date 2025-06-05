/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeregistration;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class POElogin {
   
         // attribute 
        private String firstName;
        private String lastName;
        private String userName;
        private String password;
        private String cellNumber;
        private String Username;
         private String Password;
    
    // constructor
    public POElogin (String firstName, String lastName, String userName, String Password, String cellNumber){
        this.firstName= firstName;
        this.lastName= lastName;
        this.firstName = userName;
        this.firstName = password;
        this.firstName = cellNumber;
} 
    //getter method
public String getfirstName(String firstName){
    return firstName;
}
    //setter method
public void setfirstName(String firstName){
this.firstName = firstName;
}
 //getter method
public String getlastName(String lastName){
    return lastName;
} 
//setter method
public void setlastName(String lastName){
this.lastName = lastName;
}
//getter method
public String getUsername(String Username){
    return Username;
}
//setter method
public void setUsername(String Username){
   this.Username = Username;
}
//getter method
public String getPassword(String Password){
    return Password;
}
//setter method
public void setPassword(String Password){
   this.Password = Password;
}
//getter method
public String getcellNumber (String cellNumber){
    return cellNumber;
}
//setter method
public void setcellNumber(String cellNumber){
   this.cellNumber = cellNumber;
}
//instance method
public boolean checkUsername(){
    return Username.contains("_")&&Username.length()<=5;
}

//password method
public void setUsername(){
    System.out.println(firstName + lastName);
}
private boolean isValidUsername(String username){
    return !username.isEmpty();
}
private static boolean isValidPassword(String password) {
 return password.length() >=8&&
        password.matches(".*[A-Za-z].*")&&
        password.matches(".*\\d.*");
 
}
private static boolean isValidPhoneNumber(String phone){
    return phone.matches("\\+27\\d(9)")||phone.matches("0\\d/(9)");
}

     public String registerUser(String userName, String password, String cellphoneNumber){
             if(userName.isEmpty()) {
            System.out.println("Username cannot be empty.");
        }else if(!isValidPassword(password)){
            System.out.println("password must at least be 8 characters long");
        }else if(isValidPhoneNumber(cellphoneNumber)){
            System.out.println("phoneNumber must a valid South African phoneNumber");
        }else{
            System.out.println("Account created succesfully!");
        }
     
    
    
 
   






      
  


    

