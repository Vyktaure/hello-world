package chicstyle.tableaux;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabExpedition2 extends AbstractTableModel{

	private final List<TabExpedition1> infos = new ArrayList<TabExpedition1>();
	 
    private final String[] entetes = {"Taille","Quantité","Restant","Total"};
 
    public TabExpedition2() {
        super();
 
        infos.add(new TabExpedition1("30","","",""));
        infos.add(new TabExpedition1("32","","",""));
        infos.add(new TabExpedition1("34","","",""));
        infos.add(new TabExpedition1("36","","",""));
        infos.add(new TabExpedition1("38","","",""));
        infos.add(new TabExpedition1("40","","",""));
        infos.add(new TabExpedition1("42","","",""));
        infos.add(new TabExpedition1("44","","",""));
        infos.add(new TabExpedition1("46","","",""));
        infos.add(new TabExpedition1("48","","",""));
        
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	if (columnIndex == 0 || columnIndex == 2 || columnIndex == 3) return false;
    	return true; //Toutes les cellules éditables
    }
     
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue != null){
            TabExpedition1 info = infos.get(rowIndex);
     
            switch(columnIndex){
                case 0:
                    info.setTaille((String)aValue);
                    break;
                case 1:
                    info.setQuantite((String)aValue);
                    break;
                case 2:
                    info.setReste((String)aValue);
                    break;
                case 3:
                    info.setTotal((String)aValue);
                    break;
            }
        }
    }
    @Override
    public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            default:
                return Object.class;
        }
    }
 
    public int getRowCount() {
        return infos.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return infos.get(rowIndex).getTaille();
            case 1:
                return infos.get(rowIndex).getQuantite();
            case 2:
                return infos.get(rowIndex).getReste();
            case 3:
                return infos.get(rowIndex).getTotal();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void addAmi(TabExpedition1 info) {
        infos.add(info);
 
        fireTableRowsInserted(infos.size() -1, infos.size() -1);
    }
 
    public void removeAmi(int rowIndex) {
        infos.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
