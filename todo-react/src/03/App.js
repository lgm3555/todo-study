import React, { Component } from 'react';
import StateExample from './03-1'
import Counter1 from './03-2'
import Counter2 from './03-3'
import Counter3 from './03-4'

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {count: 10};
        this.resetCount = this.resetCount.bind(this);
    }
    resetCount() {
        this.setState(({ count }) => ({count: count + 10}));
    }

    render() {
        return (
            <div>
                <StateExample />
                <hr />
                <Counter1 />
                <hr />
                <Counter2 count={this.state.count}/>
                <hr />
                <Counter3 count={this.state.count}/>
                <hr />
                <button onClick={this.resetCount}>{this.state.count + 10}으로 초기화</button>
            </div>
        );
    }
}

export default App;