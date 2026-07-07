using System;

public class TaskManagementSystem
{
    public class Task
    {
        public string TaskId { get; set; }
        public string TaskName { get; set; }
        public string Status { get; set; }
        public Task Next { get; set; }

        public Task(string taskId, string taskName, string status)
        {
            TaskId = taskId;
            TaskName = taskName;
            Status = status;
            Next = null;
        }

        public override string ToString()
        {
            return $"Task{{id={TaskId}, name={TaskName}, status={Status}}}";
        }
    }

    private Task _head;

    public void AddTask(Task task)
    {
        if (_head == null)
        {
            _head = task;
            return;
        }
        Task current = _head;
        while (current.Next != null)
        {
            current = current.Next;
        }
        current.Next = task;
    }

    public Task SearchTask(string taskId)
    {
        Task current = _head;
        while (current != null)
        {
            if (string.Equals(current.TaskId, taskId, StringComparison.Ordinal))
            {
                return current;
            }
            current = current.Next;
        }
        return null;
    }

    public void TraverseTasks()
    {
        if (_head == null)
        {
            Console.WriteLine("No tasks found.");
            return;
        }
        Task current = _head;
        while (current != null)
        {
            Console.WriteLine(current);
            current = current.Next;
        }
    }

    public bool DeleteTask(string taskId)
    {
        if (_head == null)
        {
            return false;
        }
        if (string.Equals(_head.TaskId, taskId, StringComparison.Ordinal))
        {
            _head = _head.Next;
            return true;
        }
        Task current = _head;
        while (current.Next != null)
        {
            if (string.Equals(current.Next.TaskId, taskId, StringComparison.Ordinal))
            {
                current.Next = current.Next.Next;
                return true;
            }
            current = current.Next;
        }
        return false;
    }

    public static void Main(string[] args)
    {
        TaskManagementSystem taskSystem = new TaskManagementSystem();
        taskSystem.AddTask(new Task("T100", "Design module", "In Progress"));
        taskSystem.AddTask(new Task("T101", "Write tests", "Pending"));
        taskSystem.AddTask(new Task("T102", "Deploy app", "Pending"));

        Console.WriteLine("All tasks:");
        taskSystem.TraverseTasks();

        Console.WriteLine("\nSearch for T101:");
        Console.WriteLine(taskSystem.SearchTask("T101"));

        taskSystem.DeleteTask("T100");

        Console.WriteLine("\nAfter deleting T100:");
        taskSystem.TraverseTasks();
    }
}
