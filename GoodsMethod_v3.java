package kr.co.checkpoint2;

import java.util.ArrayList;

import kr.co.checkpoint.Goods_v2;

public class GoodsMethod_v3 implements GoodsMakable_v3 {
	
	

	public GoodsMethod_v3() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ArrayList<Goods_v2> list) {
		Goods_v2 a1 = new Goods_v2(1000, "������", 330000, "���ѹα�");
		Goods_v2 a2 = new Goods_v2(1001, "û�ұ�", 130000, "���ٺ��");
		Goods_v2 a3 = new Goods_v2(1002, "����û����", 110000, "Ƣ��Ű��");
		Goods_v2 a4 = new Goods_v2(1003, "������", 120000, "���ѹα�");
		Goods_v2 a5 = new Goods_v2(1004, "������", 30000, "����");

		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
	}

	@Override
	public int viewMenu() {
		int num;
		String tmp = null;
		
		System.out.println("[�޴�]");
		System.out.println("1.��ǰ�߰� 2.��ǰ����. 3.��ǰ���� 4.��ǰ���� 5. ����");
		System.out.print("�޴��� �����ϼ���(1~5) :");
		
		tmp = scan.nextLine();
		
		if (! IS_NUMBER.matcher(tmp).matches()) {
			errorCheck(10);
			return -1; 
		}		
		
		num = Integer.parseInt(tmp);
		
		if (!((num >=1)&&(num<=5))){
			errorCheck(20);
			return -1;
		}
		
		System.out.println();
		
		return num;
	}

	@Override
	public void viewGoods(ArrayList<Goods_v2> list) {
		System.out.println("Serial      ��ǰ��      ����     ������");
		for(int i=0; i<list.size(); i++) {
			//gNo, gName, gPrice, gMake
			System.out.printf("%5d%10s  %8d   %s%n", list.get(i).getgNo()
												, list.get(i).getgName()
												, list.get(i).getgPrice()
												, list.get(i).getgMake()  );
			
		}
		System.out.println();
	}

	@Override
	public int addGoods(ArrayList<Goods_v2> list) {
		int gNo;
		String gName;
		int gPrice;
		String gMake;
		String tmp;
		
		System.out.println("�ʱ�޴��� ���ư����� -1 �� �Է����ּ���.");
		System.out.print("�߰��� ��ǰ�� �ø���ѹ��� �Է��ϼ���:");
		tmp = scan.nextLine();
		if (! IS_NUMBER.matcher(tmp).matches()) {
			return 150; // ���ڰ� �ƴ� �ø���
		}				
		if(searchGoods(1, tmp, list) != -1) {
			return 170; // �̵̹�ϵ� �ø���
		}
		
		gNo = Integer.parseInt(tmp);
		if (gNo == -1) {
			return 110;			
		}
		
		System.out.print("�߰��� ��ǰ�� �̸��� �Է��ϼ���:");
		gName = scan.nextLine();
		if(searchGoods(2, gName, list) != -1) {
			return 180; // �̵̹�ϵ� ��ǰ�� �ߺ�
		}
		if (gName.equals("-1")) {  
			return 120;			
		}

		
		System.out.print("�߰��� ��ǰ�� ������ �Է��ϼ���:");
		tmp = scan.nextLine();
		if (! IS_NUMBER.matcher(tmp).matches()) {
			return 160; // ���ڰ� �ƴ� ����
		}				
		gPrice = Integer.parseInt(tmp);
		if (gPrice == -1) {
			return 130;			
		} 
		
		System.out.print("�߰��� ��ǰ�� ���� �Է��ϼ���:");
		gMake = scan.nextLine();
		if (gMake.equals("-1")) {
			return 140;			
		}
		
		Goods_v2 sample = new Goods_v2(gNo,gName, gPrice, gMake);
		list.add(sample);
		
		System.out.println("��ǰ�߰� �Ϸ�!!");
		System.out.println(list.get(list.size()-1).toString());
		
		return 0;
	}
	
	@Override
	public int modifyGoods(ArrayList<Goods_v2> list) {
		String serial=null;
		int index = 0;
		int nCheck = 0;
		int gNo;
		String gName;
		int gPrice;
		String gMake;		
		int menu;
		String tmp = null;
		
		viewGoods(list);
		
		System.out.print("������ ��ǰ�� Serial�� �����ּ���.:");
		serial = scan.nextLine();
		
		if (! IS_NUMBER.matcher(serial).matches()) {
			return 280; // ���ڰ� �ƴ� �ø��� �ѹ�
		}		
		index = searchGoods(1, serial, list);
		
		if (index == -1) {
			return 270; //��ϵ��� ���� �ø���.
		}
		
		if (!(index >= 0)&&(index < list.size())){
			return 201;
		}
		
		System.out.println("1.�ø���ѹ� 2.��ǰ�� 3.��ǰ���� 4.������");
		System.out.println(">�ʱ�޴��� ���÷��� -1���Է����ּ���.");
		System.out.print("������ �޴��� �������ּ���(1~4):");
		tmp = scan.nextLine();
		if (! IS_NUMBER.matcher(tmp).matches()) {
			return 292;  // ���ڰ� �ƴ� �޴�
		}			
		
		menu = Integer.parseInt(tmp);
		if (!((menu >=1)&&(menu<=4))){
			return 202;
		}
		
		switch(menu) {
			case 1 : 
				System.out.print("������ ��ǰ�� Serial�� �Է��ϼ���:");
				tmp = scan.nextLine();
				if (! IS_NUMBER.matcher(tmp).matches()) {
					return 290; // ���ڰ� �ƴ� �ø��� �ѹ�
				}			
				if (serial.equals(tmp)) {
					return 293; //������ ��ǰ�� �ø���� ���ο� �ø����� �������
				}

				gNo = Integer.parseInt(tmp);  
				if (gNo == -1) {              //�߰��� ������
					return 210;			
				}

				nCheck = searchGoods(1, Integer.toString(gNo), list);
				
				if (nCheck != -1) {
					return 250; // �ߺ��� �ø��� �ѹ�.
				}
					
				list.get(index).setgNo(gNo);
				break;
			case 2 : 
				System.out.print("������ ��ǰ�� �̸��� �Է��ϼ���:");
				gName = scan.nextLine();
				if (gName.equals("-1")) {
					return 220;			
				}
				nCheck = searchGoods(2, gName, list);
				
				if (nCheck != -1) {
					return 260; // �ߺ��� ��ǰ��
				}				
				list.get(index).setgName(gName); 
				break;
			case 3 : 
				System.out.print("������ ��ǰ�� ������ �Է��ϼ���:");
				
				tmp = scan.nextLine();
				if (!IS_NUMBER.matcher(tmp).matches() ) {
					return 291; // ���ڰ� �ƴ� ��
				}				
				gPrice = Integer.parseInt(tmp);
				if (gPrice == -1) {
					return 230;			
				}
				list.get(index).setgPrice(gPrice); 
				break;
			case 4 : 
				System.out.print("������ ��ǰ�� ���� �Է��ϼ���:");
				gMake = scan.nextLine();
				if (gMake.equals("-1")) {
					return 240;			
				}
				list.get(index).setgMake(gMake); 
				break;
		
		}
		
		System.out.println("��ǰ���� �Ϸ�!!");
		System.out.println(list.get(index).toString());
		return 0;
	}

	@Override
	public int deleteGoods(ArrayList<Goods_v2> list) {
		int num = 0;
		int index = -1;
		String tmp = null;
		viewGoods(list);
		
		System.out.print("������ ��ǰ�� SerialNo�� �����ּ���.:");
		tmp = scan.nextLine();
		
		if (! IS_NUMBER.matcher(tmp).matches()) {
			return 302; // ���ڰ� �ƴ� �ø���
		}				
		num = Integer.parseInt(tmp);
		index = searchGoods(1, Integer.toString(num), list);
		
		if (index == -1) {
			return 301;  //��ϵ��� ���� �ø���.
		}
		
		if (!(index >= 0)&&(index<list.size())){
			return 300;
		}
		
		list.remove(index);
		
		System.out.println("��ǰ�� �����Ǿ����ϴ�.");
		return 0;
	}


	@Override
	public int searchGoods(int nMode, String nSearch, ArrayList<Goods_v2> list) {
		int nindex=-1;
		int gNo;
		String gName;
		int gPrice;
		String gMake;			
		
		for(int i=0; i < list.size() ; i++) {
			
			switch(nMode) {
				case 1 : //no
					gNo = list.get(i).getgNo();
					
					if (nSearch.equals(Integer.toString(gNo))) {
						nindex = i;
						return nindex;
					}
					break;
				case 2 : //gName
					gName = list.get(i).getgName();
					
					if (nSearch.equals(gName)) {
						nindex = i;
						return nindex;
					}
					break;
				case 3 : //gPrice
					gPrice = list.get(i).getgPrice();
					
					if (nSearch.equals(Integer.toString(gPrice))) {
						nindex = i;
						return nindex;
					}
					break;
				case 4 : //gMake
					gMake = list.get(i).getgMake();
					
					if (nSearch.equals(gMake)) {
						nindex = i;
						return nindex;
					}
					break;
				default : 
					break;
					
			}
			
		}
		
		return nindex;
	}

	@Override
	public void errorCheck(int errCode) {
		switch (errCode) {
		case 10 :
			System.out.println("�޴��� ���ڷ� �Է����ּ���. �ʱ�� ���ư��ϴ�. (menu:code10)");
			break;
		case 20 :
			System.out.println("�޴��Է� ����.(1~5)������ ���ڸ� �Է����ּ���. �ʱ�� ���ư��ϴ�. (menu:code20)");
			break;
		case 110: case 120: case 130: case 140:
			System.out.printf("��ǰ�߰��� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ� (add:code: %d)%n", errCode);
			break;
		case 150 :
			System.out.println("�ø����Է¿���. ���ڷ� �Է����ּ���. �ʱ�޴��� ���ư��ϴ�. (add:code:150)");
			break;
		case 160 :
			System.out.println("�����Է¿���. ���ڷ� �Է����ּ���. �ʱ�޴��� ���ư��ϴ�. (add:code:160)");
			break;
		case 170 :
			System.out.println("�̹� ��ϵ� �ø����Դϴ�. �ʱ�޴��� ���ư��ϴ�. (add:code:170)");
			break;
		case 180 : 
			System.out.println("�̹� ��ϵ� ��ǰ�� �ʱ�޴��� ���ư��ϴ�. (add:code:180)");
			break;
		case 201 :
			System.out.println("�߸��� ��ȣ �Դϴ�. �ʱ�޴��� ���ư��ϴ�.  (modify:code201)");
			break;
		case 202 :
			System.out.println("�߸��� �޴� �Դϴ�. �ʱ�޴��� ���ư��ϴ�.  (modify:code202)");
			break;
		case 210: case 220: case 230: case 240:
			System.out.printf("��ǰ������ �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ� (modify:code: %d)%n", errCode);
			break;
		case 250:
			System.out.println("�ߺ��� �ø���ѹ� �ʱ�޴��� ���ư��ϴ� (modify:code : 250)");
			break;
		case 260:
			System.out.println("�ߺ��� ��ǰ�� �ʱ�޴��� ���ư��ϴ� (modify:code:260)");
			break;
		case 270:
			System.out.println("��ϵ��� ���� �ø��� �Դϴ�. �ʱ�޴��� ���ư��ϴ�. (modify:code:270)");
			break;
		case 280:
			System.out.println("�Է¿���. ���ڷ� �Է����ּ���. �ʱ�޴��� ���ư��ϴ�. (modify:code:280)");
			break;
		case 290:
			System.out.println("�Է¿���. ���ڷ� �Է����ּ���. �ʱ�޴��� ���ư��ϴ�. (modify:code:290)");
			break;
		case 291:
			System.out.println("�Է¿���. ���ڷ� �Է����ּ���. �ʱ�޴��� ���ư��ϴ�. (modify:code:291)");
			break;
		case 292:
			System.out.println("�޴� �Է¿���. ���ڷ� �Է����ּ���. �ʱ�޴��� ���ư��ϴ�. (modify:code:292)");
			break;
		case 293: 
			System.out.println("���� ������� �ø���� �����մϴ�. �ʱ�޴��� ���ư��ϴ�. (modify:code:292)");
			break;
		case 300:
			System.out.println("�߸��� ��ȣ �Դϴ�. �ʱ�޴��� ���ư��ϴ�. (delete:code:300)");
			break;
		case 301:
			System.out.println("��ϵ��� ���� �ø���. �ʱ�޴��� ���ư��ϴ�. (delete:code:301)");
			break;
		case 302:
			System.out.println("�ø����Է� ����. ���ڷ� �Է����ּ���. �ʱ�޴��� ���ư��ϴ�. (delete:code:302)");
			break;
		default :
			break;
	}
		
	}

	

}
