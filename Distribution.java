import java.util.ArrayList;

public class Distribution {
	private final static int MAX = 500;
	
	private class Element{
		private String name;
		private int amount = 0;
		private int price, maxAmount;
		
		public Element(String name, int price){
			this.name = name;
			this.price = price;
			this.maxAmount = MAX/price;
		}
		
		public void increment(){
			amount = amount + 1;
			if (amount > maxAmount) amount = 0;
		}
		
	}
	
	private ArrayList<Element> elements = new ArrayList<Element>();
	
	public void add(String name, int price){
		Element e = new Element(name, price);
		elements.add(e);
	}
	
	public boolean isValidSolution(){
		int sum = 0;
		for (Element e : elements){
			sum += e.amount * e.price;
		}
		return sum == MAX;
	}
	
	public boolean atMaxIteration(){
		for(Element e : elements){
			if (e.amount < e.maxAmount){
				return false;
			}
		}
		return true;
	}
	
	public void increment(int i){
		if (i < 0) return;
		elements.get(i).increment();
		if(elements.get(i).amount == 0) increment(i - 1);
	}
	
	public void increment(){
		increment(elements.size() - 1);
	}
	
	public String toString(){
		String s = "";
		
		boolean moreThanOne = false;
		
		for(Element e : elements){
			if(e.amount > 0){
				if(moreThanOne) s += ", "; 
				moreThanOne = true;
				
				s += e.amount + " ";
				s += e.name;
				if(e.amount > 1) s += "s";
			}
		}
		return s;
	}
	
	public void print(){
		System.out.println(this.toString());
	}
	
	public void solve(){
		while(true){
			if(isValidSolution()) print(); 
			if(atMaxIteration()){
				return;
			}
			else{
				increment();
			}
		}
	}
}
