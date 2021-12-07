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
public class Coffee extends Beverage{
        private boolean extraShot;
        private boolean extraSyrup;
        private final double SHOT_COST = .5;
        private final double SYRUP_COST = .5;
        
        /** Constructors */
        public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
                super(n, TYPE.COFFEE, s);
                extraShot = shot;
                extraSyrup = syrup;
        }
        
        /** Utility */
        public String toString() {
                String s = getBevName() +", " +getSize();
                
                while (extraShot) {
                        s += " Extra shot";
                }
                while (extraSyrup) {
                        s += " Extra syrup";
                }
                
                s += ", $" +calcPrice();
                
                return s;
        }
        public double calcPrice() {
                double price = super.getBasePrice();
                
                if (SIZE.MEDIUM == super.getSize()) {
                        price += super.getSizePrice();
                }
                else if (SIZE.LARGE == super.getSize() ) {
                        price += 2 * super.getSizePrice();
                }
                
                while (extraShot) {
                        price += SHOT_COST;
                }
                while (extraSyrup) {
                        price += SYRUP_COST;
                }
                
                return price;
        }
        public boolean equals(Coffee c) {
                if (super.equals(c) && c.getExtraShot() == extraShot && c.getExtraSyrup() == extraSyrup) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        /** Accessors */
        public boolean getExtraShot() {
                return extraShot;
        }
        public boolean getExtraSyrup() {
                return extraSyrup;
        }
        public double getShotCost() {
                return SHOT_COST;
        }
        public double getSyrupCost() {
                return SYRUP_COST;
        }
        
        /** Mutators */
        public void setExtraShot(boolean shot) {
                extraShot = shot;
        }
        public void setExtraSyrup(boolean syrup) {
                extraSyrup = syrup;
        }
}