package Helper;

public class Session {
    private static Session instance;

    private Session(){}

    public static Session getInstance() {
        return instance;
    }

    public static void newInstance() {
        instance = new Session();
    }

    public static void deleteInstance(){
        instance = null;
    }
}
