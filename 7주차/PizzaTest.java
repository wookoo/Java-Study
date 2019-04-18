class Circle{
	private double radius;
	private String color;
	

	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}
	public Circle(double radius) {
		this.radius = radius;
		this.color = "red";
	}
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getArea() {
		return this.radius *this.radius * 3.14;
	}
	public String toString() {
		
		return String.format("Circle[radius=%.3f,color=%s]", this.radius,this.color);
		
	}
		
}

class Pizza extends Circle{
	private String type;
	private int price;
	public Pizza() {
		
	}
	public Pizza(String type,int price,double radius) {
		super(radius);
		this.type = type;
		this.price = price;
	}
	
	public void print(){
		System.out.println(String.format("Price = %d$, Type = %s, Radius = %.2f, Area = %.2f", this.price,this.type,this.getRadius(),this.getArea()));
	}
	public String getType() {
		return this.type;
	}
}


public class PizzaTest {
	
	public static void main(String[] args) {
		Pizza combination = new Pizza("콤비네이션",30,20);
		Pizza potato = new Pizza("포테이토",10,5);
		Pizza nonePizza = new Pizza();
		combination.print();
		potato.print();
		nonePizza.print();
		Pizza bigger = Bigger(combination,potato);
		System.out.println(String.format("%s 피자가 더 큽니다. 반지름 : = %.2f", bigger.getType(), bigger.getRadius()));
	}
	
	public static  Pizza Bigger(Pizza p1, Pizza p2) {
		return (p1.getRadius()> p2.getRadius() ? p1 : p2);
		
	}
	
	
	

}
