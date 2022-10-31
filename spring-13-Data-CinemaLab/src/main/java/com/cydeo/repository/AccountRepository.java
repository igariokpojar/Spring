package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state

    List<Account> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value

    List<Account>findAllByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role

    List<Account>findAllByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages

    List<Account> findAllByAgeBetween(Integer age1, Integer age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword

    List<Account>findByAddressStartingWith(String keyword);

    //Write a derived query to sort the list of accounts with age

    List<Account> findByOrderByAgeDesc();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts

    @Query("select a from Account a ")
    List<Account> getAllAccounts();

    //Write a JPQL query to list all admin accounts
     @Query("select a from Account a where a.role = 'admin'")
    List<Account> listAllAdminAccounts( );

    //Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age desc ")
    List<Account> sortAccountWithAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
     @Query(value = "select * from account_details where age <?1",nativeQuery = true)
     List<Account>retrieveAllAccountsByAgeLowerThan(Integer age); // can use with@Param("age") too

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details ad WHERE name ILIKE concat('%', ?1, '%') " +
            "OR country ILIKE concat('%', ?1, '%') " +
            "OR address ILIKE concat('%', ?1, '%') " +
            "OR ad.state ILIKE concat('%', ?1, '%') " +
            "OR city ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Account>retrieveAccountsSpecific(@Param("pattern") String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "select * from account_details where age>?1",nativeQuery = true)
   List<Account>retrieveAccountsWithAge(@Param("age")Integer age);

}
