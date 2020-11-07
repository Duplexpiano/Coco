package secondandthird;

import java.time.LocalDate;
import java.util.Arrays;

public class TestLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.of(2001, 8, 07);
		Staff[] staffs = new Staff[4];
		staffs[0] = new Staff("Cat", "514", 36, 1, 3000, date);
		staffs[1] = new Teacher("Computer technique", "SE", 2000, "Judy", "437", 40, 1, 7000, date.plusYears(2));
		staffs[2] = new SecurityGuard("talk", 1000, "Bob", "011", 29, 0, 4000, date.minusYears(4));
		staffs[3] = new Dean("Computer technique", "SE", 2000, "Sally", "501", 54, 0, 12000, date.minusYears(10), 5000);
		// ����˳��
		sortByAge(staffs);
		printAge(staffs);
		sortByName(staffs);
		printName(staffs);
		sortByComplex(staffs);
		printComplex(staffs);
		sortBySalary(staffs);
		printSalary(staffs);
		sortByDateHired(staffs);
		printDateHired(staffs);
	}

	// ���нˮ
	private static void printSalary(Staff[] staffs) {
		System.out.println("Sort salary(descending order): ");
		for (Staff x : staffs) {
			System.out.println(x.getName() + " : " + x.getSalary());
		}
	}

	// �������
	private static void printName(Staff[] persons) {
		System.out.println("Sort name(ascending order): ");
		for (Staff x : persons) {
			System.out.println("Name: " + x.getName());
		}
	}

	// �������
	private static void printAge(Staff[] staffs) {
		System.out.println("Sort age(ascending order): ");
		for (Staff x : staffs) {
			System.out.println(x.getName() + " : " + x.getAge());
		}
	}

	// ������ϱȽ����ȽϽ��
	private static void printComplex(Staff[] staffs) {
		System.out.println("sort ComplexComparator(descending order): ");
		for (Staff x : staffs) {
			System.out.println("Sex: " + x.getSex() + ", Salary: " + x.getSalary());
		}
	}

	// �����Ӷ����
	private static void printDateHired(Staff[] staffs) {
		System.out.println("sort DateHired(ascending order): ");
		for (Staff x : staffs) {
			System.out.println("Name: " + x.getName() + ", DateHired: " + x.getDateHired());
		}
	}

	// ��������нˮ
	private static void sortBySalary(Staff[] staffs) {
		Arrays.sort(staffs, (o1, o2) -> {
			return (int) (o2.getSalary() - o1.getSalary());
		});

	}

	// ������������
	private static void sortByAge(Staff[] staffs) {
		Arrays.sort(staffs, (o1, o2) -> {
			return o1.getAge() - o2.getAge();
		});
	}

	// ������������
	private static void sortByName(Staff[] staffs) {
		Arrays.sort(staffs, (o1, o2) -> {
			return o1.getName().compareTo(o2.getName());
		});
	}

	// ComplexComparatorʹ��lambda���ʽʵ��
	private static void sortByComplex(Staff[] staffs) {
		Arrays.sort(staffs, (o1, o2) -> {
			if (o1.getSex() == o2.getSex()) {
				return (int) (o2.getSalary() - o1.getSalary());
			} else if (o1.getSex() > o2.getSex())
				return 1;
			else {
				return -1;
			}
		});
	}

	// �����Ź�Ӷ����
	private static void sortByDateHired(Staff[] staffs) {
		Arrays.sort(staffs, (o1, o2) -> {
			return o1.getDateHired().compareTo(o2.getDateHired());
		});

	}
}
