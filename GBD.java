package GetBirthDate;

import java.util.Arrays;
import java.util.Scanner;

public class GBD {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] id = new String[18];
		String[] rlt = new String[10];
		System.out.println("������10�����֤�ţ�");
		for (int i = 0; i < 10; i++) {
			id[i] = in.nextLine();
			rlt[i] = getBirthDate(id[i]);
		}
		in.close();
		Arrays.sort(rlt); // Ĭ����������
		System.out.println("������������Ϣ:");
		for (String x : rlt) {
			System.out.println(x);
		}
	}

	public static String getBirthDate(String id) {
		id = id.substring(6, 10) + '-' + id.substring(10, 12) + '-' + id.substring(12, 14);
		return id;
	}
}
/* ʮһ������������֤
110101199003074653
210102200507152286
130102199806144993
13010219970614693X
350423200108076836
350212200104201599
341102201211281700
341102200911089761
110101200302014744
350211201610017530
350211201402206828
*/