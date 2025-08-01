import React, { useState } from "react";
import { createTask } from "../api";

const TaskForm = ({ onTaskCreated }) => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    await createTask({ title, description });
    onTaskCreated();
    setTitle("");
    setDescription("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>➕ Add Task</h2>
      <input
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        required
      />
      <input
        placeholder="Description"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
      />
      <button type="submit">Create</button>
    </form>
  );
};

export default TaskForm;
