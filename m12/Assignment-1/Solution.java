import java.util.Scanner;
class Insertionsort {
	void exchange(studentdata[] array, int smallindex, int bigindex) {
		studentdata temp = array[smallindex];
		array[smallindex] = array[bigindex];
		array[bigindex] = temp;
	}
	boolean less(studentdata valueone, studentdata valuetwo) {
		return valueone.compareTo(valuetwo) == -1;
	}
	void sort(studentdata[] students) {
		for (int i = 1; i < students.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(students[j - 1], students[j])) {
					exchange(students, j - 1, j);
				} else {
					break;
				}
			}
		}
	}
}
class studentdata implements Comparable<studentdata> {
	String studentname;
	String birthdate;
	int sub1marks;
	int sub2marks;
	int sub3marks;
	int totalmarks;
	String rescategory;
	studentdata(String name, String dob, int sub1, int sub2, int sub3, int total, String category) {
		this.studentname = name;
		this.birthdate = dob;
		this.sub1marks = sub1;
		this.sub2marks = sub2;
		this.sub3marks = sub3;
		this.totalmarks = total;
		this.rescategory = category;
	}
	String[] datesplit() {
		String[] splitdate = birthdate.split("-");
		return splitdate;
	}
	public int compareTo(studentdata other) {
		if (this.totalmarks > other.totalmarks) {
			return 1;
		}
		if (this.totalmarks < other.totalmarks) {
			return -1;
		}
		if (this.sub3marks > other.sub3marks) {
			return 1;
		}
		if (this.sub3marks < other.sub3marks) {
			return -1;
		}
		if (this.sub2marks > other.sub2marks) {
			return 1;
		}
		if (this.sub2marks < other.sub2marks) {
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
class Solution {
	Solution() {
		//unused
	}
	static int opencount = 0;
	static int bccount = 0;
	static int sccount = 0;
	static int stcount = 0;
	public static void countcat(studentdata[] array) {
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
	public static void meritfill(studentdata[] array, int vacancy, int open, int bc, int sc, int st) {
		for (int i = 0; i < array.length; i++) {
			if (vacancy == 0) {
				// System.out.println("entered");
				return;
			}
			if (open > 0) {
				System.out.println(array[i].studentname + "," +
				                   array[i].totalmarks + "," +
				                   array[i].rescategory);
				// if (array[i].rescategory.equals("BC")) {
				// 	bc--;
				// } else if(array[i].rescategory.equals("SC")) {
				// 	sc--;
				// } else if(array[i].rescategory.equals("ST")) {
				// 	st--;
				// }
				open--;
				vacancy--;

			} else {
				if (array[i].rescategory.equals("BC") || array[i].rescategory.equals("SC") || array[i].rescategory.equals("ST")) {
					if (array[i].rescategory.equals("BC") && bc > 0) {
						System.out.println(array[i].studentname + "," +
						                   array[i].totalmarks + "," +
						                   array[i].rescategory);
						bc--;
						vacancy--;
					} else if (array[i].rescategory.equals("SC") && sc > 0) {
						System.out.println(array[i].studentname + "," +
						                   array[i].totalmarks + "," +
						                   array[i].rescategory);
						sc--;
						vacancy--;
					} else if (array[i].rescategory.equals("ST") && st > 0) {
						System.out.println(array[i].studentname + "," +
						                   array[i].totalmarks + "," +
						                   array[i].rescategory);
						st--;
						vacancy--;
					} else if (vacancy > 0 && bccount == 0 && sccount == 0 && stcount == 0) {
						System.out.println(array[i].studentname + "," +
						                   array[i].totalmarks + "," +
						                   array[i].rescategory);
						vacancy--;
					}
				}
			}
		}
	}

	public static void print(studentdata[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].studentname + "," +
			                   array[i].totalmarks + "," +
			                   array[i].rescategory);
		}
	}
	public static void main(String[] args) {
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
		meritfill(students, vacancynum, openvacancy, bcvacancy, scvacancy, stvacancy);
	}

}