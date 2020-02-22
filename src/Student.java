import java.util.Scanner;
public class Student {
	Scanner y= new Scanner (System.in);
	String name;
	int roll;
	Book bk;
	Date doi;
	Date dor;
	Student(String name,int roll){
		
		this.name=name;
		this.roll=roll;
	}
	 public void issueDate(Date doi) {
	        System.out.print("Enter issue date (dd mm yyyy) : ");
	        int dd = y.nextInt(),mm = y.nextInt(), yyyy = y.nextInt();
	        doi.setDD(dd);doi.setMM(mm);doi.setYYYY(yyyy);
	    }
	 public void returnDate(Date dor) {
	        System.out.print("Enter return date (dd mm yyyy) : ");
	        int dd = y.nextInt(),mm = y.nextInt(), yyyy = y.nextInt();
	        dor.setDD(dd);dor.setMM(mm);dor.setYYYY(yyyy);
	    }

    public String getName() {
		return name;
	}
	public int getRoll() {
		return roll;
	}
	 public void display_book_list(Book bk) {
	        System.out.println("Name of bk : " + bk.getName() + " by " + bk.getAuthor().getName() + " [QTY : " + bk.getQty() + "]");
	    }

	
	public Book issueBook(Book bk, String issued_book_name, int issued_qty, Date doi) {
        if (bk.getQty() > 0 && bk.getName().equals(issued_book_name) && issued_qty <= 5 && bk.getQty() - issued_qty >= 0 && issued_qty > 0) {
            System.out.println("You have issued " + bk.getName());
            bk.setQty(bk.getQty() - issued_qty);
            issueDate(doi);
           
            return bk;
        } else if (issued_qty > 5) {
            System.out.println("You can't issue more then 5 books.");
            return null;
        } else if (bk.getQty() - issued_qty < 0) {
            System.out.println("The quantity you are wanting is not available");
            return null;
        } else if (issued_qty <= 0) {
            System.out.println("Enter a valid quantity.");
            return null;
        } else {
            System.out.println("The book doesn't exist.");
            return null;
        }
    }
	 public Book depositBook(Book bk, String returned_book_name, int returned_qty, Date doi, Date dor) {
	        if (bk.getName().equals(returned_book_name)) {
	            bk.setQty(returned_qty + bk.getQty());
	            returnDate(dor);
	            int fine = Math.abs(dor.getDD()-doi.getDD()) + Math.abs(dor.getMM()-doi.getMM())*30 + Math.abs(dor.getYYYY()-doi.getYYYY())*365;
	            if(fine > 30)
	                System.out.println("Your fine is Rs. " + (fine-30));
	            else
	                System.out.println("You don't have any fine");
	            return bk;
	        } else {
	            System.out.println("No such book exist.");
	            return null;
	        }
	    }
	
}
