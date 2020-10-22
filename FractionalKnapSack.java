import java.util.*;
import java.util.Collections;

class KnapSack implements Comparable<KnapSack>{
	int weight;
	int value;
	double ratio;
	KnapSack(int w ,int v ){
		this.weight = w ;
		this.value = v ;
		this.ratio = (double)(v/w);
	}
	public int getweight(){
		return weight;
	}
	public int getvalue(){
		return value;
	}
	
	public double getratio(){
		return ratio;
	}
	
	
	public  int compareTo(KnapSack knp){
		 return (int)(knp.ratio-this.ratio);
	}
	
	
	public String toString(){
		return (this.weight+","+this.value+","+ratio);
	}
}
class FractionalKnapSack{
	
	static Double MaximumValue(ArrayList<KnapSack> lst,int weight){
		int currW=0;
		double finalV=0.0;
		for(int i =0 ; i< lst.size();i++){
			if(currW+(lst.get(i).getweight())<=50){
				currW+=lst.get(i).getweight();
				finalV+=lst.get(i).getvalue();
			}
			else{
				double remain = weight-currW;
				finalV+=(lst.get(i).getvalue())*(double)(remain/lst.get(i).getweight());
				//System.out.println(finalV);
				break;
			}
		}
		return finalV;
	}
	 	
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		int no_of_items = sc.nextInt();
		System.out.print("Total_KnapSack_weight:");
		int KnapSack_weight=sc.nextInt();
		 
		ArrayList<KnapSack> lst = new ArrayList<KnapSack>(no_of_items);
		
		
		for(int i=0;i<no_of_items;i++){
			int n  = sc.nextInt();
			int m = sc.nextInt();
			lst.add(new KnapSack(n,m));
		}
		
		/*System.out.println("Unsorted list.************************");
		for(int i=0;i<lst.size();i++){
			System.out.println(lst.get(i));
		}
		*/
		Collections.sort(lst);
		System.out.println("sorted list.************************");
		
		/*for(int i=0;i<lst.size();i++){
			System.out.println(lst.get(i));
		}*/
		System.out.println("Maximum value in the KnapSack is   =  "+MaximumValue(lst,KnapSack_weight));
	}	
}















