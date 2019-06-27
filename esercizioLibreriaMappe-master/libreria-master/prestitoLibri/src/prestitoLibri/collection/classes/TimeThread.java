package prestitoLibri.collection.classes;

public class TimeThread {

	private volatile boolean flag1 = true;
	private volatile boolean flag2 = true;
	
	public void finePrimoThread() {
		flag1=false;
	}
	
	public void fineSecondoThread() {
		flag2=false;
	}

	public void run() {
		//tempo0
		//timer.sleep();	//o qualcosa al suo posto per far si che parta un altro Thread
		while(flag1 && flag2){};
		
		if(!flag1) {
			//tempo1=tempoAttuale-tempo0;
			while(flag2) {}
			//tempo2=tempoAttuale-tempo0;
			//System.out.println("Il metodo 1 ha finito prima");
			//System.out.println("Il processo 1 ha finito in: " + tempo1);
			//System.out.println("Il processo 2 ha finito in: " + tempo2);
		}
		
		if(!flag2) {
			//tempo2=tempoAttuale-tempo0;
			while(flag1) {}
			//tempo1=tempoAttuale-tempo0;
			//System.out.println("Il metodo 2 ha finito prima");
			//System.out.println("Il processo 1 ha finito in: " + tempo1);
			//System.out.println("Il processo 2 ha finito in: " + tempo2);
		}
	}
	
	
	
	
}
