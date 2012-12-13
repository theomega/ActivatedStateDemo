package de.dbruhn.android.activatedstatedemo.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent {

    public static class DummyItem {

        public String id;
        public String content;
        public String subcontent;

        public DummyItem(String id, String content, String subcontent) {
            this.id = id;
            this.content = content;
            this.subcontent = subcontent;
        }

        @Override
        public String toString() {
            return content;
        }
        
        public String getSubContent() {
        	return subcontent;
        }
    }

    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        addItem(new DummyItem("1", "Germany", "Europe"));
        addItem(new DummyItem("2", "Italy", "Europe"));
        addItem(new DummyItem("3", "India", "Asia"));
        addItem(new DummyItem("4", "China", "Asia"));       
        addItem(new DummyItem("5", "Russia", "Asia"));
        addItem(new DummyItem("6", "Canada", "North America"));
    
        addItem(new DummyItem("7", "United States", "North America"));
        addItem(new DummyItem("8", "Brasil", "South America"));       
        addItem(new DummyItem("9", "Chile", "South America"));
        addItem(new DummyItem("10", "Equador", "South America"));
    }
    

    
    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
}
