
public class CalculatorFunctions {
	
	private int total = 0;
	
	public String getTotalString() {
        return "" + total;
    }
    
    public void setTotal(String number) {
        total = Integer.parseInt(number);
    }
    
    public void add(String number) {
        total = total + Integer.parseInt(number);
    }
    
    public void subtract(String number) {
        total = total - Integer.parseInt(number);
    }
    
    public void multiply(String number) {
        total = total * Integer.parseInt(number);
    }
    
    public void divide(String number) {
        total = total / Integer.parseInt(number);
    }


}
