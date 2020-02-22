import java.util.Scanner;
public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner y= new Scanner (System.in);
		Book b[]=new Book[3];
		Author author[]= new Author[3];
		Author a1=new Author("J.K. Rolling","email",'F');
		Book   b1= new Book("Harry_Potter",a1,190,90);
		b[0]=b1;author[0]=a1;
		Author a2=new Author("H.C. Verma","email",'M');
		Book   b2= new Book("Concept_of_Physics",a2,100,100);
		b[1]=b2;author[1]=a2;
		Author a3=new Author("D.C Pandey","email",'M');
		Book   b3= new Book("Understanding_Physics",a3,100,100);
		b[2]=b3;author[2]=a3;
		int n=b.length;

		System.out.println("Enter number of students : ");
        int num = y.nextInt();
        Student[] s = new Student[num];
        Date[] doi = new Date[num];
        Date[] dor = new Date[num];
        for (int i = 0; i < num; i++) {
            doi[i] = new Date();
            dor[i] = new Date();
            System.out.print("Enter student name and roll of student " + (i + 1) + " : ");
            String name = y.next();int roll = y.nextInt();
            s[i] = new Student(name, roll);
            System.out.print("Do you want to issue or deposit book . (ENTER 1 for issue & 2 FOR DEPOSIT) : " );
            int choice = y.nextInt();
            if(choice == 1) {
                System.out.println("These books are present : ");
                for (int j = 0; j < n; j++)
                    if(b[j].getQty() >0)
                        s[i].display_book_list(b[j]);
                System.out.print("Enter the name of book and quantity : ");
                String issued_book_name = y.next();
                int issued_qty = y.nextInt();
                int flag = 0;
                for (int k = 0; k < n; k++) {
                    if (issued_book_name.equals(b[k].getName())) {
                        b[k] = s[i].issueBook(b[k], issued_book_name, issued_qty,doi[i]);
                        flag= 1;
                    }
                }
                System.out.println("These books are left");
                for (int j = 0; j < n; j++)
                { if(b[j].getQty() >0)
                        s[i].display_book_list(b[j]);
                }

                if(flag == 0)
                    System.out.println("You have entered a book name which is not present in library");
                System.out.println("\n");
            }

            else if(choice == 2 ) {
                int flag = 0;
                for (int j = 0; j < n; j++)
                    if(b[j].getQty() >0)
                        s[i].display_book_list(b[j]);
                System.out.print("Enter the name of book and quantity : ");
                String returned_book_name = y.next();int returned_qty = y.nextInt();
                for (int k = 0; k < n; k++) {
                    if (b[k].getName().equals(returned_book_name)) {
                        for (int l = 0;l < i;l++) {
                            if (s[i].getRoll() == s[l].getRoll() && s[i].getName().equals(s[l].getName())) {
                                b[k] = s[i].depositBook(b[k], returned_book_name, returned_qty, doi[l], dor[l]);
                                System.out.println(b[k].toString());
                                flag = 1;
                            }
                        }
                    }
                }
                if(flag == 0)
                    System.out.println("You have entered a book name  which is never present in library \"OR\" you have never issued a book and you are trying to return a book... ");
                System.out.println("\n");
            }
            else System.out.println("Enter a valid choice (1 or 2) next time \"OR\" you have never issued a book and you are trying to return a book...");

        }
    }

		

	}


