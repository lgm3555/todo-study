import React from 'react';
import { Routes, Route } from 'react-router-dom';
import ExampleApp from './example/ExampleApp';
import LifeCycleApp from './lifecycle/LifeCycleApp';
import HookApp from './hook/HookApp';
import Navigation from './Navigation';
import SassApp from './sass/SassApp';
import TodoApp from './todoList/App';
import RouterApp from './router/RouterApp';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigation />} />
      <Route path="/example" element={<ExampleApp />} />
      <Route path="/lifecycle" element={<LifeCycleApp />} />
      <Route path="/hook" element={<HookApp />} />
      <Route path="/sass" element={<SassApp />} />
      <Route path="/todoapp" element={<TodoApp />} />
      <Route path="/routerapp/*" element={<RouterApp />} />
    </Routes>
  );
}

export default App;
