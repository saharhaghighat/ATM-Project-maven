package com.none.dao;

import com.none.domain.Account;
import com.none.domain.Enum.AccountType;
import com.none.utill.Method;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDao extends DaoImplement<Account> {
    private final String FIND_BY_ID = "SELECT * FROM Account WHERE Account_id=?";

    private final String FIND_ALL = "SELECT * FROM Account ";

    private final String INSERT = "Insert Into Account(Account_number,Password,Balance,User_id,Card_id) VALUES (?,?,?,?)";

    private final String UPDATE = "UPDATE Account SET Account_number=?,Password=?,Balance=?,USer_id=?,Card_id=? WHERE Account_id=?";

    private final String DELETE = "DELETE FROM Account WHERE Account_id=?";

    private final String FIND_BY_ACCOUNT_NUMBER = "SELECT * Account WHERE Account_id=?";


    private final String CHANGE_BALANCE = "UPDATE Account SET Balance=? WHERE Account_id=?";


    public Optional findById(Integer id) {
        Optional<Account> account = Optional.empty();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account1 = new Account(resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), AccountType.valueOf(resultSet.getString(5)));
                account1.setId(id);
                account = Optional.of(account1);
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        return account;
    }

    @Override
    public List getAll() {
        List<Account> accounts = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account1 = new Account(resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), AccountType.valueOf(resultSet.getString(5)));
                account1.setId(resultSet.getInt(1));
                accounts.add(account1);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;

    }


    @Override
    public void save(Account account) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getUser().getId());
            preparedStatement.setInt(5, account.getCard().getId());

            int resultSet = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void update(Integer id, Account account) {


    }

    @Override
    public void delete(Account account) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, account.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Account> FindByAccount(String AccNumb) {
        Optional<Account> account = Optional.empty();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ACCOUNT_NUMBER)) {
            preparedStatement.setString(1, AccNumb);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account1 = new Account(resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), AccountType.valueOf(resultSet.getString(5)));
                account1.setAccountNumber(AccNumb);
                account = Optional.of(account1);
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        return account;
    }

    public void changeBalance(Integer id, Double balance) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_BALANCE)) {

            preparedStatement.setDouble(1, balance);
            preparedStatement.setInt(2, id);
            Method.print("Balance Changed!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}


