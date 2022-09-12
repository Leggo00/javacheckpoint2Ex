/*
 * AddGoods(list);
 */
package kr.co.checkpoint2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import kr.co.checkpoint.Goods_v2;

public interface GoodsMakable_v3 {
	static Scanner scan = new Scanner(System.in);
	static final Pattern IS_NUMBER = Pattern.compile("^-?\\d*\\.{0,1}\\d+$");	
	
	void init(ArrayList<Goods_v2> list); 
	
	int viewMenu();
	void viewGoods(ArrayList<Goods_v2> list);

	int addGoods(ArrayList<Goods_v2> list);
	int modifyGoods(ArrayList<Goods_v2> list);
	int deleteGoods(ArrayList<Goods_v2> list);
	int searchGoods(int nMode, String nSearch, ArrayList<Goods_v2> list);
	void errorCheck(int errCode);
}
