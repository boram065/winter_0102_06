package vendingmochine.controller;

import java.util.ArrayList;

import vendingmochine.view.ProductView;
import vendingmochine.vo.ProductDAO;
import vendingmochine.vo.ProductVO;

public class ProductController {
	
	public static final int YES = 1;
	public static final int NO = 0;
	
	ProductDAO dao;
	
	public static void main(String[] args) {
		ProductController controller = new ProductController();
		controller.dao = new ProductDAO();
		String[] names = {"콜라", "사이다", "밀키스", "알로에", "처음처럼", "참이슬", "진로", "테라", "카스"};
		int[] prices = {1000, 1000, 1500, 2000, 1500, 1600, 3000, 2000, 2000};
		ProductVO pvo = null;
		ArrayList<ProductVO> productList = controller.dao.select();
		for(int i = 0; i < names.length; i++) {
			pvo = new ProductVO();
			pvo.setName(names[i]);
			pvo.setPrice(prices[i]);
			pvo.setProductNum(i);
			pvo.setStockNum(10);
			productList.add(pvo);
		}
		
		//화면 출력
		ProductView view = new ProductView();
		view.setProductList(productList);
		view.displayProducts();
		
		//자판기 구매 화면
		view.scan();
		while(true) {
			view.inputPurchase();
			System.out.print("계속 구매하시겠습니까?(Yes:1 / No:0) : ");
			int answer = view.scan().nextInt();
			if(answer == YES) {
				view.displayProducts();
			}else if(answer == NO){
				System.out.println("종료되었습니다.");
				break;
			}//if
		}//while
		view.scan().close();
	}
	
}//class
