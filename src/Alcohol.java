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

public class Alcohol extends Beverage{
        private boolean isWeekend;
        private final double WEEKEND_FEE = .6;
        
        /** Constructors */
        public Alcohol(String n, SIZE s, boolean iw) {
                super(n, TYPE.ALCOHOL, s);
                isWeekend = iw;
        }
        
        /** Utility */
        public String toString() {
                String s = getBevName() +", " +getSize();
                
                while (isWeekend) {
                        s += " Weekend";
                }
                
                s += ", $" +calcPrice();
                
                return s;
        }
        public double calcPrice() {
            double price = super.getBasePrice();
            
            if (super.getSize() == SIZE.MEDIUM) {
                    price += super.getSizePrice();
            }
            else if (super.getSize() == SIZE.LARGE) {
                    price += 2 * super.getSizePrice();
            }
            
            if (isWeekend) {
                    price += WEEKEND_FEE;
            }
            
            return price; 
        }
        public boolean equals(Alcohol a) {
                if (super.equals(a) && a.getIsWeekend() == isWeekend) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        /** Mutators */ 
        public void setIsWeekend(boolean is) {
                isWeekend = is;
        }
        /** Accessors */
        public boolean getIsWeekend() {
                return isWeekend;
        }
        public double getWeekendFee() {
                return WEEKEND_FEE;
        }
       
}