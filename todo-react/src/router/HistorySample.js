import React from "react";
import { useNavigate } from "react-router-dom";

const HistorySample = () => {
    
    const navigator = useNavigate();

    const goBack = () => {
        navigator(-1);
    };

    const goHome = () => {
        navigator('/');
    };

    return (
        <div>
            <button onClick={goBack}>뒤로가기</button>
            <button onClick={goHome}>홈으로</button>
        </div>
    )
}

export default HistorySample;