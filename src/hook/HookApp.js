import React from 'react';
import Info from './Info';
import Counter from './Counter';
import Average from './Average';
import NewInfo from './NewInfo';

const HookApp = () => {
    return (
        <div>
            <Info />
            <hr />
            <Counter />
            <hr />
            <Average />
            <hr />
            <NewInfo />
        </div>
    )
};

export default HookApp;