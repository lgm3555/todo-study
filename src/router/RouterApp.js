import React from "react";
import { Routes, Route, Link } from 'react-router-dom';
import About from './About';
import Home from './Home';
import Profile from './Profile';
import HistorySample from "./HistorySample";

const RouterApp = () => {
    return (
        <div>
            <ul>
                <li>
                    <Link to="/routerapp">홈</Link>
                </li>
                <li>
                    <Link to="/routerapp/about">소개</Link>
                </li>
                <li>
                    <Link to="/routerapp/profile/velopert">velopert 프로필</Link>
                </li>
                <li>
                    <Link to="/routerapp/profile/gildong">gildong 프로필</Link>
                </li>
                <li>
                    <Link to="/routerapp/history">History 예제</Link>
                </li>
            </ul>
            <hr />
            <Routes path="/routerapp">
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/profile/:username" element={<Profile />} />
                <Route path="/history" element={<HistorySample />} />
            </Routes>
        </div>
    );
};

export default RouterApp;