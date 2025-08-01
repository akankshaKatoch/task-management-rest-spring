const API_BASE = "http://localhost:8080/api/tasks";

export const getAllTasks = async () => {
  const response = await fetch(API_BASE);
  return response.json();
};

export const createTask = async (task) => {
  const response = await fetch(API_BASE, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task),
  });
  return response.json();
};

export const deleteTask = async (id) => {
  await fetch(`${API_BASE}/${id}`, { method: "DELETE" });
};
