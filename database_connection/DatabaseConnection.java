package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DatabaseConnection {
    
    public static void main(String[] args) {
        
        //h2 jdbc 드라이버가 있는지 확인
        try {
            Class.forName("org.h2.Driver");

            // DB Connection 정보 구성
            // DataBaseType은 나중에 Enum으로 만들면 좋을것 같다.
            // 1.메모리 기반 h2db 접속 정보 세팅 
            // DatabaseConnectInfo databaseConnectInfoH2dbMemory = DatabaseConnectInfo.builder()
            //     .databaseType("H2DB")     // ORACLE, MARIADB H2DB 
            //     .url("jdbc:h2:mem:test;MODE=MySQL;")
            //     .schema("")
            //     .userName("sa")
            //     .password("")
            //     .encodingType("")
            //     .build();

            DatabaseConnectInfo databaseConnectInfoH2dbFile = DatabaseConnectInfo.builder()
                .databaseType("H2DB")     // ORACLE, MARIADB H2DB 
                .url("jdbc:h2:file:./database_connection/test;MODE=MySQL;")
                .schema("")
                .userName("sa")
                .password("")
                .encodingType("")
                .build();

            // 정보를 바탕으로 Connection 연결
            Connection connection = DriverManager.getConnection(databaseConnectInfoH2dbFile.getUrl(), databaseConnectInfoH2dbFile.getUserName(), databaseConnectInfoH2dbFile.getPassword());

            Statement statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    // Inner Class

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatabaseConnectInfo {

        private String databaseType;

        private String url;

        private String schema;

        private String userName;

        private String password;

        private String encodingType;

        // Method
        public String getFullConnectionUrl() {
            return this.url
                    + (this.schema.isEmpty() ? "" : "/" + this.schema)
                    + (this.encodingType.isEmpty() ? "" : "?characterEncoding=" + this.encodingType);
        }
    }

}
