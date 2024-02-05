import java.util.Scanner;
import java.util.*;

public class LucasNumber {
    public static void main(String args[]) {
        int input; 
        int answer;
        int count;
        int display;
        int again = 0;
        LinkedList<Long> times = new LinkedList<Long>();

        Scanner myObj = new Scanner(System.in);

        while(again == 0){
            System.out.println("What Lucas number value would you like to calculate: ");
            input = myObj.nextInt(); 

            answer = getLucas(input);
            System.out.println("The Lucas Number at " + input + " is " + answer);

            System.out.println("Would you like to repeat?");
            System.out.println("(0: yes    1: no)");
            again = myObj.nextInt();
        }
        
        System.out.println("How many time values would you like to see?");
        count = myObj.nextInt();

        for(int i = 0; i < count; i++){
            long start = System.nanoTime();
            getLucas(i);
            long end = System.nanoTime();
            times.add(end-start);
            System.out.println("It took " + times.get(i) + " nanoseconds to find the " + i + " Lucas number");
        }

        System.out.println("Would you like to display ratios between subsequent Lucas Numbers?");
        System.out.println("(0: yes    1: no)");
        display = myObj.nextInt();
        if(display == 0){
            displayNums(times.size());
        }

        System.out.println("Would you like to display ratios between subsequent times?");
        System.out.println("(0: yes    1: no)");
        display = myObj.nextInt();
        if(display == 0){
            displayTimes(times);
        }

        System.out.println("Would you like to see my pattern?");
        System.out.println("(0: yes    1: no)");
        LinkedList<Long> newTimes = new LinkedList<Long>();
        display = myObj.nextInt();
        if(display == 0){
            System.out.println("What Alex number value would you like to calculate: ");
            input = myObj.nextInt(); 
            answer = getAlex(input);
            System.out.println("The Alex Number at " + input + " is " + answer);

            for(int i = 0; i < 40; i++){
                long start = System.nanoTime();
                getAlex(i);
                long end = System.nanoTime();
                newTimes.add(end-start);
                System.out.println("It took " + newTimes.get(i) + " nanoseconds to find the " + i + " Lucas number");
            }
            displayTimes(newTimes);
        }
        myObj.close();
    }

    public static int getLucas(int start){
        int calc;
        if(start < 0){
            return 0;
        }
        else if(start == 0){
            return 2;
        }
        else if(start == 1){
            return 1;
        }
        else{
            calc = getLucas(start-2) + getLucas(start-1);
            return calc;
        }
    }

    public static int getAlex(int start){
        int calc;
        if(start < 0){
            return 0;
        }
        else if(start == 0){
            return 5;
        }
        else if(start == 1){
            return 5;
        }
        else{
            calc = getAlex(start-2) + getAlex(start-1);
            return calc;
        }
    }

    public static void displayNums(int size){
        Double ratio;
        for(int i = 0; i < size-1; i++){
            ratio = (double)getLucas(i+1)/getLucas(i);
            System.out.println("The ratio between times for n = " + i + " and n = " + (i+1) + " is " + ratio);
        }
    }

    public static void displayTimes(LinkedList<Long> times){
        Double ratio;
        for(int i = 0; i < times.size()-1; i++){
            ratio = (double)times.get(i+1)/times.get(i);
            System.out.println("The ratio between times for n = " + i + " and n = " + (i+1) + " is " + ratio);
        }
    }

}
