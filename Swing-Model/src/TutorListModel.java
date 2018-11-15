import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class TutorListModel implements ListModel<String> {
	private ArrayList<String> data;
	
	public TutorListModel() {
		data = new ArrayList<String>();
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		
	}
	
	@Override
	public void removeListDataListener(ListDataListener arg0) {
		
	}

	@Override
	public String getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}
	
	public void addElement(String s) {
		data.add(s);
	}
	public void removeElement(int index) {
		data.remove(index);
	}
	public void removeElement(String obj) {
		data.remove(obj);
	}

}
