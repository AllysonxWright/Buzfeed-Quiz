import java.util.Scanner;

public class Question2 {
// Fields
String label;
Answer2[] possibleAnswers = new Answer2[3];

Question2(String label) {
this.label = label;
}

// ask a question, and return the category of the answer
Category2 ask(Scanner sc) {
System.out.println(this.label);
// prints out all the answer choices
for (int i = 0; i < this.possibleAnswers.length; i++) {
String choice = Integer.toString(i + 1);
System.out.println("[" + choice + "]:" +
this.possibleAnswers[i].label);
}
int ans = ErrorChecking.errorCheck(sc);
return possibleAnswers[ans - 1].cat;
}
}

class ErrorChecking {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
errorCheck(sc);
}

public static int errorCheck(Scanner sc) {
// restate possible inputs
System.out.println("I am expecting a number from 1 - 3!");
// if input is not an 1, 2, or 3
if (sc.hasNextInt()) {
int input = sc.nextInt();
if (input > 3|| input < 1) {
System.out.println("Hey! this number is not what I wanted. Try again.");
return errorCheck(sc);
} else {
System.out.println("valid answer");
return input;
}
// if input is not a number
} else {
System.out.println("This is not a number. Discarding this input");
sc.next(); // discarding the next input
return errorCheck(sc);
}
}
}