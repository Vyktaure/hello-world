package chicstyle.tableaux;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabDirectionProduitsFinis2 extends AbstractTableModel{

	private final List<TabDirectionProduitsFinis1> infos = new ArrayList<TabDirectionProduitsFinis1>();
	 
    private final String[] entetes = {"Taille","Quantité houssée", "Quantité expédiéé", "Total", "Différence"};
 
    public TabDirectionProduitsFinis2() {
        super();
 
        infos.add(new TabDirectionProduitsFinis1("30","","","",""));
        infos.add(new TabDirectionProduitsFinis1("32","","","",""));
        infos.add(new TabDirectionProduitsFinis1("34","","","",""));
        infos.add(new TabDirectionProduitsFinis1("36","","","",""));
        infos.add(new TabDirectionProduitsFinis1("38","","","",""));
        infos.add(new TabDirectionProduitsFinis1("40","","","",""));
        infos.add(new TabDirectionProduitsFinis1("42","","","",""));
        infos.add(new TabDirectionProduitsFinis1("44","","","",""));
        infos.add(new TabDirectionProduitsFinis1("46","","","",""));
        infos.add(new TabDirectionProduitsFinis1("48","","","",""));
        
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue != null){
            TabDirectionProduitsFinis1 info = infos.get(rowIndex);
     
            switch(columnIndex){
                case 0:
                    info.setTaille((String)aValue);
                    break;
                case 1:
                    info.setHousse((String)aValue);
                    break;
                case 2:
                    info.setExpedie((String)aValue);
                    break;
                case 3:
                    info.setTotal((String)aValue);
                    break;
                case 4:
                    info.setDiff((String)aValue);
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
                return infos.get(rowIndex).getHousse();
            case 2:
                return infos.get(rowIndex).getExpedie();
            case 3:
                return infos.get(rowIndex).getTotal();
            case 4:
            	return infos.get(rowIndex).getDiff();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void addAmi(TabDirectionProduitsFinis1 info) {
        infos.add(info);
 
        fireTableRowsInserted(infos.size() -1, infos.size() -1);
    }
 
    public void removeAmi(int rowIndex) {
        infos.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
