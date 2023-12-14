package manhntph29583.baithi.demodethi.DTO;

public class Group {
    int idGroup;
    String name_group;

    public Group(int idGroup, String name_group) {
        this.idGroup = idGroup;
        this.name_group = name_group;
    }

    public Group(String name_group) {
        this.name_group = name_group;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }
}
