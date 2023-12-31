//다양한 프로퍼티 자료형 사용해보기
import React, { Component } from 'react';
import PropTypes from 'prop-types';

class ChildComponent extends Component {
    render() {
        const {
            boolValue,
            numValue,
            arrayValue,
            objValue,
            nodeValue,
            funcValue,
        } = this.props;

        return (
            <div>
                <span>불리언값: {boolValue} </span>
                <span>숫자값: {numValue} </span>
                <span>배열값: {arrayValue} </span>
                <span>객체값: {objValue} </span>
                <span>노드값: {nodeValue} </span>
                <span>함수값: {funcValue} </span>
            </div>
        );
    }
}

ChildComponent.propTypes = {
    boolValue: PropTypes.bool,
    numValue: PropTypes.number,
    arrayValue: PropTypes.arrayOf(PropTypes.number),
    objValue: PropTypes.object,
    nodeValue: PropTypes.node,
    funcValue: PropTypes.func,
}

export default ChildComponent;