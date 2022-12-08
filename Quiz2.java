
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz2 {
    public static void main(String[] args) throws Exception {
        //Create Categories
        Category2 ColbyJack = new Category2("Colby Jack", " The best of the best " +  " You like to be in control and you should be");
        Category2 Cheddar = new Category2("Cheddar", "A classy classic, just like you!!!" + "While it is not the best out there, it is a very solid and respectable option");
        Category2 Blue = new Category2("Blue Cheese", "You are a dissapointment" + " Blue cheese is a sad pathetic and putrid excuse for cheese" +"Do better!!");


        // Create Questions
        Question2 q1 = new Question2("You have a 1pm flight out of LAG (you live in NYC), What time do you leave the house?");
        // Attach Answers to Questions
        q1.possibleAnswers[0] = new Answer2("9:15am", Blue);
        q1.possibleAnswers[1] = new Answer2("10am", Cheddar);
        q1.possibleAnswers[2] = new Answer2("11am", ColbyJack);

        Question2 q2 = new Question2(" It's your turn on AUX what song do you put on?");
        q2.possibleAnswers[0] = new Answer2("Clouded - Brent Faiyaz", ColbyJack );
        q2.possibleAnswers[1] = new Answer2("Before He Cheats - Carrie Underwood", Blue);
        q2.possibleAnswers[2] = new Answer2("Trap Queen - Fetty Wap", Cheddar);

        Question2 q3 = new Question2("Favorite shoe brand?");
        q3.possibleAnswers[0] = new Answer2("Nike", Cheddar);
        q3.possibleAnswers[1] = new Answer2("Converse", ColbyJack);
        q3.possibleAnswers[2] = new Answer2("Alexander McQueen", Blue);
        

        Question2 q4 = new Question2("Best French Fries?");
        q4.possibleAnswers[0] = new Answer2("McDonalds", ColbyJack);
        q4.possibleAnswers[1] = new Answer2("Wingstop", Cheddar);
        q4.possibleAnswers[2] = new Answer2("Burger King", Blue);
     

        Question2 q5 = new Question2( "Favorite Childhood Movie");
        q5.possibleAnswers[0] = new Answer2("Ratatouille", Cheddar);
        q5.possibleAnswers[1] = new Answer2("Walle", Blue);
        q5.possibleAnswers[2] = new Answer2("Home Alone", ColbyJack);

        // For each question, ask, read input, store answer.
        Scanner sc = new Scanner(System.in);
        gameIntro(sc);
        Question2[] qList = { q1, q2, q3, q4, q5 };
        for (Question2 q : qList)
         {
            Category2 c = q.ask(sc);
            c.points++;
        }
        // Get most common category from the questions asked
        // Return Category1
        Category2[] cList = { ColbyJack, Cheddar, Blue, };
        int[] counts = { ColbyJack.points, Cheddar.points, Blue.points, };
        // these need to be in the same order or the points will be incorrect!
        int index = getMostPopularCatIndex(counts);
        System.out.println("If you were a type of cheese, you would be " + cList[index].label + ". ");
        System.out.println(cList[index].description);

    }

    public static void gameIntro(Scanner sc) {
        // requires 1 to keep going
        System.out.println("What type of cheese are you?");
        System.out.println("You get to choose numbers 1-3 for every question. Enter '1' to play!");
        int play = sc.nextInt();
        if (play != 1) {
            System.out.println("Unidentifiable input. Please enter '1' to play");
            gameIntro(sc);
        }
    }

    public static int getMostPopularCatIndex(int[] counts) {
        // returns the index that is the max
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}