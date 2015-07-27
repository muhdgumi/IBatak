package com.qoantum.springmvc.dao;

import com.qoantum.springmvc.configuration.HibernateTestConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

import javax.sql.DataSource;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/07/2015
 */
@ContextConfiguration(classes = { HibernateTestConfig.class })
public abstract class TestDaoImpl extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    DataSource dataSource;

    @BeforeMethod
    public void setUp() throws Exception {
        IDatabaseConnection databaseConnection = new DatabaseDataSourceConnection(dataSource);
        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, getDataSet());
    }

    protected abstract IDataSet getDataSet() throws Exception;
}
