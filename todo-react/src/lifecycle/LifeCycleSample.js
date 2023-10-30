import React, { Component } from 'react';

class LifeCycleSample extends Component {
    state = {
        number: 0,
        color: null
    };

    myRef = null; //ref 설정할 부분

    constructor(props) {
        super(props);
        console.log('constructor');
    }

    /*
    props로 받아 온 값을 state에 동기화시키는 용도
    컴포넌트가 마운트, 업데이트될 떄 호출
    */
    static getDerivedStateFromProps(nextProps, prevState) {
        console.log('getDerivedStateFromProps - ' + nextProps.color + '-' + prevState.color + '-');
        if (nextProps.color !== prevState.color) {
            return { color: nextProps.color };
        }
        return null;
    }

    /*
    첫 렌더링 이후 호출
    - 자바스크립트 라이브러리 또는 프레임워크 함수 호출
    - 이벤트 등록
    - setTimeout, setInterval, 네트워크 요청 같은 비동기 작업 처리
    */
    componentDidMount() {
        console.log('componentDidMount');
    }

    /*
    props, state 변경시 리렌더링을 시작할지 여부 체크, default값 true
    */
    shouldComponentUpdate(nextProps, nextState) {
        console.log('shouldComponentUpdate', nextProps, nextState);
        //숫자의 마지막 자리가 4면 리렌더링하지 않습니다.
        return nextState.number % 10 !== 4;
    }

    /*
    componentDidMount에서 등록한 이벤트, 타이머, 직접생성한 DOM 제거 작업
    */
    componentWillUnmount() {
        console.log('componentWillUnmount');
    }

    handleClick = () => {
        console.log('handleClick');
        this.setState({
            number: this.state.number + 1
        });
    }

    /*
    render에서 만들어진 결과물이 브라우저에 실제로 반영되기 직전에 호출.
    */
    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('getSnapshopBeforeUpdate');
        if (prevProps.color !== this.props.color) {
            return this.myRef.style.color;
        }
        return null;
    }

    /*
    렌더링 완료 후 실행
    */
    componentDidUpdate(prevProps, prevState, snapShot) {
        console.log('componentDidUpdate', prevProps, prevState);
        if (snapShot) {
            console.log('업데이트되기 직전 색상: ', snapShot);
        }
    }

    render() {
        console.log('render');

        const style = {
            color: this.props.color
        }

        return (
            <div>
                <h1 style={style} ref={ref => this.myRef=ref}>
                    {this.state.number}
                </h1>
                <p>color: {this.state.color}</p>
                <button onClick={this.handleClick}>
                    더하기
                </button>
            </div>
        )
    }
}

export default LifeCycleSample;