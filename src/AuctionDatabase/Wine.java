package AuctionDatabase;

public class Wine {
	private int year;
	private TypeOfWine type;	
	private String name;
	private double startingPrice;
	private int servingTemperature;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public TypeOfWine getType() {
		return type;
	}
	@Override
	public String toString() {
		return "Wine [year=" + year + ", type=" + type + ", name=" + name + ", price=" + startingPrice + ", servingTemperature="
				+ servingTemperature + "]";
	}
	public void setType(TypeOfWine type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return startingPrice;
	}
	public void setPrice(double price) {
		this.startingPrice = price;
	}
	public int getServingTemperature() {
		return servingTemperature;
	}
	public void setServingTemperature(int servingTemperature) {
		this.servingTemperature = servingTemperature;
	}
	public Wine(int year, TypeOfWine type, String name, double price, int servingTemperature) {
		super();
		this.year = year;
		this.type = type;
		this.name = name;
		this.startingPrice = price;
		this.servingTemperature = servingTemperature;
	}
	

}
