/****************************

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
 *
 * @author burge
 */
public class TestFantasyTown {
    
    public static void main(String[] args){
        
        FantasyTown allTown[] = new FantasyTown[10];
        
        
        allTown[0]= new FantasyTown();
        allTown[0].setCapacity(2);
        allTown[0].addOccupant("Peter");
        allTown[0].setDescription("water air!");
        allTown[0].setCoordinates(10,20);
        boolean aa = allTown[0].descriptionContains("r!");
        System.out.println(allTown[0].toString());
        
    } 
    
}
