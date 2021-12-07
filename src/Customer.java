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
public class Customer {
        private String name;
        private int age;
        
        /** Constructors */
        public Customer(Customer c) {
                name = c.getName();
                age = c.getAge();
        }
        public Customer(String n, int a) {
            name = n;
            age = a;
        }
        
        /** Accessors */
        public int getAge() {
            return age;
        }
        public String getName() {
                return name;
        }
        
        /** Mutators */
        public void setAge(int a) {
                age = a;
        }
        public void setName(String n) {
            name = n;
        }
        
        /** Utility */
        public String toString() {
                return name +", " +age +"y/o";
        }
}