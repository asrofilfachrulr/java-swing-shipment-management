package Helper;

import Model.LoggedAccount;

public class Session {
    private LoggedAccount account;

    Session(){}

    public LoggedAccount getAccount() {
        return account;
    }

    public void setAccount(LoggedAccount acc) {
        account = acc;
    }

    public void deleteSession(){
        account = null;
    }
}
