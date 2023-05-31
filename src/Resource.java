import java.util.HashMap;

public class Resource {

    private HashMap<String, String> strings;

    public Resource() {
        this.strings = new HashMap<>();
    }

    public void addString(String key, String value){
        this.strings.put(key, value);
    }


    public HashMap<String, String> getStrings() {
        return strings;
    }

    public void setStrings(HashMap<String, String> strings) {
        this.strings = strings;
    }
}
