import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LifeCycleApp from './lifecycle/LifeCycleApp';
import HookApp from './hook/HookApp';
import Navigation from './Navigation';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigation />} />
        <Route path="/lifecycle" element={<LifeCycleApp />} />
        <Route path="/hook" element={<HookApp />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
