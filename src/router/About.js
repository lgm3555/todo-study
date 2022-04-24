import React from "react";

const About = () => {
    
    const params = new URLSearchParams(window.location.search);
    let detail = params.get('detail');

    return (
        <div>
            <h1>소개</h1>
            <p>이 프로젝트는 리액트 라우터 기초를 실습해 보는 예제 프로젝트 입니다.</p>
            {detail && <p>detail 값을 true로 설정하셨군여</p>}
        </div>
    );
};

export default About;