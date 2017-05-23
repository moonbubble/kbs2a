package tsp.scherm;

import java.util.ArrayList;
import java.util.List;

import domeinmodel.Product;

public class NearestNeighbour implements Functies {
	private List<Product> orderList;
	private List<Product> route;
	private int stappen;
	private Product goeie;
	private int temp;

	public NearestNeighbour(List<Product> list) {
		this.orderList = list;
		route = new ArrayList<Product>();
	}

	public void voegProductToeAanRoute(Product p) {
		this.route.add(p);
	}

	public void printRoute() {
		for (Product p : route) {
			System.out.println(p.getLocatie());
		}
	}

	public void printOrder() {
		for (Product p : orderList) {
			System.out.println(p.getLocatie());
		}
	}

	private int routeBerekenen(Product bp, Product vp) {
		stappen = bp.meetAfstand(vp);
		return stappen;
	}

	public List<Product> algoritme() {
		goeie = orderList.get(0);
		while (orderList.size() > 0) {
			voegProductToeAanRoute(goeie);
			orderList.remove(goeie);
			Product kruisje = goeie;
			// System.out.println(
			// "(" + kruisje.getLocatie() + ") toegevoegd aan route en
			// verwijderd uit order");
			temp = 1000;
			for (int i = 0; i < orderList.size(); i++) {
				Product rondje = orderList.get(i);
				routeBerekenen(kruisje, rondje);
				if (stappen < temp) {
					temp = stappen;
					goeie = rondje;
				}
			}
		}
		return route;
	}
}