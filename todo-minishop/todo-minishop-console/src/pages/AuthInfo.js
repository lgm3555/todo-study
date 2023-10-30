import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, Button, TextField } from '@mui/material';
import {createTheme} from "@mui/material/styles";
import {ThemeProvider} from "@emotion/react";
import Container from "@mui/material/Container";
import {Box} from "@mui/system";
import {authInfo, check} from "../services/AuthService";

const theme = createTheme({
    components: {
        MuiTableCell: {
            styleOverrides: {
                root: {
                    textAlign: 'center',
                    fontSize: '13px'
                },
            },
        },
    },
});


const AuthInfo = () => {

    const [info, setInfo] = React.useState({
        id: '',
        name: '',
        email: '',
        phone: '',
        address: '',
    });

    React.useEffect(() => {
        authInfo().then((res) => {
            if (res.data) {
                setInfo(res.data)
            } else {
                window.location.href = '/sign-in'
            }
        }).catch(err => {
            window.location.href = '/sign-in'
        })
    }, [])

    const handleChange = (event) => {

    };

    const handleSave = () => {

    };

    return (
        <ThemeProvider theme={theme}>
            <Container sx={{maxWidth: '50%'}} maxWidth={false}>
                <TableContainer component={Box} sx={{
                    borderTop: 1,
                    borderColor: 'divider',
                    display: 'flex',
                }}>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell colSpan={2}>[회원 정보]</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            <TableRow>
                                <TableCell>아이디</TableCell>
                                <TableCell>{info.id}</TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>비밀번호</TableCell>
                                <TableCell>
                                    <TextField
                                        name="name"
                                        onChange={handleChange}
                                        size={"small"}
                                        sx={{ fontSize: '13px' }}
                                    />
                                </TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>비밀번호 확인</TableCell>
                                <TableCell>
                                    <TextField
                                        name="name"
                                        onChange={handleChange}
                                        size={"small"}
                                        sx={{ fontSize: '13px' }}
                                    />
                                </TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>닉네임</TableCell>
                                <TableCell>
                                    <TextField
                                        name="name"
                                        value={info.name}
                                        onChange={handleChange}
                                        size={"small"}
                                        sx={{ fontSize: '13px' }}
                                    />
                                </TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>이메일</TableCell>
                                <TableCell>
                                    <TextField
                                        name="name"
                                        value={info.email}
                                        onChange={handleChange}
                                        size={"small"}
                                        sx={{ fontSize: '13px' }}
                                    />
                                </TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>전화번호</TableCell>
                                <TableCell>
                                    <TextField
                                        name="name"
                                        value={info.phone}
                                        onChange={handleChange}
                                        size={"small"}
                                        sx={{ fontSize: '13px' }}
                                    />
                                </TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>주소</TableCell>
                                <TableCell>
                                    <TextField
                                        name="name"
                                        value={info.address}
                                        onChange={handleChange}
                                        size={"small"}
                                        sx={{ fontSize: '13px' }}
                                    />
                                </TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell colSpan={2}>
                                    <Button onClick={handleSave}>저장</Button>
                                </TableCell>
                            </TableRow>
                        </TableBody>
                    </Table>
                </TableContainer>
            </Container>
        </ThemeProvider>
    );
};

export default AuthInfo;