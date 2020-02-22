
public class Book  extends Author{
	private String name;
	private double price;
	private int qty;
	private Author author;
	


	Book(String name,Author author,double price ,int qty){
		super("name","email",'m');
		this.author=author;
		this.name=name;
		this.price=price;
		this.qty=qty;
	}
	public String  getName() {
		return name;
	}
	public Author getAuthor() {
		return author;
	}
	public double getPrice() {
		return price;
	}
	public int  getQty() {
		return qty;
	}
	public void setPrice(double price){
		this.price=price;
		
	}
	public void setQty(int qty) {
		this.qty=qty;
	}
	public String toString() {
		return "Book [name :"+getName()+" ,"+author.toString()+" ,price: "+getPrice()+" ,qty: "+getQty()+"]";
	}

	

}
