package vendingmochine.view;

import java.util.ArrayList;
import java.util.Scanner;

import vendingmochine.vo.ProductVO;

public class ProductView {

	ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	private Scanner scan = new Scanner(System.in);
	
	public void displayProducts() {
		int count = 0;
		System.out.println("========Drink Vending Mochine ============");
		for(ProductVO pvo : productList) {
			if(count++ == 0) {
				System.out.println();
			} else {
				System.out.print(pvo.getProductNum() + " : " + pvo.getName() + " [ 가격 : " + pvo.getPrice() + ", 재고량 : " +  pvo.getStockNum() + " ]\n");
			}//if
		}//for
		System.out.println("\n===========================================");
	}
	
	public void inputPurchase() {
		System.out.println("****** Purchase Drink ******");
		System.out.print("구입제품 번호를 입력하세요 : ");
		int productNum = scan().nextInt();
		ProductVO pvo = productList.get(productNum);
		
		if(pvo.getStockNum() > 0) {
			while(true) {
				System.out.println(pvo.getName() + " 제품의 가격 " + pvo.getPrice() + "원 투입하세요.");
				System.out.print("투입할 금액 : ");
				int price = scan().nextInt();
				if(price > pvo.getPrice()) {
					System.out.println("거스름 돈 : " + (price - pvo.getPrice()) + "원 입니다.");
					System.out.println(pvo.getName() + " 제품이 나왔습니다.");
					pvo.setStockNum(pvo.getStockNum()-1); break;
				}else if(price == pvo.getPrice()){
					System.out.println(pvo.getName() + " 제품이 나왔습니다.");
					pvo.setStockNum(pvo.getStockNum()-1); break;
				} else if(price < pvo.getPrice()) {
					System.out.println("잔액이 부족합니다.");
					continue;
				}//while
			}//if
		} else {
			System.out.println("선택하신 제품은 재고가 없습니다.");
		}//if
	}
	
	public Scanner scan() {
		return scan;
	}
	
	public void setProductList(ArrayList<ProductVO> productList) {
		this.productList = productList;
	}
	
}//class
