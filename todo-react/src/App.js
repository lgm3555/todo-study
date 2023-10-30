import React from 'react';
import './meterialize.css';
import { Routes, Route } from 'react-router-dom';
import ExampleApp from './example/ExampleApp';
import LifeCycleApp from './lifecycle/LifeCycleApp';
import HookApp from './hook/HookApp';
import Navigation from './Navigation';
import SassApp from './sass/SassApp';
import TodoApp from './todoList/App';
import RouterApp from './router/RouterApp';
import ExApp2 from './02/App';
import ExApp3 from './03/App';

function App() {
  return (
    <div>
      <nav>
        <div className='nav-wrapper'>
          <div>두잇! 리액트 시작하기</div>
        </div>
      </nav>
      <Routes>
      <Route path="/" element={<Navigation />} />
      <Route path="/example" element={<ExampleApp />} />
      <Route path="/lifecycle" element={<LifeCycleApp />} />
      <Route path="/hook" element={<HookApp />} />
      <Route path="/sass" element={<SassApp />} />
      <Route path="/todoapp" element={<TodoApp />} />
      <Route path="/routerapp/*" element={<RouterApp />} />
      <Route path="/02/*" element={<ExApp2/>} />
      <Route path="/03/*" element={<ExApp3/>} />
    </Routes>
    </div>
  );
}

export default App;
