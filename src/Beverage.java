public abstract class Beverage {
        private String name;
        private TYPE type;
        private SIZE size;
        private final double BASE_PRICE = 2.0;
        private final double SIZE_PRICE = 1.0;
        
        /** Constructors */
        public Beverage(String n, TYPE t, SIZE s) {
                name = n;
                type = t;
                size = s;
        }
                
        /** Utility */
        public abstract double calcPrice();

        public String toString() {
                return name +", " +size;
        }
        public boolean equals(Beverage bev) {
                if (name.equals(bev.getBevName()) && type==bev.getType() && size==bev.getSize()) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        /** Accessors */
        public String getBevName() {
                return name;
        }
        public TYPE getType() {
                return type;
        }
        public SIZE getSize() {
                return size;
        }
        public double getBasePrice() {
                return BASE_PRICE;
        }
        public double getSizePrice() {
                return SIZE_PRICE;
        }
        
        /** Mutators */
        public void setName(String n) {
                name = n;
        }
        public void setType(TYPE t) {
                type  = t;
        }
        public void setSize(SIZE s) {
                size = s;
        }
        
}