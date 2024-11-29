package CheckBalanceGUI;

import javax.swing.RowFilter;

public class MyRowFilter extends RowFilter<Object, Object> {
    private String searchText;

    public MyRowFilter(String searchText) {
        this.searchText = searchText.toLowerCase();
    }

    @Override
    public boolean include(Entry<? extends Object, ? extends Object> entry) {
        for (int i = 0; i < entry.getValueCount(); i++) {
            if (entry.getStringValue(i).toLowerCase().contains(searchText)) {
                return true; // Include row if any column contains the search text
            }
        }
        return false; // Exclude row otherwise
    }
}
