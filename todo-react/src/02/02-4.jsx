// 필수 프로퍼티, 기본값 프로퍼티 사용해보기
import React, { Component } from 'react';
import PropTypes from 'prop-types';

class ChildComponent3 extends Component {
    render() {
        const {
            objValue,
            requiredStringValue,
        } = this.props;

        return (
            <div>
                <div>객체값 : {String(Object.entries(objValue))}</div>
                <div>필수값 : {requiredStringValue}</div>
            </div>
        );
    }
}

ChildComponent2.propTypes = {
    objValue: PropTypes.shape({
        name: PropTypes.string,
        age: PropTypes.number,
    }),
    requiredStringValue: PropTypes.string.isRequired,
    defaultValue: PropTypes.bool,
}

ChildComponent2.defaultProps = {
    defaultValue: false,
}

export default ChildComponent2;