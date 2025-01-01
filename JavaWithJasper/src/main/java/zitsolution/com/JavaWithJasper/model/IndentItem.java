package zitsolution.com.JavaWithJasper.model;



public class IndentItem {
    private int sl;
    private String itemName;
    private String uom;
    private int qty;
    private int price;
    private int totalAmount;
    private String remarks;

    // No-argument constructor
    public IndentItem() {}

    // Constructor with arguments
    public IndentItem(int sl, String itemName, String itemNameBn, String uom, int qty, int price, int totalAmount, String remarks) {
        this.sl = sl;
        this.itemName = itemName;
        this.uom = uom;
        this.qty = qty;
        this.price = price;
        this.totalAmount = totalAmount;
        this.remarks = remarks;
    }

    // Getters and Setters
    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
