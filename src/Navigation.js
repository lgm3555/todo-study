import React from 'react';
import { Link } from 'react-router-dom';

function Navigation() {
    return (
        <div className="nav">
            <Link to="/">
                <button>Home</button>
            </Link>
            <Link to="/lifecycle">
                <button>lifecycle</button>
            </Link>
            <Link to="/hook">
                <button>hook</button>
            </Link>
        </div>
    )
}

export default Navigation;