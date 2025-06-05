/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poeregistration;
import java.util.Random;
import java.util.Scanner;
 


public class POEREGISTRATION {

    public static void main(String[] args) {
       
        POElogin loginObj = new POElogin() ;
        
        Scanner input = new Scanner  (System. in) ;
        
        
        String firstName;
        String lastName; 
        String userName;
        String password;
        String cellNumber;
        
        
        System. out.println ( "Registration");
        
        System.out.print("Enter your first name:") ;
        firstName = input.nextLine() ;
        loginObj.setFirstname(firstName);
        
        System.out.print ("Enter your last name:");
        lastName = input.nextLine() ;
        loginObj.setLastname(lastName);
        
        System.out.print ("\n" + "Create your user name"
        + "\n*Note that your username:"
        +"\n- must not exceed 5 characters in length and" 
        +"\n- must contain an underscore(_)."
        +"\nEnter a username:");
        userName = input.nextLine();
        loginObj.setUsername (userName);
        loginObj.checkUserName(userName);
        
        System.out.print ("\n" + "Create your password" 
        + "\n*Note that your password must: " 
        +"\n-contain atleast 8 characters, "
        +"\n-contain a capital letter,"
        +"\n-contain a digit and" 
        +"\n-contain a special character."
        +"\nEnter password:");
        password = input.nextLine();
        loginObj.setPassword (password);
        loginObj.checkPasswordComplexity(password);
        
        System.out.print ("\n" + "Enter your cellphone number"
        +"\n*Note that your number must:"
        +"\n-contain international country code (+27) "
        +"\nEnter cellphone number:") ; 
        cellNumber=input.nextLine();
        loginObj.setCellnumber (cellNumber);
        loginObj.checkCellPhoneNumber(cellNumber) ;
        
        System.out.println( loginObj.registerUser(userName,password,cellNumber));//calling register user (to validate)
        
        System.out.println ( "Login");
        
        System.out.print ( "enter your username:") ;
        userName = input.nextLine() ;
        String loginName = userName;
        
        LoginObj.setUsername (userName);
        
        System.out.print ( "enter your password:");
        password=input.nextLine () ;
        String loginPass = password;
        loginObj.setPassword(password);
        System.out.print( loginObj.returnLoginStatus(loginName,loginPass, userName,password,firstName,lastName));
       
    }//(ITE, 2025)
// (Farell, 2019)
// (Raven, 2023) 
    
         
    
    }
public class MessageLogin {
    private String username;
    private String password;
    private boolean loggedIn;

    public MessageLogin(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    public boolean authenticate() {
        // Simple hardcoded login
        if (username.equals("admin") && password.equals("1234")) {
            loggedIn = true;
        }
        return loggedIn;
    }

    public void logout() {
        loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUsername() {
        return username;
    }
} 

    public class Message {
    private String messageId;
    private int messageNumber;
    private String recipient;
    private String content;
    private String messageHash;
    private static int totalMessagesSent = 0;

    public Message(int messageNumber, String recipient, String content) {
        this.messageId = generateMessageId();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.content = content;
        this.messageHash = createMessageHash();
    }

    private String generateMessageId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public boolean checkMessageID() {
        return messageId.length() == 10;
    }

    public boolean checkRecipientCell() {
        return recipient.startsWith("+") && recipient.length() <= 10;
    }

    public String createMessageHash() {
        String[] words = content.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        return (messageId.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    public String SentMessage(String choice) {
        return switch (choice) {
            case "1" -> {
                totalMessagesSent++;
                yield "Message successfully sent.";
            }
            case "2" -> "Press 0 to delete message.";
            case "3" -> {
                storeMessage();
                yield "Message stored.";
            }
            default -> "Invalid choice.";
        };
    }

    public String printMessages() {
        return "MessageID: " + messageId + "\nMessage Hash: " + messageHash +
                "\nRecipient: " + recipient + "\nMessage: " + content;
    }

    public static int returnTotalMessages() {
        return totalMessagesSent;
    }

    public void storeMessage() {
        MessageStorage.store(this);
}
}
public class MessageStorage {
    public static void store(Message msg) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("messages.json", true)) {
            gson.toJson(msg, writer);
        }catch (IOException e) {
            e.printStackTrace();
 }}
}

public class MessagingApp.java {
    private static Scanner scanner = new Scanner(System.in);
    private static int messageCount = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to QuickChat!");

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Login login = new Login(username, password);

        if (!login.authenticate()) {
            System.out.println("Login failed.");
            return;
        }

        System.out.println("Login successful.");

        System.out.print("How many messages would you like to send? ");
        int totalMessages = Integer.parseInt(scanner.nextLine());

        int menuOption = 0;

        while (menuOption != 3) {
            System.out.println("\nMenu:");
            System.out.println("1. Send Message");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            menuOption = Integer.parseInt(scanner.nextLine());

            switch (menuOption) {
                case 1 -> {
                    if (messageCount >= totalMessages) {
                        System.out.println("You have reached the message limit.");
                        break;
                    }

                    System.out.print("Enter recipient (e.g. +2712345678): ");
                    String recipient = scanner.nextLine();

                    System.out.print("Enter message (max 250 chars): ");
                    String content = scanner.nextLine();

                    if (content.length() > 250) {
                        System.out.println("Message exceeds 250 characters by " + (content.length() - 250) + ", please reduce size.");
                        break;
                    }

                    Message msg = new Message(messageCount + 1, recipient, content);

                    if (!msg.checkMessageID()) {
                        System.out.println("Message ID generation failed.");
                        break;
                    }

                    if (!msg.checkRecipientCell()) {
                        System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                        break;
                    }

                    System.out.println("Choose: [1] Send  [2] Disregard  [3] Store for Later");
                    String option = scanner.nextLine();

                    String result = msg.SentMessage(option);
                    System.out.println(result);

                    if (option.equals("1")) {
                        messageCount++;

                        JOptionPane.showMessageDialog(null, msg.printMessages());
                    } else if (option.equals("2")) {
                        System.out.println("Message disregarded.");
                    } else if (option.equals("3")) {
                        System.out.println("Message stored.");
                    }
                }
                case 2 -> System.out.println("Coming Soon.");
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Total messages sent: " + Message.returnTotalMessages());

    }
}






