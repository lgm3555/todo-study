import React, { Component } from 'react';
import Counter2 from './04-2'
import Input from './Input'

class App extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Counter2 />
                <hr />
                <Input
                    label="name"
                    name="name"
                    value=""
                    type="number"
                />
            </div>
        );
    }
}

export default App;