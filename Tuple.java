/** A class for Tuples, an array of integers
 */
 public class Tuple{
     //private instance data
     private int[] tuples;
 /** A constructor that creats a Tuple of length k, with all elments set to 0
 */
     public Tuple(int k){
         this.tuples = new int[k];
         for (int i = 0; i < k; i++){
             this.tuples[i] = 0;
         }
     }
     /** A constructor that creates a Tuple from a given array
     */
     public Tuple(int[] data){
         this.tuples = new int[data.length];
         for(int i = 0; i < data.length; i++){
             this.tuples[i] = data[i];
         }
     }
     public static Tuple makeTupleFromData (int[] data){
       return new Tuple(data);
     }
     /** Creates and returns a new Tuple that is a copy of this Tuple
     */
     public Tuple clone(){
       Tuple cloneTuple = new Tuple(this.length());
       for(int i = 0; i < this.length(); i++){
         cloneTuple.setElement(i, this.getElement(i));
       }
       return cloneTuple;
     }
     /** Returns the length of the Tuple
     */
     public int length(){
         return this.tuples.length;
     }
     /** Returns the element at index i
     */
     public int getElement(int i){
         if (i > this.length() - 1){
               throw new IllegalArgumentException();
         }
         return this.tuples[i];
     }
     /** Sets the element at index i to the give value
     */
     public void setElement(int i, int value){
         if(i > this.length() - 1){
             throw new IllegalArgumentException();
         }
         this.tuples[i] = value;
     }
     /** Adds each element of the tuples
     */
     public Tuple add(Tuple t){
         if(this.length() != t.length()){
             throw new IllegalArgumentException();
         }
         Tuple tempTuple = new Tuple(this.length());
         int elementsAdded;
         for(int i = 0; i < t.length(); i++){
             elementsAdded = this.getElement(i) + t.getElement(i);
             tempTuple.setElement(i, elementsAdded);
         }
         return tempTuple;
     }
     /** Returns a stringy version of the Tuple
     */
     public String toString(){
       String tupleString = "[";
       for(int i = 0; i < this.length(); i++){

         tupleString += (this.getElement(i));
         if(i < this.length() - 1){
           tupleString += ",";
         }
       }
       tupleString += "]";
       return tupleString;
     }
     /** Returns the sum of all the elements in a Tuple
     */
     public int sum(){
       int x = 0;
       for(int i = 0; i < this.length(); i++){
         x += this.getElement(i);
       }
       return x;
     }
     /** Returns true if the given Object is a Tuple that has the same length
         and elements as this Tuple
         */
     public boolean equals(Object obj){
       if(!(obj instanceof Tuple) || (obj == null) ){
         return false;
       }else{
         Tuple objTuple = (Tuple) obj;
         if(!(this.length() == objTuple.length())){
           return false;
         }else{
           for(int i = 0; i < this.length(); i++){
             if(objTuple.getElement(i) != this.getElement(i)){
               return false;
             }
           }
         }
       }
       return true;
     }

     

 /** A comprehensive set of tests for the Tuple class */
     public static void main (String[] args){
       /** TESTS
       int[] testArray = {0, 1, 2};
       Tuple testTuple1 = new Tuple(3);
       Tuple testTuple2 = new Tuple(3);

       for(int i = 0; i < 3; i++){
         testTuple1.setElement(i, i);
         testTuple2.setElement(i, i - 1);
       }
       Tuple testTuple3 = new Tuple(testArray);
       Tuple testTuple4 = testTuple3.clone();


       System.out.println("Test for toString");
       System.out.println(testTuple1.toString());
       System.out.println(testTuple2.toString());
       System.out.println(testTuple3.toString());

       System.out.println("Test for clone");
       System.out.println(testTuple3.equals(testTuple4));

       System.out.println("Test for length");
       System.out.println(testTuple1.length() == 3);

       System.out.println("Test for getElement");
       System.out.println(testTuple1.getElement(0) == 0);
       System.out.println(testTuple1.getElement(1) == 1);
       System.out.println(testTuple1.getElement(2) == 2);
       System.out.println(!(testTuple2.getElement(0) == 0));
       System.out.println(!(testTuple2.getElement(1) == 1));
       System.out.println(!(testTuple2.getElement(2) == 2));

       System.out.println("Test for add");
       Tuple testTuple5 = testTuple1.add(testTuple3);
       int[] testArray2 = {0, 2, 4};
       Tuple testTuple6 = new Tuple(testArray2);
       System.out.println(testTuple6.equals(testTuple5));

       System.out.println("Test for makeTupleFromData");
       System.out.println(testTuple1.equals(makeTupleFromData(testArray)));

       System.out.println("Test for sum");
       System.out.println(testTuple1.sum() == 3);
       System.out.println(testTuple2.sum() == 0);

       System.out.println("Test for equals");
       System.out.println(!testTuple1.equals(testTuple2));
       System.out.println(testTuple1.equals(testTuple3));

       System.out.println("Test for setElement");
       testTuple1.setElement(0, 2);
       testTuple1.setElement(1, 3);
       testTuple1.setElement(2, 4);
       System.out.println(testTuple1.getElement(0) == 2);
       System.out.println(testTuple1.getElement(1) == 3);
       System.out.println(testTuple1.getElement(2) == 4);
       System.out.println(!(testTuple1.getElement(0) == 0));
       System.out.println(!(testTuple1.getElement(1) == 1));
       System.out.println(!(testTuple1.getElement(2) == 2));
       */

     }

 }
