 // @author Ivan Prusac

package AlgoProject;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;
/**
 *
 * @author lenovo
 */
class Employee implements Comparable<Object>{

	private int empNo;
	private String dateOfBirth;
	private String firstName;
	private String lastName;
	private char gender;
	private String hireDate;

	// constructor
	public Employee (){
	}

	public Employee(int empNo, String dateOfBirth, String firstName, String lastName, char gender, String hireDate)
	{
		this.empNo = empNo;
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) throws ParseException {
             Date convert = new SimpleDateFormat ("dd/MM/yyyy").parse(dateOfBirth);
             Date retirement = new Date(01/01/1950);
             Date minor = new Date (31/12/2003);
             if (convert.before(retirement)){
                 System.out.println("INVALID INPUT! Employers age is over retirement age!");
             }
             else if (convert.after(minor)){
                 System.out.println("INVALID INPUT! Employers age is below employemnt age!");
                 
             }
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws firstNameException  {
		if (firstName.contains("1") || firstName.contains("2") || firstName.contains("3") || firstName.contains("4") || firstName.contains("5")
		|| firstName.contains("6") || firstName.contains("7") || firstName.contains("8") || firstName.contains("9") || firstName.contains("0")){
			throw new  firstNameException (" Employee first_name cannot have only digits!");
	}
	else if (firstName.contains(" ")){
		throw new firstNameException (" Employee first_name cannot be empty!");
	}

		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	// so the employee objects can be compared when sorting/searching
	// NOTE: this will only allow comparisons based on the firstName
	@Override
	public int compareTo(Object obj) {
		Employee emp = (Employee)obj;
		return firstName.compareTo(emp.getFirstName());
	}
       
   
                
	// return a String containing the employee details
	@Override
	public String toString()
	{
		return empNo+" "+dateOfBirth+" "+firstName+" "+lastName+" "+gender +" "+ hireDate;
	}
         
        public static Employee [] sort (Employee [] emp, int l, int r) {

            if (l<r) {
                // First we need to find middle point
                int m = l + (r-l)/2;
                // Then we sort first and second halves
                sort(emp, l, m);
                sort(emp, m + 1, r);
                // At the end we merge halves that are alredy sorted
                merge (emp, l, m, r);
            }

            return emp;
        }




        public static void merge (Employee [] arr, int l, int m, int r ){
            // Now we need to find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;
            // Then we create temp arrays
            Employee L [] = new Employee [n1];
            Employee R [] = new Employee [n2];

            for (int i = 0; i < n1; ++i)
                L[i] = arr [l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr [m + 1 + j];

                int i = 0;
                int j = 0;

                int k = l;
                while (i < n1 && j < n2) {
                    if (L[i].compareTo (R[j]) < 0) {
                    arr [k] = L [i];
                    i++;
                } else {
                        arr [k] = R[j];
                        j++;
                    }
                    k++;
                }
                  while (i < n1) {
                      arr [k] = L [i];
                      i++;
                      k++;
                  }
                  while (j < n2) {
                      arr[k] = R [j];
                      j++;
                      k++;
                  }
            }

public static Employee[] linsearch(Employee [] emp, String search)
    {


        int i;
        int flag = 0;

        for(i = 0; i<4999; i++)
        {

            if (search.equals(emp[i].getFirstName()))
            {
                flag = 1;
                break;
            }

        }
        if (flag ==1)
        {
            System.out.println("Name found at position " +(i+1));
        }
        else
        {
            System.out.println("Not an employee");
        }
        return null;
    }


}
