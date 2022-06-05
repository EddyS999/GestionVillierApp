package vue;

import java.awt.Color;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;



import controleur.Tableau;
import modele.Modele;

public class PanelStatistique extends PanelDeBase
{
	private JPanel unPanel = new JPanel(); 

	public PanelStatistique() 
	{
		super(new Color(225,210,184));

		this.unPanel.setBackground(new Color(225,210,184));
		this.unPanel.setBounds(200, 200, 700, 200);
		this.unPanel.setLayout(new GridLayout(3,1));
		
		int nbFamille = Modele.countFamille (); 
		int nbTypeEvent = Modele.countTypeEvent(); 
		int nbEvent = Modele.countEvent (); 
		int nbTypePresta = Modele.countTypePresta();
		int nbPresta = Modele.countPresta(); 
		
		
		String entetes [] = {"Nombre Famille","Nombre Type Event","Nombre Evenement",
				"Nombre Type Presta", "Nombre Prestation"}; 
		Object matrice [][]= {{nbFamille,nbTypeEvent,nbEvent,nbTypePresta,nbPresta}}; 
		Tableau unTableau = new Tableau (entetes, matrice); 
		JTable uneTable = new JTable(unTableau);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); 
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); 
		for (int i =0; i < uneTable.getColumnCount() ; i++)
		{
			uneTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer); 
		}
		
		JScrollPane uneScroll = new JScrollPane(uneTable); 
		uneScroll.setBounds(40, 40, 500, 500);
		this.unPanel.add(uneScroll);
		
		this.add(this.unPanel); 
		
	}
}
