
public class Camion {

	private Site[] sites;
	private static int nbVelosEnStock;
	
	public Camion(Site[]site) {
		this.sites=site;
	}

	
	public Camion(Site[]site, int nbvelos) {
		this.nbVelosEnStock=nbvelos;
		this.sites=site;
	}

	public static void stockVelo() {
		nbVelosEnStock++;
	}

	public static void destockVelo() {
		nbVelosEnStock--;
	}

	public synchronized void veloEnTrop()  {
		int diff=Site.nbvelos - Site.BORNE_SUP;
		for(int i=0;i<diff;i++) {
			Camion.stockVelo();
			//Site.empruntVelo(); 
		}

	}

	public synchronized void veloEnManque() {
		int diff=Site.BORNE_INF - Site.nbvelos;
		if(nbVelosEnStock<diff) {
			for(int i=0;i<nbVelosEnStock;i++) {
				Camion.destockVelo();
				//Site.rendreVelo();
			}
		}
		else {
			for(int i=0;i<diff;i++) {
				Camion.destockVelo();
				//Site.rendreVelo();
			}
		}
	}

	public void difference() {
		if(Site.nbvelos<=Site.BORNE_INF) {
			veloEnManque();
		}
		else if(Site.nbvelos>=Site.BORNE_SUP){
			veloEnTrop();
		}
	}
	
	public void seDeplace() {
		for(int i=0;i<this.sites.length;i++) {
			this.difference();
		}
	}
	
	public void print() {
		System.out.print("Le camion possède " + nbVelosEnStock+" vélos.");
	}

}
