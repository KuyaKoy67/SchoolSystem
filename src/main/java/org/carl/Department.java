package org.carl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private final String departmentId;
    @Setter private String departmentName;

    private static int nextId;

    private static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && !(c >= '0' && c <= '9')) {
                return false;
            }
        }

        return true;
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    public Department(String departmentName) {

        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }
}
