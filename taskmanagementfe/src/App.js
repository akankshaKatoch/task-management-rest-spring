import React from "react";
import TaskList from "./components/TaskList";
import TaskForm from "./components/TaskForm";

function App() {
  const [refresh, setRefresh] = React.useState(false);

  return (
    <div className="App">
      <h1>🧠 Smart Task Manager</h1>
      <TaskForm onTaskCreated={() => setRefresh(!refresh)} />
      <TaskList key={refresh} />
    </div>
  );
}

export default App;
