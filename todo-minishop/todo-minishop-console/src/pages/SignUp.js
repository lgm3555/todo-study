import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import {createTheme, ThemeProvider} from '@mui/material/styles';
import {signUp} from "../services/AuthService";
import Toast from "../components/common/Alert";

const theme = createTheme();

export default function SignUp() {

    const [toast, setToast] = React.useState(false);
    const [message, setMessage] = React.useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);

        signUp(
            data.get('id'),
            data.get('password'),
            data.get('name'),
            data.get('email'),
            data.get('phone'),
            data.get('address')
        ).then((res) => {
            if (res.data.errorCode) {
                setMessage(res.data.errorMessage)
                setToast(true)
            } else {
                window.location.href = '/sign-in'
            }
        }).catch((err) => {
            setToast(true)
        })
    };

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline />
                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Typography component="h1" variant="h5">
                        회원가입
                    </Typography>
                    <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
                        <Grid container spacing={2}>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    id="id"
                                    label="아이디"
                                    name="id"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    name="password"
                                    label="비밀번호"
                                    type="password"
                                    id="password"
                                    autoComplete="new-password"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    id="name"
                                    label="이름"
                                    name="name"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    id="email"
                                    label="이메일"
                                    name="email"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    id="phone"
                                    label="전화번호"
                                    name="phone"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    id="address"
                                    label="주소"
                                    name="address"
                                />
                            </Grid>
                        </Grid>
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            sx={{ mt: 3, mb: 2 }}
                        >
                            회원가입
                        </Button>
                    </Box>
                </Box>
                {toast && <Toast setToast={setToast} status="warning" message={message} />}
            </Container>
        </ThemeProvider>
    );
}