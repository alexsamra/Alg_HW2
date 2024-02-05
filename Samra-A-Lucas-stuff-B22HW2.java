import java.util.*;

public class MagicSquare {
    public static int acc = 0;
    public static void main(String args[]) {
        int total;
        int combinationsFour;
        LinkedList <Integer> magic = makeSquare();
        LinkedList <Integer> combCount;

        total = getTotal(magic);

        combinationsFour = findFour(magic, 0, 0, -1);
        System.out.println("There are " + combinationsFour/6 + " four number combinations that make the total " + total);

        magic = makeSquare();
        combCount = setList(magic);
        printCombs(combCount);
    }

    public static LinkedList<Integer> makeSquare(){
        LinkedList<Integer> magic = new LinkedList<Integer>();
        magic.add(1);
        magic.add(14);
        magic.add(14);
        magic.add(4);
  
        magic.add(11);
        magic.add(7);
        magic.add(6);
        magic.add(9);
 
        magic.add(8);
        magic.add(10);
        magic.add(10);
        magic.add(5);

        magic.add(13);
        magic.add(2);
        magic.add(3);
        magic.add(15);
        
        return magic;
    }

    public static int getTotal(LinkedList<Integer> magic){
        int total = 0;
        for(int i = 0; i < 4; i++){
            total += magic.get(i);
        }
        return total;
    }

    public static int findFour(LinkedList<Integer> magic, int total, int round, int start){
        int temp;
        int count = 0;
        if(round == 4 && total == 33){
            count++;
        }
        else if(round < 4){
            for(int i = 0; i < magic.size(); i++){
                if(magic.get(i) != 0){
                    if(findZeros(magic, start) == 0){
                        if(start >= 0){
                            magic.set(start, 0);
                        }
                        start++;
                    }
                    temp = magic.get(i);
                    magic.set(i, 0);
                    count += findFour(magic, total+temp, findZeros(magic, start), start);
                    magic.set(i, temp);
                }
            }
        }
        return count;
    }

    public static void findAll(LinkedList<Integer> magic, int goal, LinkedList<Integer> tempList) {
        int count = 0;
        for (int i = 0; i < tempList.size(); i++){
            count += tempList.get(i);
        }
        if (count == goal){
            MagicSquare.acc++;
            return;
        }
        else if(count > goal){
            return;
        }
        for(int i=0;i<magic.size();i++) {
            LinkedList<Integer> remaining = new LinkedList<Integer>();
            int n = magic.get(i);
            for (int j = i + 1; j < magic.size(); j++){
                remaining.add(magic.get(j));
            }
            LinkedList<Integer> temp2 = new LinkedList<Integer>(tempList);
            temp2.add(n);
            findAll(remaining, goal, temp2);
        }
    }

    public static int findZeros(LinkedList<Integer> magic, int start){
        
        int zeros = 0;
        if(start < 0){
            start = 0;
        }
        for(int i = start; i < magic.size(); i++){
            if(magic.get(i) == 0){
                zeros++;
            }
        }
        return zeros;
    }

    public static LinkedList<Integer> setList(LinkedList<Integer> magic){
        LinkedList <Integer> combCount = new LinkedList<Integer>();
        LinkedList <Integer> tempList = new LinkedList<Integer>();
        int total = 0;
        for(int i = 0; i < magic.size(); i++){
            total += magic.get(i);
        }

        for(int i = 0; i <= total; i++){
            findAll(magic, i, tempList);
            combCount.add(MagicSquare.acc);
            MagicSquare.acc = 0;
        }
        return combCount;
    }

    public static void printCombs(LinkedList<Integer> combs){
        int maxNum = 0;
        int maxIndex = 0;
        for(int i = 0; i < combs.size(); i++){
            if(maxNum < combs.get(i)){
                maxIndex = i;
                maxNum = combs.get(i);
            }
            System.out.println("There are " + combs.get(i) + " ways to get " + i);
        }
        System.out.println();
        System.out.println("The number that occurred the most was " + maxIndex + " and it occurred " + maxNum + " times");
    }
}




  

