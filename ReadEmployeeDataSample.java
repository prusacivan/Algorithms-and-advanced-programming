 // @author Ivan Prusac

package AlgoProject;

import java.io.File;
import java.util.Scanner;


public class ReadEmployeeDataSample {

	public static void main(String[] args) throws Exception{
		Employee[] employees;

		employees = new Employee[10000];
                
                Employee [] emp5000 = new Employee[5000];
                Employee [] emp1000 = new Employee[1000];
                Employee [] emp100 = new Employee[100];
                Employee [] emp10 = new Employee[10];



           Scanner sc = new Scanner(new File("C:\\Users\\lenovo\\Desktop\\Algorithms and advance programing\\Project\\employees_data.csv"));

                // this will just print the header in CSV file
                System.out.println(sc.nextLine());
                int i = 0;
                String st = "";
                while (sc.hasNextLine()) {
                    st = sc.nextLine();
                    st = st.replace("\"","");
                    String[] data = st.split(",");
                    employees[i] = new Employee(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4].charAt(0), data[5]);
                    i++;
                }
                //closes the scanner


		// We can print employee details due to overridden toString method in Employee class
		for ( i = 0; i < 20; i++){
				                    System.out.println (employees [i]);
                }

		// we can compare employees based on their first name due to overridden CompareTo method in Employee class
		System.out.println(employees[0]==employees[0]);

	long start = System.nanoTime();
	start = System.nanoTime();
        Employee.sort (employees, 0,employees.length -1 );
        long timeComp = System.nanoTime() - start;
        System.out.println ("Time complexity for 10 000 records is: " + timeComp + " nanoseconds.");

        long start2 = System.nanoTime();
        Employee.sort (employees, 0,5000 );
        long timeComp2 = System.nanoTime() - start2;
        System.out.println ("Time complexity for 5000 records is: " + timeComp2 + " nanoseconds");


	long start3 = System.nanoTime();
	Employee.sort (employees, 0,1000 );
	long timeComp3 = System.nanoTime() - start3;
        System.out.println ("Time complexity for 1000 records is: " + timeComp3 + " nanoseconds.");

        long start4 = System.nanoTime();
	Employee.sort (employees, 0,100 );
	long timeComp4 = System.nanoTime() - start4;
	System.out.println ("Time complexity for 100 records is: " + timeComp4 + " nanoseconds.");

	long start5 = System.nanoTime();
	Employee.sort (employees, 0,10 );
	long timeComp5 = System.nanoTime() - start5;
	System.out.println ("Time complexity for 100 records is: " + timeComp5 + " nanoseconds.");

        long start6 = System.nanoTime();
        Employee.linsearch(employees, "Berni");
        long timeComp6 = System.nanoTime() - start6;
        System.out.println ("Time complexity for 10000 records is: " + timeComp6 + " nanoseconds.");
        
        long start7 = System.nanoTime();
        Employee.linsearch(emp5000, "Berni");
        long timeComp7 = System.nanoTime() - start7;
        System.out.println ("Time complexity for 5000 records is: " + timeComp7 + " nanoseconds.");
         
            







		for ( i = 0; i < 20; i++){
		                    System.out.println (employees [i]);
                }




		Scanner input = new Scanner(System.in);

		Employee emp = new Employee();

		
                
		System.out.println("Please enter employers Id number");
		int empId = input.nextInt();
					input.nextLine();
		emp.setEmpNo(empId);

		System.out.println("Please enter employers birth date in dd/MM/yyyy format");
		String dob = input.nextLine();
		emp.setDateOfBirth(dob);

		System.out.println("Please enter employers first name");
		String fName = input.nextLine();
		try{
		emp.setFirstName(fName);
	    } catch (firstNameException fn){
			System.out.println(fn.getMessage());
			System.exit(0);
		}

		System.out.println("Please enter employers last name");
		String lName = input.nextLine();
		emp.setLastName (lName);

		System.out.println("Please enter employers gender");
		char gend = input.next().charAt(0);
					input.nextLine();
		emp.setGender (gend);

		System.out.println("Please enter employers hire date in dd/MM/yyyy format");
		String hDate = input.nextLine();

		emp.setHireDate (hDate);
		System.out.println(emp.toString());
	}
}
