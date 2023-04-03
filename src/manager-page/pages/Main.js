import * as React from 'react';
import {makeStyles, Tab} from "@material-ui/core";
import {Box, Grid} from '@mui/material';
import {TabContext, TabList, TabPanel} from "@mui/lab";
import {
    getDKwdDictData,
    getEKwdDictData,
    getDAngDictData,
    getEAngDictData
} from "../services/dictService";
import SearchBar from "../components/pages/SearchBar";
import AngDictTable from "../components/pages/AngDictTable";
import KwdDictTable from "../components/pages/KwdDictTable";
import {useDispatch, useSelector} from 'react-redux';

const useStyles = makeStyles((theme) => ({
    root: {
        height: "100vh",
        backgroundColor: theme.palette.background.paper,
    },
    tabs: {
        borderRight: `1px solid ${theme.palette.divider}`,
        width: '190px',
    },
    nav: {
        minWidth: "160px",
    },
    search: {
        minWidth: "1200px",
        minHeight: "140px",
    }
}));

function Main() {
    const dispatch = useDispatch()
    const dKwdDict = useSelector((state) => state.dKwdDict)
    const dAngDict = useSelector((state) => state.dAngDict)
    const eKwdDict = useSelector((state) => state.eKwdDict)
    const eAngDict = useSelector((state) => state.eAngDict)
    const classes = useStyles();
    const [value, setValue] = React.useState("kwd");

    React.useEffect(() => {
        dispatch(getDKwdDictData());
        dispatch(getEKwdDictData());
        dispatch(getDAngDictData());
        dispatch(getEAngDictData());
        console.log(eKwdDict)
    }, []);

    const handleChange = (event, newValue) => {
        console.log(eKwdDict)
        setValue(newValue);
    };

    return (
        <Box sx={{flexGrow: 1}} className={classes.root}>
            <Grid container>
                <TabContext value={value}>
                    <Grid item xs={1}>
                        <Box sx={{borderBottom: 1, borderColor: 'divider'}} className={classes.nav}>
                            <TabList onChange={handleChange} orientation="vertical">
                                <Tab label="키워드 사전" value="kwd" />
                                <Tab label="유사어 사전" value="ang" />
                            </TabList>
                        </Box>
                    </Grid>
                    <Grid item xs={11} style={{height: "100vh", textAlign: "center"}}>
                        <Grid item xs={12}>
                            <Box sx={{borderBottom: 1, borderColor: 'divider'}} className={classes.search}>
                                <SearchBar />
                            </Box>
                        </Grid>
                        <Box sx={{borderBottom: 1, borderColor: 'divider'}}>
                            <TabPanel value={"kwd"}>
                                <Grid container>
                                    <Grid item xs={6}>
                                        <KwdDictTable type="danawa" data={dKwdDict} />
                                    </Grid>
                                    <Grid item xs={6}>
                                        <KwdDictTable type="enuri" data={eKwdDict} />
                                    </Grid>
                                </Grid>
                            </TabPanel>
                            <TabPanel value={"ang"}>
                                <Grid container>
                                    <Grid item xs={6}>
                                        <AngDictTable type="danawa" data={dAngDict} />
                                    </Grid>
                                    <Grid item xs={6}>
                                        <AngDictTable type="enuri" data={eAngDict} />
                                    </Grid>
                                </Grid>
                            </TabPanel>
                        </Box>
                    </Grid>
                </TabContext>
            </Grid>
        </Box>
    );
}

export default Main;