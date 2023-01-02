package vendingmochine.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vendingmochine.view.ProductView;
import vendingmochine.vo.ProductDAO;
import vendingmochine.vo.ProductVO;

public class ProductController extends JFrame{
	ArrayList<ProductVO> productList;
	
	public ProductController() {
		//화면 출력
		ProductView view = new ProductView();
		fullProduct();
		view.setProductList(productList);
		JPanel jpC = view.displayProducts();
		add(jpC, "Center");
		
		setTitle("음료 자판기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 50, 600, 600);
		setVisible(true);
	}
	
	public void fullProduct() {
		//자판기 제품 채우기
		ProductDAO dao = new ProductDAO();
		String[] names = {"콜라", "사이다", "밀키스", "알로에", "처음처럼", "참이슬", "이슬톡톡", "테라", "카스"};
		int[] prices = {1000, 1000, 1500, 2000, 1500, 1600, 3000, 2000, 2000};
		ProductVO pvo = null;
		productList = dao.select();
		for(int i = 0; i < names.length; i++) {
			pvo = new ProductVO();
			pvo.setName(names[i]);
			pvo.setPrice(prices[i]);
			pvo.setProductNum(i);
			pvo.setStockNum(10);
			pvo.setImageName("drink" + i);
			productList.add(pvo);
		}//for
	}
	
	public static final int YES = 1;
	public static final int NO = 0;
	
	public static void main(String[] args) {
		new ProductController();
	}
	
}//class
