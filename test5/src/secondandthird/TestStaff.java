package secondandthird;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class TestStaff {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2010, 12, 05);
		Staff[] staffs = new Staff[4];
		staffs[0] = new Staff("Tom", "514", 36, 1, 3000, date);
		staffs[1] = new Teacher("Computer technique", "SE", 2000, "Java", "437", 40, 0, 7000, date.plusYears(2));
		staffs[2] = new SecurityGuard("talk", 1000, "Bob", "011", 29, 0, 4000, date.minusYears(4));
		staffs[3] = new Dean("Computer technique", "SE", 2000, "Berry", "501", 54, 1, 12000, date.minusYears(10), 5000);
		// ����˳��
		sortBySalary(staffs);
		printSalary(staffs);
		sortByName(staffs);
		printName(staffs);
		sortByAge(staffs);
		printAge(staffs);
		sortByDateHired(staffs);
		printAllStaffs(staffs);
		sortAndPrintComplex(staffs);
	}

	// �������Ա��
	private static void printAllStaffs(Staff[] staffs) {
		System.out.println("Sort DateHired(ascending order): ");
		for (Staff x : staffs) {
			System.out.println("DateHired: " + x.getDateHired());
		}
	}

	// �������
	private static void printName(Staff[] persons) {
		System.out.println("Sort name(ascending order): ");
		for (Staff x : persons) {
			System.out.println("Name: " + x.getName());
		}
	}

	// ���нˮ
	private static void printSalary(Staff[] staffs) {
		System.out.println("Sort salary(descending order): ");
		for (Staff x : staffs) {
			System.out.println(x.getName() + " : " + x.getSalary());
		}
	}

	// �������
	private static void printAge(Staff[] staffs) {
		System.out.println("Sort age(ascending order): ");
		for (Staff x : staffs) {
			System.out.println(x.getName() + " : " + x.getAge());
		}
	}

	// ��������нˮ(�ڲ���)
	private static void sortBySalary(Staff[] staffs) {
		Arrays.sort(staffs, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				return (int) (o2.getSalary() - o1.getSalary());
			}

		});

	}

	// ������������
	private static void sortByAge(Staff[] staffs) {
		Arrays.sort(staffs, new AgeComparator());
	}

	// ������������
	private static void sortByName(Staff[] staffs) {
		Arrays.sort(staffs, new NameComparator());
	}

	// ���������Ӷ����(�ڲ���)
	private static void sortByDateHired(Staff[] staffs) {
		class DateHiredComparator implements Comparator<Staff>{

			@Override
			public int compare(Staff o1, Staff o2) {
				return o1.getDateHired().compareTo(o2.getDateHired());
			}
			
		}
		Arrays.sort(staffs, new DateHiredComparator());
//		Arrays.sort(staffs, new Comparator<Staff>() {
//
//			public int compare(Staff o1, Staff o2) {
//				return o1.getDateHired().compareTo(o2.getDateHired());
//			}
//
//		});
	}

	// �����������ؼ���(Sex, Salary)
	private static void sortAndPrintComplex(Staff[] staffs) {
		Arrays.sort(staffs, new ComplexComparator());
		System.out.println("ComplexComparator(ascending order): ");
		for (Staff x : staffs) {
			System.out.println("Sex: " + x.getSex() + ", Salary: " + x.getSalary());
		}
	}
}
