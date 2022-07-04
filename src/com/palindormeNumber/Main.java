package com.palindormeNumber;

public class Main {

    public static void main(String[] args) {
        String s="19099";
        int readNumber = -1;
        try {
            readNumber = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("It is not a number.");
        }
        System.out.println(possibleTail(s));


    }

    static Integer countInteger(int num){
        int count = 0;

        while (num != 0) {
            // num = num/10
            num /= 10;
            ++count;
        }

       return count;
    }



    static Integer possibleTail(String s){
        int length=s.length();
        int newTail=Integer.parseInt(s.substring(s.length()-(s.length()/2)));
        String newHead =s.substring(0,(s.length()/2));
        StringBuilder sb=new StringBuilder(newHead);
        int target=Integer.parseInt(sb.reverse().toString());
        int tempResult=target-newTail;
        int absTempResult=Math.abs(tempResult);
        int digit=countInteger(tempResult);
        double thresh= (int) (Math.pow(10,digit-1)*11);
        boolean b = (int) (s.charAt(length / 2)) == '9';
        if(absTempResult>thresh/2 && length%2==0){
            return (int)(thresh-absTempResult);

        }
        else if(absTempResult>thresh/2 && length%2==1 && b){
            return (int)(thresh-absTempResult);

        }
        else{
            return tempResult;
        }
    }
}
