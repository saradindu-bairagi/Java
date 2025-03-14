package oops.pp3;

class Mart {
    public static String [] itemNameArr= {"Chocolate","Perfume","Bouquet","Apparel"};
    public static float [] itemPriceArr= {200.0f,400.0f,150.0f,300.0f};
    public static int [] itemQuantityArr= {10,20,30,40};

    public float findPricePerItem(String itemName) {
        float priceItem = -1.0f;
        for(int index=0; index<Mart.itemNameArr.length;index++) {
            if(itemName.equals(Mart.itemNameArr[index])) {
                priceItem=Mart.itemPriceArr[index];
            }
        }
        return priceItem;
    }
}

class OnlineMart extends Mart{
    private int onlineDiscountPercentage;
    private Order order;

    public OnlineMart(Order order){
        this.order=order;
    }

    public Order getOrder(){
        return this.order;
    }

    public void identifyOnlineDiscount() {
        if (this.order.getPaymentMode().equals("Prepaid")){
            this.onlineDiscountPercentage=5;
        }else if (this.order.getPaymentMode().equals("COD")) {
            this.onlineDiscountPercentage=2;
        }
        else {
            this.onlineDiscountPercentage=-1;
        }
    }

    //To_Trainee
    @Override
    public float findPricePerItem(String itemName) {
        float pricePerItem = 0.0f;

        //write your code here
        float unitPrice = super.findPricePerItem(itemName);
        if(unitPrice==-1.0f)
        {
            pricePerItem=-1.0f;
        }
        else
        {
            identifyOnlineDiscount();
            if(onlineDiscountPercentage==-1)
            {
                pricePerItem=-1.0f;
            }
            else
            {
                float discount = (unitPrice*onlineDiscountPercentage)/100;
                pricePerItem=unitPrice-discount;
            }
        }
        return pricePerItem;
    }

    @Override
    public String toString() {
        return "OnlineMart (Order ( itemName=" + this.order.getItemName()
                + ", quantityRequired=" + this.order.getQuantityRequired() + ", paymentMode="
                + this.order.getPaymentMode() + "))";
    }

    //To_Trainee
    public int checkItemAvailability() {
        //write your code here
        String itemName = order.getItemName();
        int quantityRequired = order.getQuantityRequired();
        for(int i=0;i<Mart.itemNameArr.length;i++)
        {
            if(itemName.equals(Mart.itemNameArr[i]))
            {
                if(quantityRequired<=itemQuantityArr[i])
                {
                    Mart.itemQuantityArr[i] -= quantityRequired;
                    return quantityRequired;
                }
            }
        }
        //change return statement accordingly
        return -1;
    }

    //To_Trainee
    public void shipOrder() {

        //write your code here
        int quantity = checkItemAvailability();
        float pricePerItem = findPricePerItem(order.getItemName());
        if(quantity==-1 || findPricePerItem(order.getItemName())==-1.0f)
        {
            order.setOrderPrice(-1.0);
            order.setTrackingId("NA");
        }
        else
        {
            order.setOrderPrice(quantity*pricePerItem);
            order.generateTrackingId();
        }

    }
}

class Order{
    private static int counter=1000;
    private String trackingId;
    private String itemName;
    private int quantityRequired;
    private String paymentMode;
    private double orderPrice;

    public Order(String itemName, int quantityRequired, String paymentMode){
        this.itemName = itemName;
        this.quantityRequired = quantityRequired;
        this.paymentMode = paymentMode;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getTrackingId() {
        return this.trackingId;
    }
    public String getItemName(){
        return this.itemName;
    }
    public int getQuantityRequired(){
        return this.quantityRequired;
    }

    @Override
    public String toString() {
        return "Order (trackingId=" + this.trackingId + ", itemName=" + this.itemName
                + ", quantityRequired=" + this.quantityRequired + ", paymentMode="
                + this.paymentMode + ", orderPrice=" + this.orderPrice + ")";
    }

    public String getPaymentMode(){
        return this.paymentMode;
    }

    public double getOrderPrice(){
        return this.orderPrice;
    }
    public void setOrderPrice(double orderPrice){
        this.orderPrice=orderPrice;
    }

    //To_Trainee
    public void generateTrackingId(){
        //write your code here
        setTrackingId("TR"+counter++);
    }
}

class Tester {
    public static void main(String[] args) {
        Order orderObj = new Order("Bouquet", 20, "Prepaid");
        OnlineMart onlineMartObject = new OnlineMart(orderObj);
        onlineMartObject.shipOrder();
        System.out.println("Tracking ID :" + onlineMartObject.getOrder().getTrackingId());
        System.out.println("Order Price :" + onlineMartObject.getOrder().getOrderPrice());
    }
}