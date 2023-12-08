import java.util.*;
public class Main {
    public static void main(String[] args) {
    }
    
    public static ArrayList<Integer> Sieve(int n) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            nums.add(i);
        }

        ;


        for (int k = 0; k < nums.size(); k++) {
            int p = nums.get(k);
            for (int i = k+1; i < nums.size(); i++) {
                if (nums.get(i) % p == 0) {
                    nums.remove(i);
                    i--;
                }
            }
        }
        return nums;
    }


    public static void GoldBach(int n) {
        ArrayList<Integer> nums = Sieve(n);
        int first = 0;
        int second = 0;


        for (int num : nums) {
            first = num;

            for (int current : nums) {
                if (first + current == n) {
                    second = current;
                    break;
                }



            }

            if (second != 0) {
                break;
            }
        }

        System.out.println(n + " = "+  first + " + " + second);


    }

    public static ArrayList<Integer> BigInts(ArrayList<Integer> first, ArrayList<Integer> second) {

        if (first.size() > second.size()){
            for (int i = second.size(); i < first.size(); i++){
                second.add(0, 0);
            }
        } else if (first.size() < second.size()){
            for (int i = first.size(); i < second.size(); i++){
                first.add(0, 0);
            }
        }


        ArrayList<Integer> sumList = new ArrayList<>();

        for (int i =0; i < first.size(); i++) {
            sumList.add(0);
        }

        for (int i = first.size() - 1; i >= 0; i--) {
            int sum = first.get(i) + second.get(i);


            int newNum = sumList.get(i) + sum;

            sumList.set(i, newNum);

            if (sumList.get(i) >= 10 && i > 0) {
                sumList.set(i, newNum - 10);
                sumList.set(i - 1, sumList.get(i-1)+1);

            } else if (sumList.get(i) >= 10 && i == 0) {
                sumList.add(0,1);
                sumList.set(i+1, sumList.get(i+1)-10);


            }




        }




        return sumList;




    }





}