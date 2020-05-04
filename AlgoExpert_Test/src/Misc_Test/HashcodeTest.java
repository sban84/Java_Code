package Misc_Test;


public class HashcodeTest {

	public static void main(String args[])
	{
		SAGEmp emp1 = new SAGEmp(100, "sban");
		SAGEmp emp2 = new SAGEmp(100, "abcd");
		System.out.println("employee check " + emp1.equals(emp2));
	}
}

class SAGEmp
{
	int empId ;
	String empName;
	public SAGEmp(int empId , String empName) {
		this.empId = empId;
		this.empName = empName;
		
	}
	
	public boolean equals(SAGEmp obj)
	{
		if(obj == this ) {
			return true;
		}
		if(obj == null ) {
			return false;
		}
		else {
			//return this.empId==obj.empId;
			return (this.empId==obj.empId) && (this.empName.equals(obj.empName));
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}

}

