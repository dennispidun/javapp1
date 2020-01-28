// Blatt 10 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051
package containers;

public class ArrayList extends List {
    
    private Object[] array;
    
    /**
     * Default Konstrukor.
     */
    public ArrayList() {
        this.array = new Object[0];
    }
    
    @Override
    public void add(Object obj) {
        this.add(this.size(), obj);
    }
    
    @Override
    public void remove(Object obj) {
        while (this.at(obj) != -1) {
            this.remove(this.at(obj));
        }
        
    }
    
    @Override
    public int size() {
        return this.array.length;
    }
    
    @Override
    public void add(int pos, Object obj) {
        if (pos >= 0 && pos <= this.size()) {
            Object[] temp = new Object[this.size() + 1];
            
            for (int i = 0; i < pos; i++) {
                temp[i] = this.get(i);
            }
            
            temp[pos] = obj;
            
            for (int i = pos; i < this.size(); i++) {
                temp[i + 1] = this.get(i);
            }
            
            this.array = temp;
        }        
    }
    
    @Override
    public Object get(int pos) {
        Object output = null;
        if (pos >= 0 && pos < this.size()) {
            output = this.array[pos];
        }
        return output;
    }
    
    @Override
    public void remove(int pos) {
        if (pos >= 0 && pos < this.size()) {
            Object[] temp = new Object[this.size() - 1];
            
            for (int i = 0; i < pos; i++) {
                temp[i] = this.get(i);
            }
            
            for (int i = pos; i < temp.length; i++) {
                temp[i] = this.get(i + 1);
            }
            
            this.array = temp;
        }
        
    }
    
    @Override
    public int at(Object obj) {
        int output = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(obj)) {
                output = i;
                break;
            }
        }
        return output;
    }
    
    @Override
    public Object[] toArray() {
        Object[] output = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            output[i] = this.get(i);
        }
        return output;
    }
    
    @Override
    public String toString() {
        String output = "[";
        
        for (int i = 0; i < this.size(); i++) {
            if (i == 0) {
                output += this.get(i).toString();
            } else {
                output += ", " + this.get(i).toString();
            }
        }
        
        output += "]";
        return output;
    }

    /**
     * Neben-Haupteinstiegsmethode, um Programmlogik von ArrayList zu testen.
     * @param args Programmargumente
     */
    public static void main(String[] args) {
        List liste = new ArrayList();
        liste.add("1");
        liste.add("2");
        liste.add("3");
        System.out.println(liste.toString());
        liste.add(2, "X");
        liste.add(4, "X");
        System.out.println(liste.toString());
        liste.remove(0);
        liste.remove("X");
        System.out.println(liste.toString());
    }

}
