package at.fhj.ischedulefx.Entity;

public enum UserRole {
    ADMIN("Administrator"),
    ASSISTANT("Assistant"),
    STUDENT("Student");

    private final String role;

    UserRole(String role) {this.role = role;}

    private String getRole() {return role;}

    @Override
    public String toString() {return role;}
}
