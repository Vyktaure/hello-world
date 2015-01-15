package chicstyle.abstraction;

import java.util.Observable;
import java.util.Vector;


public abstract class ChicEtStyle extends Observable {

protected Piece pieceCourante;
	
	public static final Integer CHANGEMENT_PIECE_COURANT = new Integer(1);
	public static final Integer CHANGEMENT_COMPETITION_COURANTE = new Integer(2);
	public static final Integer CHANGEMENT_ATHLETE_COURANT = new Integer(3);
	
	public static final Integer CHANGEMENT_PIECES = new Integer(4);
	public static final Integer CHANGEMENT_COMPETITIONS = new Integer(5);
	public static final Integer CHANGEMENT_ATHLETES = new Integer(6);
	
	public abstract void savePiece(Piece p, boolean creation);
	public abstract Vector<String> findAllClients();
	public abstract Vector<String> findAllModelesClient(String client);
	public abstract Vector<String> findAllTissusModele(String modele);
	public abstract Vector<String> findAllCouleursTissu(String tissu);
	public abstract Piece findPiece(String client, String modele, String tissu, String couleur);
	public abstract Piece findPiece(String id_piece);
	

	public ChicEtStyle() {
		super();
		this.pieceCourante = new Piece();
	}
	
	public Piece getPieceCourante(){
		return this.pieceCourante;
	}
	
	public void setPieceCourante(Piece selectedPiece) {
		if (this.pieceCourante != null
				&& !this.pieceCourante.equals(selectedPiece)
				|| (selectedPiece != null && !selectedPiece
						.equals(this.pieceCourante))) {
			this.pieceCourante = selectedPiece;
			this.setChanged();
			this.notifyObservers(CHANGEMENT_PIECE_COURANT);
		}
	}
}
