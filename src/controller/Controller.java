package controller;

import model.Qr;
import view.View;

public class Controller {

	private View view = new View();
	private Qr qr = new Qr();
	
	public Controller () {
		this.run();
	}
	
	public void run() {
		String qr = this.qr.generateCodeQr();
		this.view.print(qr);
	}
	
}
