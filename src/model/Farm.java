package model;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;

public class Farm {

	public Tasks tasks =new Tasks();
	final public int maxRow=6;
	final public int maxCol=6;
	public int turn_cnt =0;
	public WateringSystem WS = new WateringSystem();
	public vehicle truck = new vehicle();
	public ArrayList <Domestics> AnimalInFarm = new ArrayList<>();
	public ArrayList <Wilds> WildesInFarm = new ArrayList<>();
	public ArrayList <Workshop> workshops = new ArrayList<>();
	public ArrayList <Cat> cats = new ArrayList<>();
	public ArrayList <Dog> dogs = new ArrayList<>();
	public warehouse farmWarehouse = new warehouse();
	public ArrayList<Product> [][] product_map = new ArrayList[maxCol+1][maxRow+1];
	public int [][] grass = new int[maxCol+1][maxRow+1];
	public int coins;


	public Farm(Tasks tasks, int user_coin) {
		for (int i = 0; i <maxCol+1 ; i++) {
			for (int j = 0; j <maxRow+1 ; j++) {
				product_map[i][j] = new ArrayList<>();
			}
		}

		this.tasks = tasks;
		coins = tasks.init_coin+user_coin;
	}

	public int build (WorkshopList label){ // 1= not enough coin   2= already exist
		if (coins< label.cost[0])
			return 1;
		boolean already_exist = false;

		for (Workshop w:workshops) {
			if (w.name==label){
				already_exist = true;
				break;
			}
		}
		if (already_exist)
			return 2;

		coins -= label.cost[0];
		workshops.add(new Workshop(label));
		return  0;
	}

	public int upgrade (WorkshopList label){ //  1= not enough coin   2= doesn't exist

		if (coins< label.cost[1])
			return 1;

		for (Workshop w:workshops) {
			if (w.name==label){
				w.upgrade(this);
				return 0;
			}
		}
		return 2;


	}

	public int well (){ // 0 -> ready to use       1-> filling in progress
		return WS.filling();
	}

	public boolean plant (int x , int y){
		if (WS.using()) {
			grass[x][y]++;
			return true;
		}
		return false;
	}

	public int pick_up (int x , int y){  // 1= empty    2= no space
		if (product_map[x][y].isEmpty())
			return 1;

		if (farmWarehouse.add(product_map[x][y].get(0).ProductName)) {
			product_map[x][y].remove(0);
			return 0;
		}
		return 2;
	}

	public boolean buy (DomesticAnimal animalLabel){
		if (coins>=animalLabel.cost){
			coins-= animalLabel.cost;
			AnimalInFarm.add(new Domestics(animalLabel));
			return true;
		}
		else return false;

	}

	public boolean buy_cat (){
		if (coins>=Cat.price){
			coins-= Cat.price;
			cats.add(new Cat());
			return true;
		}
		else return false;
	}

	public boolean buy_dog (){
		if (coins>=Dog.price){
			coins-= Dog.price;
			dogs.add(new Dog());
			return true;
		}
		else return false;

	}

	public int work(WorkshopList label){ //1= working 2= not enough  3= doesn't exist
		for (Workshop w:workshops) {
			if(w.name==label){
				return w.work(farmWarehouse);
			}
		}
		return 3;
	}

	public boolean cage (int x,int y){
		Iterator <Wilds> wild_itr  = WildesInFarm.iterator();
		Wilds temporary_wild ;
		while (wild_itr.hasNext()){
			temporary_wild = wild_itr.next();
			if ((temporary_wild.y_position==y)&&(temporary_wild.x_position==x)) {
				if (temporary_wild.cage()){
					product_map[x][y].add(new Product(x,y,temporary_wild.name.caged_form));
					wild_itr.remove();
				}
				return true;
			}

		}
		return  false;
	}

