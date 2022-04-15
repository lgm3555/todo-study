import React, { Component } from 'react';

class Example1 extends Component {
    constructor(props) {
        super(props);

        //state의 초깃값 설정
        this.state = {
            number: 0
        };
    };

    render() {
        const { number } = this.state; // state를 조회할 떄는 this.state로 조회
        return (
            <div>
                <h1>{number}</h1>
                <button onClick={() => {
                    this.setState({ number: number + 1 });
                }}
                >
                    + 1
                </button>
            </div>
        )
    }
}

export default Example1;