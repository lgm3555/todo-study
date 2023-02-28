// 객체 프로퍼티 사용해보기
import React, { Component } from 'react';
import PropTypes from 'prop-types';

class ChildComponent2 extends Component {
    render() {
        const {
            objValue,
        } = this.props;

        return (
            <div>
                <div>객체값 : {String(Object.entries(objValue))}</div>
            </div>
        );
    }
}

ChildComponent2.propTypes = {
    objValue: PropTypes.shape({
        name: PropTypes.string,
        age: PropTypes.number,
    })
}

export default ChildComponent2;