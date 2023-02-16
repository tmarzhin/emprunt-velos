
class Site {

	/* Constantes communes à tous les sites */

	static final int STOCK_INIT = 5;
	static final int STOCK_MAX = 10;
	static final int BORNE_SUP = 8;
	static final int BORNE_INF = 2;

	public int num;
	public static int nbvelos;

	public Site (int numero) {
		this.num=numero;

	}



	public synchronized  void rendreVelo() throws InterruptedException {
		while(nbvelos>=STOCK_MAX){
			wait();
			
		}
		nbvelos++;
		notifyAll();
	}

	public synchronized void empruntVelo() throws InterruptedException {
		while(nbvelos<=0) {
			wait();
		}
		nbvelos--;
		notifyAll();
	}

}
