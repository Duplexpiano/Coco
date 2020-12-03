package two;

import java.util.*;
import java.util.List;

public class NameDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NameDaoImpl nd = new NameDaoImpl();
		String[] names = { "Tom", "Jerry", "Bob", "Peter", "Torry", "Sally", "Hash", "Lily", "Momo" };
		List<String> nameList = new ArrayList<String>();
		nameList = nd.getNameFromArray(names); // ��������б�

		System.out.println("Name list: ");
		printNameList(nameList); // ��ӡ�б�

		String name = "Lily"; // ��Ҫremove������

		int index = nd.searchName(nameList, name); // ���name���б��е��±�
		System.out.println(index + ": " + name);
		nd.removeFromList(nameList, index);

		System.out.println("--------------------");
		System.out.println("New name list: ");
		printNameList(nameList); // ��ӡ���б�
	}

	public static void printNameList(List<String> nameList) {
		System.out.println("--------------------");
		for (String n : nameList) {
			System.out.println(n);
		}
		System.out.println("--------------------");
	}

}
