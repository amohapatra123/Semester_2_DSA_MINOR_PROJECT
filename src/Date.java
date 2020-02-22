import java.util.*;
public class Date {
	Scanner y= new Scanner (System.in);
	

	int dd;
	int mm;
	int yyyy;
	
	

	public int getDD() {
		return dd;
	}
    public int getMM() {
       return mm ;
    }
    public int getYYYY() {
    	return yyyy;
    }
    public void setDD(int dd) {
    	this.dd=dd;
    }
    public void setMM(int mm) {
    	this.mm=mm;
    }
    public void setYYYY(int yyyy) {
    	this.yyyy=yyyy;
    }
    public String toString() {
    	return getDD()+"-"+getMM()+"-"+getYYYY();
    }
    
    
    
}
