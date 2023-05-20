
public class Order {
    public static final int MAX_NUMBERS_ORDERED=10;

    private int qtyOrdered=0;

    private DigitalVideoDisc itemsOdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int getQtyOrdered() {
        return qtyOrdered;
    }
    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }
    public boolean addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered>=MAX_NUMBERS_ORDERED){
            if(qtyOrdered==MAX_NUMBERS_ORDERED){
                System.out.println("The order is full");
            }
            return false;
        } else {
            itemsOdered[qtyOrdered]=disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
            if(qtyOrdered==MAX_NUMBERS_ORDERED){
                System.out.println("The order is almost full");
            }
            return true;
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(var i=qtyOrdered-1;i>-1;i--){
            if(itemsOdered[i]==disc){
                qtyOrdered--;
                for(var j=i;j<qtyOrdered;j++){
                    itemsOdered[j]=itemsOdered[j+1];
                }
            }
        }
    }
    public float totalCost(){
        int cost=0;
        for(int i=0;i<qtyOrdered;i++){
            cost+=itemsOdered[i].getCost();
        }
        return cost;
    }
}
