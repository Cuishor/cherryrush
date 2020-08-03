package cherryrush;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import source.actor.Cherry;
import source.actor.Monster;

public class Board extends JPanel {
	private static final int width = 600;
	private static final int height = 700;
	private static final int lines = 7;
	private static final int columns = 6;
	private static final int scale = 100;
	private static final int centeringValue = 20;
	private Rectangle[][] structure = new Rectangle[lines][columns];
	private Monster monster;
	private List<Cherry> cherries = new ArrayList<>();
	private static int cherryId = 0;
	private Cherry[] selectedCherries = new Cherry[5];
}
