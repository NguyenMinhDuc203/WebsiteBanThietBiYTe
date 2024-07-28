package entity;

public class Product {
	private int id;
	private String name;
	private String image;
	private double price;
	private String title;
	private String description;
	private int cateID;
	private int sell_ID;
	
	
	public Product(int id, String name, String image, double price, String title, String description, int cateID,
			int sell_ID) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.title = title;
		this.description = description;
		this.cateID = cateID;
		this.sell_ID = sell_ID;
	}

	public Product(String name, String image, double price, String title, String description, int cateID, int sell_ID) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.title = title;
		this.description = description;
		this.cateID = cateID;
		this.sell_ID = sell_ID;
	}

	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public int getSell_ID() {
		return sell_ID;
	}
	public void setSell_ID(int sell_ID) {
		this.sell_ID = sell_ID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product(int id, String name, String image, double price, String title) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.title = title;
		
	}
	public Product() {
		super();
	}
	
	public Product(int id, String name, String image, double price, String title, String description) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.title = title;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title
				+ ", description=" + description + "]";
	}
	
	
	

}
