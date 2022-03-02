package com.techgem.account.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.techgem.account.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AccountRepository {

    Logger logger = LoggerFactory.getLogger(AccountRepository.class);

    @Resource(name = "dynamoDBMapper")
    DynamoDBMapper dbMapper;

    public List<Account> getAllAccount() {
        return dbMapper.scan(Account.class, new DynamoDBScanExpression());
    }

    public void addAccount(Account account) {
        dbMapper.save(account);
        logger.info("Account Added : "+account.getId());
    }

    public void deleteAccount(Account account) {
        dbMapper.delete(account);
        logger.info("Account delete : "+account.getId());
    }

}
