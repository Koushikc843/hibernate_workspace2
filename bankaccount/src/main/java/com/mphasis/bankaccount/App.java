package com.mphasis.bankaccount;

import org.hibernate.Session;
import com.mphasis.bankaccont.model.BankAccount;
import com.mphasis.bankaccont.model.Currency;
import com.mphasis.bankaccont.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Create and persist two accounts
        BankAccount account1 = new BankAccount();
        account1.setAccountNumber("ACC001");
        account1.setAccntHolderName("Alice Smith");
        account1.setBalance(1500.0000);
        account1.setCurrency(new Currency("USD", "$", "en-US"));

        BankAccount account2 = new BankAccount();
        account2.setAccountNumber("ACC002");
        account2.setAccntHolderName("Bob Johnson");
        account2.setBalance(2500);
        account2.setCurrency(new Currency("Rs", "$", "rupees"));

        session.persist(account1);
        session.persist(account2);

        // Retrieve accounts
        BankAccount retrievedAcc1 = session.get(BankAccount.class, "ACC001");
        BankAccount retrievedAcc2 = session.get(BankAccount.class, "ACC002");

        System.out.println(retrievedAcc1.getAccntHolderName() + ": " +
                retrievedAcc1.getCurrency().getCurrency() +
                retrievedAcc1.getBalance());

        // Transfer 500 from Bob to Alice
        retrievedAcc1.setBalance(
                retrievedAcc1.setBalance().getBalance(+500);
        );

        retrievedAcc2.setBalance(
                retrievedAcc2.getBalance().subtract("500")
        );

        session.getTransaction().commit();
        session.close();

        System.out.println("Done!");
    }
}