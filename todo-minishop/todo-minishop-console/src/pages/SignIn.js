import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import {createTheme, ThemeProvider} from '@mui/material/styles';
import {check, refresh, signIn} from "../services/AuthService";
import Toast from "../components/common/Alert";
import {AUTH_ACCESS_TOKEN, AUTH_REFRESH_TOKEN} from "../utils/constrants";

const theme = createTheme();

export default function Login() {

    const [flag, setFlag] = React.useState(false);
    const [toast, setToast] = React.useState(false);

    React.useEffect(() => {
        check().then(res => {
            let active = (res || {}).data;
            if (active === 'active') {
                window.location.href  = '/'
            } else {
                localStorage.removeItem(AUTH_ACCESS_TOKEN);
                refreshCall()
            }
        }).catch(err => {
            console.log(err)
        });
    }, [flag])

    const refreshCall = () => {
        refresh().then(res => {
            setFlag(true)
        }).catch(err => {
            console.log(err)
        });
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        const formData = new FormData(event.currentTarget);

        const data = {
            id: formData.get('id'),
            password: formData.get('password')
        }

        signIn(data).then((res) => {
            if (res.data.errorCode) {
                setToast(true);
            } else {
                window.location.href = '/';
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
                        로그인
                    </Typography>
                    <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="id"
                            label="아이디"
                            name="id"
                            autoFocus
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="password"
                            label="패스워드"
                            type="password"
                            id="password"
                        />
                        <FormControlLabel
                            control={<Checkbox value="remember" color="primary" />}
                            label="자동 로그인"
                        />
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            sx={{ mt: 3, mb: 2 }}
                        >
                            로그인
                        </Button>
                        <Grid container>
                            <Grid item xs>
                                <Link href="/find-pwd" variant="body2">
                                    패스워드 찾기
                                </Link>
                            </Grid>
                            <Grid item>
                                <Link href="/sign-up" variant="body2">
                                    회원가입
                                </Link>
                            </Grid>
                        </Grid>
                    </Box>
                </Box>
                {toast && <Toast setToast={setToast} status="info" message="로그인 정보를 확인해주세요." />}
            </Container>
        </ThemeProvider>
    );
}