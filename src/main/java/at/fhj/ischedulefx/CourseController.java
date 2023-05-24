package at.fhj.ischedulefx;

import at.fhj.ischedulefx.Entity.Course;
import at.fhj.ischedulefx.Entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    private User currentUser;
    @FXML
    private TableColumn<Course, String> col_course_name;
    @FXML
    private TableColumn<Course, Button> col_enroll_button;
    @FXML
    private TableColumn<Course, String> col_semester;
    @FXML
    private TableColumn<Course, User> col_teacher;
    @FXML
    private TableColumn<Course, String> col_day_time;
    @FXML
    private Button create_button;
    @FXML
    private Button delete_button;
    @FXML
    private Button edit_button;
    @FXML
    private TableView<Course> table_courses;
    @FXML
    private TextField search_field;
    @FXML
    private Button button_search;

    @FXML
    private Label welcome_textfield;

    @FXML
    private TableColumn<?, ?> col_end_time;
    @FXML
    private TableColumn<?, ?> col_start_time;
    ObservableList<Course> courseObservableList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        SessionFactory connection = databaseConnection.getSessionFactory();

        String getCourseQuery = "SELECT name, code, semester, teacher_id, day_of_week, start_time, end_time FROM course";

        try {
            Statement statement = connection.createStatement();
            ResultSet query = statement.executeQuery(getCourseQuery);

            while (query.next()) {
                String queryName = query.getString("name");
                String queryCode = query.getString("code");
                String querySemester = query.getString("semester");
                Long queryTeacher = query.getLong("teacher_id");
                DayOfWeek queryDay = DayOfWeek.valueOf(query.getString("day_of_week").toUpperCase());
                LocalTime queryStartTime = LocalTime.parse(query.getString("start_time"));
                LocalTime queryEndTime = LocalTime.parse(query.getString("end_time"));

                User teacher = new User(queryTeacher);
                courseObservableList.add(new Course(queryName, queryCode, querySemester, teacher, queryDay, queryStartTime, queryEndTime));
            }

            col_course_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
            col_teacher.setCellValueFactory(new PropertyValueFactory<>("teacher"));
            col_day_time.setCellValueFactory(new PropertyValueFactory<>("dayOfWeek"));
            col_start_time.setCellValueFactory(new PropertyValueFactory<>("startTime"));
            col_end_time.setCellValueFactory(new PropertyValueFactory<>("endTime"));

            table_courses.setItems(courseObservableList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchCourse() {
        FilteredList<Course> filteredList = new FilteredList<>(courseObservableList, b -> true);
        String keyword = search_field.getText().toLowerCase();
        filteredList.setPredicate(course -> {
            if (course.getName().toLowerCase().contains(keyword)) {
                return true;
            }
            return false;
        });
        SortedList<Course> sortedCourses = new SortedList<>(filteredList);
        sortedCourses.comparatorProperty().bind(table_courses.comparatorProperty());
        table_courses.setItems(sortedCourses);
    }

    public void deleteCourse() throws IOException {
        if (checkRole("Admin Assistant")) {

        } else {
            createAlertWindow();
        }
    }

    public void createCourse() throws IOException {
        if (checkRole("Admin Assistant")) {

        } else {
            createAlertWindow();
        }
    }

    public void editCourse() throws IOException {
        if (checkRole("Admin Assistant")) {

        } else {
            createAlertWindow();
        }
    }

    public void createAlertWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WrongRoleAlert.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 200);
        Stage stage = new Stage();
        stage.setTitle("Role Alert");
        stage.setScene(scene);
        stage.show();
    }


    public boolean checkRole(String correctRole) {
        if(correctRole.toLowerCase().contains(currentUser.getRole().toLowerCase())) {
            return true;
        } return false;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

