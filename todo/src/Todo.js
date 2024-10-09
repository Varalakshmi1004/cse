// src/App.js
import React, { useState } from 'react';
import './App.css';

function TodoList() {
    const [todos, setTodos] = useState([]);
    const [inputValue, setInputValue] = useState('');
    const [editingIndex, setEditingIndex] = useState(null);
  
    const handleInputChange = (e) => {
      setInputValue(e.target.value);
    };
  
    const handleAddTodo = () => {
      if (inputValue.trim() !== '') {
        if (editingIndex !== null) {
          const updatedTodos = todos.map((todo, index) =>
            index === editingIndex ? inputValue : todo
          );
          setTodos(updatedTodos);
          setEditingIndex(null);
        } else {
          setTodos([...todos, inputValue]);
        }
        setInputValue('');
      }
    };
  
    const handleEditTodo = (index) => {
      setInputValue(todos[index]);
      setEditingIndex(index);
    };
  
    const handleDeleteTodo = (index) => {
      const newTodos = todos.filter((_, i) => i !== index);
      setTodos(newTodos);
      if (editingIndex === index) {
        setEditingIndex(null);
        setInputValue('');
      }
    };
  
    return (
      <div className="App">
        <h1>To-Do List</h1>
        <input
          type="text"
          value={inputValue}
          onChange={handleInputChange}
          placeholder="Add a new task"
        />
        <button onClick={handleAddTodo}>
          {editingIndex !== null ? 'Update' : 'Add'}
        </button>
        <ul>
          {todos.map((todo, index) => (
            <li key={index}>
              {todo}
              <div className="actions">
                <span className="edit" onClick={() => handleEditTodo(index)}>
                  ✏️
                </span>
                <span className="delete" onClick={() => handleDeleteTodo(index)}>
                  🗑️
                </span>
              </div>
            </li>
          ))}
        </ul>
      </div>
  );
}

export default TodoList;
