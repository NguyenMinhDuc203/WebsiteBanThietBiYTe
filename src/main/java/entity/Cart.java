package entity;

public class Cart {
	private int id;
	private int accountID;
	private int productID;
	private int amount;
	private double price;
	private String pname;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", accountID=" + accountID + ", productID=" + productID + ", amount=" + amount
				+ ", price=" + price + ", pname=" + pname + ", image=" + image + "]";
	}
	public Cart(int id, int accountID, int productID, int amount, double price, String pname, String image) {
		super();
		this.id = id;
		this.accountID = accountID;
		this.productID = productID;
		this.amount = amount;
		this.price = price;
		this.pname = pname;
		this.image = image;
	}
	public Cart() {
		super();
	}
	
	
	
	

}
