/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuohsi;

/**
 * A fantasyTown is created.
 * @author burgess
 * 
 * @parameter name, description, occupant array, capacity, coordinates array
 */

public class FantasyTown {
    private String name = "A Town without a Name"; //town name
    // town's description
    private String description = "A mysterious place you’ve never been to before. ";
    private String[] occupants; // how many people in the town
    private int capacity=1; // how mant people can put in the town
    private double[] coordinates; // the position of the town

   /**
    * Default constructor of the fantasyTown.
    */
    public FantasyTown(){
        this.coordinates = new double[2];
        this.occupants = new String[1];
        this.occupants[0] = "The Mayor";
    }
    
    /**
     * A second constructor of the fantasyTown.
     * @param name, default town name or user input
     * @param capacity, default town capacity or user input
     * @param xCoor is coordinates x
     * @param yCoor is coordinates y
     */
    public FantasyTown(String name, int capacity, double xCoor, double yCoor)
    throws IllegalArgumentException{
        
        this.setName(name);
        this.setCapacity(capacity);
        
        this.occupants = new String[1];
        this.occupants[0] = "The Mayor";
        
        this.coordinates = new double[2];
        this.setCoordinates(xCoor,yCoor);
        
              
    }
    
    /**
     * Get the name of the fantasyTown.
     * @return the name of the fantasyTown.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Reset the name of the fantasyTown.
     * @param name to set the name of the fantasyTown.
     * @throws IllegalArgumentException - if name is null or empty
     */
    public void setName(String name) throws IllegalArgumentException{
        if((name!=null)&&!(name.trim().equals(""))){
            this.name=name;
        }
        else{
            throw new IllegalArgumentException("The name can not be nothing, "
                            +"please enter again > ");
        }
    }

    /**
     * Get the description of the fantasyTown.
     * @return the description of the fantasyTown.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Reset the description of the fantasyTown.
     * @param description to set the description of the fantasyTown.
     * @throws IAE - if description is null or empty
     */
    public void setDescription(String description) throws IllegalArgumentException{
        if((description != null)&&(description.equals("")==false)){
        this.description = description;
    }
    else{
            throw new IllegalArgumentException("The description can not be "
                            +"nothing, please enter again > ");
        }
    }
    
    /**
     * Add the new description of the fantasyTown.
     * @param description in order to add to the fantasyTown.
     * @throws IAE - if description is null or empty.
     */
    public void addToDescription(String description) throws IllegalArgumentException{
        if((description != null)&&(description.equals("")==false)){
        this.description = this.getDescription()+description+" ";
    }
    else{
            throw new IllegalArgumentException("The description can not be "
                            +"nothing, please enter again > ");
        }
    }

    /**
     * Get the category of people's name who live in the town.
     * @return the occupants, the array of the category of people's name who live
     * in the town.
     */
    public String[] getOccupants() {
        return occupants;
    }
    
    /**
     * Get a random occupant
     * @return String of the occupant's name.
     */
    
    public String getRandomOccupant(){
        int randomPerson = (int)(Math.random()*(this.getNumberOfOccupants()-1));
        return (this.occupants[randomPerson]);
    }
    
    /**
     * Get the number of people who live in the town.
     * @return int, the number of people who live in the town.
     */
    public int getNumberOfOccupants(){
        int count = 0;
        for (String occupant : occupants) {
            if ((occupant == null) || (occupant.equals(""))) {
            } else {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Check the person is live in the town or not. 
     * @param name of the person.
     * @return Boolean in order to check the person is live in the town or not.
     */
    public boolean hasOccupant(String name){
        boolean a = false;
        for (String occupant : occupants) {
            if (occupant != null) {
                if (occupant.equals(name)) {
                    a=true;
                }
            }
        }
        return a;
    }
    
    /**
     * Add new person to the town.
     * @param name of the person.
     * @throws IAE - if name is null or empty
     */
    public void addOccupant(String name)throws IllegalArgumentException{
        if((!"".equals(name))&&(name!=null)&&(getNumberOfOccupants()<capacity)){
            String [] newOccupant = new String [this.occupants.length+1];
            for(int i=0;i<this.occupants.length;i++){
                newOccupant[i] = this.occupants[i];
            }
            newOccupant[this.occupants.length]=name;
            this.occupants = newOccupant;
        }
        else{
            throw new IllegalArgumentException("The occupant's name can not be "
                            +"nothing, please enter again > ");
        }
    }

    /**
     * Get the capacity of the town.
     * @return int, the capacity of the town.
     */
    public int getCapacity() {
        return this.capacity;
    }
    
    /**
     * Reset the capacity of the town.
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) throws IllegalArgumentException{
        if(capacity>=1){
            this.capacity = capacity;
        }
        else{
            throw new IllegalArgumentException("Number need to be greater "
                    +"than 0 > ");
        }
    }
    
    /**capacity
     * Increase the number of the capacity.
     * @param amount of the number of the capacity.
     */
    public void increaseCapacity(int amount) {
        this.setCapacity(this.capacity + amount);
    } 
    
    /**
     * Check if the town is full of people or not.
     * @return Boolean check if the town is full of people or not.
     */
    public Boolean isFull(){
        boolean a=false;
        if(getNumberOfOccupants()==capacity){
            a=true;
        }
        return a;
    }
    
    /**
     * Get the exact coordinate of the town.
     * @return the coordinates, the array of the exact coordinate of the town.
     */
    public double[] getCoordinates() {
        return this.coordinates;
    }
    
    /**
     * Reset the exact coordinate of the town.
     * @param x for coordinates x
     * @param y for coordinates y
     * @throws IAE - if x, y are not between 1 - 100
     */
    public void setCoordinates(double x, double y) throws IllegalArgumentException{
        if((x>=0)&&(x<=100)){
            this.coordinates[0]=x;
        } 
        else{
            throw new IllegalArgumentException("The number need to be greater or " 
                    +"equals to 0, and less or equals to 100 > ");
        }
        
        if((y>=0)&&(y<=100)){
            this.coordinates[1]=y;
        }
        else{
            throw new IllegalArgumentException("The number need to be greater or " 
                    +"equals to 0, and less or equals to 100 > ");
        }
    }
    
    /**
     * About the distance of two different towns.
     * @param otherTown to calculate distance with.
     * @return double is the distance
     */
    public double calculateDistanceTo(FantasyTown otherTown){
        double[] a = otherTown.getCoordinates();
        double[] b = this.getCoordinates();
        
        double side1=a[0]-b[0];
        double side2=a[1]-b[1];
        
        double distance = Math.sqrt(side1*side1+side2*side2);
        return distance;
    }
    
    /**
     * Check the description is contained or not
     * @param kindOfPlace, part of the description  
     * @return Boolean to check the description is contained or not
     */
    public boolean descriptionContains(String kindOfPlace){
        int num = this.getDescription().indexOf(kindOfPlace);
        if(num!=-1) {
            return true;
        } else return false;
    }
    
    
    /**
     * About the description of the town.
     * @return String, description for the whole information of each town.
     */
    @Override
    public String toString(){
        double[] a = this.getCoordinates();
        String s1, s2, s3;
        s1 = String.format("Fantasytown %s is located at (%2.2f, %2.2f) "
                , this.getName(), a[0], a[1]);
        s2 = String.format("and is occupied by %d out of a possible %d people. "
                , this.getNumberOfOccupants(), this.getCapacity());
        s3 = String.format("Fantasytown %s is %s\n", this.getName()
                , this.getDescription());
        
        return s1+s2+s3;
                
    }


}
