/*
 * 
[상품정보] Goods
- 상품번호,상품명,가격,제조국가
- gNo, gName, gPrice, gMake
- 생성자 4개 필드 작성
- getter, setter작성
- tostring작성
----------
GoodsControl.java
1 초기화 하여 배열에 상품 5개 등록함

[메뉴]
1.상품추가 2.상품수정. 3. 상품삭제
4.상품보기 5. 종료

상품추가/수정/삭제하기 전 있는 품목인지 파악후 동작

필요한 메소스드들 : 상품추가하기, 상품수정하기, 상품 삭제하기, 상품보기, 상품검색

 */

package kr.co.checkpoint2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import kr.co.checkpoint.Goods_v2;

public class GoodsControl_v3 {

	public static void main(String[] args) {
		int errCode = 0;
		int nSelectMenu = 0;
		ArrayList<Goods_v2> list = new ArrayList<Goods_v2>();
		GoodsMethod_v3 method    = new GoodsMethod_v3();

		method.init(list);                                           //초기화
		
		while (nSelectMenu != 5) {
			nSelectMenu = method.viewMenu();                         //메뉴출력
			
			switch(nSelectMenu) {
				case 1 :
					errCode = method.addGoods(list);                 //상품추가
					method.errorCheck(errCode);                      //에러관리
					break;
				case 2 :
					errCode = method.modifyGoods(list);              //상품수정
					method.errorCheck(errCode);                      //에러관리
					break;
				case 3 :
					errCode = method.deleteGoods(list);              //상품삭제
					method.errorCheck(errCode);                      //에러관리
					break;
				case 4:
					method.viewGoods(list);                          //상품보기
					break;
				case 5: 
					System.out.println("프로그램을 종료합니다. bye~");    //프로그램종료
					break;
				case 100 : 
					
					break;
					
				default:
					break;
				
			}
		}

	}

}
