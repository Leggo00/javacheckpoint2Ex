package kr.co.checkpoint2;
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

public class Goods_v3 {
	private int gNo;
	private String gName;
	private int gPrice;
	private String gMake;
	
	public Goods_v3() {
		// TODO Auto-generated constructor stub
	}

	public Goods_v3(int gNo, String gName, int gPrice, String gMake) {
		super();
		this.gNo = gNo;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gMake = gMake;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgPrice() {
		return gPrice;
	}

	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}

	public String getgMake() {
		return gMake;
	}

	public void setgMake(String gMake) {
		this.gMake = gMake;
	}

	@Override
	public String toString() {
		return "Goods [gNo=" + gNo + ", gName=" + gName + ", gPrice=" + gPrice + ", gMake=" + gMake + "]";
	}
	
	
	

}
