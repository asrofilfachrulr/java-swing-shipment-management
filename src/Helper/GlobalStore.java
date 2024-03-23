package Helper;

import Model.LoggedAccount;

public class GlobalStore {
    private LoggedAccount account;
    private int accountType;

    public GlobalStore(){}

    public LoggedAccount getAccount() {
        return account;
    }

    public void setAccount(LoggedAccount account) {
        this.account = account;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}
