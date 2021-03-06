package views;

import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.ControllerBarreHorizontale;
import modele.Modele;

public class ViewBarreHorizontale extends JPanel implements View {
	private Modele modele;
	private JButton tirer;
	private JButton placer;
	
	public ViewBarreHorizontale(Modele modele) {
		this.modele = modele;
		
		tirer = new JButton("Tirer");
		tirer.addActionListener(new ControllerBarreHorizontale(modele, "Tirer"));
		this.add(tirer);
	
		placer = new JButton("Placer");
		placer.addActionListener(new ControllerBarreHorizontale(modele, "Placer"));
		this.add(placer);
		
	}
	
	@Override
	public void update() {
		this.setVisible(modele.estEnJeu());
		// bouton actif si une case est selectionnee et que tous les bateaux sont places et qu'un bateau est selectionne pour tirer et qu'on n'a pas deja tire sur cette case
		tirer.setEnabled(modele.getXTirSelect() >= 0 && modele.bateauxTousPlaces() && modele.getTailleBateauTir() > 0 && modele.estMarque(2, modele.getXTirSelect(), modele.getYTirSelect())== false); 
		placer.setEnabled(modele.getTaillePlacement() >= 2 && modele.getTaillePlacement() <= 5); // bouton actif si un bouton de taille est selectionne
	}

}
