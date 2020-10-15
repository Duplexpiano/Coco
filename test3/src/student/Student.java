package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	private String name;
	private int math;
	private int java;
	private int ds;
	private int avg;
	private int total;
	
	public Student(String name, int math, int java, int ds) {
		this.name = name;
		this.math = math;
		this.java = java;
		this.ds = ds;
	}
	
	public Student(String name, int math, int java, int ds, int avg, int total) {
		this.name = name;
		this.math = math;
		this.java = java;
		this.ds = ds;
		this.avg = avg;
		this.total = total;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getDs() {
		return ds;
	}
	public void setDs(int ds) {
		this.ds = ds;
	}
	public int getAvg() {
		calcAvgAndTotal();
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public int getTotal() {
		calcAvgAndTotal();
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	//����average��total
	public void calcAvgAndTotal() {
		total = java + math + ds;
		avg = total/3;
	}
	//��ȡ�ļ�������Student[]����
	public static Student[] readStudentsFromFile(String fileName) throws FileNotFoundException{
		Scanner in = new Scanner(new File(fileName));
		ArrayList<Student> students = new ArrayList<>();
		while(in.hasNextLine()) {
			String line = in.nextLine();
			Scanner linescanner = new Scanner(line);  //ר��ɨ��line��ɨ����
			linescanner.useDelimiter(" ");  //�ո���Ϊ�ָ���
			students.add(new Student(linescanner.next(), Integer.valueOf(linescanner.next()), Integer.valueOf(linescanner.next()), Integer.valueOf(linescanner.next()), Integer.valueOf(linescanner.next()), Integer.valueOf(linescanner.next())));
			linescanner.close();
		}
		in.close();
		//���б�students�е�Ԫ��תΪ�µ�ָ�����͵�����
		Student[] resStudents = students.toArray(new Student[students.size()]);
		return resStudents;
	}
	//���򷵻ص�Student�������飬�����
	public static void sort(Student[] students) {
		for(int i = 0; i < students.length; i++)
			for(int j = 0; j < students.length-1; j++)
				if(students[j].getAvg() < students[j+1].getAvg()) {
					Student tmp = students[j];
					students[j] = students[j+1];
					students[j+1] = tmp;
				}
		for(Student x : students) {
			System.out.println(x);  //toString()
		}
	}
	//��дtoString
	@Override
	public String toString() {
		return "Student [name=" + name + ", math=" + math + ", java=" + java + ", ds=" + ds + ", avg=" + avg
				+ ", total=" + total + "]";
	}
	
}
