/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poeregistration;

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
        MessageStorage.store;
}
}
    

