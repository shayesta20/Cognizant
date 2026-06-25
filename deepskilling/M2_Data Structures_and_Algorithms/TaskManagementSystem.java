public class TaskManagementSystem {
    static class Task {
        String taskId;
        String taskName;
        String status;
        Task next;

        Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("Task{id=%s, name=%s, status=%s}", taskId, taskName, status);
        }
    }

    private Task head;

    public void addTask(Task task) {
        if (head == null) {
            head = task;
            return;
        }
        Task current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = task;
    }

    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId.equals(taskId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }
        if (head.taskId.equals(taskId)) {
            head = head.next;
            return true;
        }
        Task current = head;
        while (current.next != null) {
            if (current.next.taskId.equals(taskId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        TaskManagementSystem taskSystem = new TaskManagementSystem();

        taskSystem.addTask(new Task("T100", "Design module", "In Progress"));
        taskSystem.addTask(new Task("T101", "Write tests", "Pending"));
        taskSystem.addTask(new Task("T102", "Deploy app", "Pending"));

        System.out.println("All tasks:");
        taskSystem.traverseTasks();

        System.out.println("\nSearch for T101:");
        System.out.println(taskSystem.searchTask("T101"));

        taskSystem.deleteTask("T100");
        System.out.println("\nAfter deleting T100:");
        taskSystem.traverseTasks();
    }
}
