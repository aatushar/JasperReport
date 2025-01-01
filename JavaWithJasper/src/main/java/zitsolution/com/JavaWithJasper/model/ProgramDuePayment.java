package zitsolution.com.JavaWithJasper.model;

public class ProgramDuePayment {
    private int sl;
    private String programName;
    private String customerName;
    private String phone;
    private String programDate;
    private String time;
    private int guests;
    private double totalAmount;
    private double paidAmount;
    private double dueAmount;

    // No-argument constructor
    public ProgramDuePayment() {}

    // Constructor
    public ProgramDuePayment(int sl, String programName, String customerName, String phone,
                             String programDate, String time, int guests,
                             double totalAmount, double paidAmount, double dueAmount) {
        this.sl = sl;
        this.programName = programName;
        this.customerName = customerName;
        this.phone = phone;
        this.programDate = programDate;
        this.time = time;
        this.guests = guests;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
    }

    // Getters and Setters
    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProgramDate() {
        return programDate;
    }

    public void setProgramDate(String programDate) {
        this.programDate = programDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }
}