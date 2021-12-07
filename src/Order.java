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
import java.util.ArrayList;
import java.util.Random;

// OrderInterface isWeekend Issue
public class Order implements OrderInterface, Comparable<Order> {
		private Customer customer;
        private int orderNo;
        private DAY orderDay;
        private int orderTime;
        private ArrayList<Beverage> beverages;
        
        /** Constructors */
        public Order(int ot, DAY od, Customer c) {
        		beverages = new ArrayList<>();
                orderTime = ot;
                orderDay = od;
                customer = c;
                orderNo = genOrderNum();
                
        }
        
        /** Utility */
        public String toString() {
            String s = "__________________________________"
                               +orderDay.toString() +"\n" +customer.toString()
                               +", " +orderTime +" Order Num: " +orderNo;
            
            for (Beverage b : beverages) {
                    s += "\n" +b.toString();
            }
            s += "\n Order Total: " +calcOrderTotal();
            
            return s;
        }
        public int genOrderNum() {
                Random rand = new Random();
                // [10_000, 90_000)
                int randInt = rand.nextInt(90_000-10_000)+10_000;
                return randInt;
        }
        public boolean isWeekend() {
                while (DAY.SATURDAY == orderDay || DAY.SUNDAY == orderDay) {
                        return true;
                }
                return false;
        }
        public int getTotalItems() {
            return beverages.size();
        }
        public Beverage getBeverage(int itemNum) {
                return beverages.get(itemNum);
        }
        public int compareTo(Order o) {
                if (orderNo == o.getOrderNo()) {
                        return 0;
                }
                else if (o.getOrderNo() < orderNo) {
                        return 1;
                }
                else {
                        return -1;
                }
        }
        public int findNumOfBeveType(TYPE type) {
            int count = 0;
            
            for (Beverage b : beverages) {
                    while (type == b.getType()) {
                            count++;
                    }
            }
            
            return count;
        }
        public double calcOrderTotal() {
                double orderTotal = 0;
                
                for (Beverage b : beverages) {
                        orderTotal += b.calcPrice();
                }
                
                return orderTotal;
        }
        
        /** Add Beverages */
        public void addNewBeverage(String name, SIZE size) {
            boolean isWeekend = false;
            while (DAY.SATURDAY == orderDay || DAY.SUNDAY == orderDay) {
                    isWeekend = true;
            }
            Alcohol a = new Alcohol(name, size, isWeekend);
            beverages.add(a);
        }
        public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean proteinPowder) {
            Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);
            beverages.add(s);
        }
        public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
                Coffee c = new Coffee(name, size, extraShot, extraSyrup);
                beverages.add(c);
        }
        
        /** Accessors */
        public DAY getOrderDay() {
            return orderDay;
        }
        public Customer getCustomer() {
            return new Customer(customer);
        }
        public int getOrderNo() {
                return orderNo;
        }
        public int getOrderTime() {
                return orderTime;
        }
        public ArrayList<Beverage> getBeverages() {
                return beverages;
        }
        
        /** Mutators */
        public void setOrderDay(DAY od) {
            orderDay = od;
        }
        public void setCustomer(Customer c) {
            customer = c;
        }
        public void setOrderNum(int on) {
                orderNo = on;
        }
        public void setOrderTime(int ot) {
                orderTime = ot;
        }
}