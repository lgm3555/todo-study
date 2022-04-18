import React from 'react';
import { Link } from 'react-router-dom';

function Navigation() {
    return (
        <div className="nav">
            <Link to="/">
                <button>Home</button>
            </Link>
            <Link to="/example">
                <button>example</button>
            </Link>
            <Link to="/lifecycle">
                <button>lifecycle</button>
            </Link>
            <Link to="/hook">
                <button>hook</button>
            </Link>
            <Link to="/sass">
                <button>sass</button>
            </Link>
            <Link to="/todoapp">
                <button>todoApp</button>
            </Link>
        </div>
    )
}

export default Navigation;