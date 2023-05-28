import java.util.Scanner;

public class chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Welcome to Customer Service! How can I assist you today?");

        while (true) {
            System.out.print("User: ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Chatbot: Thank you for reaching out. Have a great day!");
                break;
            } 
            else if (userInput.equalsIgnoreCase("speak to a representative")) {
                System.out.println("Chatbot: Sure, please hold on for a moment while I transfer you to a representative.");
                break;
            } 
            else if (userInput.equalsIgnoreCase("check order status")) {
                System.out.println("Chatbot: To check your order status, please provide your order number.");
                System.out.print("User: ");
                String orderNumber = scanner.nextLine();
                System.out.println("Chatbot: Your order " + orderNumber + " is currently under shipping. It may deliver soon.");
            } 
            else if (userInput.equalsIgnoreCase("cancel my order")) {
                System.out.println("Chatbot: I'm sorry to hear that. To cancel your order, please provide your order number.");
                System.out.print("User: ");
                String orderNumber = scanner.nextLine();
                System.out.println("Chatbot: Your order " + orderNumber + " has been successfully canceled.");
            } 
            else if (userInput.equalsIgnoreCase("return policy")) {
                System.out.println("Chatbot: Our return policy allows returns within 30 days of purchase. " +
                "Please ensure that the product is in its original condition with all accessories and packaging. ");
            } 
            else if (userInput.equalsIgnoreCase("change my shipping address")) {
                System.out.println("Chatbot: To change your shipping address, please provide your order number and " +
                        "the new shipping address details. Our customer support team will assist you further.");
                System.out.print("Order Number: ");
                String orderNumber = scanner.nextLine();
                System.out.print("New Shipping Address: ");
                String newShippingAddress = scanner.nextLine();
                System.out.println("Chatbot: Your shipping address for order " + orderNumber + " has been updated to: " + newShippingAddress);
            } 
            else {
                System.out.println("Chatbot: I'm sorry, I can't understand that. Could you please repeat?");
            }
        }
    }
}
