import * as React from 'react';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

function Footer() {
    return (
        <Box component="footer" display={"flex"} gap={20} sx={{marginTop: '100px', backgroundColor: '#f8f8f8', justifyContent: 'center'}}>
            <Typography
                variant="subtitle2"
                color="text.secondary"
            >
                <p>[전화번호 / 운영 시간]</p>
                <p>070-0000-0000</p>
                <p>평일 / 14:00 ~ 17:00</p>
                <p>휴무 / 토, 일요일, 공휴일</p>
            </Typography>
            <Typography
                variant="subtitle2"
                color="text.secondary"
            >
                <p>[반품주소지]</p>
                <p>카카오톡 문의 : [링크] / 인스타그램 문의 : [링크]</p>
                <p>이메일 문의 : test@test.com</p>
                <p>주소 : 00000 서울특별시 어디구 어디동 000-00 어디빌딩 0층 미니샵</p>
            </Typography>
            <Typography
                variant="subtitle2"
                color="text.secondary"
            >
                <p>[은행]</p>
                <p>[무통장 입금 계좌]</p>
                <p>국민 000000-00-000000</p>
                <p>예금주 : 홍길동(미니샵)</p>
            </Typography>
            <Typography
                variant="subtitle2"
                color="text.secondary"
            >
                <p>[회사 정보]</p>
                <p>사업자 번호 : 000-00-00000</p>
                <p>온라인 번호 : 000-00-00000</p>
                <p>주소 : 00000 서울특별시 어디구 어디동 000-00 어디빌딩 0층 미니샵</p>
            </Typography>
        </Box>
    );
}

export default Footer;