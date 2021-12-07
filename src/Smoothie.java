/*
 Program: Assignment 6
 Class: CMSC 203, CRN 22297
 Instructor: Grigoriy Grinberg
 Summary of Description: The BevShop offers 3 types of beverages: Coffee, Alcoholic and Smoothie. 
  Beverages can be ordered in 3 different sizes: Small, medium and large. All the beverage types have 
  a base price. In addition there are additional charges depending on the size and specific add-ons for 
  each type of beverage.
 Due Date: 06DEC2021
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student: Daniel Cortes Gratacos
*/
public class Smoothie extends Beverage{
		private final double FRUIT_COST = .5;
        private int numOfFruits;
        private boolean addProtein;
        private final double PROTEIN_COST = 1.5;
        
        /** Constructors */
        public Smoothie(String n, SIZE s, int nof, boolean ap) {
                super(n, TYPE.SMOOTHIE, s);
                numOfFruits = nof;
                addProtein = ap;
        }
        
        /** Utility */
        public String toString() {
                String s = getBevName() +" " +numOfFruits +", " +getSize() +" Fruits";
                
                while (addProtein) {
                        s += " Protein powder";
                }
                
                s += ", $" +calcPrice();
                
                return s;
        }
        public boolean equals(Smoothie s) {
                if (super.equals(s) && s.getNumOfFruits() == numOfFruits && s.getAddProtien() == addProtein) {
                        return true;
                }
                else {
                        return false;
                }
        }
        public double calcPrice() {
                double price = super.getBasePrice();
                
                if (SIZE.MEDIUM == super.getSize()) {
                        price += super.getSizePrice();
                }
                else if (SIZE.LARGE == super.getSize()) {
                        price += 2 * super.getSizePrice();
                }
                
                price += numOfFruits * FRUIT_COST;
                while (addProtein) {
                        price += PROTEIN_COST;
                }
                
                return price;
        }
        
        /** Accessors */
        public boolean getAddProtien() {
            return addProtein;
        }
        public int getNumOfFruits() {
                return numOfFruits;
        }
        public double getFruitCost() {
                return FRUIT_COST;
        }
        public double getProteinCost() {
                return PROTEIN_COST;
        }
        
        /** Mutators */
        public void setProteinPowder(boolean ap) {
            addProtein = ap;
        }
        public void setNumOfFruits(int nof) {
                numOfFruits = nof;
        }
}