	public int truck_load (ProductList label){// 3= doesn't exist
		if (!farmWarehouse.existingProduct.containsKey(label))
			return 3;

		switch (truck.loading(label)){

			case 0:
				if(farmWarehouse.remove(label)) {
					return 0;
				}else {
					truck.price-=label.price;
					truck.Loaded-=label.housingSpace;
					return 3;
				}
			case 1:
				return 1;
			case 2:
				return 2;
		}
		return 4;
	}
	public int truck_unload (ProductList label){ // 1=not present 2=doesnt exist 3= full warehouse
		if ((farmWarehouse.maxCapacity- farmWarehouse.capacity)<=0)
			return 3;

		switch (truck.remove(label)){

			case 0:
				if(farmWarehouse.add(label)) {
					return 0;
				}else {
					truck.Loaded+=label.housingSpace;
					truck.price+= label.price;

					return 3;

				}
			case 1:
				return 1;
			case 2:
				return 2;
		}
		return 4;
	}
	public boolean truck_go (){
		return truck.go();
	}

	// pro -> cat -> dom -> work -> wild -> dog
	public  boolean turn (){ //
		turn_cnt ++;
		turn_products();
		turn_cats();
		turn_domestics();
		turn_workshops();
		int truck_coin= truck.move();
		if (truck_coin>0)
			coins+=truck_coin;

		WS.turn();
 		turn_wildes();
 		tasks.addWildAnimal(this);
 		turn_dogs();

 		return tasks.checking(this);

	}

private void turn_domestics (){
	Iterator <Domestics> domestic_itr  = AnimalInFarm.iterator();
	Domestics temporary_dom ;
	while (domestic_itr.hasNext()){
		temporary_dom = domestic_itr.next();
		temporary_dom.move(grass,maxRow,maxCol);
		temporary_dom.eating(grass);
		temporary_dom.turn(this);
		if (!temporary_dom.decreasingLife_isalive())
			domestic_itr.remove();

	}
}

private void turn_wildes (){
	Iterator <Wilds> wild_itr  = WildesInFarm.iterator();
	Wilds temporary_wild ;
	while (wild_itr.hasNext()){
		temporary_wild = wild_itr.next();
		temporary_wild.move(this);
	}

}

private void turn_products (){

	// ======= iterate through all uncollected products ======
	Iterator <Product> product_itr;
	Product temporary_pro;
	for (int i = 0; i < maxCol; i++) {
		for (int j = 0; j < maxRow; j++) {
			product_itr = product_map[i][j].iterator();
			while (product_itr.hasNext()){
				temporary_pro = product_itr.next();
				if (temporary_pro.turn_and_is_expired())
					product_itr.remove();

			}
		}
	}

}

private void turn_workshops() {
	// ========= iterate through all workshops =============
	Iterator <Workshop> workshop_itr = workshops.iterator();
	Workshop temporary_workshop;
	while (workshop_itr.hasNext()){
		temporary_workshop = workshop_itr.next();
		temporary_workshop.turn(this);
	}

}

private void turn_cats (){
	for (Cat c: cats) {
		c.move(product_map,maxCol,maxRow);
		c.collect(this);
	}
}

private void turn_dogs (){
	Iterator <Dog> dog_itr  = dogs.iterator();
	Dog temporary_dog ;
	while (dog_itr.hasNext()){
		temporary_dog = dog_itr.next();
		temporary_dog.move(maxCol,maxRow);
		if (temporary_dog.KillingWild(WildesInFarm))
			dog_itr.remove();

	}
}


//wild -> dog
// pro -> dom , work

// pro -> cat -> dom -> work -> wild -> dog


	/*
	WateringSystem WS;
	vehicle truck;
	ArrayList <Domestics> AnimalInFarm ;
	ArrayList <Workshop> workshops;
	warehouse farmWarehouse;
	ArrayList<Product> [][] product_map = new ArrayList[maxRow][maxCol];
	int [][] grass;
	int coins;

*/












}
