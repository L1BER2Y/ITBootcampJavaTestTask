package by.shershen.database.entity;

public enum Role {
    ADMINISTRATOR("ADMINISTRATOR"),
    SALE_USER("SALE_USER"),
    CUSTOMER_USER("CUSTOMER_USER"),
    SECURE_API_USER("SECURE_API_USER");

    private final String roleId;

    Role(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }
}
