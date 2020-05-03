package com.company;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;


public class JavaIntro {
    public static void stdInChallenge() {
        System.out.println("Yo Bitch im back on intellij type yer shit an i'll try to read it in");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        //After inputing a double//int you need to clear the input buffer as the enter escape char will be what remains in after reading the value
        scan.nextLine();
        //scan.next() on reads the next word input a space will break out of the statement
        String s = scan.nextLine();
        System.out.printf("I think this is the Integer you typed: %s \n",i);
        System.out.printf("I think this is the Double you typed: %s \n",d);
        System.out.printf("This is Def the String you slapped in:%s",s);
    }
    public static void javaOutputFormatting() {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");
    }
    public static void javaLoopI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type A number yo and I'll try to multiply it n shit: ");
        int in = scanner.nextInt();
        for (int i = 1; i<11;i++){
            System.out.println(in+" x "+ i + " = " + (in*i));
        }
        scanner.close();
    }
    public static void  javaLoopII() {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int tally = a;
            for (int j=0; j<n;j++){
                tally+=(Math.pow(2,j)*b);
                System.out.print(tally+" ");
            }
            System.out.println();
        }
        in.close();
    }
    public static void dataTypes() {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                //Complete the code
                if(x >= -Math.pow(2, 15) && x <= Math.pow(2, 15) - 1)
                    System.out.println("* short");
                if(x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1)
                    System.out.println("* int");
                if(x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1)
                    System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
    public static void endOfFile() {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = 1;
        while (scanner.hasNextLine()) {
            System.out.println(lineNumber +" "+ scanner.nextLine());
            lineNumber++;
        }
    }

    public static void findDay(int month, int day, int year) {
        Calendar datePassed = Calendar.getInstance();
        LocalDate dt = LocalDate.of(year, month, day);
        datePassed.set(year, month, day);
        String dayOfWeek = LocalDate.of(year, month, day).getDayOfWeek().name();
        System.out.println(dayOfWeek);
    }
    public static void ifElse() {
        System.out.println("Type a numba bitch");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input % 2 != 0) {
            System.out.println("Weird");
        } else if (input%2 ==0 && input>=2 && input<=5) {
            System.out.println("Not Weird");
        } else if (input%2 ==0 && input>=6 && input<=20) {
            System.out.println("Weird");
        } else if (input > 20) {
            System.out.println("Not Weird");
        }
        scanner.close();
    }
    public static void currencyFormatter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type A monetary Value Bitch");
        double payment = scanner.nextDouble();
        scanner.close();
        NumberFormat usaF = NumberFormat.getCurrencyInstance(Locale.US);
        //There is no predefine enum value for india so you gotta generate it manually
        NumberFormat indiaF = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat chinaF = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceF = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String us = usaF.format(payment);
        String india = indiaF.format(payment);
        String china = chinaF.format(payment);
        String france = franceF.format(payment);
        // Write your code here.

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
    public static void mD5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type A value and I will hash it");
        String password =  scanner.nextLine();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                //In "%02x"
                //0 - used for padding
                //2 - width
                //x - prints the hash code of the object
                //Why width is 2 ?->Beacause Byte contains 8-bits & int contains 4-bits, so the total no of int needed is 2.
                System.out.printf("%02x", b);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    public static void  sha256() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type A value and I will hash it");
        String password =  scanner.nextLine();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                System.out.printf("%02x", b);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    public static void anagram(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 2 Words and I will evaluate them ");
        String word1 = scanner.nextLine().toLowerCase();
        String word2 = scanner.nextLine().toLowerCase();
        System.out.println("Testing Anagramness");
        if (isAnagramMultiplication(word1, word2)) {
            System.out.println("That shit you typed is an anagram");
        } else {
            System.out.println("Fuck outa here wit dat non anagram shit");
        }
        //Begin iterating over the
    }

    public static boolean isAnagram(String a, String b) {
        HashMap<Character,Integer> charMap = new HashMap();
        a = a.toLowerCase();
        b = b.toLowerCase();
        //Separate the first string into a char array and input into the hashmap and update the vales if the key already exists
        for (char c : a.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.replace(c, charMap.get(c), charMap.get(c) + 1);
            } else {
                charMap.put(c,1);
            }
        }
        for (char d : b.toCharArray()) {
            if(!charMap.containsKey(d)){
                return false;
            } else if (charMap.containsKey(d) && charMap.get(d) == 1) {
                charMap.remove(d);
            } else {
                charMap.replace(d, charMap.get(d), charMap.get(d) - 1);
            }
        }
        return charMap.size() == 0;
    }
    public static boolean isAnagramMultiplication(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int aValue = 1;
        int bValue = 1;
        //Separate the first string into a char array and input into the hashmap and update the vales if the key already exists
        for (char c : a.toCharArray()) {
            aValue *= c;
        }
        for (char d : b.toCharArray()) {
            bValue *= d;
        }
        System.out.println("aValue = " + aValue);
        System.out.println("bValue = " + bValue);
        return aValue==bValue;
    }
    public static void stringTokens() {
        System.out.println("Type a sentance and I'll fuck it up");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();
        if(s.length()>400000){
            return;
        }
        String[] splitStr = s.split("\\W+");
        System.out.println(splitStr.length);
        for (String str : splitStr) {
            System.out.println(str);
        }
        scan.close();
    }
    public static void syntaxChecker() {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (Exception exception) {
                System.out.println("Invalid");
            }
            testCases--;
            //Write your code
        }
    }
    public static void regexMatchIP() {
        String pattern = "\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\W(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\W(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\W(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
        System.out.println("Type some ips and i'll check em");
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(pattern));
        }

    }

}
