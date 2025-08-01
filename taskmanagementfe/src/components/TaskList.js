import React, { useEffect, useState } from "react";
import { getAllTasks, deleteTask } from "../api";

const TaskList = () => {
  const [tasks, setTasks] = useState([]);

  const loadTasks = async () => {
    const data = await getAllTasks();
    setTasks(data);
  };

  useEffect(() => {
    loadTasks();
  }, []);

  const handleDelete = async (id) => {
    await deleteTask(id);
    loadTasks();
  };

  return (
    <div>
      <h2>📋 Task List</h2>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <strong>{task.title}</strong> - {task.description}
            <button onClick={() => handleDelete(task.id)}>❌ Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TaskList;
