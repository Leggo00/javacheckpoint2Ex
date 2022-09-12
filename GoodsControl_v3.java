/*
 * 
[��ǰ����] Goods
- ��ǰ��ȣ,��ǰ��,����,��������
- gNo, gName, gPrice, gMake
- ������ 4�� �ʵ� �ۼ�
- getter, setter�ۼ�
- tostring�ۼ�
----------
GoodsControl.java
1 �ʱ�ȭ �Ͽ� �迭�� ��ǰ 5�� �����

[�޴�]
1.��ǰ�߰� 2.��ǰ����. 3. ��ǰ����
4.��ǰ���� 5. ����

��ǰ�߰�/����/�����ϱ� �� �ִ� ǰ������ �ľ��� ����

�ʿ��� �޼ҽ���� : ��ǰ�߰��ϱ�, ��ǰ�����ϱ�, ��ǰ �����ϱ�, ��ǰ����, ��ǰ�˻�

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

		method.init(list);                                           //�ʱ�ȭ
		
		while (nSelectMenu != 5) {
			nSelectMenu = method.viewMenu();                         //�޴����
			
			switch(nSelectMenu) {
				case 1 :
					errCode = method.addGoods(list);                 //��ǰ�߰�
					method.errorCheck(errCode);                      //��������
					break;
				case 2 :
					errCode = method.modifyGoods(list);              //��ǰ����
					method.errorCheck(errCode);                      //��������
					break;
				case 3 :
					errCode = method.deleteGoods(list);              //��ǰ����
					method.errorCheck(errCode);                      //��������
					break;
				case 4:
					method.viewGoods(list);                          //��ǰ����
					break;
				case 5: 
					System.out.println("���α׷��� �����մϴ�. bye~");    //���α׷�����
					break;
				case 100 : 
					
					break;
					
				default:
					break;
				
			}
		}

	}

}
