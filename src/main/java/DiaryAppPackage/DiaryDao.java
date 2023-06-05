package DiaryAppPackage;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiaryDao implements IDiaryDao {

    private final String connectionString;

    public DiaryDao(String connectionString) {
        this.connectionString = connectionString;
        initialize();
    }

    public void add(Diary diary) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "insert into DIARY (TITLE, BEGIN, ISPUBLIC) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diary.getTitle());
            preparedStatement.setString(2, String.valueOf(diary.getBegin()));
            preparedStatement.setBoolean(3, diary.isPublic());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Diary diary) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "update DIARY set TITLE=?, BEGIN=?, ISPUBLIC=? where ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diary.getTitle());
            preparedStatement.setString(2, String.valueOf(diary.getBegin()));
            preparedStatement.setBoolean(3, diary.isPublic());
            preparedStatement.setInt(4, diary.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "delete DIARY where ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Diary> fetch() {
        List<Diary> diaryList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString)){
            String sql = "select ID, TITLE, BEGIN, ISPUBLIC from DIARY";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String title = resultSet.getString("TITLE");
                LocalDate begin = LocalDate.parse(resultSet.getString("BEGIN"));
                boolean isPublic = resultSet.getBoolean("ISPUBLIC");
                Diary diary = new Diary(id, title, begin, isPublic);
                diaryList.add(diary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return diaryList;
    }

    private void initialize() {
        String sql = "create table if not exists DIARY (" +
                "  ID integer primary key auto_increment," +
                "  TITLE varchar(32) not null," +
                "  BEGIN varchar(32) not null," +
                "  ISPUBLIC varchar(32)" +
                ")";
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

