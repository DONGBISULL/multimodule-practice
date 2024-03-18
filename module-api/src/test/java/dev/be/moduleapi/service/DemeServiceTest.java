package dev.be.moduleapi.service;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import java.io.InputStream;
import java.sql.Connection;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class DemeServiceTest {

    @Autowired
    private DataSource dataSource;

    private Connection connection;
    private IDatabaseConnection iDatabaseConnection;
    private IDataSet flatXmlDataSet;

    @BeforeEach
    void setup() throws Exception {
        connection = dataSource.getConnection();
//        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_database?serverTimezone=Asia/Seoul", "root", "test");
        iDatabaseConnection = new MySqlConnection(connection, "test_database");

        InputStream is = this.getClass().getResourceAsStream("member.xml"); // 테스트용 데이터셋 설정
        flatXmlDataSet = new FlatXmlDataSetBuilder().build(is);
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, flatXmlDataSet); // 테스트용 데이터셋 DB 에 입력
    }


    @AfterEach
    void tearDown() throws Exception {
        // DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection, flatXmlDataSet); // 입력한 데이터셋 삭제
        if (connection != null) {
            connection.close();
        }
        if (iDatabaseConnection != null) {
            iDatabaseConnection.close();
        }
    }
}