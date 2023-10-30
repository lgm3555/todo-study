import * as React from 'react';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Grid from "@mui/material/Grid";
import Tab from '@mui/material/Tab';
import TabList from '@mui/lab/TabList';
import {AUTH_ACCESS_TOKEN, AUTH_REFRESH_TOKEN} from "../../utils/constrants";

function Header(props) {

    const handleTrans = (type) => {
        window.location.href = type;
    }

    const handleLogout = () => {
        localStorage.removeItem(AUTH_ACCESS_TOKEN)
        localStorage.removeItem(AUTH_REFRESH_TOKEN)
        window.location.href = '/';
    }

    const handleChange = (event, newValue) => {
        props.setValue(newValue);
    };

    return (
        <React.Fragment>
            <Grid container sx={{ my: 3 }}>
                <Grid item xs={2}>
                    {
                        props.status ?
                            props.name == 'main' ?
                                <Button onClick={() => handleTrans('/my-page')} size="small">마이페이지</Button>
                                :
                                <Button onClick={() => handleTrans('/')} size="small">메인화면</Button>
                            :
                            ''
                    }
                </Grid>
                <Grid item xs={8}>
                    <Typography
                        component="h2"
                        variant="h5"
                        color="inherit"
                        align="center"
                        noWrap
                        sx={{ flex: 1 }}
                    >
                        MINI-SHOP
                    </Typography>
                </Grid>
                <Grid item xs={2} sx={{textAlign: 'right'}}>
                    {
                        props.status ?
                            <Button onClick={() => handleLogout()} size="small">로그아웃</Button>
                            :
                            <Button onClick={() => handleTrans('/sign-in')} size="small">로그인</Button>
                    }

                </Grid>
            </Grid>
            <Toolbar
                component="nav"
                variant="dense"
                sx={{ justifyContent: 'center', gap: 10, borderTop: 1, borderColor: 'divider' }}
            >
                <TabList onChange={handleChange}>
                    {props.sections.map((section, key) => (
                        <Tab key={key} label={section.title} value={section.value} />
                    ))}
                </TabList>
            </Toolbar>
        </React.Fragment>
    );
}

export default Header;