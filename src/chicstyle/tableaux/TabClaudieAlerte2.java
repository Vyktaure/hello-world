package chicstyle.tableaux;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabClaudieAlerte2 extends AbstractTableModel {

	private final List<TabClaudieAlerte1> infos = new ArrayList<TabClaudieAlerte1>();
	 
    private final String[] entetes = {"Source", "Message"};
 
    public TabClaudieAlerte2() {
        super();
 
        infos.add(new TabClaudieAlerte1("", ""));
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //Toutes les cellules �ditables
    }
     
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue != null){
            TabClaudieAlerte1 info = infos.get(rowIndex);
     
            switch(columnIndex){
                case 0:
                    info.setSource((String)aValue);
                    break;
                case 1:
                    info.setMessage((String)aValue);
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
                return infos.get(rowIndex).getSource();
            case 1:
                return infos.get(rowIndex).getMessage();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void addAmi(TabClaudieAlerte1 info) {
        infos.add(info);
 
        fireTableRowsInserted(infos.size() -1, infos.size() -1);
    }
 
    public void removeAmi(int rowIndex) {
        infos.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
