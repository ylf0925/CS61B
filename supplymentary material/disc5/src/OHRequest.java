public class OHRequest {

    public String description;
    public String name;
    public OHRequest next;

    public OHRequest(String des, String name, OHRequest nxt) {
        description = des;
        this.name = name;
        next = nxt;
    }

}