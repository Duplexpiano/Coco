package account;

import java.time.LocalDate;
import java.util.Scanner;

public class TestAccount {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		Scanner in = new Scanner(System.in);
		int optionAcc, optionFun;
		double money;
		System.out.println("Please input your option:");
		System.out.println("1.CheckingAccount\n2.SavingAccount");
		optionAcc = in.nextInt();
		// ѡ������
		switch (optionAcc) {
		// 1����֧Ʊ���У�2����������
		case 1:
			CheckingAccount a1 = new CheckingAccount("Tom", 20000, 0.02, date, -500);
			System.out.println(a1);
			System.out.println("Please input your opyion: ");
			System.out.println("1.deposit\n2.withdraw");
			optionFun = in.nextInt();
			// ѡ���ܣ�1�Ĵ����2����ȡ��
			switch (optionFun) {
			case 1:
				System.out.printf("Deposit how much: ");
				money = in.nextDouble();
				System.out.println("Balance of CheckingAccount(deposit): " + a1.deposit(money));
				System.out.println(a1);
				break;
			case 2:
				System.out.printf("Withdraw how much: ");
				money = in.nextDouble();
				if (a1.getBalance() - money >= a1.getOverdraftLimit())// ȡ���Ƿ񳬳�֧Ʊ����͸֧�޶���
					System.out.println("Balance of CheckingAccount(withdraw): " + a1.withdraw(money));
				else {
					System.out.println("CheckingAccount Overdraft limit.");
				}
				System.out.println(a1);
				break;
			}
			break;
		case 2:
			SavingAccount a2 = new SavingAccount("Jerry", 20000, 0.05, date);
			System.out.println(a2);
			System.out.println("Please input your opyion: ");
			System.out.println("1.deposit\n2.withdraw");
			optionFun = in.nextInt();
			switch (optionFun) {
			case 1:
				System.out.printf("Deposit how much: ");
				money = in.nextDouble();
				System.out.println("Balance of SavingAccount(deposit): " + a2.deposit(money));
				System.out.println(a2);
				break;
			case 2:
				System.out.printf("Withdraw how much: ");
				money = in.nextDouble();
				if (a2.getBalance() - money >= 0) // ��������ȡ���Ƿ�͸֧
					System.out.println("Balance of SavingAccount(withdraw): " + a2.withdraw(money));
				else {
					System.out.println("Balance of SavingAccount is not enough.");
				}
				System.out.println(a2);
				break;

			}
			in.close();
		}
	}
}
