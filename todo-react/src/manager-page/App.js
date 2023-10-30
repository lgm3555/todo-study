import React from "react";
import Helmet from 'react-helmet';
import { StylesProvider } from "@material-ui/styles";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Main from './pages/Main';

function App() {
    return (
        <React.Fragment>
            <Helmet defaultTitle={`DANAWA & ENURI DICT`} />
            <StylesProvider injectFirst>
                <Router>
                    <Routes>
                        <Route path='/' exact element={<Main />}></Route>
                    </Routes>
                </Router>
            </StylesProvider>
        </React.Fragment>
    );
}

export default App;