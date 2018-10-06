import java.util.Scanner;
/**
 * Class for insertionsort.
 */
class Insertionsort {
	void ex(studentdata[] array, int sindex, int bindex) {
		studentdata tmp = array[sindex];
		array[sindex] = array[bindex];
		array[bindex] = tmp;
	}
	/**
	 * { function_description }.
	 *
	 * @param      b1    The b 1.
	 * @param      b2    The b 2.
	 *
	 * @return     { description_of_the_return_value }.
	 */
	boolean less(studentdata b1, studentdata b2) {
		return b1.compareTo(b2) == -1;
	}
	/**
	 * { function_description }.
	 *
	 * @param      students  The students.
	 */
	void sort(studentdata[] students) {
		for (int i = 1; i < students.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(students[j - 1], students[j])) {
					ex(students, j - 1, j);
				} else {
					break;
				}
			}
		}
	}
}
/**
 * Class for studentdata.
 */
class studentdata implements Comparable<studentdata> {
	String studentname;
	String birthdate;
	int s1marks;
	int s2marks;
	int s3marks;
	int tmarks;
	String rescategory;
	/**
	 * Constructs the object.
	 *
	 * @param      name      The name.
	 * @param      dob       The dob.
	 * @param      s1        The s 1.
	 * @param      s2        The s 2.
	 * @param      s3        The s 3.
	 * @param      total     The total.
	 * @param      category  The category.
	 */
	studentdata(String name, String dob, int s1, int s2, int s3, int total, String category) {
		this.studentname = name;
		this.birthdate = dob;
		this.s1marks = s1;
		this.s2marks = s2;
		this.s3marks = s3;
		this.tmarks = total;
		this.rescategory = category;
	}
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }.
	 */
	String[] datesplit() {
		String[] splitdate = birthdate.split("-");
		return splitdate;
	}
	/**
	 * { function_description }.
	 *
	 * @param      other  The other.
	 *
	 * @return     { description_of_the_return_value }.
	 */
	public int compareTo(studentdata other) {
		if (this.tmarks > other.tmarks) {
			return 1;
		}
		if (this.tmarks < other.tmarks) {
			return -1;
		}
		if (this.s3marks > other.s3marks) {
			return 1;
		}
		if (this.s3marks < other.s3marks) {
			return -1;
		}
		if (this.s2marks > other.s2marks) {
			return 1;
		}
		if (this.s2marks < other.s2marks) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[2]) > Integer.parseInt(other.datesplit()[2])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[2]) < Integer.parseInt(other.datesplit()[2])) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[1]) > Integer.parseInt(other.datesplit()[1])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[1]) < Integer.parseInt(other.datesplit()[1])) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[0]) > Integer.parseInt(other.datesplit()[0])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[0]) < Integer.parseInt(other.datesplit()[0])) {
			return -1;
		}
		return 0;
	}

}
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {
	}
	static int opencount = 0;
	static int bccount = 0;
	static int sccount = 0;
	static int stcount = 0;
	/**
	 * { function_description }.
	 *
	 * @param      array  The array.
	 */
	public static void countcat(final studentdata[] array) {
		for (int i = 0; i < array.length; i++) {
if (array[i].rescategory.equals("Open")) {
				opencount++;
			}
			if (array[i].rescategory.equals("BC")) {
				bccount++;
			}
			if (array[i].rescategory.equals("SC")) {
				sccount++;
			}
			if (array[i].rescategory.equals("ST")) {
				stcount++;
			}
		}
	}
	/**
	 * { function_description }.
	 *
	 * @param      array    The array.
	 * @param      vacancy  The vacancy.
	 * @param      open     The open.
	 * @param      bc       { parameter_description }.
	 * @param      sc       The screen.
	 * @param      st       { parameter_description }.
	 */
	public static void meritofstd(final studentdata[] array, int vacancy, int open,
 int bc,  int sc,int st) {
		countcat(array);
		for (int i = 0; i < array.length; i++) {
			if (vacancy == 0) {
				return;
			}
			if (open > 0) {
				System.out.println(array[i].studentname + "," 
	+ array[i].tmarks + "," 
	+ array[i].rescategory);
			open--;
				vacancy--;

			} else {
if (array[i].rescategory.equals("BC") || array[i].rescategory.equals("SC") 
	|| array[i].rescategory.equals("ST")) {
		if (array[i].rescategory.equals("BC") && bc > 0) {
		System.out.println(array[i].studentname + "," +
			array[i].tmarks + "," 
				+ array[i].rescategory);
						bc--;
						vacancy--;
	} else if (array[i].rescategory.equals("SC") && sc > 0) {
	System.out.println(array[i].studentname + "," 
						 + array[i].tmarks + "," 
                + array[i].rescategory);
						sc--;
						vacancy--;
					} else if (array[i].rescategory.equals("ST") && st > 0) {
						System.out.println(array[i].studentname + "," 
				+ array[i].tmarks + "," 
				+ array[i].rescategory);
						st--;
						vacancy--;
					}
} else if (vacancy > 0 && bccount == 0 && sccount == 0 && stcount == 0) {
					System.out.println(array[i].studentname + "," 
					          + array[i].tmarks + "," 
					       + array[i].rescategory);
					vacancy--;
				}

			}
		}
	}
	/**
	 * { function_description }.
	 *
	 * @param      array  The array.
	 */
	public static void print(studentdata[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].studentname + "," 
			                   + array[i].tmarks + "," 
			                   + array[i].rescategory);
		}
	}
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(final String[] args) {
		Scanner scan =  new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		studentdata[] students = new studentdata[num];
		int vacancynum = Integer.parseInt(scan.nextLine());
		int openvacancy = Integer.parseInt(scan.nextLine());
		int bcvacancy = Integer.parseInt(scan.nextLine());
		int scvacancy = Integer.parseInt(scan.nextLine());
		int stvacancy = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < num; i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			studentdata eachstudentdata = new studentdata(tokens[0], tokens[1],
				Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
			students[i] = eachstudentdata;
		}
		Insertionsort insertion = new Insertionsort();
		insertion.sort(students);
		print(students);
		System.out.println();
		meritofstd(students, vacancynum, openvacancy,
		 bcvacancy, scvacancy, stvacancy);
	}

}