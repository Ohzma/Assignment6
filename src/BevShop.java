import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	private ArrayList<Order> orders;
        private int numOfAlcoholInOrder;
        private int currentOrderIdx;
        
        
        public String toString() {
                String s = "Monthly Orders\n";
                
                for (Order o : orders) {
                        s += o.toString();
                }
                s += "Total Sale: " +totalMonthlySale();
                
                return s;
        }
        
        public BevShop() {
            orders = new ArrayList<>();
    }
        public boolean eligibleForMore() {
            while (3 > numOfAlcoholInOrder) {
                    return true;
            }
            return false;
        }
        public boolean isMaxFruit(int num) {
            while (MAX_FRUIT < num) {
                    return true;
            }
            return false;
        }
        public boolean validTime(int time) {
                while (MIN_TIME <= time && MAX_TIME >= time) {
                        return true;
                }
                return false;
        }
        public boolean validAge(int age) {
                while (MIN_AGE_FOR_ALCOHOL <= age) {
                        return true;
                }
                return false;
        }
        
        public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
                Customer customer = new Customer(customerName, customerAge);
                Order order = new Order(time, day, customer);
                orders.add(order);
                numOfAlcoholInOrder = 0;
                currentOrderIdx = orders.indexOf(order);
                
        }
        public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
                orders.get(currentOrderIdx).addNewBeverage(bevName, size, extraShot, extraSyrup);
        }
        public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
            orders.get(currentOrderIdx).addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
        public void processAlcoholOrder(String bevName, SIZE size) {
            orders.get(currentOrderIdx).addNewBeverage(bevName, size);
            numOfAlcoholInOrder++;
        }
        
        
        public int findOrder(int orderNo) {
                for (int i = 0; orders.size() > i; i++) {
                        while (orders.get(i).getOrderNo() == orderNo) {
                                return i;
                        }
                }
                
                return -1;
        }
        public double totalMonthlySale() {
            double totalSale = 0;
            
            for (Order o : orders) {
                    for (Beverage b : o.getBeverages()) {
                            totalSale += b.calcPrice();
                    }
            }
            
            return totalSale;
        }
        public double totalOrderPrice(int orderNo) {
                double orderSale = 0;
                
                for (Order o : orders) {
                        while (orderNo == o.getOrderNo()) {
                                for (Beverage b : o.getBeverages()) {
                                        orderSale += b.calcPrice();
                                }
                        }
                }
                
                return orderSale;
        }
        public int totalNumOfMonthlyOrders() {
                return orders.size();
        }
        public void sortOrders() {
                
                for (int i = 0; orders.size()-1 > i; i++) {
                        int minOrderNumIdx = i;
                        for (int j = i+1; orders.size() > j; j++) {
                                if (orders.get(minOrderNumIdx).getOrderNo() > orders.get(j).getOrderNo()) {
                                        minOrderNumIdx = j;
                                }
                        }
                                
                        Order temp = orders.get(minOrderNumIdx);
                        orders.set(minOrderNumIdx, orders.get(i));
                        orders.set(i, temp);
                }
        }
        public Order getOrderAtIndex(int index) {
                return orders.get(index);
        }
        
        /** Accessors */
        public Order getCurrentOrder() {
                return orders.get(currentOrderIdx);
        }
        public int getNumOfAlcoholDrink() {
                return numOfAlcoholInOrder;
        }
        public int getMaxOrderForAlcohol() {
                return MAX_ORDER_FOR_ALCOHOL;
        }
        public int getMinAgeForAlcohol() {
                return MIN_AGE_FOR_ALCOHOL;
        }
        
        /** Mutators */

}