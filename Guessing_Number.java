import java.util.*;

public class Guessing_Number{
    public static void main(String[] args){
        int Answer = (int)(Math.random()*100)+1;
        int k =5;
        Scanner sc = new Scanner(System.in);
        boolean correct = false;

        System.out.println("HEY PLAYER!!");
        System.out.println("In this game, you have to guess a number between 1 to 100");
        System.out.println("You have 5 tries to guess the number correct");

        while(k>0){
            System.out.println("Enter your guess: ");
            int Guess = sc.nextInt();

            if(Guess == Answer) {
                System.out.println("You guessed the number! \nYou won!");
                correct = true;
                break;
            } else if(Guess>Answer) {
                System.out.println("Your Answer is too high!! \nYou have "+ (k-1) +" tries left.");
            } else {
                System.out.println("Your Guess is too low!! \nYou have "+ (k-1) +" tries left.");
            }
            k--;
        }

        if(!correct) {
            System.out.println("You ran out of tries! \nYou lose!!");
            System.out.println("The number was "+ Answer);
        }
    }
}