import java.util.ArrayList;

public class PointsManager {
    private final ArrayList<Integer> points;
    private final ArrayList<Integer> grades;

    public PointsManager() {
        points = new ArrayList<>();
        grades = new ArrayList<>();
    }

    public void addPoint(int point) {
        points.add(point);
        addGrade(point);
    }

    public double averageAll() {
        double sum = 0;

        for (int num : points) {
            sum += num;
        }
        return sum / points.size();
    }

    public double averagePassing() {
        double sum = 0;
        int count = 0;

        for (int num : points) {
            if (num >= 50) {
                sum += num;
                count++;
            }
        }

        if (sum > 0) {
            return sum / count;
        }
        return 0;
    }

    public double passPercentage() {
        // 100 * passing / participants
        double passing = 0;

        for (int num : points) {
            if (num >= 50) {
                passing++;
            }
        }

        return 100 * passing / points.size();
    }

    public void addGrade(int point) {
        int grade = 0;

        if (point >= 50) {
            if (point < 60) {
                grade = 1;
            } else if (point < 70) {
                grade = 2;
            } else if (point < 80) {
                grade = 3;
            } else if (point < 90) {
                grade = 4;
            } else {
                grade = 5;
            }
        }

        grades.add(grade);
    }

    public int gradeCount(int grade) {
        int count = 0;
        for (int num : grades) {
            if (num == grade) {
                count++;
            }
        }
        return count;
    }
}
