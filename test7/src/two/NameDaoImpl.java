package two;

import java.util.*;
import java.util.ListIterator;

public class NameDaoImpl implements NameDao {

	// �������е��ַ��������б�
	@Override
	public List<String> getNameFromArray(String[] names) {
		// TODO Auto-generated method stub
		List<String> nameList = new ArrayList<String>();
		ListIterator it = nameList.listIterator();

		for (String name : names) {
			it.add(name);
		}

		return nameList;
	}

	// ���б�����������name��ͬ����Ŀ���ͷ��ظ�name���ڵ���ţ��Ҳ�������-1��
	@Override
	public int searchName(List nameList, String name) {
		// TODO Auto-generated method stub
		ListIterator it = nameList.listIterator();
		while (it.hasNext()) {
			if (it.next() == name) {
				return it.nextIndex() - 1;
			}
		}
		return -1;
	}

	// ����ָ��id�����б����Ƴ�ָ������Ŀ�����idָ������(�������߳����б����ֵ)�׳�IllegalArgumentException�쳣���Ƴ��ɹ�����true
	@Override
	public boolean removeFromList(List<String> nameList, int id) {
		// TODO Auto-generated method stub
		ListIterator it = nameList.listIterator();

		while(it.hasNext()) {
			if(it.next() == nameList.get(id)) {
				
				it.remove();
				return true;
			}
		}
		
		if (id < 0 || id > nameList.size())
			throw new IllegalArgumentException();

		if (nameList.remove(id) != null) {
			return true;
		}

		return false;
	}
}
