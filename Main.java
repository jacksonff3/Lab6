import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int inputInt;
        String inputStr;
        int overallIndex;
        String fileName = "TY9_Grades.csv";
        File file = new File(fileName);
        String [] unsortedSID = new String[38];
        String [] unsortedPP1 = new String[38];
        String [] unsortedPP2 = new String[38];
        String [] unsortedPP3 = new String[38];
        String [] unsortedPP4 = new String[38];
        String [] unsortedPP5 = new String[38];
        String [] unsortedPP6 = new String[38];
        String [] unsortedL1 = new String[38];
        String [] unsortedL2 = new String[38];
        String [] unsortedL3 = new String[38];
        String [] unsortedL4 = new String[38];
        String [] unsortedM1 = new String[38];
        String [] unsortedM2 = new String[38];
        String [] unsortedSubtotal = new String[38];

        try {
            Scanner scanner = new Scanner(file); //Scans File
            scanner.next();
            scanner.next();
            for(int i = 0; i < 37; i++){
                String id = scanner.next();
                String [] values = id.split(",");
                unsortedSID[i] = values[0].replaceAll("\"", "");
                unsortedPP1[i] = values[1].replaceAll("\"","");
                unsortedPP2[i] = values[2].replaceAll("\"","");
                unsortedPP3[i] = values[3].replaceAll("\"","");
                unsortedPP4[i] = values[4].replaceAll("\"","");
                unsortedPP5[i] = values[5].replaceAll("\"","");
                unsortedPP6[i] = values[6].replaceAll("\"","");
                unsortedL1[i] = values[7].replace("\"","");               //Everything into arrays
                unsortedL2[i] = values[8].replace("\"","");
                unsortedL3[i] = values[9].replace("\"","");
                unsortedL4[i] = values[10].replace("\"","");
                unsortedM1[i] = values[11].replace("\"","");
                unsortedM2[i] = values[12].replace("\"","");
                unsortedSubtotal[i] = values[13].replaceAll("\"", "");
                }

            } catch(FileNotFoundException e){
           e.printStackTrace();
        }
        massSorting(unsortedSID,unsortedPP1, unsortedPP2,unsortedPP3,unsortedPP4,unsortedPP5,unsortedPP6, //Calls Method massSorting
                unsortedL1,unsortedL2,unsortedL3,unsortedL4,unsortedM1,unsortedM2,unsortedSubtotal);      //All the "unsorted" arrays should be sorted now



        //Prompting user to search
        System.out.println("Please enter TY9 - (last 4 digits of your EMPLID)");
        inputStr = sc.next();
        overallIndex = findElementIndex(inputStr, unsortedSID);
        int rank = overallIndex;
        System.out.println("What which assignment would you like to search up your grade for?" +
                "\n 1) Practice Problem 1" +
                "\n 2) Practice Problem 2" +
                "\n 3) Practice Problem 3" +
                "\n 4) Practice Problem 4" +
                "\n 5) Practice Problem 5" +
                "\n 6) Practice Problem 6" +
                "\n 7) Lab 1" +
                "\n 8) Lab 2" +
                "\n 9) Lab 3" +
                "\n 10) Lab 4" +
                "\n 11) Midterm 1" +
                "\n 12) Midterm 2" +
                "\n 13) Overall Grade");
        inputInt = sc.nextInt();
        if(inputInt == 1){
            System.out.println("Practice Problem 1:" + " " + unsortedPP1[overallIndex]);
        }
        else if(inputInt == 2 ){
            System.out.println("Practice Problem 2:" + " " + unsortedPP2[overallIndex]);
        }
        else if(inputInt == 3 ){
            System.out.println("Practice Problem 3:" + " " + unsortedPP3[overallIndex]);
        }
        else if(inputInt == 4 ){
            System.out.println("Practice Problem 4:" + " " + unsortedPP4[overallIndex]);
        }
        else if(inputInt == 5 ){
            System.out.println("Practice Problem 5:" + " " + unsortedPP5[overallIndex]);
        }
        else if(inputInt == 6 ){
            System.out.println("Practice Problem 6:" + " " + unsortedPP6[overallIndex]);
        }
        else if(inputInt == 7 ){
            System.out.println("Lab 1" + " " + unsortedL1[overallIndex]);
        }
        else if(inputInt == 8 ){
            System.out.println("Lab 2" + " " + unsortedL2[overallIndex]);
        }
        else if(inputInt == 9 ){
            System.out.println("Lab 3" + " " + unsortedL3[overallIndex]);
        }
        else if(inputInt == 10 ){
            System.out.println("Lab 4" + " " + unsortedL4[overallIndex]);
        }
        else if(inputInt == 11){
            System.out.println("Midterm 1" + " " + unsortedM1[overallIndex]);
        }
        else if(inputInt == 12){
            System.out.println("Midterm 2" + " " + unsortedM2[overallIndex]);
        }
        else if(inputInt == 13){
            System.out.println(unsortedSubtotal[overallIndex]);
        }
        gradeCalculator(unsortedSubtotal,overallIndex,sc);
        System.out.println("Your current class ranking is *" + rank + "*");
    }

    public static void massSorting(String [] unSortedSid, String [] unSortedPP1,String [] unSortedPP2, String [] unSortedPP3, String [] unSortedPP4
                            , String [] unSortedPP5, String [] unSortedPP6, String [] unSortedL1, String [] unSortedL2, String [] unSortedL3
                            , String [] unSortedL4, String [] unSortedM1, String [] unSortedM2, String [] unsortedSubtotal){
        String temp;
        for(int i = 0; i< unsortedSubtotal.length-2; i++){
            if(Double.parseDouble(unsortedSubtotal[i]) > Double.parseDouble(unsortedSubtotal[i+1])){
                //Sorts subTotal
                temp = unsortedSubtotal[i];
                unsortedSubtotal[i] = unsortedSubtotal[i+1];
                unsortedSubtotal[i+1] = temp;
                //Sorts SID
                temp = unSortedSid[i];
                unSortedSid[i] = unSortedSid[i+1];
                unSortedSid[i+1] = temp;
                //Sorts Unsorted Practice Problem 1
                temp = unSortedPP1[i];
                unSortedPP1[i] = unSortedPP1[i+1];
                unSortedPP1[i+1] = temp;
                //Sorts Unsorted Practice Problem 2
                temp = unSortedPP2[i];
                unSortedPP2[i] = unSortedPP2[i+1];
                unSortedPP2[i+1] = temp;
                //Sorts Unsorted Practice Problem 3
                temp = unSortedPP3[i];
                unSortedPP3[i] = unSortedPP3[i+1];
                unSortedPP3[i+1] = temp;
                //Sorts Unsorted Practice Problem 4
                temp = unSortedPP4[i];
                unSortedPP4[i] = unSortedPP4[i+1];
                unSortedPP4[i+1] = temp;
                //Sorts Unsorted Practice Problem 5
                temp = unSortedPP5[i];
                unSortedPP5[i] = unSortedPP5[i+1];
                unSortedPP5[i+1] = temp;
                //Sorts Unsorted Practice Problem 6
                temp = unSortedPP6[i];
                unSortedPP6[i] = unSortedPP6[i+1];
                unSortedPP6[i+1] = temp;
                //Sorts Unsorted Lab 1
                temp = unSortedL1[i];
                unSortedL1[i] = unSortedL1[i+1];
                unSortedL1[i+1] = temp;
                //Sorts Unsorted Lab 2
                temp = unSortedL2[i];
                unSortedL2[i] = unSortedL2[i+1];
                unSortedL2[i+1] = temp;
                //Sorts Unsorted Lab 3
                temp = unSortedL3[i];
                unSortedL3[i] = unSortedL3[i+1];
                unSortedL3[i+1] = temp;
                //Sorts Unsorted Lab 4
                temp = unSortedL4[i];
                unSortedL4[i] = unSortedL4[i+1];
                unSortedL4[i+1] = temp;
                //Sorts Midterm1
                temp = unSortedM1[i];
                unSortedM1[i] = unSortedM1[i+1];
                unSortedM1[i+1] = temp;
                //Sorts Midterm2
                temp = unSortedM2[i];
                unSortedM2[i] = unSortedM2[i+1];
                unSortedM2[i+1] = temp;
            }
        }


    }
    //Finds the index of the emplid, since all the arrays are parrallel this will give us access to the others as well
    public static int findElementIndex(String value, String [] sortedSID){
        int index = 0;
        for(int i = 0; i< sortedSID.length-1; i ++){
            if ((sortedSID[i]).equalsIgnoreCase(value)){
                index = i;
            }

        }
        return index;
    }

    public static void gradeCalculator (String [] sortedSubtotal,int overallIndex,Scanner scanner){
        double points;
        double sum = Double.parseDouble(sortedSubtotal[overallIndex]);
        System.out.println("Your current grade is " + sortedSubtotal[overallIndex]);
        System.out.println("Here are the grade values of the remaining assignments" +
                "\n Lab 5 = 2 points" +
                "\n Lab 6 = 2 points" +
                "\n Lab 7 = 4 points" +
                "\n Practice Problem 7 = 6 points" +
                "\n Practice Problem 8 = 6 points" +
                "\n Finals = 20 points" +
                "\n Enter the grade you think you'll get for each assignment and see what your grade is!");
        System.out.println("Lab 5 (Enter a number between 1 and 2)");
        points = scanner.nextDouble();
        sum = sum + points;
        System.out.println("Lab 6 (Enter a number between 1 and 2)");
        points = scanner.nextDouble();
        sum = sum + points;
        System.out.println("Lab 7 (Enter a number between 1 and 4)");
        points = scanner.nextDouble();
        sum = sum + points;
        System.out.println("Practice Problem 7 (Enter a number between 1 and 6)");
        points = scanner.nextDouble();
        sum = sum + points;
        System.out.println("Practice Problem 8 (Enter a number between 1 and 6)");
        points = scanner.nextDouble();
        sum = sum + points;
        System.out.println("Final (Enter a number between 1 and 20)");
        points = scanner.nextDouble();
        sum = sum + points;
        if((sum >= 97) && (sum <= 100)){
            System.out.println("A+");
        }
        else if((sum >= 93) && (sum <= 96)){
            System.out.println("A");
        }
        else if((sum >= 90) && (sum <= 92)){
            System.out.println("A-");
        }
        else if((sum >= 87) && (sum <= 89)){
            System.out.println("B+");
        }
        else if((sum >= 83) && (sum <= 86)){
            System.out.println("B");
        }
        else if((sum >= 80) && (sum <= 82)){
            System.out.println("B-");
        }
        else if((sum >= 77) && (sum <= 79)){
            System.out.println("C+");
        }
        else if((sum >= 73) && (sum <= 76)){
            System.out.println("C");
        }
        else if((sum >= 70) && (sum <= 72)){
            System.out.println("C-");
        }
        else if((sum >= 67) && (sum <= 69)){
            System.out.println("D+");
        }
        else if((sum >= 65) && (sum <= 66)){
            System.out.println("D");
        }
        else{
            System.out.println("F");
        }
    }
}
