package Model;

import Helper.KeyHelper;
import Helper.Session;
import Model.Dao.CustomerDao;
import Model.Dao.StaffDao;

import java.sql.SQLException;

public class Guest extends Account{
    public static final int ACCOUNT_CUSTOMER = 0x33;
    public static final int ACCOUNT_STAFF = 0x99;

    public boolean register(){
        return false;
    }

    public LoggedAccount login(String username, String password, int accountType) throws Exception {
        System.out.printf("Password: %s%n", password);
        String hashedPw;
        try {
            hashedPw = KeyHelper.hashSHA256(password);
        } catch (Exception err) {
            System.out.println(err.toString());
            hashedPw = "";
        }

        System.out.printf("Hashed Pw: %s%n%n", hashedPw);

        boolean isCorrect = false;
        try {
            if(accountType == ACCOUNT_STAFF) {
                StaffDao staffDao = new StaffDao();
                isCorrect = staffDao.verifyLogin(username, password);
                checkResultCompare(isCorrect);

                return staffDao.getLoggedStaff(username);
            } else {
                CustomerDao customerDao = new CustomerDao();
                isCorrect = customerDao.verifyLogin(username, password);
                checkResultCompare(isCorrect);

                return customerDao.getLoggedCustomer(username);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private void checkResultCompare(boolean isCorrect) throws Exception {
        if(isCorrect){
            System.out.println("Password is correct");
        } else {
            System.out.println("Password is incorrect");
            throw new Exception("Password or Username is incorrect");
        }
    }
}
