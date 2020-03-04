/****************************
 * 
* Hsiao-Hsien, Kuo(Burgess)
* kuohsi
* January 25, 2019
*
****************************/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuohsi;

/**
 * Test the fantasyTown
 * @author burgess
 */

import java.util.Scanner;
import ErrorCheck.JavaErrorCheck;
public class Main {

    /**
     * main method to call the whole method
     * @param args 
     */
    
    public static void main(String[] args) {
        Callme();
    }
    
    
    /**
     * method to call the whole town progress.
     * @param args 
     */
    public static void Callme(){

        Scanner input = new Scanner(System.in);
        JavaErrorCheck jec = new JavaErrorCheck();

        System.out.println("How many towns you want to insert (Please enter a "
                +"number!) > ");

//      number1 is the total town that user want to input.
        int number1 = jec.checkIntAndZero(input); 
        System.out.printf("Now you want to creat %d towns!\n",number1);
        
        FantasyTown allTown[] = new FantasyTown[number1];

//      countTown is the index for allTown[], countTownNumber shows the exact
//      number that the user input right now.
//      x1, y1 is the value in the coordinates[] array and the length is 2.
        int countTown=0;
        int countTownNumber=1;
        double x1, y1;
        double [] coordinates = new double[2];
        input.nextLine();
        
        do{
            allTown[countTown]= new FantasyTown();
            System.out.println("Enter town's information for town"
                    +countTownNumber+"?('Y/y' for 'Yes', 'N/n' for 'No'!) > ");

//          only enter y or n
            String input1 = jec.checkYorN(input);
            System.out.println("Your answer is: "+input1+".");
            if(input1.equals("n")||input1.equals("N")){

//              default town will be create if the user enter 'n'.
                allTown[countTown]=new FantasyTown();
                countTown++;
                countTownNumber++;
                System.out.print("---------------------");
                System.out.printf("We make you one default town, "
                        + "which is %d/%d towns!---------------------\n\n"
                        ,countTown,number1);
            }
            else{
                System.out.print("Enter the town name > ");

//              the user must enter the name instead of just enter "";
                String townName = jec.checkEnterOfString(input);
                allTown[countTown].setName(townName);

                System.out.print("Enter the town capacity > ");

//              Capacity only above 1;
                int c1 = jec.checkIntAndZero(input);
                allTown[countTown].setCapacity(c1);    
                
                System.out.println("Enter the town coordinates > ");

//              Coordinates only between 1-100 and no String is allowed to input
                System.out.print("coordinates x:");
                x1 = jec.checkDoubleBetweenZeroHundred(input);
                System.out.print("coordinates y:");
                y1 = jec.checkDoubleBetweenZeroHundred(input); 
                
                allTown[countTown].setCoordinates(x1,y1);

//              currentPeopleLive to show that the first resident is the Mayor.
                int currentPeopleLive=2;
                boolean vaild = false;
                input.nextLine();
                while(!vaild){
                    if(allTown[countTown].getNumberOfOccupants()
                            ==allTown[countTown].getCapacity()){

//                      if the people is full, that the user can not 
//                      input any people
                        vaild = true;
                    }
                    else{
                        System.out.println("Now you need to enter occupants' name. "
                        + "Enter name"+currentPeopleLive+"/"
                        + allTown[countTown].getCapacity()
                        + " (Type 'N/n' if there is 'no additional "
                        +"occupants') > ");
                        String occupantsName = jec.checkEnterOfString(input);
                        currentPeopleLive++;
                        if(occupantsName.equals("n")||occupantsName.equals("N")){
                            vaild = true;
                        }
                        else{
                            allTown[countTown].addOccupant(occupantsName);
                        }
                    }
                }
                System.out.println("Do you want to add the description for "
                +"town"+countTownNumber+"?(Y/N) > ");
                String descriptionYorN = jec.checkYorN(input);
                System.out.println("Your answer is: "+descriptionYorN+".");
                if(descriptionYorN.equals("Y")||descriptionYorN.equals("y")){
                    System.out.println("Please enter the information > ");
                    String descriptionInput = jec.checkEnterOfString(input);
                    allTown[countTown].setDescription(descriptionInput);
                }
                countTown++;
                countTownNumber++;
                System.out.print("---------------------");
                System.out.printf("You make %d/%d towns!---------------------\n\n"
                        ,countTown,number1);
            }
        }while(countTown<number1);
        
//      Show all the result that the user input.
        System.out.println("Let me show you every town's infomation now!");
        System.out.println();
        for (FantasyTown allTown1 : allTown) {
            System.out.println(allTown1.toString());
        }
        
//      Check how far and the description that the user want to input
        System.out.println("Hello, you are in the town "
                +allTown[number1-1].getName()
                +" now. How far you are willing to walk? (Enter a number!) > ");
        double distInput = jec.checkDoubleAndZero(input);
        input.nextLine();
        System.out.println("What kind of place you want to go? Please enter one "
        +"description (Press 'Enter' if you do not want to make a description) > ");
        String descInput = jec.checkOneAdjective(input);
        
//      hasDescription show the description and the town that the user want to go 
//      is same or not.
        boolean hasDescription;
        int canMoveToTown = 0;
        for(int i=0; i<number1-1;i++){
            double dist = allTown[number1-1].calculateDistanceTo(allTown[i]);
            hasDescription = allTown[i].descriptionContains(descInput);
            if((distInput>dist)&&(hasDescription)){
                
                System.out.println("You can go to town "+allTown[i].getName()
                        +". And the town is "+allTown[i].getDescription()
                        +" as you mention!");
                canMoveToTown++;
            }
        }

//          End the system if there is no same description or no town to go to
            if(canMoveToTown==0){
                System.out.println("Sorry! You have no town to go to! ");
                System.exit(0);
            }
            else{

//                  Keep asking the distance the the description about the town that 
//                  the user want to go, make a do-while loop
                    boolean stopMoveToTown=false;
                    String sayHiPerson="";
                    do{
                        System.out.println("Which town you want to go?(Enter 'N/n' " 
                                +"if you still want to stay in this town or enter "
                                +"'any town is just fine' then I will select a "
                                +"town for you!");
                        String moveToTown = jec.checkEnterOfString(input);
                        String moveToTownRandom = moveToTown.toLowerCase();

//                      if use enter 'n' then stop the loop.
                        if(moveToTown.equals("N")||moveToTown.equals("n")){
                            System.out.println("Fine, Let's stay!");
                            stopMoveToTown=true;
                        }
                        else{

//                              choose a random town for the user if they input 
//                              any town is just fine
                                if(moveToTownRandom.equals("any town is just fine"))
                                {
                                    int moveToTownRandomNum 
                                            = (int)(Math.random()*(number1-1));
                                    moveToTown 
                                            =allTown[moveToTownRandomNum].getName();
                                }
                            
                                int theTownFull = 0;
                                int theTownExist = 0;
                                for(int i=0; i<number1;i++){
                                    if(allTown[i].getName().equals(moveToTown)){

//                                      if the town is full, make the user to input
//                                      again, otherwise choose a random resdient
//                                      to say hi.
                                        if(allTown[i].isFull()){
                                            theTownFull++;
                                        }
                                        else{
                                            sayHiPerson 
                                                    =allTown[i].getRandomOccupant();
                                        }
                                    }
                                    else{
                                        theTownExist++;
                                    }
                                }

                                if(theTownFull!=0){
                                    System.out.println("The town is full! Choose "
                                            + "another town!");
                                }
                                else if(theTownExist==number1){
                                    System.out.println("The town is not in the "
                                            + "list, Please enter the correct name "
                                            + "of town!");
                                }
                                else{
                                    System.out.println("You are now in the town "
                                            +moveToTown);
                                    
                                    String sayHi = sayHiPerson+" says, 'Hello my "
                                            +"good friend. Welcome back to "
                                            +moveToTown+". Let’s have another duel "
                                            +"sometime.";
                                    System.out.println(sayHi);
                                    
                                    System.out.println("Hello, you are in the town "
                                            +moveToTown+" now. How far you are "
                                                    +"willing to walk? (Enter a "
                                                    +"number!) > ");
                                    double distAgain=jec.checkDoubleAndZero(input);
                                    input.nextLine();
                                    System.out.println("Hello again, and what kind "
                                            +"of place you want to go? Please "
                                            +"enter one description(Press 'Enter' "
                                            +"if you have already chosen 'any town "
                                            +"is just fine' or you do not want to "
                                            +"make a description) > ");
                                    descInput = jec.checkOneAdjective(input);

//                                  make a loop to show every town that the user 
//                                  can go.
                                    for (FantasyTown allTown1 : allTown) {
                                        if (allTown1.getName().equals(moveToTown)) {
                                            for (FantasyTown allTown2 : allTown) {
                                                double distKeepGoing 
                                                    = allTown1.calculateDistanceTo(allTown2);
                                                hasDescription 
                                                    = allTown2.descriptionContains(descInput);
                                                if ((distAgain>distKeepGoing)
                                                        &&(distKeepGoing>0)
                                                        &&(hasDescription)) {
                                                    System.out.println("You can go "
                                                            + "to town " 
                                                            + allTown2.getName()
                                                            + ". And the town is "
                                                        + allTown2.getDescription()
                                                            + " as you mention!");
                                                }
                                                else if(hasDescription==false){
                                                    System.out.println("Sorry, no "
                                                    +"place has that kinds of "
                                                    +"description.");
                                                    System.exit(0);
                                                }
                                            }
                                        } 
                                    }
                                }
                        }
                    }while(!stopMoveToTown);
            }
    } 
}     

    

