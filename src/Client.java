
public class Client extends Thread{

	private Site sitedepart;
	private Site sitearrivée;

	public Client (Site sitedep, Site sitearr) {
		this.sitedepart=sitedep;
		this.sitearrivée=sitearr;
	}


	public synchronized void emprunt() throws InterruptedException{
		sitedepart.empruntVelo();
	}

	public synchronized void rendu() throws InterruptedException{
		sitearrivée.rendreVelo();
	}
	
	public void run() {
        
			
    }
}
