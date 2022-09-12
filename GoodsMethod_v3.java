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
		Goods_v2 a1 = new Goods_v2(1000, "에어컨", 330000, "대한민국");
		Goods_v2 a2 = new Goods_v2(1001, "청소기", 130000, "짐바브웨");
		Goods_v2 a3 = new Goods_v2(1002, "공기청정기", 110000, "튀르키예");
		Goods_v2 a4 = new Goods_v2(1003, "제습기", 120000, "대한민국");
		Goods_v2 a5 = new Goods_v2(1004, "건조기", 30000, "광야");

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
		
		System.out.println("[메뉴]");
		System.out.println("1.상품추가 2.상품수정. 3.상품삭제 4.상품보기 5. 종료");
		System.out.print("메뉴를 선택하세요(1~5) :");
		
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
		System.out.println("Serial      상품명      가격     제조국");
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
		
		System.out.println("초기메뉴로 돌아가려면 -1 을 입력해주세요.");
		System.out.print("추가할 상품의 시리얼넘버를 입력하세요:");
		tmp = scan.nextLine();
		if (! IS_NUMBER.matcher(tmp).matches()) {
			return 150; // 숫자가 아닌 시리얼
		}				
		if(searchGoods(1, tmp, list) != -1) {
			return 170; // 이미등록된 시리얼
		}
		
		gNo = Integer.parseInt(tmp);
		if (gNo == -1) {
			return 110;			
		}
		
		System.out.print("추가할 상품의 이름를 입력하세요:");
		gName = scan.nextLine();
		if(searchGoods(2, gName, list) != -1) {
			return 180; // 이미등록된 상품명 중복
		}
		if (gName.equals("-1")) {  
			return 120;			
		}

		
		System.out.print("추가할 상품의 가격을 입력하세요:");
		tmp = scan.nextLine();
		if (! IS_NUMBER.matcher(tmp).matches()) {
			return 160; // 숫자가 아닌 가격
		}				
		gPrice = Integer.parseInt(tmp);
		if (gPrice == -1) {
			return 130;			
		} 
		
		System.out.print("추가할 상품의 나라를 입력하세요:");
		gMake = scan.nextLine();
		if (gMake.equals("-1")) {
			return 140;			
		}
		
		Goods_v2 sample = new Goods_v2(gNo,gName, gPrice, gMake);
		list.add(sample);
		
		System.out.println("상품추가 완료!!");
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
		
		System.out.print("수정할 상품의 Serial를 눌러주세요.:");
		serial = scan.nextLine();
		
		if (! IS_NUMBER.matcher(serial).matches()) {
			return 280; // 숫자가 아닌 시리얼 넘버
		}		
		index = searchGoods(1, serial, list);
		
		if (index == -1) {
			return 270; //등록되지 않은 시리얼.
		}
		
		if (!(index >= 0)&&(index < list.size())){
			return 201;
		}
		
		System.out.println("1.시리얼넘버 2.상품명 3.상품가격 4.제조국");
		System.out.println(">초기메뉴로 가시려면 -1을입력해주세요.");
		System.out.print("수정할 메뉴를 선택해주세요(1~4):");
		tmp = scan.nextLine();
		if (! IS_NUMBER.matcher(tmp).matches()) {
			return 292;  // 숫자가 아닌 메뉴
		}			
		
		menu = Integer.parseInt(tmp);
		if (!((menu >=1)&&(menu<=4))){
			return 202;
		}
		
		switch(menu) {
			case 1 : 
				System.out.print("수정할 상품의 Serial을 입력하세요:");
				tmp = scan.nextLine();
				if (! IS_NUMBER.matcher(tmp).matches()) {
					return 290; // 숫자가 아닌 시리얼 넘버
				}			
				if (serial.equals(tmp)) {
					return 293; //수정할 상품의 시리얼과 새로운 시리얼이 같을경우
				}

				gNo = Integer.parseInt(tmp);  
				if (gNo == -1) {              //중간에 나가기
					return 210;			
				}

				nCheck = searchGoods(1, Integer.toString(gNo), list);
				
				if (nCheck != -1) {
					return 250; // 중복된 시리얼 넘버.
				}
					
				list.get(index).setgNo(gNo);
				break;
			case 2 : 
				System.out.print("수정할 상품의 이름를 입력하세요:");
				gName = scan.nextLine();
				if (gName.equals("-1")) {
					return 220;			
				}
				nCheck = searchGoods(2, gName, list);
				
				if (nCheck != -1) {
					return 260; // 중복된 상품명
				}				
				list.get(index).setgName(gName); 
				break;
			case 3 : 
				System.out.print("수정할 상품의 가격을 입력하세요:");
				
				tmp = scan.nextLine();
				if (!IS_NUMBER.matcher(tmp).matches() ) {
					return 291; // 숫자가 아닌 값
				}				
				gPrice = Integer.parseInt(tmp);
				if (gPrice == -1) {
					return 230;			
				}
				list.get(index).setgPrice(gPrice); 
				break;
			case 4 : 
				System.out.print("수정할 상품의 나라를 입력하세요:");
				gMake = scan.nextLine();
				if (gMake.equals("-1")) {
					return 240;			
				}
				list.get(index).setgMake(gMake); 
				break;
		
		}
		
		System.out.println("상품수정 완료!!");
		System.out.println(list.get(index).toString());
		return 0;
	}

	@Override
	public int deleteGoods(ArrayList<Goods_v2> list) {
		int num = 0;
		int index = -1;
		String tmp = null;
		viewGoods(list);
		
		System.out.print("삭제할 상품의 SerialNo를 눌러주세요.:");
		tmp = scan.nextLine();
		
		if (! IS_NUMBER.matcher(tmp).matches()) {
			return 302; // 숫자가 아닌 시리얼
		}				
		num = Integer.parseInt(tmp);
		index = searchGoods(1, Integer.toString(num), list);
		
		if (index == -1) {
			return 301;  //등록되지 않은 시리얼.
		}
		
		if (!(index >= 0)&&(index<list.size())){
			return 300;
		}
		
		list.remove(index);
		
		System.out.println("상품이 삭제되었습니다.");
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
			System.out.println("메뉴를 숫자로 입력해주세요. 초기로 돌아갑니다. (menu:code10)");
			break;
		case 20 :
			System.out.println("메뉴입력 에러.(1~5)사이의 숫자를 입력해주세요. 초기로 돌아갑니다. (menu:code20)");
			break;
		case 110: case 120: case 130: case 140:
			System.out.printf("상품추가를 중단하고 초기메뉴로 돌아갑니다 (add:code: %d)%n", errCode);
			break;
		case 150 :
			System.out.println("시리얼입력에러. 숫자로 입력해주세요. 초기메뉴로 돌아갑니다. (add:code:150)");
			break;
		case 160 :
			System.out.println("가격입력에러. 숫자로 입력해주세요. 초기메뉴로 돌아갑니다. (add:code:160)");
			break;
		case 170 :
			System.out.println("이미 등록된 시리얼입니다. 초기메뉴로 돌아갑니다. (add:code:170)");
			break;
		case 180 : 
			System.out.println("이미 등록된 상품명 초기메뉴로 돌아갑니다. (add:code:180)");
			break;
		case 201 :
			System.out.println("잘못된 번호 입니다. 초기메뉴로 돌아갑니다.  (modify:code201)");
			break;
		case 202 :
			System.out.println("잘못된 메뉴 입니다. 초기메뉴로 돌아갑니다.  (modify:code202)");
			break;
		case 210: case 220: case 230: case 240:
			System.out.printf("상품수정을 중단하고 초기메뉴로 돌아갑니다 (modify:code: %d)%n", errCode);
			break;
		case 250:
			System.out.println("중복된 시리얼넘버 초기메뉴로 돌아갑니다 (modify:code : 250)");
			break;
		case 260:
			System.out.println("중복된 상품명 초기메뉴로 돌아갑니다 (modify:code:260)");
			break;
		case 270:
			System.out.println("등록되지 않은 시리얼 입니다. 초기메뉴로 돌아갑니다. (modify:code:270)");
			break;
		case 280:
			System.out.println("입력에러. 숫자로 입력해주세요. 초기메뉴로 돌아갑니다. (modify:code:280)");
			break;
		case 290:
			System.out.println("입력에러. 숫자로 입력해주세요. 초기메뉴로 돌아갑니다. (modify:code:290)");
			break;
		case 291:
			System.out.println("입력에러. 숫자로 입력해주세요. 초기메뉴로 돌아갑니다. (modify:code:291)");
			break;
		case 292:
			System.out.println("메뉴 입력에러. 숫자로 입력해주세요. 초기메뉴로 돌아갑니다. (modify:code:292)");
			break;
		case 293: 
			System.out.println("현재 사용중인 시리얼과 동일합니다. 초기메뉴로 돌아갑니다. (modify:code:292)");
			break;
		case 300:
			System.out.println("잘못된 번호 입니다. 초기메뉴로 돌아갑니다. (delete:code:300)");
			break;
		case 301:
			System.out.println("등록되지 않은 시리얼. 초기메뉴로 돌아갑니다. (delete:code:301)");
			break;
		case 302:
			System.out.println("시리얼입력 에러. 숫자로 입력해주세요. 초기메뉴로 돌아갑니다. (delete:code:302)");
			break;
		default :
			break;
	}
		
	}

	

}
