package entity;

import ADT.LinkedList;
import adt.ListInterface;

/**
 *
 * @author NicholasTayJunYang
 */
public class Programme {

    private String id;
    private String name;
    private String department;
    private int duration;
    private ListInterface<TutorialGroup> tutorialGroups;

    public Programme(String id, String name, String department,
            int duration) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.duration = duration;
        this.tutorialGroups = new LinkedList<>();

    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void addTutorialGroup(TutorialGroup group) {
        tutorialGroups.add(group);
    }

    public boolean removeTutorialGroupById(String groupId) {
        for (int i = 1; i <= tutorialGroups.getLength(); i++) {
            TutorialGroup tg = tutorialGroups.get(i);
            if (tg.getGroupId().equals(groupId)) {
                tutorialGroups.remove(i);
                return true;
            }
        }
        return false;
    }

    public ListInterface<TutorialGroup> getTutorialGroups() {
        return tutorialGroups;
    }

    private boolean containsTutorialGroup(TutorialGroup tg) {
        for (int i = 1; i <= tutorialGroups.getLength(); i++) {
            if (tutorialGroups.get(i).getGroupId().equals(tg.getGroupId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("|  %-13s |  %-53s |  %-11s |  %9d |",
                id, name, department, duration);
    }
}
