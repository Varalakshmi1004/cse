public class Book
{
	private String name;
	private String author;
	private double price;
	private int qtyInStock;
	Book(String name,String author,double price,int qtyInStock)
	{
		this.name=name;
		this.author=author;
		this.price=price;
		this.qtyInStock=qtyInStock;
	}
	public String getName()
	{
		return name;
	}
	public int getQuantity()
	{
		return qtyInStock;
	}
	public double getPrice()
	{
		return price;
	}
	public void setQuantity(int quantity)
	{
		qtyInStock=quantity;
	}
	public String bookDetails()
	{
		return "Book name="+name+"  author="+author+"  price="+price+"  qtyInStock="+qtyInStock;
	}
}

